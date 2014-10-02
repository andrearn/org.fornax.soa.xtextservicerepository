/*
 * based on Xtext findrefs components
 */
package org.xkonnex.repo.workbench.ui.search;

import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.Lists;

public class EObjectSearchResult implements ISearchResult,
		IAcceptor<IEObjectDescription> {

	private ServiceRepositorySearchQuery query;

	private List<IEObjectDescription> matchingObjects;

	private List<ISearchResultListener> listeners;
	
	protected EObjectSearchResult(ServiceRepositorySearchQuery query) {
		this.query = query;
		matchingObjects = Lists.newArrayList();
		listeners = Lists.newArrayList();
	}


	public void addListener (ISearchResultListener l) {
		synchronized (listeners) {
			listeners.add(l);
		}
	}

	public void removeListener (ISearchResultListener l) {
		synchronized (listeners) {
			listeners.remove(l);
		}
	}

	void fireEvent (SearchResultEvent searchResultEvent) {
		synchronized (listeners) {
			for (ISearchResultListener listener : listeners) {
				listener.searchResultChanged(searchResultEvent);
			}
		}
	}

	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	public String getLabel() {
		return query.getLabel();
	}

	public ISearchQuery getQuery() {
		return query;
	}

	public String getTooltip() {
		return getLabel();
	}

	public void accept(IEObjectDescription eObjectDescription) {
		matchingObjects.add (eObjectDescription);
		fireEvent(new EObjectSearchResultEvents.Added (this, eObjectDescription));
	}

	public List<IEObjectDescription> getMatchingObjects() {
		return matchingObjects;
	}
	
	public int getMatchCount() {
		return matchingObjects.size ();
	}

	public void reset() {
		matchingObjects.clear();
		fireEvent(new EObjectSearchResultEvents.Reset (this));
	}

	public void finish() {
		fireEvent(new EObjectSearchResultEvents.Finish (this));
	}
}
