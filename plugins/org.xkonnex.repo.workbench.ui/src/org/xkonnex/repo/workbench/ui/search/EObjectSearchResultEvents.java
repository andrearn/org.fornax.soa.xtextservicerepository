/*
 * based on Xtext findrefs components
 */
package org.xkonnex.repo.workbench.ui.search;

import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.xtext.resource.IEObjectDescription;

public class EObjectSearchResultEvents {
	
	public static class Added extends SearchResultEvent {
		
		private static final long serialVersionUID = 353608722108392220L;
		private final IEObjectDescription eObjectDescription;

		public Added(ISearchResult searchResult, IEObjectDescription eObjectDescription) {
			super(searchResult);
			this.eObjectDescription = eObjectDescription;
		}

		public IEObjectDescription getEObjectDescription() {
			return eObjectDescription;
		}
	}

	public static class Finish extends SearchResultEvent {

		private static final long serialVersionUID = -420070777693899476L;

		public Finish(ISearchResult result) {
			super(result);
		}
	}

	public static class Reset extends SearchResultEvent {

		private static final long serialVersionUID = 8243724417675821536L;

		public Reset(EObjectSearchResult eObjectSearchResult) {
			super(eObjectSearchResult);
		}
	}

}
