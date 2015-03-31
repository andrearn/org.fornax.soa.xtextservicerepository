package org.xkonnex.repo.server.core.merge;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Conflict;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.validation.Issue;
import org.xkonnex.repo.core.XKonneXRepoDSL;
import org.xkonnex.repo.server.core.authz.AuthorizationCheckHandler;
import org.xkonnex.repo.server.core.merge.handler.IComparisonHandler;
import org.xkonnex.repo.server.core.notification.CommitterMergeNotificationPublisher;
import org.xkonnex.repo.server.core.notification.MergeNotificationEvent;
import org.xkonnex.repo.server.core.notification.SubscriberMergeNotificationPublisher;
import org.xkonnex.repo.server.core.resource.XKonneXReader;
import org.xkonnex.repo.server.core.validation.IssueFilterPredicate;
import org.xkonnex.repo.server.core.validation.ModelIssues;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import com.google.inject.Injector;
import com.google.inject.Provider;


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
	private Provider<XtextResourceSet> resourceSetProvider;
	
	@Inject
	private EventBus bus;
	
	@Inject
	private Injector injector;
	
	/**
	 * The MergeAgent merges proper commits to the staging repository with the upstream branch head. The MergeAgent 
	 * only accepts commits, that 
	 * <ul>
	 * 	<li>the committer is authorized to contribute, chacking authorization on the model level and not only the the file level</li>
	 * 	<li>pass the compliance checks for asset versioning, lifecycle management and other model properties</li>
	 * </ul>
	 * 
	 * Unaccepted commits will be reverted from the staging repository. The MergeAgent will notify the committer, 
	 * if the commit has not been accepted.<br/>
	 * 
	 * If a commit has been accepted, all subscribers to change events will be notified.
	 */
	public MergeAgent() {
		leftModelPath = "";
		rightModelPath = "";
	}
	
	public void registerDiffHandler() {
		
	}

	/**
	 * Create a diff model for the ongoing merge. 
	 * @param ctx
	 */
	public void diffModels (MergeContext ctx) {
		ModelIssues leftModelIssues = new ModelIssues();
		ModelIssues rightModelIssues = new ModelIssues();
		ResourceSet leftResourceSet = readModel (leftModelPath, leftModelIssues);
		ResourceSet rightResourceSet = readModel (rightModelPath, rightModelIssues);
		if (leftResourceSet != null && rightResourceSet != null && !leftModelIssues.hasErrors() && ! rightModelIssues.hasErrors()) {
			EMFCompare comparator = createComparator();
			IComparisonScope comparisonScope = new DefaultComparisonScope(leftResourceSet, rightResourceSet, null);
			Comparison compare = comparator.compare (comparisonScope);
			handleComparison (compare, ctx, leftModelIssues);
		}
		if (leftModelIssues.hasErrors()) {
			
		}
		if (rightModelIssues.hasErrors()) {
			
		}
		
	}
	
	/**
	 * Command chain that handles recognized differences
	 * @param comparison The EMF Compare comparison model
	 * @param ctx
	 */
	private void handleComparison (Comparison comparison, MergeContext ctx, ModelIssues issues) {
		EList<Conflict> conflicts = comparison.getConflicts();
		if (conflicts.isEmpty()) {
			authorizeChanges (comparison, ctx, issues);
			checkCompliance (comparison, ctx, issues);
			notifySubscribers (comparison, ctx, issues);
		}
	}
	
	

	private void authorizeChanges(Comparison comparison, MergeContext ctx, ModelIssues issues) {
		authorizationCheckHandler.handleComparison (comparison, ctx, issues);
	}

	private boolean checkCompliance (Comparison comparison, MergeContext ctx, ModelIssues issues) {
		complianceCheckHandler.handleComparison (comparison, ctx, issues);
		Iterable<Issue> errors = Iterables.filter (issues.getIssues().values(), new IssueFilterPredicate(Severity.ERROR));
		Iterator<Issue> errorIt = errors.iterator();
		if (errorIt.hasNext()) {
			return false;
		} else {
			return true;
		}
	}

	private void notifySubscribers (Comparison comparison, MergeContext ctx, ModelIssues issues) {
		MergeNotificationEvent evt = new MergeNotificationEvent ("Changed assets", comparison, ctx);
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

	private ResourceSet readModel (String path, ModelIssues modelIssues) {
		XKonneXReader reader = injector.getInstance(XKonneXReader.class);
		List<String> pathes = Lists.newArrayList(path);
		return reader.read(pathes, modelIssues);
	}
}
