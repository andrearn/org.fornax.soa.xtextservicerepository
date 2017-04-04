package org.xkonnex.repo.dsl.servicedsl.service.util;

import org.xkonnex.repo.dsl.basedsl.util.VersionRefMatcher;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef;

import com.google.inject.Inject;

public class TypeRefMatcher {
	
	@Inject
	private VersionRefMatcher versionRefMatcher;
	
	/**
	 * tests whether the type reference in the version range of ref1 complies to types in the version range of ref2
	 * @param ref1
	 * @param ref2
	 * @return
	 */
	public TypeRefMatchResult matches (TypeRef ref1, TypeRef ref2) {
		if (ref1 instanceof VersionedTypeRef && ref2 instanceof VersionedTypeRef) {
			VersionedTypeRef verTypeRef1 = (VersionedTypeRef) ref1; 
			VersionedTypeRef verTypeRef2 = (VersionedTypeRef) ref2;
			String verTypeName1 = verTypeRef1.getType().getName();
			String verTypeName2 = verTypeRef2.getType().getName();
			Class<? extends VersionedType> verTypeCls1 = verTypeRef1.getType().getClass();
			Class<? extends VersionedType> verTypeCls2 = verTypeRef2.getType().getClass();
			if (verTypeName1.equals(verTypeName2) && verTypeCls1.equals(verTypeCls2)) {
				if (versionRefMatcher.matches (verTypeRef1.getVersionRef(), verTypeRef2.getVersionRef()))
					return TypeRefMatchResult.FULL_MATCH;
				else
					return TypeRefMatchResult.NO_VERSION_MATCH;
			}
			
		} else if (ref1 instanceof DataTypeRef && ref2 instanceof DataTypeRef) {
			DataTypeRef dataTypeRef1 = (DataTypeRef) ref1; 
			DataTypeRef dataTypeRef2 = (DataTypeRef) ref2;
			if (dataTypeRef1.getType().getName().equals(dataTypeRef2.getType().getName())) {
				return TypeRefMatchResult.FULL_MATCH;
			}
		}
		return TypeRefMatchResult.NO_MATCH;
	}
	
	public TypeRefMatchResult matches (Property prop1, Property prop2) {
		TypeRef ref1 = prop1.getType();
		TypeRef ref2 = prop2.getType();
		return matches (ref1, ref2);
	}

}
