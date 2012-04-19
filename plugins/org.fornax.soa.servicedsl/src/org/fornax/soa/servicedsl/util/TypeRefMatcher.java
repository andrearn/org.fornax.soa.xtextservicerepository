package org.fornax.soa.servicedsl.util;

import org.fornax.soa.basedsl.util.VersionRefMatcher;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;

public class TypeRefMatcher {
	
	private VersionRefMatcher versionRefMatcher;
	
	/**
	 * tests whether the type reference in the version range of ref1 comply to types in the version range of ref2
	 * @param ref1
	 * @param ref2
	 * @return
	 */
	public boolean matches (TypeRef ref1, TypeRef ref2) {
		if (ref1 instanceof VersionedTypeRef && ref1 instanceof VersionedTypeRef) {
			VersionedTypeRef verTypeRef1 = (VersionedTypeRef) ref1; 
			VersionedTypeRef verTypeRef2 = (VersionedTypeRef) ref2;
			String verTypeName1 = verTypeRef1.getType().getName();
			String verTypeName2 = verTypeRef2.getType().getName();
			Class<? extends VersionedType> verTypeCls1 = verTypeRef1.getType().getClass();
			Class<? extends VersionedType> verTypeCls2 = verTypeRef2.getType().getClass();
			if (verTypeName1.equals(verTypeName2) && 
					versionRefMatcher.matches (verTypeRef1.getVersionRef(), verTypeRef2.getVersionRef()) &&
					verTypeCls1.equals(verTypeCls2)) {
				return true;
			}
			
		} else if (ref1 instanceof DataTypeRef && ref2 instanceof DataTypeRef) {
			DataTypeRef dataTypeRef1 = (DataTypeRef) ref1; 
			DataTypeRef dataTypeRef2 = (DataTypeRef) ref2;
			return dataTypeRef1.getType().getName().equals(dataTypeRef2.getType().getName());
		}
		return false;
	}

}
