package org.fornax.soa.servicedsl.query

import org.fornax.soa.serviceDsl.DataTypeRef
import org.fornax.soa.serviceDsl.Type
import org.fornax.soa.basedsl.sOABaseDsl.AbstractType
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.serviceDsl.AbstractVersionedTypeRef
import org.fornax.soa.serviceDsl.VersionedTypeRef
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState

class TypeRefExtensions {
	
	def dispatch EObject resolveType (EObject typeRef) {
		throw new UnsupportedOperationException()
	}
	
	def dispatch EObject resolveType (DataTypeRef typeRef) {
		typeRef.type
	}
	
	def dispatch EObject resolveType (VersionedTypeRef typeRef) {
		typeRef.type
	}
	
	def dispatch EObject resolveType (org.fornax.soa.profiledsl.sOAProfileDsl.DataTypeRef typeRef) {
		typeRef.type
	}
	
	def dispatch EObject resolveType (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef typeRef) {
		typeRef.type
	}
}