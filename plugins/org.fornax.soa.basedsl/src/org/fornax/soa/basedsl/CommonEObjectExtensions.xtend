package org.fornax.soa.basedsl

import org.eclipse.emf.ecore.EObject
import org.fornax.soa.basedsl.sOABaseDsl.Version

class CommonEObjectExtensions {
	
	def EObject eRootContainer (EObject o) {
		if (o.eContainer != null) {
			o.eRootContainer
		} else {
			return o;
		}
	}

	def dispatch String fqn (EObject o) {
		null;
	}
	
	def dispatch EObject getOwningType (EObject o) {
		o.eContainer?.getOwningType();
	}
	
	def dispatch Version getOwnerVersion (EObject o) {
		o.eContainer?.getOwnerVersion();
	}

}