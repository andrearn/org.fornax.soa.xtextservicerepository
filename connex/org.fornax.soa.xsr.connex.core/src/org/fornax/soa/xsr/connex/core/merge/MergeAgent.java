package org.fornax.soa.xsr.connex.core.merge;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Conflict;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.mwe.Reader;
import org.eclipse.xtext.mwe.ResourceSetBasedSlotEntry;
import org.eclipse.xtext.validation.Issue;
import org.fornax.soa.BindingDslStandaloneSetup;
import org.fornax.soa.BusinessDslStandaloneSetup;
import org.fornax.soa.EnvironmentDslStandaloneSetup;
import org.fornax.soa.ServiceDslStandaloneSetup;
import org.fornax.soa.SolutionDslStandaloneSetup;
import org.fornax.soa.basedsl.SOABaseDslStandaloneSetup;
import org.fornax.soa.moduledsl.ModuleDslStandaloneSetup;
import org.fornax.soa.profiledsl.SOAProfileDslStandaloneSetup;
import org.fornax.soa.sladsl.SLADslStandaloneSetup;
import org.fornax.soa.xsr.connex.core.authz.AuthorizationCheckHandler;
import org.fornax.soa.xsr.connex.core.merge.handler.IComparisonHandler;
import org.fornax.soa.xsr.connex.core.merge.validation.ComplianceCheckHandler;
import org.fornax.soa.xsr.connex.core.merge.validation.DiffValidatorProvider;
import org.fornax.soa.xsr.connex.core.merge.validation.IDiffValidator;
import org.fornax.soa.xsr.connex.core.merge.validation.ValidationResult;
import org.fornax.soa.xsr.connex.core.notification.CommitterMergeNotificationPublisher;
import org.fornax.soa.xsr.connex.core.notification.MergeNotificationEvent;
import org.fornax.soa.xsr.connex.core.notification.SubscriberMergeNotificationPublisher;
import org.fornax.soa.xsr.connex.core.validation.IssueFilterPredicate;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;


public class MergeAgent {
	
	private String leftModelPath;
	private String rightModelPath;
	
	private List<IComparisonHandler> diffHandlers = Lists.newArrayList();
	@Inject
	private AuthorizationCheckHandler authorizationCheckHandler;
	@Inject
	private IComparisonHandler complianceCheckHandler;
	@Inject
	private SubscriberMergeNotificationPublisher subscriberNotificationHandler;
	@Inject
	private CommitterMergeNotificationPublisher committerNotificationHandler;
	
	@Inject
	private EventBus bus;
	
	public MergeAgent() {
		leftModelPath = "";
		rightModelPath = "";
	}
	
	public void registerDiffHandler() {
		
	}

	public void diffModels (MergeContext ctx) {
		ResourceSet leftResourceSet = readModel (leftModelPath, "leftModel");
		ResourceSet rightResourceSet = readModel (rightModelPath, "rightModel");
		if (leftResourceSet != null && rightResourceSet != null) {
			EMFCompare comparator = createComparator();
			IComparisonScope comparisonScope = EMFCompare.createDefaultScope (leftResourceSet, rightResourceSet);
			Comparison compare = comparator.compare (comparisonScope);
			handleComparison (compare, ctx);
		}
		
	}
	
	private void handleComparison (Comparison comparison, MergeContext ctx) {
		EList<Conflict> conflicts = comparison.getConflicts();
		if (conflicts.isEmpty()) {
			authorizeChanges (comparison, ctx);
			checkCompliance (comparison, ctx);
			notifySubscribers (comparison, ctx);
		}
	}
	
	

	private void authorizeChanges(Comparison comparison, MergeContext ctx) {
		authorizationCheckHandler.handleComparison (comparison, ctx);
	}

	private boolean checkCompliance (Comparison comparison, MergeContext ctx) {
		Iterable<Issue> issues = complianceCheckHandler.handleComparison (comparison, ctx);
		Iterable<Issue> errors = Iterables.filter (issues, new IssueFilterPredicate(Severity.ERROR));
		Iterator<Issue> errorIt = errors.iterator();
		if (errorIt.hasNext()) {
			return false;
		} else {
			return true;
		}
	}

	private void notifySubscribers (Comparison comparison, MergeContext ctx) {
		MergeNotificationEvent evt = new MergeNotificationEvent("Changed assets", comparison, ctx);
		subscriberNotificationHandler.notify (evt);
	}

	private EMFCompare createComparator() {
		IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher (UseIdentifiers.NEVER);
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory (new DefaultEqualityHelperFactory());
		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl (matcher, comparisonFactory);
		matchEngineFactory.setRanking (20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add (matchEngineFactory);
		EMFCompare comparator = EMFCompare.builder().setMatchEngineFactoryRegistry (matchEngineRegistry).build();
		return comparator;
	}

	private ResourceSet readModel (String path, String modelName) {
		IWorkflowContext ctx = new WorkflowContextImpl();
		
		Reader modelReader = new Reader();
		modelReader.addRegister (new SOABaseDslStandaloneSetup());
		modelReader.addRegister (new BindingDslStandaloneSetup());
		modelReader.addRegister (new BusinessDslStandaloneSetup());
		modelReader.addRegister (new EnvironmentDslStandaloneSetup());
		modelReader.addRegister (new ModuleDslStandaloneSetup());
		modelReader.addRegister (new ServiceDslStandaloneSetup());
		modelReader.addRegister (new SLADslStandaloneSetup());
		modelReader.addRegister (new SOAProfileDslStandaloneSetup());
		modelReader.addRegister (new SolutionDslStandaloneSetup());
		modelReader.addPath(path);
		ResourceSetBasedSlotEntry outputSlot = new ResourceSetBasedSlotEntry();
		outputSlot.setName (modelName);
		modelReader.addLoadFromResourceSet (outputSlot);
		modelReader.invoke(ctx);
		
		ResourceSet rs = (ResourceSet)ctx.get (modelName);
		return rs;
	}
}
