package org.xkonnex.repo.dsl.servicedsl.service.versioning;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractVersionedTypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType;

public interface IVersionedTypeRefResolver {
	
	public Type findMatchingTypeVersion (EObject t);
//	public org.xkonnex.repo.dsl.semanticsdsl.profiledsl.sOAProfileDsl.Type findMatchingType (DataTypeRef t);

	public VersionedType selectMatchingTypeVersion (AbstractVersionedTypeRef ref);
	public VersionedType selectMatchingTypeVersionByState (AbstractVersionedTypeRef ref, LifecycleState minState);

	public boolean typeMatchesMajorVersion (Type t, Integer majorVersion, LifecycleState minState); 
	public boolean typeMatchesMajorVersion (org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType t, Integer majorVersion);
	public boolean typeMatchesMajorVersion (org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedType t, Integer majorVersion);
}
