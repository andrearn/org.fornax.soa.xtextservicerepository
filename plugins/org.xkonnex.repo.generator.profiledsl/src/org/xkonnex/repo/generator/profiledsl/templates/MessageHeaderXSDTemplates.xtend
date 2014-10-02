package org.xkonnex.repo.generator.profiledsl.templates

import com.google.inject.Inject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaNamespaceExtensions
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaTypeExtensions
import org.xkonnex.repo.dsl.profiledsl.query.namespace.TechnicalNamespaceImportQueries
import org.xkonnex.repo.dsl.profiledsl.query.type.LatestMatchingTypeFinder
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Attribute
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Class
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.EnumLiteral
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Enumeration
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.MessageHeader
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Property
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfile
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedTypeRef
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher
import org.xkonnex.repo.dsl.profiledsl.versioning.TechnicalNamespaceSplitter
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace

/* A template class to generate an XSD for a TechnicalNamespace 
 * declaring the complextype used by message headers
 */
class MessageHeaderXSDTemplates {

	@Inject IFileSystemAccess fsa
	
	@Inject extension IStateMatcher
	@Inject extension VersionMatcher
	@Inject extension CommonStringExtensions
	@Inject extension ProfileSchemaNamespaceExtensions
	@Inject extension ProfileSchemaTypeExtensions
	@Inject extension VersionQualifierExtensions
	@Inject extension TechnicalNamespaceSplitter
	@Inject extension TechnicalNamespaceImportQueries
	@Inject extension LatestMatchingTypeFinder
	
	@Inject IEObjectDocumentationProvider docProvider

	/*
		<b>CARTRIDGE ENTRYPOINT</b> for generation message headers defined in the give SOAProfile<br/><br/>
	
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
		<b>CARTRIDGE ENTRYPOINT</b> for generation message headers defined in the give SOAProfile<br/><br/>
	
		An XSD for each TechnicalNamespace of all parameters of all message headers defined in
		the SOAProfile will be generated
		Prefixes all imports with given registryBaseUrl. Referenced imported XSDs must be
		available under the calculated URL
	*/
	def dispatch toAllMessageHeadersXSD (SOAProfile profile) {
		for (h : profile.messaging.messageHeaders) {
			h.parameters.map (p|p.type).filter (typeof (VersionedTypeRef)).map (vRef|vRef.type.eContainer).filter (typeof (TechnicalNamespace)).toSet().forEach (ns|ns.toMessageHeaderXSD (profile, h));
		}
	}
	def dispatch toAllMessageHeadersXSD (SOAProfile profile, Void registryBaseUrl) {
		for (h : profile.messaging.messageHeaders) {
			h.parameters.map (p|p.type).filter (typeof (VersionedTypeRef)).map (vRef|vRef.type.eContainer).filter (typeof (TechnicalNamespace)).toSet().forEach (ns|ns.toMessageHeaderXSD (profile, h));
		}
	}
	
	def dispatch toAllMessageHeadersXSD (SOAProfile profile, String registryBaseUrl) {
		for (h : profile.messaging.messageHeaders) {
			h.parameters.map (p|p.type).filter (typeof (VersionedTypeRef)).map (vRef|vRef.type.eContainer).filter (typeof (TechnicalNamespace)).toSet().forEach (ns|ns.toMessageHeaderXSD (profile, registryBaseUrl, h));
		}
	}
	
	def dispatch toMessageHeaderXSD (MessageHeader header, SOAProfile profile) {
		header.parameters.map (p|p.type).filter (typeof (VersionedTypeRef)).map (vRef|vRef.type.eContainer).filter (typeof (TechnicalNamespace)).toSet().forEach (ns|ns.toMessageHeaderXSD (profile, header));
	}
	
	def dispatch toMessageHeaderXSD (MessageHeader header, SOAProfile profile, Void registryBaseUrl) {
		header.parameters.map (p|p.type).filter (typeof (VersionedTypeRef)).map (vRef|vRef.type.eContainer).filter (typeof (TechnicalNamespace)).toSet().forEach (ns|ns.toMessageHeaderXSD (profile, header));
	}
	
	def dispatch toMessageHeaderXSD (MessageHeader header, SOAProfile profile, String registryBaseUrl) {
		header.parameters.map (p|p.type).filter (typeof (VersionedTypeRef)).map (vRef|vRef.type.eContainer).filter (typeof (TechnicalNamespace)).toSet().forEach (ns|ns.toMessageHeaderXSD (profile, registryBaseUrl, header));
	}
	
	/* 
	 * Generate a message header XSD for each header defined in the given profile 
	 * and for each major version of a TechnicalNamespace<br/><br/>
	 * 
	 * @param namespace			the TechnicalNamespace to generate XSDs for<br/>
	 * @param profile			the Profile to be applied<br/>
	 * @param header			the header definition of the profile to be selected for generation<br/>
	 */
	def dispatch toMessageHeaderXSD (TechnicalNamespace namespace, SOAProfile profile, MessageHeader header) {
		namespace.toVersionedTechnicalNamespaces().forEach (vns|vns.toMessageHeaderXSD (profile, header));
	}
	
	/* 
	 * Generate a message header XSD for each header defided inthe given profile 
	 * and for each major version of a TechnicalNamespace<br/><br/>
	 * 
	 * @param namespace			the TechnicalNamespace to generate XSDs for<br/>
	 * @param profile			the Profile to be applied<br/>
	 * @param registryBaseUrl	Import URLs are prefixed with the registryBaseUrl<br/>
	 * @param header			the header definition of the profile to be selected for generation<br/>
	 */
	def dispatch toMessageHeaderXSD (TechnicalNamespace namespace, SOAProfile profile, String registryBaseUrl, MessageHeader header) {
		namespace.toVersionedTechnicalNamespaces().forEach (vns|vns.toMessageHeaderXSD (profile, registryBaseUrl, header));
	}
	
	/* 
	 * Generates a message header XSD for a major version of a TechnicalNamespace
	 */
	def dispatch toMessageHeaderXSD (VersionedTechnicalNamespace vns, SOAProfile profile, MessageHeader header) {
		val imports = vns.allImportedVersionedNS().filter (e| !(e.namespace == vns.namespace && e.version.toMajorVersionNumber() == vns.version.toMajorVersionNumber()));
		val classes = (vns.namespace as TechnicalNamespace).types.filter (typeof (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Class)).filter (e|e.version.version.toMajorVersionNumber() == vns.version.toMajorVersionNumber());
		val enumerations = (vns.namespace as TechnicalNamespace).types.filter (typeof (Enumeration)).filter (e|e.isLatestMatchingType (vns.version.toMajorVersionNumber().asInteger() ));

		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema xmlns:tns="«vns.toNamespace()»"
			«vns.allImportedVersionedNS ().filter (e| !(e.namespace == vns.namespace && e.version.toMajorVersionNumber() == vns.version.toMajorVersionNumber())).map (ns|ns.toNamespaceDeclaration).join» 
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			elementFormDefault="qualified"
			attributeFormDefault="unqualified"
			targetNamespace="«vns.toNamespace()»"
			>
			«imports.map (ns|ns.toImportDeclaration).join»
			«classes.map (t|t.toComplexType(vns, profile, header)).join»
			«enumerations.map (t|t.toSimpleType (profile)).join»
			«/*«EXPAND FaultType(this) FOREACH ((SubNamespace) subdomain).exceptions.select (e|e.isLatestMatchingException (version.toMajorVersionNumber().asInteger(), minState))-*/»
		</xsd:schema>
		'''
		
		val xsdFileName = vns.toFileNameFragment() + ".xsd";
		fsa.generateFile (xsdFileName, content);
	}
	
	
	
	def dispatch toMessageHeaderXSD (VersionedTechnicalNamespace vns, SOAProfile profile, String registryBaseUrl, MessageHeader header) {
		val imports = vns.allImportedVersionedNS()
				.filter (e| !(e.namespace == vns.namespace && e.version.toMajorVersionNumber() == vns.version.toMajorVersionNumber()));
		val classes = (vns.namespace as TechnicalNamespace).types.filter (typeof (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Class))
				.filter (e|e.version.version.toMajorVersionNumber() == vns.version.toMajorVersionNumber());
		val enumerations = (vns.namespace as TechnicalNamespace).types.filter (typeof (Enumeration))
				.filter (e|e.isLatestMatchingType (vns.version.toMajorVersionNumber().asInteger() ));

		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema xmlns:tns="«vns.toNamespace()»"
			«vns.allImportedVersionedNS ().filter (e| !(e.namespace == vns.namespace && e.version.toMajorVersionNumber() == vns.version.toMajorVersionNumber())).forEach (ns|ns.toNamespaceDeclaration)» 
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			elementFormDefault="qualified"
			attributeFormDefault="unqualified"
			targetNamespace="«vns.toNamespace()»"
			>
			«imports.map (ns|ns.toImportDeclaration (registryBaseUrl)).join»
			«classes.map (t|t.toComplexType (vns, profile, header)).join»
			«enumerations.map (t|t.toSimpleType (profile)).join»
			«/*«EXPAND FaultType(this) FOREACH ((SubNamespace) subdomain).exceptions.select (e|e.isLatestMatchingException (version.toMajorVersionNumber().asInteger(), minState))-»*/»
		
		</xsd:schema>
		'''

		val xsdFileName = vns.toFileNameFragment() + ".xsd";
		fsa.generateFile (xsdFileName, content);
	}
	
	
	def protected dispatch toNamespaceDeclaration (VersionedTechnicalNamespace vns) '''
		xmlns:«vns.toPrefix() + vns.version.toMajorVersionNumber()»="«vns.toNamespace()»"
	'''
	
	def protected dispatch toImportDeclaration (VersionedTechnicalNamespace vns) '''
		<xsd:import schemaLocation="«vns.toRegistryAssetUrl (null)».xsd"
			namespace="«vns.toNamespace()»"></xsd:import>
	'''
	def protected dispatch toImportDeclaration (VersionedTechnicalNamespace vns, String registryBaseUrl) '''
		<xsd:import schemaLocation="«vns.toRegistryAssetUrl (registryBaseUrl)».xsd"
			namespace="«vns.toNamespace()»"></xsd:import>
	'''
	
	
	def protected dispatch toComplexType (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Class cls, VersionedTechnicalNamespace currNs, SOAProfile profile, MessageHeader header) '''

		<xsd:complexType name="«cls.name»">
			<xsd:annotation>
				<xsd:documentation>
					<![CDATA[
						Version:	«cls.version.toVersionNumber()»

						«docProvider.getDocumentation (cls)»
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
				«IF header.typesUseExtendibleXMLAttributes»
					«header.getTypesExtendibleXMLAttributesClause»
				«ENDIF»
			«ENDIF»
		</xsd:complexType>
	'''
	
	def protected dispatch toPropertySequenceWithAny (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Class cls, VersionedTechnicalNamespace currNs, SOAProfile profile, MessageHeader header) '''
		<xsd:sequence>
			«cls.properties.filter (typeof (Property)).map (p|p.toProperty (currNs, profile)).join»
			«IF header.typesUseExtendibleProperties»
				«header.getTypesExtendiblePropertiesClause»
			«ENDIF»
		</xsd:sequence>
		«IF !cls.properties.filter (typeof (Attribute)).isEmpty»

			«cls.properties.filter (typeof (Attribute)).map (a|a.toProperty (currNs, profile)).join»
		«ENDIF»
	'''
	
	def protected dispatch toPropertySequence (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Class cls, VersionedTechnicalNamespace currNs, SOAProfile profile) '''
		<xsd:sequence>
			«cls.properties.filter (typeof (Property)).map (p|p.toProperty (currNs, profile)).join»
		</xsd:sequence>
	    «IF !cls.properties.filter (typeof (Attribute)).isEmpty»

	   		«cls.properties.filter (typeof (Attribute)).map (a|a.toProperty (currNs, profile)).join»
	    «ENDIF»
	'''
	
	def protected dispatch toSimpleType (Enumeration enumeration, SOAProfile profile) '''
	    <xsd:simpleType name="«enumeration.name»">
	    	<xsd:annotation>
	    		<xsd:documentation>
	    			<![CDATA[
	    			Version:	«enumeration.version.toVersionNumber()»
	    			
	    			«docProvider.getDocumentation (enumeration)»
	    			]]> 
	       		</xsd:documentation>
	    	</xsd:annotation>
	    	<xsd:restriction base="xsd:string">
	    		«enumeration.literals.forEach (lit|lit.toEnumLiteral (profile))»
	    	</xsd:restriction>
	    </xsd:simpleType>
	'''
	
	
	def protected dispatch toProperty (Property prop, VersionedTechnicalNamespace currNs, SOAProfile profile) '''
		«IF docProvider.getDocumentation (prop) == null»
			<xsd:element name="«prop.name»" «IF prop.optional»minOccurs="0"«ENDIF» «IF prop.type.isMany()»maxOccurs="unbounded"«ENDIF» type="«prop.type.toTypeNameRef(currNs)»" />
		«ELSE»		
			<xsd:element name="«prop.name»" «IF prop.optional»minOccurs="0"«ENDIF» «IF prop.type.isMany()»maxOccurs="unbounded"«ENDIF» type="«prop.type.toTypeNameRef(currNs)»" >
				<xsd:annotation>
					<xsd:documentation>
						<![CDATA[«docProvider.getDocumentation (prop)»]]>
					</xsd:documentation>
				</xsd:annotation>
			</xsd:element>
		«ENDIF»
	'''
	
	def protected dispatch toProperty (Attribute attr, VersionedTechnicalNamespace currNs, SOAProfile profile) '''
		«IF docProvider.getDocumentation (attr) == null»
		   	<xsd:attribute name="«attr.name»" «IF attr.optional»use="optional"«ENDIF» type="«attr.type.toTypeNameRef (currNs)»" />
		«ELSE»		
			<xsd:attribute name="«attr.name»" «IF attr.optional»use="optional"«ENDIF» type="«attr.type.toTypeNameRef (currNs)»" >
				<xsd:annotation>
					<xsd:documentation>
						<![CDATA[«docProvider.getDocumentation (attr)»]]>
					</xsd:documentation>
				</xsd:annotation>
			</xsd:attribute>
		«ENDIF»
	'''
	
	
	def protected dispatch toEnumLiteral (EnumLiteral enumLit, SOAProfile profile) '''
   		<xsd:enumeration value="«enumLit.name»"/>
	'''
}