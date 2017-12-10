package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

/**
 * REST request parameter mapping parameterStyle
 * @author aarnold
 *
 */
public enum RESTParameterStyle {
	/** Parameters transferred in the query string part of the URL or in the 
	 * HTTP message body (PUT/POST) 
	 */
	query,
	/** Parameters are are transferred in the path part of the URL,  
	 * e.g. http://example.org/api/customer=1;contract=2
	 */
	matrix,
	/**
	 * Parameters are transferred in the HTTP header
	 */
	header,
	/** 
	 * URL templating
	 * e.g. http://example.org/api/customer/1
	 */
	template, 
	plain 
}
