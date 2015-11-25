package org.xkonnex.repo.dsl.basedsl.namespace;

import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultNamespaceURIProvider.class)
public interface NamespaceURIProvider {

	String getUnversionedNamespaceURI(Namespace ns);
	
	String getHostPart (Namespace ns);
	
	String getPathPart(Namespace ns);
	
	boolean requiresTrailingSlash (Namespace ns);

}
