package org.xkonnex.repo.dsl.basedsl

import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.Version
import org.eclipse.xtext.naming.IQualifiedNameProvider
import com.google.inject.Inject

class CommonEObjectExtensions {
	
	@Inject IQualifiedNameProvider nameProvider
	
	def EObject eRootContainer (EObject o) {
		if (o.eContainer != null) {
			o.eRootContainer
		} else {
			return o;
		}
	}

	def String fqn (EObject o) {
		nameProvider.getFullyQualifiedName(o).toString;
	}

}