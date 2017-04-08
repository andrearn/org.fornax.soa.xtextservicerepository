package org.xkonnex.repo.generator.servicedsl.templates.xsd

import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.profiledsl.namespace.ProfileNamespaceURIProvider
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.MessageHeader
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Property
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceURIProvider
import org.xkonnex.repo.dsl.servicedsl.service.query.HeaderFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceImportQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.generator.servicedsl.templates.CommonTemplateExtensions
import org.xkonnex.repo.generator.servicedsl.templates.webservice.ServiceTemplateExtensions
import org.xkonnex.repo.dsl.servicedsl.service.ModelExtensions

class EventXSDGenerator {
	

	@Inject IFileSystemAccess fsa

	@Inject extension CommonTemplateExtensions
	@Inject extension SchemaNamespaceExtensions schemaNamespaceExt
	@Inject extension SchemaTypeExtensions schemaTypeExt
	@Inject extension ServiceNamespaceURIProvider
	@Inject extension ServiceTemplateExtensions
	@Inject extension VersionQualifierExtensions versionQualifier
	@Inject extension HeaderFinder
	@Inject extension NamespaceImportQueries
	@Inject extension NamespaceQuery
	@Inject extension ILifecycleStateResolver
	@Inject extension ModelExtensions
	
	@Inject IEObjectDocumentationProvider docProvider
	@Inject ProfileNamespaceURIProvider profileNamespaceURIProvider

	
	def toEventsInclSubNamespaces (String namespace, List<SubNamespace> namespaces, LifecycleState minState, Profile profile, String registryBaseUrl) {
		for (ns : namespaces.filter (e|e.name.startsWith (namespace))) {
			ns.toEvents (minState, profile, registryBaseUrl);
		}
	}
	
	def toEvents (SubNamespace ns, LifecycleState minState, Profile enforcedProfile, String registryBaseUrl) {
		val profile = ns.getApplicableProfile(enforcedProfile)
		ns.services.forEach (s|s.toEvents (ns, minState, profile, registryBaseUrl));
	}
	
	def dispatch Void toEvents (Service svc, SubNamespace subDom, LifecycleState minState, Profile profile, String registryBaseUrl) {
	}
	
	def dispatch toEvents (Service svc, DomainNamespace subDom, LifecycleState minState, Profile profile, String registryBaseUrl) {
		val Set<VersionedTechnicalNamespace> headerImports = svc.collectTechnicalVersionedNamespaceImports (profile)
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema targetNamespace="«svc.toTargetNamespace()»"
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:jxb="http://java.sun.com/xml/ns/jaxb"
			«FOR imp : svc.allImportedVersionedNS(svc.version.toMajorVersionNumber(), minState)»
				xmlns:«imp.versionedNamespacePrefix»="«imp.versionedNamespaceURI»"
			«ENDFOR»
			«IF !headerImports.empty»
				«FOR headerImp : headerImports»
					xmlns:«profileNamespaceURIProvider.getVersionedNamespacePrefix(headerImp)»="«profileNamespaceURIProvider.getVersionedNamespaceURI(headerImp)»"
				«ENDFOR»
			«ENDIF»
			elementFormDefault="qualified"
			attributeFormDefault="unqualified"
			>
			
			«FOR imp : svc.allImportedVersionedNS(svc.version.toMajorVersionNumber(), minState)»
				<xsd:import schemaLocation="«imp.toSchemaAssetUrl (registryBaseUrl)».xsd"
					namespace="«imp.versionedNamespaceURI»"/>
			«ENDFOR»
			«IF !headerImports.empty»
				«FOR headerImp : headerImports»
					<xsd:import schemaLocation="«headerImp.toSchemaAssetUrl (registryBaseUrl)».xsd"
						namespace="«profileNamespaceURIProvider.getVersionedNamespaceURI(headerImp)»"/>
				«ENDFOR»
			«ENDIF»
			
			<xsd:annotation>
		   		<xsd:documentation>
					<![CDATA[Version «svc.version.toVersionNumber()»
					Lifecycle state: «svc.lifecycleState.toStateName»
					
					«docProvider.getDocumentation (svc)»]]>
			   	</xsd:documentation>
		   	</xsd:annotation>
			
			«svc.toEventMessages (minState, profile)»
		</xsd:schema>
		'''
	
		val xsdFileName = svc.toFileNameFragment() + "Events.xsd";
		fsa.generateFile (xsdFileName, content);
	}
	
	def dispatch toEvents (Service svc, InternalNamespace subDom, LifecycleState minState, Profile profile, String registryBaseUrl) {
		val Set<VersionedTechnicalNamespace> headerImports = svc.collectTechnicalVersionedNamespaceImports (profile)
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema targetNamespace="«svc.toTargetNamespace()»"
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			«FOR imp : svc.allImportedVersionedNS(svc.version.toMajorVersionNumber(), minState)»
				xmlns:«imp.versionedNamespacePrefix»="«imp.versionedNamespaceURI»"
			«ENDFOR»
			«IF !headerImports.empty»
				«FOR headerImp : headerImports»
					xmlns:«profileNamespaceURIProvider.getVersionedNamespacePrefix(headerImp)»="«profileNamespaceURIProvider.getVersionedNamespaceURI(headerImp)»"
				«ENDFOR»
			«ENDIF»
			elementFormDefault="qualified"
			attributeFormDefault="unqualified"
			>
			
			«FOR imp : svc.allImportedVersionedNS(svc.version.toMajorVersionNumber(), minState)»
				<xsd:import schemaLocation="«imp.toSchemaAssetUrl (registryBaseUrl)».xsd"
					namespace="«imp.versionedNamespaceURI»"/>
			«ENDFOR»
			«IF !headerImports.empty»
				«FOR headerImp : headerImports»
					<xsd:import schemaLocation="«headerImp.toSchemaAssetUrl (registryBaseUrl)».xsd"
						namespace="«profileNamespaceURIProvider.getVersionedNamespaceURI(headerImp)»"/>
				«ENDFOR»
			«ENDIF»
			
			<xsd:annotation>
		    	<xsd:documentation>
					<![CDATA[Version «svc.version.toVersionNumber()»
					Lifecycle state: «svc.lifecycleState.toStateName»
					
					«docProvider.getDocumentation (svc)»]]>
		    	</xsd:documentation>
		    </xsd:annotation>
			
			«svc.toEventMessages(minState, profile)»
		</xsd:schema>
		'''
		val xsdFileName = subDom.toFileNameFragment() + "-" + svc.name + "-" + versionQualifier.toVersionPostfix(svc.version) + "Events.xsd";
		fsa.generateFile (xsdFileName, content);
	}
	
	
	def toEventMessages(Service svc, LifecycleState minState, Profile profile) '''
		«svc.operations.map (o|o.toOperationWrapperTypes (profile)).join»
		«svc.operations.map (o|o.^throws).flatten.map (t|t.exception.name).toSet().map (o|o.toOperationFaultWrapperTypes(svc.operations.map (op|op.^throws).flatten.toList())).join»
	'''
	
	
	def toOperationWrapperTypes (Operation op, Profile profile) '''
		<xsd:element name="«op.name.toFirstUpper()»">
			<xsd:complexType>
				<xsd:sequence>
					«IF op.findBestMatchingRequestHeader(profile) !== null»
						«op.findBestMatchingRequestHeader (profile).toParameter()»
					«ENDIF»
					«op.parameters.map (p|p.toParameter ()).join»
				</xsd:sequence>
			</xsd:complexType>
		</xsd:element>
		<xsd:element name="«op.name.toFirstUpper()»Response">
			<xsd:complexType>
				<xsd:sequence>
					«IF op.findBestMatchingResponseHeader(profile) !== null»
						«op.findBestMatchingResponseHeader (profile).toParameter ()»
					«ENDIF»
					«op.^return?.map (r|r.toParameter ()).join»
				</xsd:sequence>
			</xsd:complexType>
		</xsd:element>
	'''
	
	def toOperationFaultWrapperTypes(String faultName, List<ExceptionRef> exceptions) { 
		val exceptionRef = exceptions.findFirst(e|e.exception.name == faultName);
		if (exceptionRef !== null) {
			'''
	    	<xsd:element name="«exceptionRef?.exception.name»" type="«exceptionRef?.toExceptionNameRef()»"/>
			'''
		}
	}
	
	def dispatch String toParameter (Parameter param) '''
		<xsd:element param.name="«param.name»" type="«param.type.toTypeNameRef ()»" «IF param.optional»minOccurs="0" «ENDIF»«IF param.type.isMany()»maxOccurs="unbounded"«ENDIF»></xsd:element>
	'''
	
	def dispatch String toParameter (Property prop) '''
		<xsd:element name="«prop.name»" type="«prop.type.toTypeNameRef ()»" «IF prop.optional»minOccurs="0" «ENDIF»«IF prop.type.isMany()»maxOccurs="unbounded"«ENDIF»></xsd:element>
	'''
	
	def dispatch String toParameter (MessageHeader header) '''
		«header.parameters.map (p|p.toParameter).join»
	'''
		
}