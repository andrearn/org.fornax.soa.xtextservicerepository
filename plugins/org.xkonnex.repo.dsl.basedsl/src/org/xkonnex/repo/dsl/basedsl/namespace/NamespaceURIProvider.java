package org.xkonnex.repo.dsl.basedsl.namespace;

import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultNamespaceURIProvider.class)
public interface NamespaceURIProvider {

	String getNamespaceURI (Namespace ns);
	String getNamespaceURI (String ns);
	
	String getHostPart (Namespace ns);
	String getPathPart (Namespace ns);
	
	String getHostPart (String ns);
	String getPathPart (String ns);
	
	boolean requiresTrailingSlash (Namespace ns);
	
	String getNamespacePrefix (String qualifiedNameFragment);
	String getNamespacePrefix (Namespace ns);
	String getNamespacePrefix (VersionedNamespace ns);
	
	String getVersionedNamespacePrefix (String qualifiedNameFragment);
	String getVersionedNamespacePrefix (Namespace ns);
	String getVersionedNamespacePrefix (VersionedNamespace ns);
	
	String getVersionPostfix (Namespace ns);
	String getVersionPostfix (VersionedNamespace ns);

}
