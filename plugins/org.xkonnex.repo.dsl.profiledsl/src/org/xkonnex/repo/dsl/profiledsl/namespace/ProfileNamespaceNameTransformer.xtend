package org.xkonnex.repo.dsl.profiledsl.namespace

import org.xkonnex.repo.dsl.profiledsl.namespace.NamespaceNameTransformer
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile

class ProfileNamespaceNameTransformer implements NamespaceNameTransformer {

	override getNamespaceBaseName(String namespace, Profile profile) {
		profile.namespaceRules?.aliases?.
			findFirst[namespace.startsWith(baseNamespaceFragment)]?.
			baseNamespaceFragment
	}

	override getNamespaceShortBaseName(String namespace, Profile profile) {
		profile.namespaceRules?.aliases?.
			findFirst[namespace.startsWith(baseNamespaceFragment)]?.
			shortenedBaseNamespaceFragment
	}

}