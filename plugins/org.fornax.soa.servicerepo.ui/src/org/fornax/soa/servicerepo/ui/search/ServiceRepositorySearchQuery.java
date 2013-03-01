/*
 * based on Xtext findrefs components
 */
package org.fornax.soa.servicerepo.ui.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfileDslPackage;
import org.fornax.soa.servicerepo.query.FindAssetsWithStateQuery;
import org.fornax.soa.servicerepo.query.FindUnapprovedAssetsQuery;
import org.fornax.soa.servicerepo.query.predicates.CanonicalOrNotPredicate;
import org.fornax.soa.servicerepo.ui.internal.ServiceRepositoryActivator;
import org.fornax.soa.servicerepo.ui.search.dialog.ServiceRepositorySearchMessages;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.ibm.icu.text.MessageFormat;


public class ServiceRepositorySearchQuery implements ISearchQuery {
	
	@Inject
	private Injector injector;
	
	@Inject
	private IResourceSetProvider resourceSetProvider;
	
	@Inject 
	private IWorkspace workspace;
	
	@Inject
	private IPredicateSearch predicateSearch;
	
	@Inject
	private IEObjectLookup eObjectLookup;
	
	private ServiceRepositoryQuerySpec querySpec;
	private String pattern;
	private String assetType;
	private FindUnapprovedAssetsQuery unApprovedServicesQuery;
	private EObjectSearchResult searchResult;
	
	public ServiceRepositorySearchQuery() {
		pattern = ".*";
	}
	
	public void init (ServiceRepositoryQuerySpec querySpec) {
		this.querySpec = querySpec;
		pattern = querySpec.getPattern();
		if (pattern == null || pattern == "")
			pattern = ".*";
		assetType = querySpec.getSearchFor();
		searchResult = createSearchResult();
	}


	public boolean canRerun() {
		return true;
	}

	public boolean canRunInBackground() {
		return true;
	}

	public String getLabel() {
		return ServiceRepositorySearchMessages.ServiceRepositorySearchViewPage_resultLabelInitial;
	}
	
	public String getResultLabel (int matchCount) {
		return MessageFormat.format (ServiceRepositorySearchMessages.ServiceRepositorySearchViewPage_resultLabel,new Object[] {String.valueOf (matchCount)});
	}

	public ISearchResult getSearchResult() {
		return searchResult;
	}

	public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {
		searchResult.reset();
		IProject[] projects = workspace.getRoot().getProjects();
		ResourceSet rs = null;
		
		for (IProject curProject : projects) {
			if (XtextProjectHelper.hasNature(curProject)) {
				rs = resourceSetProvider.get(curProject);
				break;
			}
		}
		Iterable<IEObjectDescription> result = doSearch (rs);
		int i = 0;
		for (IEObjectDescription ieObjDesc : result) {
			i++;
			searchResult.accept (ieObjDesc);
		}
		searchResult.finish();
		String message = MessageFormat.format (ServiceRepositorySearchMessages.ServiceRepositorySearchViewPage_resultLabel,new Object[] {String.valueOf (i)});
		return (monitor.isCanceled()) ? Status.CANCEL_STATUS : new Status (Status.OK, ServiceRepositoryActivator.PLUGIN_ID, message);
	}

	public Iterable<IEObjectDescription> doSearch(ResourceSet rs) {
		Iterable<IEObjectDescription> result = new ArrayList<IEObjectDescription>();

		String minStateName = querySpec.getMinState();
		String maxStateName = querySpec.getMaxState();
		LifecycleState minState = null;
		if (minStateName != null && minStateName != "") {
			minState = eObjectLookup.getModelElementByName(minStateName, rs, SOAProfileDslPackage.Literals.LIFECYCLE.getName());
		}
		LifecycleState maxState = null;
		if (maxStateName != null && minStateName != "") {
			maxState = eObjectLookup.getModelElementByName(maxStateName, rs, SOAProfileDslPackage.Literals.LIFECYCLE.getName());
		}
		String minVersion = null;
		if (! "".equals(querySpec.getMinVersion()))
			minVersion = querySpec.getMinVersion();
		String maxVersion = null;
		if (! "".equals(querySpec.getMaxVersion()))
			maxVersion = querySpec.getMaxVersion();
		
		String queryName = querySpec.getQueryName();

		if (FindUnapprovedAssetsQuery.class.getName().equals(queryName)) {
			unApprovedServicesQuery = injector.getInstance (FindUnapprovedAssetsQuery.class);
			result = unApprovedServicesQuery.search(pattern, assetType, minState, maxState, minVersion, maxVersion, querySpec.isCanonicalNamespaces(), querySpec.isNonCanonicalNamespaces(), rs);
		} else { 
			FindAssetsWithStateQuery query = injector.getInstance(FindAssetsWithStateQuery.class);
			result = query.search (pattern, assetType, 
					minState, maxState, 
					minVersion, maxVersion, 
					querySpec.isCanonicalNamespaces(), querySpec.isNonCanonicalNamespaces(), 
					querySpec.getTagNames(), querySpec.isAllTags(), querySpec.isWithTagsFromParent(), rs);
		}
		return result;
	}

	protected EObjectSearchResult createSearchResult() {
		return new EObjectSearchResult(this);
	}

}
