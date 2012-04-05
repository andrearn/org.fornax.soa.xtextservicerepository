/*
 * based on Xtext findrefs components
 */
package org.fornax.soa.servicerepo.ui.search;

import java.util.ArrayList;

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
import org.fornax.soa.profiledsl.search.FindAssetsWithStateQuery;
import org.fornax.soa.query.FindUnapprovedAssetsQuery;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import com.google.inject.Injector;


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
		// TODO Auto-generated method stub
		return "Service repository query result";
	}

	public ISearchResult getSearchResult() {
		return searchResult;
	}

	public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {
		searchResult.reset();
		IProject[] projects = workspace.getRoot().getProjects();
		for (IProject project : projects) {
			if (XtextProjectHelper.hasNature(project)) {
				Iterable<IEObjectDescription> result = doSearch (project);
				for (IEObjectDescription ieObjDesc : result) {
					searchResult.accept (ieObjDesc);
				}
			}
		}
		searchResult.finish();
		return (monitor.isCanceled()) ? Status.CANCEL_STATUS : Status.OK_STATUS;
	}

	public Iterable<IEObjectDescription> doSearch(IProject project) {
		Iterable<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		ResourceSet rs = resourceSetProvider.get(project);
		
		String queryName = querySpec.getQueryName();
		if (FindUnapprovedAssetsQuery.class.getName().equals(queryName)) {
			unApprovedServicesQuery = injector.getInstance (FindUnapprovedAssetsQuery.class);
			result = unApprovedServicesQuery.search(pattern, assetType, resourceSetProvider.get(project));
		} else if (FindAssetsWithStateQuery.class.getName().equals(queryName)) { 
			FindAssetsWithStateQuery query = injector.getInstance(FindAssetsWithStateQuery.class);
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
			
			result = query.search (pattern, assetType, minState, maxState, rs);
		} else {
			result = predicateSearch.search(pattern, assetType, new Predicate<IEObjectDescription>() {
				public boolean apply(IEObjectDescription input) {
					if (input.getEObjectOrProxy().getClass().getCanonicalName().startsWith("org.fornax.soa."))
						return true;
					else
						return false;
				}
			});
		}
		return result;
	}

	protected EObjectSearchResult createSearchResult() {
		return new EObjectSearchResult(this);
	}

}
