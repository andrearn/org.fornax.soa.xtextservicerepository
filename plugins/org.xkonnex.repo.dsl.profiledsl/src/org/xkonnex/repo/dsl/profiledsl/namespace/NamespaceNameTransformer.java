package org.xkonnex.repo.dsl.profiledsl.namespace;

import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile;

import com.google.inject.ImplementedBy;

@ImplementedBy(ProfileNamespaceNameTransformer.class)
public interface NamespaceNameTransformer {
	
	String getNamespaceBaseName (String namespace, Profile profile);
	String getNamespaceShortBaseName (String namespace, Profile profile);

}
