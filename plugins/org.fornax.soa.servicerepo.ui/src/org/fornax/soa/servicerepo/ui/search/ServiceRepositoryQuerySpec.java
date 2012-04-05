/*
 * based on Xtext findrefs components
 */
package org.fornax.soa.servicerepo.ui.search;

public class ServiceRepositoryQuerySpec {
	
	private String pattern;
	private String searchFor;
	private String queryName;
	private boolean caseSensitive;
	private String scopeDescription;
    private String minState;
    private String maxState;

	
	
	public ServiceRepositoryQuerySpec(String pattern, String searchFor, String queryName, boolean caseSensitive, String scopeDescription) {
		this.pattern = pattern;
		this.searchFor = searchFor;
		this.queryName = queryName;
		this.caseSensitive = caseSensitive;
		this.scopeDescription = scopeDescription;
	}
	
	public String getPattern() {
		return pattern;
	}


	public void setPattern(String pattern) {
		this.pattern = pattern;
	}


	public String getSearchFor() {
		return searchFor;
	}


	public void setSearchFor(String searchFor) {
		this.searchFor = searchFor;
	}


	public String getQueryName() {
		return queryName;
	}


	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}


	public boolean isCaseSensitive() {
		return caseSensitive;
	}


	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}


	public String getScopeDescription() {
		return scopeDescription;
	}


	public void setScopeDescription(String scopeDescription) {
		this.scopeDescription = scopeDescription;
	}

	public void setMinState(String minState) {
		this.minState = minState;
	}

	public String getMinState() {
		return minState;
	}

	public void setMaxState(String maxState) {
		this.maxState = maxState;
	}

	public String getMaxState() {
		return maxState;
	}

}
