package org.fornax.soa.service.versioning;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.AbstractVersionedTypeRef;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;

public interface IVersionedTypeRefResolver {
	
	public Type findMatchingTypeVersion (EObject t);
//	public org.fornax.soa.profiledsl.sOAProfileDsl.Type findMatchingType (DataTypeRef t);

	public VersionedType selectMatchingTypeVersion (AbstractVersionedTypeRef ref);
	public VersionedType selectMatchingTypeVersionByState (AbstractVersionedTypeRef ref, LifecycleState minState);

	public boolean typeMatchesMajorVersion (Type t, Integer majorVersion, LifecycleState minState); 
	public boolean typeMatchesMajorVersion (org.fornax.soa.serviceDsl.VersionedType t, Integer majorVersion);
	public boolean typeMatchesMajorVersion (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType t, Integer majorVersion);
}
