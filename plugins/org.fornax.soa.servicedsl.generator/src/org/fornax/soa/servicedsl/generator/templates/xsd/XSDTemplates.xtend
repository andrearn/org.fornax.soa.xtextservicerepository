package org.fornax.soa.servicedsl.generator.templates.xsd

import com.google.inject.Inject
import com.google.inject.name.Named
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.fornax.soa.basedsl.generator.CommonStringExtensions
import org.fornax.soa.basedsl.generator.version.VersionMatcher
import org.fornax.soa.basedsl.generator.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaTypeExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.Attribute
import org.fornax.soa.serviceDsl.BusinessObject
import org.fornax.soa.serviceDsl.EnumLiteral
import org.fornax.soa.serviceDsl.Enumeration
import org.fornax.soa.serviceDsl.Exception
import org.fornax.soa.serviceDsl.OrganizationNamespace
import org.fornax.soa.serviceDsl.Property
import org.fornax.soa.serviceDsl.Reference
import org.fornax.soa.serviceDsl.SimpleAttribute
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.TypeRef
import org.fornax.soa.servicedsl.VersionedDomainNamespace
import org.fornax.soa.servicedsl.generator.domain.NamespaceSplitter
import org.fornax.soa.servicedsl.generator.query.ExceptionFinder
import org.fornax.soa.servicedsl.generator.query.LifecycleQueries
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceImportQueries
import org.fornax.soa.servicedsl.generator.query.type.LatestMatchingTypeFinder
import org.fornax.soa.servicedsl.generator.query.type.ReferencedTypesFinder
import org.fornax.soa.servicedsl.generator.query.type.VersionedTypeFilter
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher

class XSDTemplates {


	@Inject IFileSystemAccess fsa
	
	@Inject extension VersionMatcher
	@Inject extension CommonStringExtensions
	@Inject extension SchemaNamespaceExtensions
	@Inject extension SchemaTemplateExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension ProfileSchemaTypeExtensions
	@Inject extension VersionedTypeFilter
	@Inject extension LifecycleQueries
	@Inject extension NamespaceSplitter
	@Inject extension NamespaceImportQueries
	@Inject extension LatestMatchingTypeFinder
	@Inject extension ReferencedTypesFinder
	@Inject extension IStateMatcher
	
	@Inject ExceptionFinder exceptionFinder
	
	@Inject VersionQualifierExtensions versionQualifier

	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
	@Inject
	IQualifiedNameProvider nameProvider
	
	@Inject org.fornax.soa.profiledsl.generator.query.LifecycleQueries lifecycleQueries

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
		var nsVersions = ns.toVersionedDomainNamespaces().getAllLatestSubNamespacesByMajorVersion();
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
		var nsVersions = ns.toVersionedDomainNamespaces().getAllLatestSubNamespacesByMajorVersion();
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
	def dispatch toXSDForImports (SubNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		for (nsVer : ns.toVersionedDomainNamespaces().getAllLatestSubNamespacesByMajorVersion()) {
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
	def dispatch toXSDVersion (VersionedDomainNamespace vns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		val imports = vns.importedVersionedNS (minState).filter (e|e.toNamespace() != vns.toNamespace());
		val bos = vns.types.filter (typeof (BusinessObject)).filter (b|!b.state.isEnd)
			.filter (e|minState.matches (e.state) && e.isLatestMatchingType (versionQualifier.toMajorVersionNumber(vns.version).asInteger(),  minState));
		val enums = vns.types.filter (typeof (Enumeration))
			.filter (en|minState.matches (en.state) && en.isLatestMatchingType (versionQualifier.toMajorVersionNumber(vns.version).asInteger(), minState));
		val exceptions = vns.exceptions.filter (typeof (org.fornax.soa.serviceDsl.Exception))
			.filter (ex|minState.matches (ex.state) && exceptionFinder.isLatestMatchingException (ex, versionQualifier.toMajorVersionNumber(vns.version).asInteger(), minState));

		if (!bos.empty || !enums.empty || !exceptions.empty) {
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

	def dispatch toXSDVersion (VersionedDomainNamespace vns, LifecycleState minState, SOAProfile profile, String registryBaseUrl, boolean noDeps, boolean includeSubNamespaces) {
		val imports = vns.importedVersionedNS(minState).filter(e|e.toNamespace() != vns.toNamespace());
		val bos = vns.types.filter (typeof (BusinessObject)).filter (b|!b.state.isEnd)
			.filter (e|minState.matches (e.state) && e.isLatestMatchingType (versionQualifier.toMajorVersionNumber(vns.version).asInteger(),  minState));
		val enums = vns.types.filter (typeof (Enumeration))
			.filter (en|minState.matches (en.state) && en.isLatestMatchingType (versionQualifier.toMajorVersionNumber(vns.version).asInteger(), minState));
		val exceptions = vns.exceptions.filter (typeof (org.fornax.soa.serviceDsl.Exception))
			.filter (e|minState.matches (e.state) && exceptionFinder.isLatestMatchingException (e, versionQualifier.toMajorVersionNumber(vns.version).asInteger(), minState));

		if (!bos.empty || !enums.empty || !exceptions.empty) {
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
	
	
	def dispatch toNamespaceDeclaration (VersionedDomainNamespace vns) '''
		xmlns:«vns.toPrefix() + versionQualifier.toMajorVersionNumber(vns.version)»="«vns.toNamespace()»"
	'''
	
	def dispatch toImportDeclaration (VersionedDomainNamespace vns, String registryBaseUrl) '''
		<xsd:import schemaLocation="«vns.toRegistryAssetUrl (registryBaseUrl)».xsd"
			namespace="«vns.toNamespace()»"></xsd:import>
	'''
	
	/*
		Generate a ComplexType for a BusinessObject respecting the major version of the containing 
		XSD. Hence, the same VersionedDomainNamespace as for the containing XSD must be used.
		
		@param 		currNs	The VersionedDomainNamespace currently in use for the containing 
							XSD being generated
		@param		profile	The SOAProfile defining the governing architecture rules.
	*/
	def dispatch toComplexType(BusinessObject bo, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''

		<xsd:complexType name="«bo.name»"«IF bo.abstract» abstract="true"«ENDIF»>
			<xsd:annotation>
		    	<xsd:documentation>
					<![CDATA[Version:	«versionQualifier.toVersionNumber(bo.version)»
						Lifecycle state: «bo.state.name»
						«IF bo.doc != null»
										
							«bo.doc?.stripCommentBraces()?.trim()»
						«ENDIF»
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
				«IF profile.typesUseExtendableXMLAttributes()»
					<xsd:anyAttribute namespace="##any"/>
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
			«IF profile.typesUseExtendableProperties ()»
				<xsd:any maxOccurs="unbounded" minOccurs="0" namespace="http://www.w3.org/2001/XMLSchema ##local"
					processContents="skip"/>
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
	
	def dispatch toPropertySequenceWithAny (org.fornax.soa.serviceDsl.Exception ex, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''
		<xsd:sequence>
			«ex.properties.map (e|e.toProperty (currNs, profile, minState)).join»
			«IF profile.typesUseExtendableProperties ()»
				<xsd:any maxOccurs="unbounded" minOccurs="0" namespace="http://www.w3.org/2001/XMLSchema ##local"
					processContents="skip"/>
			«ENDIF»
		</xsd:sequence>
	'''
	
	def dispatch toPropertySequence(org.fornax.soa.serviceDsl.Exception ex, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''
		<xsd:sequence>
			«ex.properties.map (e|e.toProperty (currNs, profile, minState)).join»
		</xsd:sequence>
	'''
	
	def dispatch toSimpleType (Enumeration en, LifecycleState minState) '''

		<xsd:simpleType name="«en.name»">
			<xsd:annotation>
				<xsd:documentation>
					<![CDATA[
						Version:	«versionQualifier.toVersionNumber(en.version)»
					«IF en.doc != null»
						
						«en.doc?.stripCommentBraces()?.trim()»
					«ENDIF» 
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
	def dispatch toFaultType (org.fornax.soa.serviceDsl.Exception ex, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''

		<xsd:complexType name="«ex.toTypeName()»">
			<xsd:annotation>
				<xsd:documentation>
					<![CDATA[
						Version:			«versionQualifier.toVersionNumber(ex.version)»
					    Lifecycle state: 	«ex.state.name»
						«IF ex.doc != null»
							
							«ex.doc?.stripCommentBraces()?.trim()»
						«ENDIF»
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
				«IF profile.typesUseExtendableXMLAttributes()»
					<xsd:anyAttribute namespace="##any"/>
				«ENDIF»
			«ENDIF»
		</xsd:complexType>
	'''
	
	def dispatch toProperty (Property p, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) {
	}
	
	def dispatch toProperty (Attribute attr, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''
		«IF attr.doc != null»
			<xsd:element name="«attr.name»" «IF attr.optional»minOccurs="0"«ENDIF» «IF attr.type.isMany()»maxOccurs="unbounded"«ENDIF» type="«attr.type.toTypeNameRef(currNs)»" «IF attr.type.isAttachment()»«attr.type.toAttachmentMimeFragment()»«ENDIF» >
				«IF attr.doc != null»
					<xsd:annotation>
						<xsd:documentation>
							<![CDATA[«attr.doc?.stripCommentBraces()?.trim()»]]>
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
				«ENDIF»
			</xsd:element>
		«ELSE»
			<xsd:element name="«attr.name»" «IF attr.optional»minOccurs="0"«ENDIF» «IF attr.type.isMany()»maxOccurs="unbounded"«ENDIF» type="«attr.type.toTypeNameRef(currNs)»" «IF attr.type.isAttachment()»«attr.type.toAttachmentMimeFragment ()»«ENDIF» />
		«ENDIF»
	'''
	
	def dispatch toProperty (SimpleAttribute attr, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''
		«IF attr.doc == null»
			<xsd:element name="«attr.name»" «IF attr.optional»minOccurs="0"«ENDIF» «IF attr.type.isMany()»maxOccurs="unbounded"«ENDIF» type="«attr.type.toTypeNameRef(currNs)»" «IF attr.type.isAttachment()»«attr.type.toAttachmentMimeFragment ()»«ENDIF»/>
		«ELSE»
			<xsd:element name="«attr.name»" «IF attr.optional»minOccurs="0"«ENDIF» «IF attr.type.isMany()»maxOccurs="unbounded"«ENDIF» type="«attr.type.toTypeNameRef(currNs)»" «IF attr.type.isAttachment()»«attr.type.toAttachmentMimeFragment () »«ENDIF»>
				«IF attr.doc != null»
					<xsd:annotation>
						<xsd:documentation>
							<![CDATA[«attr.doc?.stripCommentBraces()?.trim()»]]>
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
			   	«ENDIF»
			</xsd:element>
		«ENDIF»
	'''
	
	def dispatch toProperty (Reference ref, VersionedDomainNamespace currNs, SOAProfile profile, LifecycleState minState) '''
		<xsd:element name="«ref.name»" «IF ref.optional»minOccurs="0"«ENDIF» type="«ref.type.toWeakRefType (minState)»" >
		   	<xsd:annotation>
		   		<xsd:documentation>
		   			<![CDATA[
			   			References an instance of type «ref.type.toFullTypeNameRef(currNs)» using it's business-key «ref.type.toWeakRefKeyAttr(minState)»
						«IF ref.doc != null»
				   			«ref.doc?.stripCommentBraces()?.trim()»
				    	«ENDIF»
			    	]]>
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
	'''
	
	def dispatch toEnumLiteral (EnumLiteral enumLit) '''
		<xsd:enumeration value="«enumLit.name»"/>
	'''
	
	def dispatch toAttachmentMimeFragment (TypeRef t) '''
		xmime:expectedContentTypes="application/octet-stream"
	'''
}