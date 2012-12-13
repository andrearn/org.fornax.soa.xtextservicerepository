package org.fornax.soa.service.util;

import java.util.List;

import org.fornax.soa.basedsl.util.VersionRefMatcher;
import org.fornax.soa.service.query.TypePropertyQueries;
import org.fornax.soa.serviceDsl.Attribute;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.Reference;
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
		if (prop1 instanceof Attribute && prop2 instanceof Attribute) {
			return matches (ref1, ref2);
		} else if (prop1 instanceof Reference && prop2 instanceof Reference) {
			BusinessObject bo1 = (BusinessObject)((VersionedTypeRef)ref1).getType();
			List<Property> keys1 = typePropQueries.getBOBusinessKeys(bo1);
			if (keys1 == null || keys1.isEmpty()) {
				keys1 = typePropQueries.getBOProvidedKeys(bo1);
			}
			BusinessObject bo2 = (BusinessObject)((VersionedTypeRef)ref1).getType();
			List<Property> keys2 = typePropQueries.getAllBOKeys(bo2);
			if (keys2 == null || keys2.isEmpty()) {
				keys2 = typePropQueries.getBOProvidedKeys(bo2);
			}
			if (keys1.size() != 1 && keys2.size() != 1)
				return TypeRefMatchResult.NO_MATCH;
			TypeRef key1TypeRef = keys1.get(0).getType();
			TypeRef key2TypeRef = keys2.get(0).getType();
			return matches (key1TypeRef, key2TypeRef);
		} else if (prop1 instanceof Attribute && prop2 instanceof Reference) {
			BusinessObject bo2 = (BusinessObject)((VersionedTypeRef)ref1).getType();
			List<Property> keys2 = typePropQueries.getAllBOKeys(bo2);
			if (keys2 == null || keys2.isEmpty()) {
				keys2 = typePropQueries.getBOProvidedKeys(bo2);
			}
			if (keys2.size() != 1)
				return TypeRefMatchResult.NO_MATCH;
			TypeRef key2TypeRef = keys2.get(0).getType();
			return matches (ref1, key2TypeRef);
		} else if (prop1 instanceof Reference && prop2 instanceof Attribute) {
			BusinessObject bo1 = (BusinessObject)((VersionedTypeRef)ref1).getType();
			List<Property> keys1 = typePropQueries.getBOBusinessKeys(bo1);
			if (keys1 == null || keys1.isEmpty()) {
				keys1 = typePropQueries.getBOProvidedKeys(bo1);
			}
			if (keys1.size() != 1)
				return TypeRefMatchResult.NO_MATCH;
			TypeRef key1TypeRef = keys1.get(0).getType();
			return matches (key1TypeRef, ref2);
		}
		return TypeRefMatchResult.NO_MATCH;
	}

}
