package org.fornax.soa.service.versioning;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.AbstractVersionedTypeRef;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;

public interface ITypeResolver {
	
	public Type findMatchingType (EObject t);
	public org.fornax.soa.profiledsl.sOAProfileDsl.Type findMatchingType (DataTypeRef t);
	public Type findMatchingTypeByState (TypeRef t, LifecycleState minState);

	public VersionedType selectMatchingType (AbstractVersionedTypeRef ref);
	public VersionedType selectMatchingTypeByState (AbstractVersionedTypeRef ref, LifecycleState minState);

	public boolean isMatchingType (Type t, Integer majorVersion, LifecycleState minState); 
	public boolean isMatchingType (org.fornax.soa.serviceDsl.VersionedType t, Integer majorVersion);
	public boolean isMatchingType (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType t, Integer majorVersion);
}
