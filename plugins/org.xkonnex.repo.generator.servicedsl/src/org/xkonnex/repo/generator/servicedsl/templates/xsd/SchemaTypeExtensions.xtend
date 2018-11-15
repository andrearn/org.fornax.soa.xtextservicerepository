package org.xkonnex.repo.generator.servicedsl.templates.xsd

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaTypeExtensions
import org.xkonnex.repo.dsl.profiledsl.query.namespace.TechnicalNamespaceQueries
import org.xkonnex.repo.dsl.profiledsl.profileDsl.AttributeDataTypeRef
import org.xkonnex.repo.dsl.profiledsl.profileDsl.ClassRef
import org.xkonnex.repo.dsl.profiledsl.profileDsl.DataType
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.service.versioning.NamespaceSplitter
import org.xkonnex.repo.dsl.servicedsl.service.query.VersionQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.service.versioning.IExceptionResolver
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EnumTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.QueryObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef
import org.xkonnex.repo.dsl.servicedsl.service.versioning.IVersionedTypeRefResolver
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceURIProvider
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource

/**
 * Extension functions for 
 * Type representations and references in XSDs
 */
class SchemaTypeExtensions {
	
	@Inject extension VersionMatcher
	@Inject extension SchemaNamespaceExtensions schemaNamespaceExt
	@Inject extension NamespaceQuery
	@Inject extension VersionQualifierExtensions
	@Inject extension VersionQueries
	@Inject extension IVersionedTypeRefResolver
	@Inject extension IExceptionResolver
	@Inject extension IEObjectLookup
	@Inject extension ServiceNamespaceURIProvider serviceNamespaceURIProvider
	
	@Inject ProfileSchemaTypeExtensions profileSchemaTypes
	@Inject TechnicalNamespaceQueries profileNSQueries
	
	/**
	 *	Return the XSD type name for a type reference including it's derived namespace prefix
	 */
	def dispatch String toTypeNameRef (TypeRef t) {
		null;
	}
	
	def dispatch String toTypeNameRef (org.xkonnex.repo.dsl.profiledsl.profileDsl.TypeRef t) {
		null;
	}
	
	def dispatch String toTypeNameRef (DataTypeRef t) {
		t.type.toTypeNameRef();
	}
	
	def dispatch String toTypeNameRef (DataType t) {
		profileSchemaTypes.toTypeNameRef (t);
	}
	
	def dispatch String toTypeNameRef (org.xkonnex.repo.dsl.profiledsl.profileDsl.DataTypeRef t) {
		t.type.toTypeNameRef();
	}

	def dispatch String toTypeNameRef (org.xkonnex.repo.dsl.profiledsl.profileDsl.AttributeDataTypeRef t) {
		t.type.toTypeNameRef();
	}
	
	def dispatch String toTypeNameRef (VersionedTypeRef t) {
		if (t.type.findSubdomain() !== null) {
			var prefix = "tns";
			if (! (t.findTypeRefOwnerSubdomain() == t.type.findSubdomain()
				&& t.getOwnerVersion().toMajorVersionNumber() == t.type.version.toMajorVersionNumber()
			 	&& ! (t.getStatefulOwner() instanceof Service || t.getStatefulOwner() instanceof Resource))
			) {
			 	prefix = t.type.findSubdomain().toShortName() + t.type.version.toMajorVersionNumber();
			}
			prefix + ":" +t.type.name;
		} else {
			t.type.name;
		}
	}
	
	def dispatch String toTypeNameRef (org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedTypeRef t) {
		if (profileNSQueries.findTechnicalNamespace (t.type) !== null) {
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
	
	def dispatch String toTypeNameRef (DataObjectRef t) { 
		if (t.type.findSubdomain() !== null) {
			var prefix = "tns";
			if (!(t.findTypeRefOwnerSubdomain() == t.type.findSubdomain()
				&& t.getOwnerVersion().toMajorVersionNumber() == t.type.version.toMajorVersionNumber()
				&& !(t.getStatefulOwner() instanceof Service || t.getStatefulOwner() instanceof Resource))
			)  {
				prefix = t.type.findSubdomain().toShortName() + t.type.version.toMajorVersionNumber();
			}
			prefix + ":" + t.type.name;
		} else {
			t.type.name;
		}
	}
	
	def dispatch String toTypeNameRef (EnumTypeRef t) { 
		if (t.type.findSubdomain() !== null) {
			var prefix = "tns";
			if (!(t.findTypeRefOwnerSubdomain() == t.type.findSubdomain()
				&& t. getOwnerVersion().toMajorVersionNumber() == t.type.version.toMajorVersionNumber()
				&& ! (t.getStatefulOwner() instanceof Service || t.getStatefulOwner() instanceof Resource))
			) {
				prefix = t.type.findSubdomain().toShortName() + t.type.version.toMajorVersionNumber();
			}
			prefix + ":" +t.type.name;
		} else {
			t.type.name;
		}
	}
	
	def String toExceptionNameRef (ExceptionRef exRef) {
		if (exRef.exception.findSubdomain() !== null) {
			var prefix = "tns";
			if (!(exRef.findExceptionRefOwnerSubdomain() == exRef.exception.findSubdomain()
			 && exRef.getOwnerVersion().toMajorVersionNumber() == exRef.exception.version.toMajorVersionNumber()
			 && ! (exRef.getStatefulOwner() instanceof Service || exRef.getStatefulOwner() instanceof Resource))
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
	def dispatch String toTypeNameRef (org.xkonnex.repo.dsl.profiledsl.profileDsl.TypeRef typeRef, VersionedDomainNamespace currNs) {
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
		if (typeRef.type.findSubdomain().namespacePrefix == currNs.subdomain.namespacePrefix  
			&& typeRef.getOwnerVersion().toMajorVersionNumber() == typeRef.type.version.toMajorVersionNumber()
			&& ! (typeRef.getStatefulOwner() instanceof Service)
		
		) {
			"tns:" +typeRef.type.name;
		} else {
			typeRef.type.findSubdomain().namespacePrefix + typeRef.type.version.toMajorVersionNumber() + ":" +typeRef.type.name;
		}
	}
		
	/**
	 * Calculate the plain type name used when a type needs to be referenced. The type name is not 
	 * qualified by namespace prefixes
	 */
	def dispatch String toTypeNameRef (DataObjectRef typeRef, VersionedDomainNamespace currNs) { 
		if (typeRef.type.findSubdomain().toUnversionedNamespace() == currNs.subdomain.toUnversionedNamespace()
			&& typeRef.getOwnerVersion().toMajorVersionNumber() == typeRef.type.version.toMajorVersionNumber()
			&& !(typeRef.getStatefulOwner() instanceof Service)
		) {
			"tns:" +typeRef.type.name;
		} else {
			typeRef.type.findSubdomain().toUnversionedNamespace() + typeRef.type.version.toMajorVersionNumber() + ":" +typeRef.type.name;
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
			typeRef.type.findSubdomain().toUnversionedNamespace() + typeRef.type.version.toMajorVersionNumber() + ":" +typeRef.type.name;
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
			typeRef.type.findSubdomain().toUnversionedNamespace() + typeRef.type.version.toMajorVersionNumber() + ":" +typeRef.type.name;
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
	def dispatch String toNsPrefixedTypeNameRef (DataObjectRef t, VersionedDomainNamespace currNs) { 
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
	def dispatch String toNsPrefixedTypeNameRef (org.xkonnex.repo.dsl.profiledsl.profileDsl.DataType t) {
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
		return t.contentType !== null || t.type.name == "attachment"
	}
	
	def dispatch boolean isMimeContentMultiPartAttachment (TypeRef t) {
		false;
	}
	
	def dispatch boolean isMimeContentMultiPartAttachment (DataTypeRef t) {
		if (t.contentType !== null) {
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
	 * 
	 * @param p a {@link Property}
	 * @return true if the resulting XSD element for the property p is optional
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
	def dispatch boolean isMany (DataObjectRef t) {
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
		var nsUri = t.type.eContainer.toUnversionedNamespace()
		if (!nsUri.endsWith("/")) {
			nsUri = nsUri + "/"
		}
		nsUri + schemaNamespaceExt.toVersionPostfix((t.findMatchingTypeVersion() as VersionedType).version) + "/";
	}
	/**
	 * Calculate the namespace URL
	 */
	def dispatch String toNamespace (DataObjectRef t) { 
		var nsUri = t.type.eContainer.toUnversionedNamespace()
		if (!nsUri.endsWith("/")) {
			nsUri = nsUri + "/"
		}
		nsUri + schemaNamespaceExt.toVersionPostfix((t.findMatchingTypeVersion() as BusinessObject).version) + "/";
	}
	/**
	 * Calculate the namespace URL
	 */
	def dispatch String toNamespace (EnumTypeRef t) {
		t.type.eContainer.toUnversionedNamespace() + "/"
			+ schemaNamespaceExt.toVersionPostfix((t.findMatchingTypeVersion() as Enumeration).version) + "/";
	}
	/**
	 * Calculate the namespace URL
	 */
	def dispatch String toNamespace (ExceptionRef t) {
		var nsUri = t.exception.eContainer.toUnversionedNamespace()
		if (!nsUri.endsWith("/")) {
			nsUri = nsUri + "/"
		}
		nsUri + schemaNamespaceExt.toVersionPostfix((t.findMatchingException() as org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception).version) + "/";
	}
	
	/**
	 * Calculate the namespace URL
	 */
	def dispatch String toNamespace (SubNamespace ns) {
		serviceNamespaceURIProvider.getVersionedNamespaceURI(ns)
	}
	
	/**
	 * Calculate the namespace URL
	 */
	def dispatch String toNamespace (VersionedDomainNamespace ns) {
		serviceNamespaceURIProvider.getVersionedNamespaceURI(ns)
	}
	
	/**
	 * Determine, whether XSD type definitions should be made extensible for unknown elements in
	 * the complexType  
	 * 
	 * @param p the architecture profile
	 * @return true, if the profile allows extensible XSD properties
	 */
	def boolean typesUseExtensibleProperties (org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile p) {
		if (p.designRules !== null 
			&& p.designRules.typeDefPolicy !== null 
			&& p.designRules.typeDefPolicy.versionEvolution !== null) {
			return  p.designRules.typeDefPolicy.versionEvolution.extensibleProperties;
		} else {
			return false
		}
		
	}
	
	/**
	 * Determine, whether XSD type definitions should be made extensible for unknown XML attributes 
	 * 
	 * @param p the architecture profile
	 * @return true, if the profile allows extensible XSD attributes
	 */
	def boolean typesUseExtensibleXMLAttributes (org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile p) {
		if (p.designRules !== null 
			&& p.designRules.typeDefPolicy !== null 
			&& p.designRules.typeDefPolicy.versionEvolution !== null) {
			return  p.designRules.typeDefPolicy.versionEvolution.extensibleXMLAttributes;
		} else {
			return false
		}
	}
	
	/**
	 * Determine, whether XSD type definitions, that subtype another type definition, 
	 * should be made extensible for unknown XML elements or attributes 
	 * 
	 * @param p the architecture profile
	 * @return true, if the profile allows extensible XSD subtypes
	 */
	def boolean useExtensibleSubtypes (org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile p) {
		if (p.designRules !== null 
			&& p.designRules.typeDefPolicy !== null 
			&& p.designRules.typeDefPolicy.versionEvolution !== null) {
			return  p.designRules.typeDefPolicy.versionEvolution.extensibleSubTypes;
		} else {
			return false
		}
		
	}
	
	/**
	 * Get the XSD any clause that makes complexTypes backward compatible allowing additional 
	 * optional elements
	 * 
	 * @param p the architecture profile
	 * @return custom XSD any clause defined in the profile p
	 */
	def String getTypesExtensiblePropertiesClause (org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile p) {
		if (p.typesUseExtensibleProperties) {
			if (p.designRules.typeDefPolicy.versionEvolution.extensibleXMLClause !== null) {
				return p.designRules.typeDefPolicy.versionEvolution.extensibleXMLClause;
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
	 * 
	 * @param p the architecture profile
	 * @return custom XSD anyAttribute clause defined in the profile p
	 */
	def String getTypesExtensibleXMLAttributesClause (org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile p) {
		if (p.typesUseExtensibleXMLAttributes) {
			if (p.designRules.typeDefPolicy.versionEvolution.extensibleXMLAttributeClause !== null) {
				return p.designRules.typeDefPolicy.versionEvolution.extensibleXMLAttributeClause;
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