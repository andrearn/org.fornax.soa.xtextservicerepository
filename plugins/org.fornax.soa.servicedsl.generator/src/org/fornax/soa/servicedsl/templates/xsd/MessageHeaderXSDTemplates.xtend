package org.fornax.soa.servicedsl.templates.xsd

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.basedsl.lifecycle.LifecycleQualifierExtensions
import org.fornax.soa.basedsl.lifecycle.StateMatcher
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.ProfileSchemaNamespaceExtensions
import org.fornax.soa.profiledsl.TechnicalNamespaceSplitter
import org.fornax.soa.profiledsl.VersionedTechnicalNamespace
import org.fornax.soa.profiledsl.query.NamespaceImportQueries
import org.fornax.soa.profiledsl.sOAProfileDsl.Attribute
import org.fornax.soa.profiledsl.sOAProfileDsl.Class
import org.fornax.soa.profiledsl.sOAProfileDsl.EnumLiteral
import org.fornax.soa.profiledsl.sOAProfileDsl.Enumeration
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader
import org.fornax.soa.profiledsl.sOAProfileDsl.Property
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef
import org.fornax.soa.profiledsl.query.type.LatestMatchingTypeFinder
import org.fornax.soa.profiledsl.ProfileSchemaTypeExtensions

class MessageHeaderXSDTemplates {

	@Inject IFileSystemAccess fsa
	
	@Inject extension StateMatcher
	@Inject extension VersionMatcher
	@Inject extension CommonStringExtensions
	@Inject extension SchemaNamespaceExtensions
	@Inject extension ProfileSchemaNamespaceExtensions
	@Inject extension ProfileSchemaTypeExtensions
	@Inject extension SchemaTemplateExtensions
	@Inject extension VersionQualifierExtensions
	@Inject extension LifecycleQualifierExtensions
	@Inject extension TechnicalNamespaceSplitter
	@Inject extension NamespaceImportQueries
	@Inject extension LatestMatchingTypeFinder
	@Inject extension XSDTemplates

	/*
		CARTRIDGE ENTRYPOINT for generation message headers defined in the give SOAProfile
	
		An XSD for each TechnicalNamespace of all parameters of all message headers defined in
		the SOAProfile will be generated
	*/
	def dispatch toMessageHeaderXSD (SOAProfile profile) {
		for (h : profile.messaging.messageHeaders) {
			h.parameters.map (p|p.type).filter (typeof (VersionedTypeRef))
				.map (vRef|vRef.type.eContainer).filter (typeof (TechnicalNamespace)).toSet()
				.forEach (ns|ns.toMessageHeaderXSD (profile, h));
		}
	}
	
	/*
		CARTRIDGE ENTRYPOINT for generation message headers defined in the give SOAProfile
	
		An XSD for each TechnicalNamespace of all parameters of all message headers defined in
		the SOAProfile will be generated
		Prefixes all imports with given registryBaseUrl. Referenced imported XSDs must be
		available under the calculated URL
	*/
	def dispatch toMessageHeaderXSD (SOAProfile profile, String registryBaseUrl) {
		for (h : profile.messaging.messageHeaders) {
			h.parameters.map (p|p.type).filter (typeof (VersionedTypeRef)).map (vRef|vRef.type.eContainer).filter (typeof (TechnicalNamespace)).toSet().forEach (ns|ns.toMessageHeaderXSD (profile, registryBaseUrl, h));
		}
	}
	def dispatch toMessageHeaderXSD (VersionedTechnicalNamespace vns, SOAProfile profile, MessageHeader header) {
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema xmlns:tns="«vns.toNamespace()»"
			«vns.allImportedVersionedNS ().filter (e| !(e.namespace == vns.namespace && e.version.toMajorVersionNumber() == vns.version.toMajorVersionNumber())).forEach (ns|ns.toNamespaceDeclaration)» 
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:jxb="http://java.sun.com/xml/ns/jaxb"
			elementFormDefault="qualified"
			attributeFormDefault="unqualified"
			targetNamespace="«vns.toNamespace()»"
			>
			«vns.allImportedVersionedNS().filter (e| !(e.namespace == vns.namespace && e.version.toMajorVersionNumber() == vns.version.toMajorVersionNumber())).forEach (ns|ns.toImportDeclaration)» 	
			«IF vns.namespace instanceof TechnicalNamespace»
				«(vns.namespace as TechnicalNamespace).types.filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.Class)).filter (e|e.version.version.toMajorVersionNumber() == vns.version.toMajorVersionNumber()).forEach (t|t.toComplexType(vns, profile, header))»
				«(vns.namespace as TechnicalNamespace).types.filter (typeof (Enumeration)).filter (e|e.isLatestMatchingType (vns.version.toMajorVersionNumber().asInteger() )).forEach (t|t.toSimpleType (profile))»
				«/*«EXPAND FaultType(this) FOREACH ((SubNamespace) subdomain).exceptions.select (e|e.isLatestMatchingException (version.toMajorVersionNumber().asInteger(), minState))-*/»
			«ENDIF»
		</xsd:schema>
		'''
		
		val xsdFileName = vns.toFileNameFragment() + ".xsd";
		fsa.generateFile (xsdFileName, content);
	}
	
	def dispatch toMessageHeaderXSD (TechnicalNamespace namespace, SOAProfile profile, MessageHeader header) {
		namespace.toVersionedTechnicalNamespaces().forEach (vns|vns.toMessageHeaderXSD (profile, header));
	}
	
	def dispatch toMessageHeaderXSD (TechnicalNamespace namespace, SOAProfile profile, String registryBaseUrl, MessageHeader header) {
		namespace.toVersionedTechnicalNamespaces().forEach (vns|vns.toMessageHeaderXSD (profile, registryBaseUrl, header));
	}
	
	
	
	def dispatch toMessageHeaderXSD (VersionedTechnicalNamespace vns, SOAProfile profile, String registryBaseUrl, MessageHeader header) {
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema xmlns:tns="«vns.toNamespace()»"
			«vns.allImportedVersionedNS ().filter (e| !(e.namespace == vns.namespace && e.version.toMajorVersionNumber() == vns.version.toMajorVersionNumber())).forEach (ns|ns.toNamespaceDeclaration)» 
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			elementFormDefault="qualified"
			attributeFormDefault="unqualified"
			targetNamespace="«vns.toNamespace()»"
			>
			«vns.allImportedVersionedNS()
				.filter (e| !(e.namespace == vns.namespace && e.version.toMajorVersionNumber() == vns.version.toMajorVersionNumber()))
				.forEach (ns|ns.toImportDeclaration (registryBaseUrl))»
			«IF vns.namespace instanceof TechnicalNamespace»
				«(vns.namespace as TechnicalNamespace).types.filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.Class))
					.filter (e|e.version.version.toMajorVersionNumber() == vns.version.toMajorVersionNumber())
					.forEach (t|t.toComplexType (vns, profile, header))»
				«(vns.namespace as TechnicalNamespace).types.filter (typeof (Enumeration))
					.filter (e|e.isLatestMatchingType (vns.version.toMajorVersionNumber().asInteger() ))
					.forEach (t|t.toSimpleType (profile))»
				«/*«EXPAND FaultType(this) FOREACH ((SubNamespace) subdomain).exceptions.select (e|e.isLatestMatchingException (version.toMajorVersionNumber().asInteger(), minState))-»*/»
			«ENDIF»
		</xsd:schema>
		'''

		val xsdFileName = vns.toFileNameFragment() + ".xsd";
		fsa.generateFile (xsdFileName, content);
	}
	
	
	def dispatch toNamespaceDeclaration (VersionedTechnicalNamespace vns) '''
		xmlns:«vns.toPrefix() + vns.version.toMajorVersionNumber()»="«vns.toNamespace()»"
	'''
	
	def dispatch toImportDeclaration (VersionedTechnicalNamespace vns) '''
		<xsd:import schemaLocation="«vns.getRegisteredUrl (null)».xsd"
			namespace="«vns.toNamespace()»"></xsd:import>
	'''
	def dispatch toImportDeclaration (VersionedTechnicalNamespace vns, String registryBaseUrl) '''
		<xsd:import schemaLocation="«vns.getRegisteredUrl (registryBaseUrl)».xsd"
			namespace="«vns.toNamespace()»"></xsd:import>
	'''
	
	
	def dispatch toComplexType (org.fornax.soa.profiledsl.sOAProfileDsl.Class cls, VersionedTechnicalNamespace currNs, SOAProfile profile, MessageHeader header) '''
	    <xsd:complexType name="«cls.name»">
	    	<xsd:annotation>
	    		<xsd:documentation>
	    			<![CDATA[Version:	«cls.version.toVersionNumber()»
					«IF cls.doc != null»
					
	    				«cls.doc.stripCommentBraces().trim()»
					«ENDIF» 
					]]>   			
	    		</xsd:documentation>
	    	</xsd:annotation>
	    	
	    	«IF cls.superClass != null»
	    	<xsd:complexContent>
	    		<xsd:extension base="«cls.superClass.toTypeNameRef(currNs)»">
			    	«cls.toPropertySequence (currNs, profile)»
	    		</xsd:extension>
	    	</xsd:complexContent>
	    	«ELSE»
		    	«cls.toPropertySequenceWithAny (currNs, profile, header)»
		    	«IF header.extendableXMLAttributes»
					<xsd:anyAttribute namespace="##any"/>
		    	«ENDIF»
	    	«ENDIF»
	    </xsd:complexType>
	'''
	
	def dispatch toPropertySequenceWithAny (org.fornax.soa.profiledsl.sOAProfileDsl.Class cls, VersionedTechnicalNamespace currNs, SOAProfile profile, MessageHeader header) '''
    	<xsd:sequence>
    		«cls.properties.filter (typeof (Property)).forEach (p|p.toProperty (currNs, profile))»
    		«IF header.extendableProperties»
			<xsd:any maxOccurs="unbounded" minOccurs="0" namespace="http://www.w3.org/2001/XMLSchema ##local"
				processContents="skip"/>
    		«ENDIF»
    	</xsd:sequence>
    	«IF !cls.properties.filter (typeof (Attribute)).isEmpty»
    	
   			«cls.properties.filter (typeof (Attribute)).forEach (a|a.toProperty (currNs, profile))»
    	«ENDIF»
	'''
	
	def dispatch toPropertySequence (org.fornax.soa.profiledsl.sOAProfileDsl.Class cls, VersionedTechnicalNamespace currNs, SOAProfile profile) '''
		<xsd:sequence>
	   		«cls.properties.filter (typeof (Property)).forEach (p|p.toProperty (currNs, profile))»
	    </xsd:sequence>
	    «IF !cls.properties.filter (typeof (Attribute)).isEmpty»
	    
	   		«cls.properties.filter (typeof (Attribute)).forEach (a|a.toProperty (currNs, profile))»
	    «ENDIF»
	'''
	
	def dispatch toSimpleType (Enumeration enumeration, SOAProfile profile) '''
	    <xsd:simpleType name="«enumeration.name»">
	    	<xsd:annotation>
	    		<xsd:documentation>
	    			<![CDATA[Version:	«enumeration.version.toVersionNumber()»
	    			
					«IF enumeration.doc != null»
					
	    			«enumeration.doc.stripCommentBraces().trim()»
					«ENDIF» 
					]]>   			
	       		</xsd:documentation>
	    	</xsd:annotation>
	    	<xsd:restriction base="xsd:string">
	    		«enumeration.literals.forEach (lit|lit.toEnumLiteral (profile))»
	    	</xsd:restriction>
	    </xsd:simpleType>
	'''
	
	
	def dispatch toProperty (Property prop, VersionedTechnicalNamespace currNs, SOAProfile profile) '''
		«IF prop.doc == null»
			<xsd:element name="«prop.name»" «IF prop.optional»minOccurs="0"«ENDIF» «IF prop.type.isMany()»maxOccurs="unbounded"«ENDIF» type="«prop.type.toTypeNameRef(currNs)»" />
		«ELSE»		
			<xsd:element name="«prop.name»" «IF prop.optional»minOccurs="0"«ENDIF» «IF prop.type.isMany()»maxOccurs="unbounded"«ENDIF» type="«prop.type.toTypeNameRef(currNs)»" >
		    	<xsd:annotation>
		    		<xsd:documentation>
		    			<![CDATA[«prop.doc.stripCommentBraces().trim()»]]>
		    		</xsd:documentation>
		    	</xsd:annotation>
			</xsd:element>
		«ENDIF»
	'''
	
	def dispatch toProperty (Attribute attr, VersionedTechnicalNamespace currNs, SOAProfile profile) '''
		«IF attr.doc == null»
		   	<xsd:attribute name="«attr.name»" «IF attr.optional»use="optional"«ENDIF» type="«attr.type.toTypeNameRef (currNs)»" />
		«ELSE»		
		   	<xsd:attribute name="«attr.name»" «IF attr.optional»use="optional"«ENDIF» type="«attr.type.toTypeNameRef (currNs)»" >
		    	<xsd:annotation>
		    		<xsd:documentation>
		    			<![CDATA[«attr.doc.stripCommentBraces().trim()»]]>
		    		</xsd:documentation>
		    	</xsd:annotation>
		   	</xsd:attribute>
		«ENDIF»
	'''
	
	
	def dispatch toEnumLiteral (EnumLiteral enumLit, SOAProfile profile) '''
   		<xsd:enumeration value="«enumLit.name»"/>
	'''
}