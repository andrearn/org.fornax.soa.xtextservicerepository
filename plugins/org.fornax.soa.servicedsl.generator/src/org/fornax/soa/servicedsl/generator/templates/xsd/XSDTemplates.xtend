package org.fornax.soa.servicedsl.generator.templates.xsd

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.logging.Logger
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.query.LifecycleQueries
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.service.namespace.NamespaceSplitter
import org.fornax.soa.service.query.ExceptionFinder
import org.fornax.soa.service.query.namespace.NamespaceImportQueries
import org.fornax.soa.service.versioning.IExceptionResolver
import org.fornax.soa.service.versioning.ITypeResolver
import org.fornax.soa.serviceDsl.BusinessObject
import org.fornax.soa.serviceDsl.EnumLiteral
import org.fornax.soa.serviceDsl.Enumeration
import org.fornax.soa.serviceDsl.Exception
import org.fornax.soa.serviceDsl.OrganizationNamespace
import org.fornax.soa.serviceDsl.Property
import org.fornax.soa.serviceDsl.QueryObject
import org.fornax.soa.serviceDsl.SimpleAttribute
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.TypeRef

class XSDTemplates {


	@Inject IFileSystemAccess fsa
	
	@Inject extension CommonStringExtensions
	@Inject extension SchemaNamespaceExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension NamespaceSplitter
	@Inject extension NamespaceImportQueries
	@Inject extension ITypeResolver
	@Inject extension IStateMatcher
	
	@Inject IExceptionResolver exceptionResolver
	
	@Inject VersionQualifierExtensions versionQualifier

	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
	@Inject
	IQualifiedNameProvider nameProvider
	
	@Inject
	IEObjectDocumentationProvider docProvider
	
	@Inject LifecycleQueries lifecycleQueries

	@Inject 
	private Logger log

	/*
		CARTRIDGE ENTRYPOINT for generation of XSDs from namespaces. 
	
		Generate an XSD for each VersionedDomainNamespace derived from the given SubNamespace 
		applying splitting by major version of owned VersionedTypes and Exceptions in the 
		given minimal LifecycleState.
	*/
	def dispatch toXSD (SubNamespace ns, String minState, org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile profile, String registryBaseUrl) {
		ns.toXSD (lifecycleQueries.stateByName (minState, ns.eResource), profile, registryBaseUrl);
	}
	
	def dispatch toXSD (SubNamespace ns, String minState, SOAProfile profile, String registryBaseUrl, boolean noDeps, boolean includeSubNamespaces) {
		ns.toXSD (lifecycleQueries.stateByName (minState, ns.eResource), profile, registryBaseUrl, noDeps, includeSubNamespaces);
	}
	
	
	/*
		Generate an XSD for each VersionedDomainNamespace derived from the given SubNamespace 
		applying splitting by major version of owned VersionedTypes and Exceptions in the 
		given minimal LifecycleState.
	*/
	def dispatch toXSD (SubNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		var nsVersions = ns.splitNamespaceByMajorVersion().getAllLatestSubNamespacesByMajorVersion();
		for (nsVer : nsVersions) {
			nsVer.toXSDVersion (minState, profile, registryBaseUrl);
			if ( ! noDependencies ) {
				nsVer.allImportedVersionedNS (minState).filter (typeof (VersionedDomainNamespace))
					.filter (e| !(e.subdomain == nsVer.subdomain && versionQualifier.toMajorVersionNumber(e.version) == versionQualifier.toMajorVersionNumber(nsVer.version)))
					.forEach (e|e.toXSDVersion (minState, profile, registryBaseUrl));
			}
		}
	}
	
	/*
	 * TODO: review for use as noDependencies flag is being injected already
	 */
	def dispatch toXSD (SubNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl, boolean noDeps, boolean includeSubNamespaces) {
		var nsVersions = ns.splitNamespaceByMajorVersion().getAllLatestSubNamespacesByMajorVersion();
		for (nsVer : nsVersions) {
			nsVer.toXSDVersion (minState, profile, registryBaseUrl, noDeps, includeSubNamespaces);
			if ( !noDeps) {
				nsVer.allImportedVersionedNS (minState).filter (typeof (VersionedDomainNamespace))
					.filter (e|!(e.subdomain == nsVer.subdomain && versionQualifier.toMajorVersionNumber(e.version) == versionQualifier.toMajorVersionNumber(nsVer.version)))
					.forEach (e|e.toXSDVersion (minState, profile, registryBaseUrl, noDeps, includeSubNamespaces));
			}
		}
	}

	def dispatch toXSD (VersionedDomainNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		ns.toXSDVersion (minState, profile, registryBaseUrl);
		ns.allImportedVersionedNS (minState).filter (typeof (VersionedDomainNamespace))
				.filter(e| !(e.subdomain == ns.subdomain && versionQualifier.toMajorVersionNumber(e.version) == versionQualifier.toMajorVersionNumber(ns.version)))
				.forEach (e|e.toXSDVersion (minState, profile, registryBaseUrl));
	}
	
	/*
		Generate XSDs for all VersionedDomainNamespaces derived from the given SubNamespace by applying
		the major version splitting algorithm filtered by the given minimal LifecycleState
	*/
	def toXSDForImports (SubNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		for (nsVer : ns.splitNamespaceByMajorVersion().getAllLatestSubNamespacesByMajorVersion()) {
			nsVer.toXSDVersion (minState, profile, registryBaseUrl);
			nsVer.allImportedVersionedNS (minState).filter (typeof (VersionedDomainNamespace))
				.filter(e| !(e.subdomain == nsVer.subdomain && versionQualifier.toMajorVersionNumber(e.version) == versionQualifier.toMajorVersionNumber(nsVer.version)))
				.forEach (e|e.toXSDVersion (minState, profile, registryBaseUrl));
		}
	}
	
	
	/*
		Generate the XSD for the given VersionedDomainNamespace. Only consider VersionedTypes and Exceptions
		that match the given minimal LifecycleState.
	*/
	def toXSDVersion (VersionedDomainNamespace vns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		val imports = vns.importedVersionedNS (minState).filter (e|e.toNamespace() != vns.toNamespace());
		val bos = vns.types.filter (typeof (BusinessObject)).filter (b|!b.state.isEnd)
			.filter (e|minState.matches (e.state) && e.isMatchingType (versionQualifier.toMajorVersionNumber(vns.version).asInteger(),  minState));
		val qos = vns.types.filter (typeof (QueryObject)).filter (b|!b.state.isEnd)
			.filter (e|minState.matches (e.state) && e.isMatchingType (versionQualifier.toMajorVersionNumber(vns.version).asInteger(),  minState));
		val enums = vns.types.filter (typeof (Enumeration))
			.filter (en|minState.matches (en.state) && en.isMatchingType (versionQualifier.toMajorVersionNumber(vns.version).asInteger(), minState));
		val exceptions = vns.exceptions.filter (typeof (org.fornax.soa.serviceDsl.Exception))
			.filter (ex|minState.matches (ex.state) && exceptionResolver.isMatchingException (ex, versionQualifier.toMajorVersionNumber(vns.version).asInteger(), minState));

		if (!bos.empty || !qos.empty || !enums.empty || !exceptions.empty) {
			var content = '''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<xsd:schema xmlns:tns="«vns.toNamespace()»"
				«vns.importedVersionedNS (minState).map (e|e.toNamespaceDeclaration ()).join» 
				xmlns="«vns.toNamespace()»"
				xmlns:xsd="http://www.w3.org/2001/XMLSchema" 
				xmlns:xmime="http://www.w3.org/2005/05/xmlmime"
				«/*
					xmlns:jxb="http://java.sun.com/xml/ns/jaxb"
					jxb:version="2.0"
				*/»
				elementFormDefault="qualified"
				attributeFormDefault="unqualified"
				targetNamespace="«vns.toNamespace()»"
				>
				«imports.map (e|e.toImportDeclaration (registryBaseUrl)).join» 	
				«IF (vns.subdomain instanceof SubNamespace)»
					«bos.map (e|e.toComplexType (vns, profile, minState)).join»
					«qos.map (e|e.toComplexType (vns, profile, minState)).join»
					«enums.map (e|e.toSimpleType (minState)).join»
					«exceptions.map (e|e.toFaultType (vns, profile, minState)).join»
				«ELSEIF (vns.subdomain instanceof OrganizationNamespace)»
					«/*»«EXPAND ComplexType FOREACH ((OrganizationNamespace) subdomain).types.typeSelect(BusinessObject)-»«ENDREM*/»
				«ENDIF»
			</xsd:schema>'''
			
			var fileName = vns.toFileNameFragment() + ".xsd";
			fsa.generateFile (fileName, content);
		}
	}

	/*
		Generate the XSD for the given VersionedDomainNamespace. Only consider VersionedTypes and Exceptions
		that match the given minimal LifecycleState.
	*/
	def toXSDVersion (VersionedDomainNamespace vns, LifecycleState minState, SOAProfile profile, String registryBaseUrl, boolean noDeps, boolean includeSubNamespaces) {
		val imports = vns.importedVersionedNS(minState).filter(e|e.toNamespace() != vns.toNamespace());
		val bos = vns.types.filter (typeof (BusinessObject)).filter (b|!b.state.isEnd)
			.filter (e|minState.matches (e.state) && e.isMatchingType (versionQualifier.toMajorVersionNumber(vns.version).asInteger(),  minState));
		val qos = vns.types.filter (typeof (QueryObject)).filter (b|!b.state.isEnd)
			.filter (e|minState.matches (e.state) && e.isMatchingType (versionQualifier.toMajorVersionNumber(vns.version).asInteger(),  minState));
		val enums = vns.types.filter (typeof (Enumeration))
			.filter (en|minState.matches (en.state) && en.isMatchingType (versionQualifier.toMajorVersionNumber(vns.version).asInteger(), minState));
		val exceptions = vns.exceptions.filter (typeof (org.fornax.soa.serviceDsl.Exception))
			.filter (e|minState.matches (e.state) && exceptionResolver.isMatchingException (e, versionQualifier.toMajorVersionNumber(vns.version).asInteger(), minState));

		if (!bos.empty || !qos.empty || !enums.empty || !exceptions.empty) {
			var content = '''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<xsd:schema xmlns:tns="«vns.toNamespace()»"
				«vns.importedVersionedNS (minState).map (e|e.toNamespaceDeclaration).join» 
				xmlns="«vns.toNamespace()»"
				xmlns:xsd="http://www.w3.org/2001/XMLSchema" 
				xmlns:xmime="http://www.w3.org/2005/05/xmlmime"
			«/*
				xmlns:jxb="http://java.sun.com/xml/ns/jaxb"
				jxb:version="2.0"
			*/»
				elementFormDefault="qualified"
				attributeFormDefault="unqualified"
				targetNamespace="«vns.toNamespace()»"
				>
				«imports.map (e|e.toImportDeclaration (registryBaseUrl)).join» 	
				«IF (vns.subdomain instanceof SubNamespace)»
					«bos.map (e|e.toComplexType (vns, profile, minState)).join»
					«qos.map (e|e.toComplexType (vns, profile, minState)).join»
					«enums.map (e|e.toSimpleType (minState)).join»
					«exceptions.map (e|e.toFaultType (vns, profile, minState)).join»
				«ELSEIF (vns.subdomain instanceof OrganizationNamespace)»
					«/*«EXPAND ComplexType FOREACH ((OrganizationNamespace) subdomain).types.typeSelect(BusinessObject)-»*/»
				«ENDIF»
			</xsd:schema>'''
	
			var fileName = vns.toFileNameFragment() + ".xsd";
			fsa.generateFile (fileName, content);
		}
	}
	
	
	def toNamespaceDeclaration (VersionedDomainNamespace vns) '''
		xmlns:«vns.toPrefix() + versionQualifier.toMajorVersionNumber(vns.version)»="«vns.toNamespace()»"
	'''
	
	def toImportDeclaration (VersionedDomainNamespace vns, String registryBaseUrl) '''
		<xsd:import schemaLocation="«vns.toRegistryAssetUrl (registryBaseUrl)».xsd"
			namespace="«vns.toNamespace()»"></xsd:import>
	'''
	
	/**
		Generate a ComplexType for a BusinessObject respecting the major version of the containing 
		XSD. Hence, the same VersionedDomainNamespace as for the containing XSD must be used.
		
		@param 		currNs	The VersionedDomainNamespace currently in use for the containing 
							XSD being generated
		@param		profile	The SOAProfile defining the governing architecture rules.
	*/
	def toComplexType(BusinessObject bo, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''

		<xsd:complexType name="«bo.name»"«IF bo.^abstract» abstract="true"«ENDIF»>
			<xsd:annotation>
		    	<xsd:documentation>
					<![CDATA[
						Version:			«versionQualifier.toVersionNumber(bo.version)»
						Lifecycle state: 	«bo.state.name»
										
						«docProvider.getDocumentation (bo)»
					]]>
				</xsd:documentation>
						«/*
					    	<xsd:appinfo>
						    	<jxb:class>
					  	    		<jxb:javadoc>
						<![CDATA[Version:	«version.toVersionNumber()»
						Lifecycle state: «state.toString()»
						«IF doc != null-»
										
						«doc?.stripCommentBraces()?.trim()»
						«ENDIF-» ]]>   			
					    			</jxb:javadoc>
						    	</jxb:class>
					      	</xsd:appinfo>
						*/» 
			</xsd:annotation>
			
			«IF bo.superBusinessObject != null»
				<xsd:complexContent>
					<xsd:extension base="«bo.superBusinessObject.toTypeNameRef(currNs)»">
						«bo.toPropertySequence (currNs, profile, minState)»
					</xsd:extension>
				</xsd:complexContent>
			«ELSE»
				«bo.toPropertySequenceWithAny (currNs, profile, minState)»
				«IF profile.typesUseExtendibleXMLAttributes()»
					«profile.typesExtendibleXMLAttributesClause»
				«ENDIF»
			«ENDIF»
		</xsd:complexType>
	'''


	/**
		Generate a ComplexType for a QueryObject respecting the major version of the containing 
		XSD. Hence, the same VersionedDomainNamespace as for the containing XSD must be used.
		
		@param 		currNs	The VersionedDomainNamespace currently in use for the containing 
							XSD being generated
		@param		profile	The SOAProfile defining the governing architecture rules.
	*/
	def toComplexType(QueryObject qo, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''

		<xsd:complexType name="«qo.name»">
			<xsd:annotation>
		    	<xsd:documentation>
					<![CDATA[
						Version:			«versionQualifier.toVersionNumber(qo.version)»
						Lifecycle state: 	«qo.state.name»
										
						«docProvider.getDocumentation (qo)»
					]]>
				</xsd:documentation>
						«/*
					    	<xsd:appinfo>
						    	<jxb:class>
					  	    		<jxb:javadoc>
						<![CDATA[Version:	«version.toVersionNumber()»
						Lifecycle state: «state.toString()»
						«IF doc != null-»
										
						«doc?.stripCommentBraces()?.trim()»
						«ENDIF-» ]]>   			
					    			</jxb:javadoc>
						    	</jxb:class>
					      	</xsd:appinfo>
						*/» 
			</xsd:annotation>
			
			«IF qo.superQueryObject != null»
				<xsd:complexContent>
					<xsd:extension base="«qo.superQueryObject.toTypeNameRef(currNs)»">
						«qo.toPropertySequence (currNs, profile, minState)»
					</xsd:extension>
				</xsd:complexContent>
			«ELSE»
				«qo.toPropertySequenceWithAny (currNs, profile, minState)»
				«IF profile.typesUseExtendibleXMLAttributes()»
					«profile.typesExtendibleXMLAttributesClause»
				«ENDIF»
			«ENDIF»
		</xsd:complexType>
	'''

	
	/*
		Generate a sequence of elements for properties plus an additional any as placeholder for future
		backward compatible extensions of the ComplexType / BusinessObject
		
		@param 		currNs	The VersionedDomainNamespace currently in use for the containing 
							XSD being generated
		@param		profile	The SOAProfile defining the governing architecture rules.
	*/
	def dispatch toPropertySequenceWithAny(BusinessObject bo, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''
		<xsd:sequence>
			«bo.properties.map (e|e.toProperty (currNs, profile, minState)).join»
			«IF profile.typesUseExtendibleProperties ()»
				«profile.typesExtendiblePropertiesClause»
			«ENDIF»
		</xsd:sequence>
	'''
	
	/*
		Generate a sequence of elements for properties plus an additional any as placeholder for future
		backward compatible extensions of the ComplexType / BusinessObject
		
		@param 		currNs	The VersionedDomainNamespace currently in use for the containing 
							XSD being generated
		@param		profile	The SOAProfile defining the governing architecture rules.
	*/
	def dispatch toPropertySequenceWithAny(QueryObject qo, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''
		<xsd:sequence>
			«qo.properties.map (e|e.toProperty (currNs, profile, minState)).join»
			«IF profile.typesUseExtendibleProperties ()»
				«profile.typesExtendiblePropertiesClause»
			«ENDIF»
		</xsd:sequence>
	'''
	
	/*
		Generate a sequence of elements for properties without a placeholder for future
		backward compatible extensions of the ComplexType / BusinessObject
		
		@param 		currNs	The VersionedDomainNamespace currently in use for the containing 
							XSD being generated
		@param		profile	The SOAProfile defining the governing architecture rules.
	*/
	def dispatch toPropertySequence(BusinessObject bo, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''
		<xsd:sequence>
			«bo.properties.map (e|e.toProperty (currNs, profile, minState)).join»
		</xsd:sequence>
	'''
	
	/*
		Generate a sequence of elements for properties without a placeholder for future
		backward compatible extensions of the ComplexType / BusinessObject
		
		@param 		currNs	The VersionedDomainNamespace currently in use for the containing 
							XSD being generated
		@param		profile	The SOAProfile defining the governing architecture rules.
	*/
	def dispatch toPropertySequence(QueryObject qo, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''
		<xsd:sequence>
			«qo.properties.map (e|e.toProperty (currNs, profile, minState)).join»
		</xsd:sequence>
	'''
	
	def dispatch toPropertySequenceWithAny (org.fornax.soa.serviceDsl.Exception ex, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''
		<xsd:sequence>
			«ex.properties.map (e|e.toProperty (currNs, profile, minState)).join»
			«IF profile.typesUseExtendibleProperties ()»
				«profile.typesExtendiblePropertiesClause»
			«ENDIF»
		</xsd:sequence>
	'''
	
	def dispatch toPropertySequence(org.fornax.soa.serviceDsl.Exception ex, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''
		<xsd:sequence>
			«ex.properties.map (e|e.toProperty (currNs, profile, minState)).join»
		</xsd:sequence>
	'''
	
	def toSimpleType (Enumeration en, LifecycleState minState) '''

		<xsd:simpleType name="«en.name»">
			<xsd:annotation>
				<xsd:documentation>
					<![CDATA[
						Version:			«versionQualifier.toVersionNumber(en.version)»
						Lifecycle state: 	«en.state.name»
						
						«docProvider.getDocumentation (en)»
					]]>
				</xsd:documentation>
			</xsd:annotation>
			<xsd:restriction base="xsd:string">
				«en.literals.map (e|e.toEnumLiteral()).join»
			</xsd:restriction>
		</xsd:simpleType>
	'''
	
	/*
		Generate a ComplexType for a given Exception. The ComplextType is being genereated for a containing
		versioned XSD. Hence, the VersionedDomainNamespace on which the XSD is based is required.
		
		@param 		currNs	The VersionedDomainNamespace currently in use for the containing 
							XSD being generated
		@param		profile	The SOAProfile defining the governing architecture rules.
	*/
	def toFaultType (org.fornax.soa.serviceDsl.Exception ex, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''

		<xsd:complexType name="«ex.name»">
			<xsd:annotation>
				<xsd:documentation>
					<![CDATA[
						Version:			«versionQualifier.toVersionNumber(ex.version)»
					    Lifecycle state: 	«ex.state.name»
						
						«docProvider.getDocumentation (ex)»
					]]>   			
				</xsd:documentation>
				«/*
	    		<xsd:appinfo>
	    			<jxb:class>
	      				<jxb:javadoc>
							<![CDATA[Version:	«version.toVersionNumber()»
								Lifecycle state: «state.toString()»
							«IF doc != null»
												
								«doc?.stripCommentBraces()?.trim()»
							«ENDIF» ]]>   			
	      				</jxb:javadoc>
	      			</jxb:class>
	      		</xsd:appinfo>
			*/»
			</xsd:annotation>

			«IF ex.superException != null»
				<xsd:complexContent>
					<xsd:extension base="«ex.superException.toExceptionNameRef(currNs)»">
						«ex.toPropertySequence (currNs, profile, minState)»
					</xsd:extension>
				</xsd:complexContent>
			«ELSE»
				«ex.toPropertySequenceWithAny (currNs, profile, minState)»
				«IF profile.typesUseExtendibleXMLAttributes()»
					«profile.typesExtendibleXMLAttributesClause»
				«ENDIF»
			«ENDIF»
		</xsd:complexType>
	'''
	
	
	def dispatch toProperty (Property attr, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''
		«IF docProvider.getDocumentation (attr) != null»
			<xsd:element name="«attr.name»" «IF attr.optionalElement»minOccurs="0"«ENDIF» «IF attr.type.isMany()»maxOccurs="unbounded"«ENDIF» type="«attr.type.toTypeNameRef(currNs)»" «IF attr.type.isAttachment()»«attr.type.toAttachmentMimeFragment()»«ENDIF» >
				<xsd:annotation>
					<xsd:documentation>
						<![CDATA[«docProvider.getDocumentation (attr)»]]>
					</xsd:documentation>
					«/*
			   		<xsd:appinfo>
			    		<jxb:property>
			    			<jxb:javadoc>
				   				<![CDATA[«doc?.stripCommentBraces()?.trim()»]]>
			    			</jxb:javadoc>
			    		</jxb:property>
					</xsd:appinfo>
					*/»
				</xsd:annotation>
			</xsd:element>
		«ELSE»
			<xsd:element name="«attr.name»" «IF attr.optionalElement»minOccurs="0"«ENDIF» «IF attr.type.isMany()»maxOccurs="unbounded"«ENDIF» type="«attr.type.toTypeNameRef(currNs)»" «IF attr.type.isAttachment()»«attr.type.toAttachmentMimeFragment ()»«ENDIF» />
		«ENDIF»
	'''
	
	def dispatch toProperty (SimpleAttribute attr, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''
		«IF docProvider.getDocumentation (attr) == null»
			<xsd:element name="«attr.name»" «IF attr.optional»minOccurs="0"«ENDIF» «IF attr.type.isMany()»maxOccurs="unbounded"«ENDIF» type="«attr.type.toTypeNameRef(currNs)»" «IF attr.type.isAttachment()»«attr.type.toAttachmentMimeFragment ()»«ENDIF»/>
		«ELSE»
			<xsd:element name="«attr.name»" «IF attr.optional»minOccurs="0"«ENDIF» «IF attr.type.isMany()»maxOccurs="unbounded"«ENDIF» type="«attr.type.toTypeNameRef(currNs)»" «IF attr.type.isAttachment()»«attr.type.toAttachmentMimeFragment () »«ENDIF»>
				<xsd:annotation>
					<xsd:documentation>
						<![CDATA[«docProvider.getDocumentation (attr)»]]>
					</xsd:documentation>
					«/*
				   		<xsd:appinfo>
				    		<jxb:property>
				    			<jxb:javadoc>
					    			<![CDATA[«doc?.stripCommentBraces()?.trim()»]]>
				    			</jxb:javadoc>
				    		</jxb:property>
						</xsd:appinfo>
					*/»
				</xsd:annotation>
			</xsd:element>
		«ENDIF»
	'''
	
	
	def toEnumLiteral (EnumLiteral enumLit) '''
		<xsd:enumeration value="«enumLit.name»"/>
	'''
	
	def toAttachmentMimeFragment (TypeRef t) '''
		xmime:expectedContentTypes="application/octet-stream"
	'''
}