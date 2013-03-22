package org.fornax.soa.servicedsl.generator.templates.xsd

import com.google.inject.Inject
import org.fornax.soa.basedsl.search.IEObjectLookup
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaTypeExtensions
import org.fornax.soa.profiledsl.query.namespace.TechnicalNamespaceQueries
import org.fornax.soa.profiledsl.sOAProfileDsl.AttributeDataTypeRef
import org.fornax.soa.profiledsl.sOAProfileDsl.ClassRef
import org.fornax.soa.profiledsl.sOAProfileDsl.DataType
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.service.versioning.NamespaceSplitter
import org.fornax.soa.service.query.VersionQueries
import org.fornax.soa.service.query.namespace.NamespaceQuery
import org.fornax.soa.service.versioning.IExceptionResolver
import org.fornax.soa.service.versioning.ITypeResolver
import org.fornax.soa.serviceDsl.BusinessObject
import org.fornax.soa.serviceDsl.BusinessObjectRef
import org.fornax.soa.serviceDsl.DataTypeRef
import org.fornax.soa.serviceDsl.EnumTypeRef
import org.fornax.soa.serviceDsl.Enumeration
import org.fornax.soa.serviceDsl.Exception
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.serviceDsl.Property
import org.fornax.soa.serviceDsl.QueryObject
import org.fornax.soa.serviceDsl.QueryObjectRef
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.Type
import org.fornax.soa.serviceDsl.TypeRef
import org.fornax.soa.serviceDsl.VersionedType
import org.fornax.soa.serviceDsl.VersionedTypeRef

/**
 * Extension functions for 
 * Type representations and references in XSDs
 */
class SchemaTypeExtensions {
	
	@Inject extension VersionMatcher
	@Inject extension SchemaNamespaceExtensions
	@Inject extension NamespaceQuery
	@Inject extension VersionQualifierExtensions
	@Inject extension VersionQueries
	@Inject extension ITypeResolver
	@Inject extension IExceptionResolver
	@Inject extension IEObjectLookup
	
	@Inject ProfileSchemaTypeExtensions profileSchemaTypes
	@Inject TechnicalNamespaceQueries profileNSQueries
	
	/**
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
	
	def dispatch String toTypeNameRef (VersionedTypeRef t) {
		if (t.type.findSubdomain() != null) {
			var prefix = "tns";
			if (! (t.findTypeRefOwnerSubdomain() == t.type.findSubdomain()
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
			if (!(t.findTypeRefOwnerSubdomain() == t.type.findSubdomain()
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
	
	def dispatch String toTypeNameRef (QueryObjectRef t) { 
		if (t.type.findSubdomain() != null) {
			var prefix = "tns";
			if (!(t.findTypeRefOwnerSubdomain() == t.type.findSubdomain()
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
			if (!(t.findTypeRefOwnerSubdomain() == t.type.findSubdomain()
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
	
	def String toExceptionNameRef (ExceptionRef exRef) {
		if (exRef.exception.findSubdomain() != null) {
			var prefix = "tns";
			if (!(exRef.findExceptionRefOwnerSubdomain() == exRef.exception.findSubdomain()
			 && exRef.getOwnerVersion().toMajorVersionNumber() == exRef.exception.version.toMajorVersionNumber()
			 && ! (exRef.getStatefulOwner() instanceof Service))
			) {
				prefix = exRef.exception.findSubdomain().toShortName() + exRef.exception?.version?.toMajorVersionNumber()
			}
			prefix + ":" +exRef.exception.name
		} else {
			exRef.exception.name
			
		}
	
	}
	

	/**
	 * Calculate the plain type name used when a type needs to be referenced. The type name is not 
	 * qualified by namespace prefixes
	 */
	def dispatch String toTypeNameRef (TypeRef typeRef, VersionedDomainNamespace currNs) {
		null;
	}
	/**
	 * Calculate the plain type name used when a type needs to be referenced. The type name is not 
	 * qualified by namespace prefixes
	 */
	def dispatch String toTypeNameRef (org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef typeRef, VersionedDomainNamespace currNs) {
		null;
	}
	
	/**
	 * Calculate the plain type name used when a type needs to be referenced. The type name is not 
	 * qualified by namespace prefixes
	 */
	def dispatch String toTypeNameRef (DataTypeRef typeRef, VersionedDomainNamespace currentDomNs) {
		typeRef.type.toTypeNameRef();
	}
		
	/**
	 * Calculate the plain type name used when a type needs to be referenced. The type name is not 
	 * qualified by namespace prefixes
	 */
	def dispatch String toTypeNameRef (VersionedTypeRef typeRef, VersionedDomainNamespace currNs) { 
		if (typeRef.type.findSubdomain().toUnversionedNamespace() == currNs.subdomain.toUnversionedNamespace()  
			&& typeRef.getOwnerVersion().toMajorVersionNumber() == typeRef.type.version.toMajorVersionNumber()
			&& ! (typeRef.getStatefulOwner() instanceof Service)
		
		) {
			"tns:" +typeRef.type.name;
		} else {
			typeRef.type.findSubdomain().toShortName() + typeRef.type.version.toMajorVersionNumber() + ":" +typeRef.type.name;
		}
	}
		
	/**
	 * Calculate the plain type name used when a type needs to be referenced. The type name is not 
	 * qualified by namespace prefixes
	 */
	def dispatch String toTypeNameRef (BusinessObjectRef typeRef, VersionedDomainNamespace currNs) { 
		if (typeRef.type.findSubdomain().toUnversionedNamespace() == currNs.subdomain.toUnversionedNamespace()
			&& typeRef.getOwnerVersion().toMajorVersionNumber() == typeRef.type.version.toMajorVersionNumber()
			&& !(typeRef.getStatefulOwner() instanceof Service)
		) {
			"tns:" +typeRef.type.name;
		} else {
			typeRef.type.findSubdomain().toShortName() + typeRef.type.version.toMajorVersionNumber() + ":" +typeRef.type.name;
		}
	}
			
	/**
	 * Calculate the plain type name used when a type needs to be referenced. The type name is not 
	 * qualified by namespace prefixes
	 */
	def dispatch String toTypeNameRef (QueryObjectRef typeRef, VersionedDomainNamespace currNs) { 
		if (typeRef.type.findSubdomain().toUnversionedNamespace() == currNs.subdomain.toUnversionedNamespace()
			&& typeRef.getOwnerVersion().toMajorVersionNumber() == typeRef.type.version.toMajorVersionNumber()
			&& !(typeRef.getStatefulOwner() instanceof Service)
		) {
			"tns:" +typeRef.type.name;
		} else {
			typeRef.type.findSubdomain().toShortName() + typeRef.type.version.toMajorVersionNumber() + ":" +typeRef.type.name;
		}
	}
			
	/**
	 * Calculate the plain type name used when a type needs to be referenced. The type name is not 
	 * qualified by namespace prefixes
	 */
	def dispatch String toTypeNameRef (EnumTypeRef typeRef, VersionedDomainNamespace currNs) { 
		if (typeRef.type.findSubdomain().toUnversionedNamespace() == currNs.subdomain.toUnversionedNamespace()  
			&& typeRef.getOwnerVersion().toMajorVersionNumber() == typeRef.type.version.toMajorVersionNumber()
			&& !(typeRef.getStatefulOwner() instanceof Service) 
		) {
			"tns:" +typeRef.type.name;
		} else {
			typeRef.type.findSubdomain().toShortName() + typeRef.type.version.toMajorVersionNumber() + ":" +typeRef.type.name;
		}
	}
	
	/**
	 * Calculate the plain type name used when a type needs to be referenced. The type name is not 
	 * qualified by namespace prefixes
	 */
	def dispatch String toTypeNameRef (Type type) {
		"";
	}
	
	/**
	 * Calculate the plain type name used when a type needs to be referenced. The type name is not 
	 * qualified by namespace prefixes
	 */
	def dispatch String toTypeNameRef (ClassRef typeRef, VersionedDomainNamespace currNs) {
		if (typeRef.type.findSubdomain().toUnversionedNamespace() == currNs.subdomain.toUnversionedNamespace()  && currNs.version.toVersion().versionMatches(typeRef.versionRef)) {
			"tns:" +typeRef.type.name
		} else {
			typeRef.type.findSubdomain().toShortName() + typeRef.type.version.toMajorVersionNumber() + ":" +typeRef.type.name;
		}
	}
	

	/**
	 * Calculate the type name used when a type needs to be referenced. The type name is prefixed 
	 * with a namespace alias calculate from the (major) versioned namespace
	 */
	def dispatch String toNsPrefixedTypeNameRef (TypeRef t, VersionedDomainNamespace currNs) {
		null;
	}
	
	/**
	 * Calculate the type name used when a type needs to be referenced. The type name is prefixed 
	 * with a namespace alias calculate from the (major) versioned namespace
	 */
	def dispatch String toNsPrefixedTypeNameRef (DataTypeRef t, VersionedDomainNamespace currentDomNs) { 
		t.type.toNsPrefixedTypeNameRef();
	}
		
	/**
	 * Calculate the type name used when a type needs to be referenced. The type name is prefixed 
	 * with a namespace alias calculate from the (major) versioned namespace
	 */
	def dispatch String toNsPrefixedTypeNameRef (VersionedTypeRef t, VersionedDomainNamespace currNs) { 
		t.toNamespace() + t.type.name;
	}
		
	/**
	 * Calculate the type name used when a type needs to be referenced. The type name is prefixed 
	 * with a namespace alias calculate from the (major) versioned namespace
	 */
	def dispatch String toNsPrefixedTypeNameRef (BusinessObjectRef t, VersionedDomainNamespace currNs) { 
		t.toNamespace() + t.type.name;
	}
		
	/**
	 * Calculate the type name used when a type needs to be referenced. The type name is prefixed 
	 * with a namespace alias calculate from the (major) versioned namespace
	 */
	def dispatch String toNsPrefixedTypeNameRef (QueryObjectRef t, VersionedDomainNamespace currNs) { 
		t.toNamespace() + t.type.name;
	}
			
	/**
	 * Calculate the type name used when a type needs to be referenced. The type name is prefixed 
	 * with a namespace alias calculate from the (major) versioned namespace
	 */
	def dispatch String toNsPrefixedTypeNameRef (EnumTypeRef t, VersionedDomainNamespace currNs) { 
		t.toNamespace() + t.type.name;
	}
	
	/**
	 * Calculate the type name used when a type needs to be referenced. The type name is prefixed 
	 * with a namespace alias calculate from the (major) versioned namespace
	 */
	def dispatch String toNsPrefixedTypeNameRef (Type t) {
		"";
	}

	/**
	 * Calculate the type name used when a type needs to be referenced. The type name is prefixed 
	 * with a namespace alias calculate from the (major) versioned namespace
	 */
	def dispatch String toNsPrefixedTypeNameRef (org.fornax.soa.profiledsl.sOAProfileDsl.DataType t) {
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
	
			
	def dispatch boolean isMimeContent (TypeRef t) {
		false;
	}
	
	def dispatch boolean isMimeContent (DataTypeRef t) {
		return t.contentType != null
	}
	
	def dispatch boolean isMimeContentMultiPartAttachment (TypeRef t) {
		false;
	}
	
	def dispatch boolean isMimeContentMultiPartAttachment (DataTypeRef t) {
		if (t.contentType != null) {
			switch (t.type.name) {
				case "attachment":		true
				default:				false
			};
		} else {
			false
		}
	}
	 
	
	def String toExceptionNameRef (ExceptionRef t, VersionedDomainNamespace currNs) {
		if (t.exception.findSubdomain().toUnversionedNamespace() == currNs.subdomain.toUnversionedNamespace()  
			&& t.getOwnerVersion().toMajorVersionNumber() == t.exception.version.toMajorVersionNumber()
			&& ! (t.getStatefulOwner() instanceof Service)
		
		) {
			"tns:" +t.exception.name;
		} else {
			t.exception.findSubdomain().toShortName() + t.exception.version.toMajorVersionNumber() + ":" +t.exception.name;
		}
	}
	  
	/**
	 * Is the XSD element optional? Returns true, when flagged with one of the keywords:
	 * <ul>
	 * 	<li><b>optional</b> 		- optional for business reasons</li>
	 * 	<li><b>weak</b> 			- optional for technical reasons, such as not loaded under some conditions</li>
	 * 	<li><b>provided-key</b> 	- a key generated in the backend, that is not always set, such as when the object has just been created, but not yet persisted</li>
	 * </ul>
	 */
	def boolean isOptionalElement (Property p) {
		return p.optional || p.weak || p.isProvidedKey;
	}		
	
	
	/**
	 * Has the type reference a many cardinality?
	 */	
	def dispatch boolean isMany (TypeRef t) {
		false;
	}
	/**
	 * Has the type reference a many cardinality?
	 */	
	def dispatch boolean isMany (DataTypeRef t) {
		t.many;
	}
	/**
	 * Has the type reference a many cardinality?
	 */	
	def dispatch boolean isMany (BusinessObjectRef t) {
		false;
	}
	/**
	 * Has the type reference a many cardinality?
	 */	
	def dispatch boolean isMany (QueryObjectRef t) {
		false;
	}
	/**
	 * Has the type reference a many cardinality?
	 */	
	def dispatch boolean isMany (VersionedTypeRef t) {
		t.many;
	}
	
	
//	def dispatch String getXsdFilename (BusinessObject c) {
//		c.findSubdomain().toFileNameFragment() + "-v" + c.version.toMajorVersionNumber() + ".xsd";
//	}
//			
	/**
	 * Calculate the namespace URL
	 */
	def dispatch String toNamespace (TypeRef t) {
	}
	/**
	 * Calculate the namespace URL
	 */
	def dispatch String toNamespace (VersionedTypeRef t) { 
		t.type.eContainer.toUnversionedNamespace() + "/"
			+ (t.findMatchingType() as VersionedType).version.toVersionPostfix() + "/";
	}
	/**
	 * Calculate the namespace URL
	 */
	def dispatch String toNamespace (BusinessObjectRef t) { 
		t.type.eContainer.toUnversionedNamespace() + "/"
			+ (t.findMatchingType() as BusinessObject).version.toVersionPostfix() + "/";
	}
	/**
	 * Calculate the namespace URL
	 */
	def dispatch String toNamespace (QueryObjectRef t) { 
		t.type.eContainer.toUnversionedNamespace() + "/"
			+ (t.findMatchingType() as QueryObject).version.toVersionPostfix() + "/";
	}
	/**
	 * Calculate the namespace URL
	 */
	def dispatch String toNamespace (EnumTypeRef t) {
		t.type.eContainer.toUnversionedNamespace() + "/"
			+ (t.findMatchingType() as Enumeration).version.toVersionPostfix() + "/";
	}
	/**
	 * Calculate the namespace URL
	 */
	def dispatch String toNamespace (ExceptionRef t) {
		t.exception.eContainer.toUnversionedNamespace() + "/"
			+ (t.findMatchingException() as org.fornax.soa.serviceDsl.Exception).version.toVersionPostfix() + "/";
	}
	
	/**
	 * Calculate the namespace URL
	 */
	def dispatch String toNamespace (SubNamespace ns) {
		ns.toUnversionedNamespace()+"/"
	}
	
	/**
	 * Calculate the namespace URL
	 */
	def dispatch String toNamespace (VersionedDomainNamespace ns) {
		ns.toUnversionedNamespace() + "/" + ns.version.toMajorVersionNumber.toVersionPostfix + "/"
	}
	
	/**
	 * Determine, whether XSD type definitions should be made extendible for unknown elements in
	 * the complexType  
	 */
	def boolean typesUseExtendibleProperties (org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile p) {
		if (p.designRules != null 
			&& p.designRules.typeDefPolicy != null 
			&& p.designRules.typeDefPolicy.versionEvolution != null) {
			return  p.designRules.typeDefPolicy.versionEvolution.extendibleProperties;
		} else {
			return false
		}
		
	}
	
	/**
	 * Determine, whether XSD type definitions should be made extendible for unknown XML attributes 
	 */
	def boolean typesUseExtendibleXMLAttributes (org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile p) {
		if (p.designRules != null 
			&& p.designRules.typeDefPolicy != null 
			&& p.designRules.typeDefPolicy.versionEvolution != null) {
			return  p.designRules.typeDefPolicy.versionEvolution.extendibleXMLAttributes;
		} else {
			return false
		}
	}
	
	/**
	 * Determine, whether XSD type definitions, that subtype another type definition, 
	 * should be made extendible for unknown XML elements or attributes 
	 */
	def boolean useExtendibleSubtypes (org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile p) {
		if (p.designRules != null 
			&& p.designRules.typeDefPolicy != null 
			&& p.designRules.typeDefPolicy.versionEvolution != null) {
			return  p.designRules.typeDefPolicy.versionEvolution.extendibleSubTypes;
		} else {
			return false
		}
		
	}
	
	/**
	 * Get the XSD any clause that makes complexTypes backward compatible allowing additional 
	 * optional elements
	 */
	def String getTypesExtendiblePropertiesClause (org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile p) {
		if (p.typesUseExtendibleProperties) {
			if (p.designRules.typeDefPolicy.versionEvolution.extendibleXMLClause != null) {
				return p.designRules.typeDefPolicy.versionEvolution.extendibleXMLClause;
			} else {
				return 
				'''
				<xsd:any maxOccurs="unbounded" minOccurs="0" namespace="http://www.w3.org/2001/XMLSchema ##local"
						processContents="skip"/>
				'''
			}
		} else {
			return ""
		}
		
	}

	/**
	 * Get the XSD anyAttribute clause that makes complexTypes backward compatible allowing additional 
	 * optional XML attributes in the type
	 */
	def String getTypesExtendibleXMLAttributesClause (org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile p) {
		if (p.typesUseExtendibleXMLAttributes) {
			if (p.designRules.typeDefPolicy.versionEvolution.extendibleXMLAttributeClause != null) {
				return p.designRules.typeDefPolicy.versionEvolution.extendibleXMLAttributeClause;
			} else {
				return 
				'''
				<xsd:anyAttribute namespace="##any"/>
				'''
			}
		} else {
			return ""
		}
	}		
	
		
}