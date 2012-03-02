package org.fornax.soa.profiledsl.generator.schema

import com.google.inject.Inject
import org.fornax.soa.basedsl.generator.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.generator.query.NamespaceQueries
import org.fornax.soa.profiledsl.generator.query.ProfileVersionQueries
import org.fornax.soa.profiledsl.generator.query.type.LatestMatchingTypeFinder
import org.fornax.soa.profiledsl.sOAProfileDsl.AttributeDataTypeRef
import org.fornax.soa.profiledsl.sOAProfileDsl.DataType
import org.fornax.soa.profiledsl.sOAProfileDsl.DataTypeRef
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.fornax.soa.profiledsl.sOAProfileDsl.Type
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef
import org.fornax.soa.profiledsl.generator.namespace.TechnicalNamespaceSplitter
import org.fornax.soa.profiledsl.generator.namespace.VersionedTechnicalNamespace

class ProfileSchemaTypeExtensions {
	
	@Inject extension TechnicalNamespaceSplitter
	@Inject extension NamespaceQueries
	@Inject extension ProfileSchemaNamespaceExtensions
	@Inject ProfileVersionQueries profileVersionQueries
	@Inject extension LatestMatchingTypeFinder
//	@Inject extension CommonEObjectExtensions

	@Inject VersionQualifierExtensions versionQualifiers

	def dispatch String toTypeNameRef (TypeRef t, VersionedTechnicalNamespace currNs) {
		null;
	}
	
	def dispatch String toTypeNameRef (DataTypeRef t, VersionedTechnicalNamespace currentDomNs) { 
		t.findLatestMatchingType () .toTypeNameRef (currentDomNs);
	}
	
	def dispatch String toTypeNameRef (DataType t, VersionedTechnicalNamespace currentDomNs) { 
		t.toTypeNameRef ();
	}
		
	def dispatch String toTypeNameRef (AttributeDataTypeRef t, VersionedTechnicalNamespace currentDomNs) { 
		t.findLatestMatchingType () .toTypeNameRef (currentDomNs);
	}
	
	/*<b>TODO CHECK</b> getOwnerVersion for VersionedTypeRef!!!*/
	def dispatch String toTypeNameRef (VersionedTypeRef t, VersionedTechnicalNamespace currNs) { 
		if (t.type.findTechnicalNamespace().toUnversionedNamespace() == (currNs.namespace as TechnicalNamespace).toUnversionedNamespace()  
			&& versionQualifiers.toMajorVersionNumber(profileVersionQueries.getOwnerVersion(t)) == versionQualifiers.toMajorVersionNumber(t.type.version)
		) {
			"tns:" +t.type.name
		} else {
			t.type.findTechnicalNamespace().toShortName() + versionQualifiers.toMajorVersionNumber(t.type.version) + ":" +t.type.name;
		}
	}

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
	
			
	def dispatch String toFullTypeNameRef (org.fornax.soa.profiledsl.sOAProfileDsl.DataTypeRef t, VersionedTechnicalNamespace currentDomNs) { 
		t.findLatestMatchingType () .toFullTypeNameRef();
	}
		
	def dispatch String toFullTypeNameRef (VersionedTypeRef t, VersionedTechnicalNamespace currNs) { 
		t.type.findTechnicalNamespace().toNamespace() + t.type.name;
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

	def dispatch boolean isMany (TypeRef t) {
		false;
	}
	def dispatch boolean isMany (DataTypeRef t) {
		false;
	}
	def dispatch boolean isMany (VersionedTypeRef t) {
		t.many;
	}
	
	def boolean typesUseExtendableXMLAttributes (SOAProfile p) {
		p.designRules != null && p.designRules.typeDefPolicy != null && p.designRules.typeDefPolicy.extendableXMLAttributes;
	}
	def boolean typesUseExtendableProperties (SOAProfile p) {
		p.designRules != null && p.designRules.typeDefPolicy != null && p.designRules.typeDefPolicy.extendableProperties;
	}
	
}