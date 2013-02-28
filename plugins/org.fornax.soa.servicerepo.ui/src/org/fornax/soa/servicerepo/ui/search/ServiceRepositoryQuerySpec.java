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
    private String minVersion;
    private String maxVersion;
    private boolean canonicalNamespaces;
    private boolean nonCanonicalNamespaces;

	
	
	public ServiceRepositoryQuerySpec(String pattern, String searchFor, String queryName, boolean caseSensitive, String scopeDescription) {
		this.pattern = pattern;
		if (pattern == null || "".equals(pattern)) {
			this.pattern = "*";
		}
		this.searchFor = searchFor;
		if (searchFor == null || "Any".equals(searchFor)) {
			this.searchFor = "*";
		}
		this.queryName = queryName;
		this.caseSensitive = caseSensitive;
		this.scopeDescription = scopeDescription;
		this.canonicalNamespaces = true;
		this.nonCanonicalNamespaces = true;
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

	public void setMinVersion(String minVersion) {
		this.maxVersion = minVersion;
	}

	public void setMaxVersion(String maxVersion) {
		this.maxVersion = maxVersion;
	}

	public String getMinVersion() {
		return minVersion;
	}

	public String getMaxVersion() {
		return maxVersion;
	}

	public boolean isCanonicalNamespaces() {
		return canonicalNamespaces;
	}

	public void setCanonicalNamespaces(boolean canonicalNamespaces) {
		this.canonicalNamespaces = canonicalNamespaces;
	}

	public boolean isNonCanonicalNamespaces() {
		return nonCanonicalNamespaces;
	}

	public void setNonCanonicalNamespaces(boolean nonCanonicalNamespaces) {
		this.nonCanonicalNamespaces = nonCanonicalNamespaces;
	}
}
