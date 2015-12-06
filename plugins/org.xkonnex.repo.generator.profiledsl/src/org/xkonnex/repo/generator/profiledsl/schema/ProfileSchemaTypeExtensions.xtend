package org.xkonnex.repo.generator.profiledsl.schema

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.profiledsl.namespace.ProfileNamespaceURIProvider
import org.xkonnex.repo.dsl.profiledsl.profileDsl.AttributeDataTypeRef
import org.xkonnex.repo.dsl.profiledsl.profileDsl.DataType
import org.xkonnex.repo.dsl.profiledsl.profileDsl.DataTypeRef
import org.xkonnex.repo.dsl.profiledsl.profileDsl.MessageHeader
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Type
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TypeRef
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedTypeRef
import org.xkonnex.repo.dsl.profiledsl.query.ProfileVersionQueries
import org.xkonnex.repo.dsl.profiledsl.query.namespace.TechnicalNamespaceQueries
import org.xkonnex.repo.dsl.profiledsl.query.type.LatestMatchingTypeFinder
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace

class ProfileSchemaTypeExtensions {
	
	@Inject extension ProfileNamespaceURIProvider
	@Inject extension TechnicalNamespaceQueries
	@Inject extension ProfileSchemaNamespaceExtensions
	@Inject ProfileVersionQueries profileVersionQueries
	@Inject extension LatestMatchingTypeFinder

	@Inject VersionQualifierExtensions versionQualifiers

	/**
	 * Reference to type qualified by the namespace prefix defined for the namespace URI of namespace the referenced type belongs to
	 * The prefix is derived from the namespace URI or it's shortname.
	 */		
	def dispatch String toTypeNameRef (TypeRef t, VersionedTechnicalNamespace currNs) {
		null;
	}
	
	/**
	 * Reference to type qualified by the namespace prefix defined for the namespace URI of namespace the referenced type belongs to
	 * The prefix is derived from the namespace URI or it's shortname.
	 */		
	def dispatch String toTypeNameRef (DataTypeRef t, VersionedTechnicalNamespace currentDomNs) { 
		t.findLatestMatchingType ().toTypeNameRef (currentDomNs);
	}
	
	/**
	 * Reference to type qualified by the namespace prefix defined for the namespace URI of namespace the referenced type belongs to
	 * The prefix is derived from the namespace URI or it's shortname.
	 */		
	def dispatch String toTypeNameRef (DataType t, VersionedTechnicalNamespace currentDomNs) { 
		t.toTypeNameRef ();
	}

	/**
	 * Reference to type qualified by the namespace prefix defined for the namespace URI of namespace the referenced type belongs to
	 * The prefix is derived from the namespace URI or it's shortname.
	 */		
	def dispatch String toTypeNameRef (AttributeDataTypeRef t, VersionedTechnicalNamespace currentDomNs) { 
		t.findLatestMatchingType () .toTypeNameRef (currentDomNs);
	}
	
	/**
	 * Reference to type qualified by the namespace prefix defined for the namespace URI of namespace the referenced type belongs to
	 * The prefix is derived from the namespace URI or it's shortname.
	 */		
	/*<b>TODO CHECK</b> getOwnerVersion for VersionedTypeRef!!!*/
	def dispatch String toTypeNameRef (VersionedTypeRef t, VersionedTechnicalNamespace currNs) { 
		if (t.type.findTechnicalNamespace().toUnversionedNamespace() == (currNs.namespace as TechnicalNamespace).toUnversionedNamespace()  
			&& versionQualifiers.toMajorVersionNumber(profileVersionQueries.getOwnerVersion(t)) == versionQualifiers.toMajorVersionNumber(t.type.version)
		) {
			"tns:" +t.type.name
		} else {
			t.type.findTechnicalNamespace().namespacePrefix + versionQualifiers.toMajorVersionNumber(t.type.version) + ":" + t.type.name;
		}
	}

	/**
	 * Reference to type qualified by the namespace prefix defined for the namespace URI of namespace the referenced type belongs to
	 * The prefix is derived from the namespace URI or it's shortname. (uses "xsd:" for XmlSchema itself)
	 */		
	def dispatch String toTypeNameRef (DataType t) {
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
		};
	}
	
	
	/**
	 * Reference to type qualified by the  full namespace URI of namespace the referenced type belongs to
	 */		
	def dispatch String toFullTypeNameRef (DataTypeRef t) { 
		t.findLatestMatchingType () .toFullTypeNameRef();
	}
		
	/**
	 * Reference to type qualified by the full namespace URI of namespace the referenced type belongs to
	 */		
	def dispatch String toFullTypeNameRef (VersionedTypeRef t) {
		var ref = t.type.findTechnicalNamespace().namespaceURI
		if (!ref.endsWith("/")) {
			ref = ref + "/"
		}
		ref + t.type.version.toVersionPostfix + "/" + t.type.name
	}
		
	/**
	 * Reference to type qualified by the  full namespace URI of namespace the referenced type belongs to
	 */		
	def dispatch String toFullTypeNameRef (Type t) {
		"";
	}

	/**
	 * Reference to type qualified by the  full namespace URI of namespace the referenced type belongs to
	 */		
	def dispatch String toFullTypeNameRef (DataType t) {
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

	def dispatch boolean isMany (TypeRef t) {
		false;
	}
	def dispatch boolean isMany (VersionedTypeRef t) {
		t.many;
	}
	
	def boolean typesUseExtendibleProperties (MessageHeader header) {
		if (header.versionEvolution != null) {
			return  header.versionEvolution.extendibleProperties;
		} else {
			return false
		}
		
	}
	def boolean typesUseExtendibleXMLAttributes (MessageHeader header) {
		if (header.versionEvolution != null) {
			return  header.versionEvolution.extendibleXMLAttributes;
		} else {
			return false
		}
	}
	
	def String getTypesExtendiblePropertiesClause (MessageHeader header) {
		if (header.typesUseExtendibleProperties) {
			if (header.versionEvolution.extendibleXMLClause != null) {
				return header.versionEvolution.extendibleXMLClause;
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
	
	def String getTypesExtendibleXMLAttributesClause (MessageHeader header) {
		if (header.typesUseExtendibleXMLAttributes) {
			if (header.versionEvolution.extendibleXMLAttributeClause != null) {
				return header.versionEvolution.extendibleXMLAttributeClause;
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