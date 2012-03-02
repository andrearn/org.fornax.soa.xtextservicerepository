package org.fornax.soa.servicedsl.generator.query;

import java.util.ArrayList;
import java.util.List;

import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;

public class TypeReferenceHelper {
	
	public static List<Type> findAllImportedNamespacesForBO (BusinessObject bo) {
		List<Property> props = bo.getProperties();
		List<TypeRef> typeRefs = new ArrayList<TypeRef>();
		for (Property p : props) {
			typeRefs.add(p.getType());
		}
		List<Type> refTypes = new ArrayList<Type>();
		for (TypeRef typeRef : typeRefs) {
			if (refTypes instanceof VersionedType) {
				refTypes.add(((VersionedTypeRef)typeRef).getType());
			}
		}
		refTypes.add(bo.getSuperBusinessObject().getType());
		return null;
	}

}
