package org.fornax.soa.servicedsl.templates.xsd

import org.fornax.soa.serviceDsl.TypeRef
import org.fornax.soa.serviceDsl.VersionedTypeRef
import com.google.inject.Inject
import org.fornax.soa.servicedsl.query.namespace.NamespaceQuery
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.servicedsl.query.LifecycleQueries
import org.fornax.soa.servicedsl.query.VersionQueries
import org.fornax.soa.serviceDsl.BusinessObjectRef
import org.fornax.soa.serviceDsl.DataTypeRef
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.EnumTypeRef
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.servicedsl.VersionedDomainNamespace
import org.fornax.soa.serviceDsl.Type
import org.fornax.soa.servicedsl.domain.NamespaceSplitter
import org.fornax.soa.servicedsl.query.type.LatestMatchingTypeFinder
import org.fornax.soa.serviceDsl.BusinessObject
import org.fornax.soa.serviceDsl.Attribute
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.servicedsl.query.type.BusinessObjectQueries
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.serviceDsl.SubNamespace
import java.util.HashSet
import java.util.Set
import java.util.List
import org.fornax.soa.serviceDsl.Property
import org.fornax.soa.serviceDsl.VersionedType
import org.fornax.soa.servicedsl.query.ExceptionFinder
import org.fornax.soa.serviceDsl.Enumeration
import org.fornax.soa.profiledsl.ProfileSchemaTypeExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.DataType
import org.fornax.soa.profiledsl.sOAProfileDsl.EnumRef
import org.fornax.soa.profiledsl.ProfileSchemaNamespaceExtensions

/* types.ext */
class SchemaTypeExtensions {
	
	@Inject extension VersionMatcher
	@Inject extension SchemaNamespaceExtensions
	@Inject extension NamespaceQuery
	@Inject extension NamespaceSplitter
	@Inject extension VersionQualifierExtensions
	@Inject extension LifecycleQueries
	@Inject extension VersionQueries
	@Inject extension LatestMatchingTypeFinder
	@Inject extension BusinessObjectQueries
	@Inject extension ExceptionFinder
	
	@Inject ProfileSchemaTypeExtensions profileSchemaTypes
	@Inject org.fornax.soa.profiledsl.query.NamespaceQueries profileNSQueries
	@Inject ProfileSchemaNamespaceExtensions profileSchemaNSExt
	/*
	 *	Return the XSD type name for a type reference including it's derived namespace prefix
	 */
	def dispatch String toTypeNameRef (TypeRef t) {
		null;
	}
	
	def dispatch String toTypeNameRef (org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef t) {
		null;
	}
	
	def dispatch String toTypeNameRef (DataTypeRef t) {
		t.type.toTypeNameRef();
	}
	
	def dispatch String toTypeNameRef (DataType t) {
		profileSchemaTypes.toTypeNameRef (t);
	}
	
	def dispatch String toTypeNameRef (org.fornax.soa.profiledsl.sOAProfileDsl.DataTypeRef t) {
		t.type.toTypeNameRef();
	}

	def dispatch String toTypeNameRef (org.fornax.soa.profiledsl.sOAProfileDsl.AttributeDataTypeRef t) {
		t.type.toTypeNameRef();
	}
	
//	t.getLatestMatchingType () .getTypeNameRef();
	
	def dispatch String toTypeNameRef (VersionedTypeRef t) {
		if (t.type.findSubdomain() != null) {
			var prefix = "tns";
			if (! (t.findOwnerSubdomain() == t.type.findSubdomain()
				&& t.getOwnerVersion().toMajorVersionNumber() == t.type.version.toMajorVersionNumber()
			 	&& ! (t.getStatefulOwner() instanceof Service))
			) {
			 	prefix = t.type.findSubdomain().toShortName() + t.type.version.toMajorVersionNumber();
			}
			prefix + ":" +t.type.name;
		} else {
			t.type.name;
		}
	}
	
	def dispatch String toTypeNameRef (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef t) {
		if (profileNSQueries.findTechnicalNamespace (t.type) != null) {
			var prefix = "tns";
			if (! (profileNSQueries.findOwnerSubdomain(t) == profileNSQueries.findTechnicalNamespace (t.type)
				&& t.getOwnerVersion().toMajorVersionNumber() == t.type.version.toMajorVersionNumber())
			) {
				prefix = profileNSQueries.findTechnicalNamespace (t.type).toShortName() + t.type.version.toMajorVersionNumber();
			}
			prefix + ":" +t.type.name
		} else {
			t.type.name;
		}
	}
	
	def dispatch String toTypeNameRef (BusinessObjectRef t) { 
		if (t.type.findSubdomain() != null) {
			var prefix = "tns";
			if (!(t.findOwnerSubdomain() == t.type.findSubdomain()
				&& t.getOwnerVersion().toMajorVersionNumber() == t.type.version.toMajorVersionNumber()
				&& !(t.getStatefulOwner() instanceof Service))
			)  {
				prefix = t.type.findSubdomain().toShortName() + t.type.version.toMajorVersionNumber();
			}
			prefix + ":" + t.type.name;
		} else {
			t.type.name;
		}
	}
		
	def dispatch String toTypeNameRef (EnumTypeRef t) { 
		if (t.type.findSubdomain() != null) {
			var prefix = "tns";
			if (!(t.findOwnerSubdomain() == t.type.findSubdomain()
				&& t. getOwnerVersion().toMajorVersionNumber() == t.type.version.toMajorVersionNumber()
				&& ! (t.getStatefulOwner() instanceof Service))
			) {
				prefix = t.type.findSubdomain().toShortName() + t.type.version.toMajorVersionNumber();
			}
			prefix + ":" +t.type.name;
		} else {
			t.type.name;
		}
	}
	
	def dispatch String toExceptionNameRef (ExceptionRef t) {
		if (t.exception.findSubdomain() != null) {
			var prefix = "tns";
			if (!(t.findOwnerSubdomain() == t.exception.findSubdomain()
			 && t.getOwnerVersion().toMajorVersionNumber() == t.exception.version.toMajorVersionNumber()
			 && ! (t.getStatefulOwner() instanceof Service))
			) {
				t.exception.findSubdomain().toShortName() + t.exception.version.toMajorVersionNumber()
			}
			prefix + ":" +t.exception.toTypeName()
		} else {
			t.exception.toTypeName();
			
		}
	
	}
	

	def dispatch String toTypeNameRef (TypeRef t, VersionedDomainNamespace currNs) {
		null;
	}
	def dispatch String toTypeNameRef (org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef t, VersionedDomainNamespace currNs) {
		null;
	}
	
	def dispatch String toTypeNameRef (DataTypeRef t, VersionedDomainNamespace currentDomNs) {
		t.findLatestMatchingType ().toTypeNameRef();
	}
		
	def dispatch String toTypeNameRef (VersionedTypeRef t, VersionedDomainNamespace currNs) { 
		if (t.type.findSubdomain().toUnversionedNamespace() == currNs.subdomain.toUnversionedNamespace()  
			&& t.getOwnerVersion().toMajorVersionNumber() == t.type.version.toMajorVersionNumber()
			&& ! (t.getStatefulOwner() instanceof Service)
		
		) {
			"tns:" +t.type.name;
		} else {
			t.type.findSubdomain().toShortName() + t.type.version.toMajorVersionNumber() + ":" +t.type.name;
		}
	}
		
	def dispatch String toTypeNameRef (BusinessObjectRef t, VersionedDomainNamespace currNs) { 
		if (t.type.findSubdomain().toUnversionedNamespace() == currNs.subdomain.toUnversionedNamespace()
			&& t.getOwnerVersion().toMajorVersionNumber() == t.type.version.toMajorVersionNumber()
			&& !(t.getStatefulOwner() instanceof Service)
		) {
			"tns:" +t.type.name;
		} else {
			t.type.findSubdomain().toShortName() + t.type.version.toMajorVersionNumber() + ":" +t.type.name;
		}
	}
			
	def dispatch String toTypeNameRef (EnumTypeRef t, VersionedDomainNamespace currNs) { 
		if (t.type.findSubdomain().toUnversionedNamespace() == currNs.subdomain.toUnversionedNamespace()  
			&& t.getOwnerVersion().toMajorVersionNumber() == t.type.version.toMajorVersionNumber()
			&& !(t.getStatefulOwner() instanceof Service) 
		) {
			"tns:" +t.type.name;
		} else {
			t.type.findSubdomain().toShortName() + t.type.version.toMajorVersionNumber() + ":" +t.type.name;
		}
	}
	
	def dispatch String toTypeNameRef (Type t) {
		"";
	}
	
	def dispatch String toFullTypeNameRef (TypeRef t, VersionedDomainNamespace currNs) {
		null;
	}
	
	def dispatch String toFullTypeNameRef (DataTypeRef t, VersionedDomainNamespace currentDomNs) { 
		t.findLatestMatchingType () .toFullTypeNameRef();
	}
		
	def dispatch String toFullTypeNameRef (VersionedTypeRef t, VersionedDomainNamespace currNs) { 
		t.toNamespace() + t.type.name;
	}
		
	def dispatch String toFullTypeNameRef (BusinessObjectRef t, VersionedDomainNamespace currNs) { 
		t.toNamespace() + t.type.name;
	}
			
	def dispatch String toFullTypeNameRef (EnumTypeRef t, VersionedDomainNamespace currNs) { 
		t.toNamespace() + t.type.name;
	}
	
	def dispatch String toFullTypeNameRef (Type t) {
		"";
	}
	def dispatch String toFullTypeNameRef (org.fornax.soa.profiledsl.sOAProfileDsl.DataType t) {
	 	switch (t.name) {
	 		case "attachment":		"xsd:base64Binary"
	 		case "binary":			"xsd:hexBinary"
	 		case "base64Binary":	"xsd:base64Binary"
	 		case "BigInteger":		"xsd:decimal"
	 		case "BigDecimal":		"xsd:decimal"
	 		case "char":			"xsd:string"
	 		case "datetime":		"xsd:dateTime"
	 		case "Object":			"xsd:anyType"
			default : "xsd:" + t.name
		}
	}
		
	def dispatch boolean isAttachment (TypeRef t) {
		false;
	}
	def dispatch boolean isAttachment (DataTypeRef t) {
		switch (t.type.name) {
			case "base64Binary": 	true
			case "attachment":		true
			default:				false
		};
	}
	 
	
	/*
	 * Resolve the type name of weak type reference, i.e. return the type name referenced type's businessKey
	 */ 
	def dispatch String toWeakRefType (TypeRef t) {
		t.toTypeNameRef();
	}
	def dispatch String toWeakRefType (VersionedTypeRef t) {
		if (t.findLatestMatchingType() instanceof BusinessObject) {
			(t.findLatestMatchingType() as BusinessObject).properties
				.filter (e|e.isBusinessKey).filter (typeof (Attribute)).toList().head().type.toTypeNameRef()
		} else {
			t.toTypeNameRef();
		}
	}
	def dispatch String toWeakRefType (BusinessObjectRef t) {
		(t.findLatestMatchingType() as BusinessObject).properties.filter (e|e.isBusinessKey).filter (typeof (Attribute)).toList.head().type.toTypeNameRef();
	}
	def dispatch String toWeakRefKeyAttr (TypeRef t) {
		null;
	}
	def dispatch String toWeakRefKeyAttr (BusinessObjectRef t) {
		(t.findLatestMatchingType() as BusinessObject).properties.filter (e|e.isBusinessKey)
			.filter (typeof (Attribute)).head().name;
	}
	
	def dispatch String toWeakRefType(TypeRef t, LifecycleState minState) {
		t.toTypeNameRef();
	}
	def dispatch String toWeakRefType(VersionedTypeRef t, LifecycleState minState) {
		if ((t.findLatestMatchingType(minState) instanceof BusinessObject) 
			&&	! (t.findLatestMatchingType (minState) as BusinessObject).findAllVisibleProperties (minState).filter (e|e.isBusinessKey).filter (typeof (Attribute)).isEmpty)
		{
	 		(t.findLatestMatchingType(minState) as BusinessObject).findAllVisibleProperties(minState)
	 			.filter (e|e.isBusinessKey).filter (typeof (Attribute)).toList.head().type.toTypeNameRef();
	 	} else {
	 		t.toTypeNameRef();
	 	}
	}
	def dispatch String toWeakRefType(BusinessObjectRef t, LifecycleState minState) {
		if (! (t.findLatestMatchingType (minState) as BusinessObject).findAllVisibleProperties(minState)
			.filter (e|e.isBusinessKey).filter (typeof (Attribute)).isEmpty 
		) {
			(t.findLatestMatchingType (minState) as BusinessObject).findAllVisibleProperties(minState)
				.filter (e|e.isBusinessKey).filter (typeof (Attribute)).toList.head().type.toTypeNameRef();
		} else {
			null;
		}
	}
	def dispatch String toWeakRefKeyAttr(TypeRef t, LifecycleState minState) {
		null;
	}
	def dispatch String toWeakRefKeyAttr(BusinessObjectRef t, LifecycleState minState) { 
		if (! (t.findLatestMatchingType(minState) as BusinessObject).findAllVisibleProperties(minState)
			.filter (e|e.isBusinessKey).filter (typeof (Attribute)).isEmpty
		) {
			(t.findLatestMatchingType(minState) as BusinessObject).findAllVisibleProperties(minState)
				.filter (e|e.isBusinessKey).filter (typeof (Attribute)).head().name;
		} else {
			null;
		}
	}
		
		
	def dispatch String toExceptionNameRef (ExceptionRef t, VersionedDomainNamespace currNs) {
		if (t.toNamespace() == currNs.subdomain.toNamespace() && currNs.version.toVersion().versionMatches(t.version)) {
			"tns:" +t.exception.toTypeName();
		} else {
			t.exception.findSubdomain().toShortName() + t.exception.findSubdomain().version.toMajorVersionNumber() + ":" +t.exception.toTypeName();
		}
	}		
		
	def dispatch boolean isMany (TypeRef t) {
		false;
	}
	def dispatch boolean isMany (DataTypeRef t) {
		t.many;
	}
	def dispatch boolean isMany (BusinessObjectRef t) {
		false;
	}
	def dispatch boolean isMany (VersionedTypeRef t) {
		t.many;
	}
	
	
	def dispatch String getXsdFilename (BusinessObject c) {
		c.findSubdomain().toFileNameFragment() + "-v" + c.version.toMajorVersionNumber() + ".xsd";
	}
	
	
	/*
	 *	Get the namespaces a given namespace (or element declared in that namespace) imports
	 *  splitting the resultingnamespace with regard to their major versions
	 */
	def dispatch Set<VersionedDomainNamespace> getImportedSubdomains (Object s) {
		null;
	}
	
	def dispatch Set<VersionedDomainNamespace> getImportedSubdomains (VersionedDomainNamespace s) {
		(s.subdomain as SubNamespace).getImportedSubdomains();
	} 
	def dispatch Set<VersionedDomainNamespace> getImportedSubdomains (SubNamespace s) {
		var ns = new HashSet<VersionedDomainNamespace>();
		// all refs from a BO property to a BO  
		ns.addAll (s.types.filter (typeof (BusinessObject)).map(t|t.properties).flatten
			.map(p|p.type).filter (typeof (VersionedTypeRef))
			.map(r|r.findLatestMatchingType()).filter (e|e!=null).map(e|e.createVersionedDomainNamespace())
		);
		// all refs from a BO to it's superBO  
		ns.addAll (s.types.filter (typeof (BusinessObject)).filter (e|e.superBusinessObject != null)
			.map(b|b.superBusinessObject.findLatestMatchingType().createVersionedDomainNamespace()));
		// all refs from exceptions to their super exceptions
		ns.addAll (s.exceptions.filter (e|e.superException != null).map (ex|ex.superException.findLatestMatchingException().createVersionedDomainNamespace()));
		return ns;
	}
	
	def dispatch Set<VersionedDomainNamespace> getImportedSubdomains (List<TypeRef> c) { 
		c.map(e|e.findLatestMatchingType().createVersionedDomainNamespace()).toSet();
	}
		
	
	def dispatch String toNamespace (TypeRef t) {
	}
	
	def dispatch String toNamespace (VersionedTypeRef t) { 
		t.type.eContainer.toUnversionedNamespace()+"/"+(t.findLatestMatchingType() as VersionedType).version.toVersionPostfix() + "/";
	}
	def dispatch String toNamespace (BusinessObjectRef t) { 
		t.type.eContainer.toUnversionedNamespace()+"/"+(t.findLatestMatchingType() as BusinessObject).version.toVersionPostfix() + "/";
	}
	def dispatch String toNamespace (EnumTypeRef t) {
		t.type.eContainer.toUnversionedNamespace()+"/"+(t.findLatestMatchingType() as Enumeration).version.toVersionPostfix() + "/";
	}
	def dispatch String toNamespace (ExceptionRef t) {
		t.exception.eContainer.toUnversionedNamespace()+"/"+(t.findLatestMatchingException() as org.fornax.soa.serviceDsl.Exception).version.toVersionPostfix() + "/";
	}
	
		
		
}