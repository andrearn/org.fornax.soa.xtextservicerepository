package org.fornax.soa.service.util;

import java.util.List;

import org.fornax.soa.basedsl.util.VersionRefMatcher;
import org.fornax.soa.service.query.TypePropertyQueries;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.ibm.icu.util.ULocale.Type;

public class TypeRefMatcher {
	
	@Inject
	private VersionRefMatcher versionRefMatcher;
	
	@Inject
	private TypePropertyQueries typePropQueries;
	
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
