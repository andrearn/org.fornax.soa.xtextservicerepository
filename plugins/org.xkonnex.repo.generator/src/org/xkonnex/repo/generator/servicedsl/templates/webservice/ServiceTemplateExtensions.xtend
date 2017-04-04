package org.xkonnex.repo.generator.servicedsl.templates.webservice

import com.google.inject.Inject
import java.util.Set
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.profiledsl.query.namespace.TechnicalNamespaceImportQueries
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceURIProvider
import org.xkonnex.repo.dsl.servicedsl.service.query.HeaderFinder
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaTemplateExtensions
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource

class ServiceTemplateExtensions {

	@Inject VersionQualifierExtensions versionQualifier
	@Inject TechnicalNamespaceImportQueries techNsImportQueries
	@Inject extension SchemaNamespaceExtensions
	@Inject extension SchemaTemplateExtensions
	@Inject extension HeaderFinder
	@Inject extension ServiceNamespaceURIProvider
	@Inject extension IEObjectLookup
	
	def dispatch String toTargetNamespace (Object svc) {
		"";
	}
	def dispatch String toTargetNamespace (Service svc) { 
		svc.versionedServiceNamespaceURI
	}
	
	def dispatch String toWrapperTargetNamespace (Object svc) {""}
	
	def dispatch String toWrapperTargetNamespace (Service svc) {
		val ns = svc.getOwnerByType(SubNamespace)
		var tns = ns.namespaceURI 
		if (!tns.endsWith("/")) 
			tns = tns + "/" 
		tns = tns + svc.name + "Wrapped/" + svc.version.toVersionPostfix() + "/wrapper/"
		tns
	}
	
	def String toWrapperServiceTargetNamespace (Service svc) {
		val ns = svc.getOwnerByType(SubNamespace)
		var tns = ns.namespaceURI 
		if (!tns.endsWith("/")) 
			tns = tns + "/" 
		tns = tns + svc.name + "Wrapped/" + svc.version.toVersionPostfix() + "/"
		tns
	}
		
	def String toVersionPostfix (Service svc) {
		if (svc.version != null) {
			versionQualifier.toVersionPostfix(svc.version)
		} else {
			versionQualifier.toDefaultVersionPostfix()
		}
	}
	
	def String toServiceName (Service svc) {
		svc.name;
	}
	def String toBindingName (Service svc) {
		svc.toServiceName() + "SOAP";
	}
	
	def String getWsdlFilename(Service s) {
		s.eContainer.toFileNameFragment() + "-v" + versionQualifier.toMajorVersionNumber(s.version) + ".wsdl";
	}
	
	
	def boolean operationsUseExtensibleParameters (Profile p) {
		if (p.designRules != null 
			&& p.designRules.serviceDefPolicy != null 
			&& p.designRules.serviceDefPolicy.operationRules != null
			&& p.designRules.serviceDefPolicy.operationRules.versionEvolution != null) {
			return p.designRules.serviceDefPolicy.operationRules.versionEvolution.extensibleParameters;
		} else {
			return false
		}
		
	}
	def boolean operationsUseExtensibleXMLAttributes (Profile p) {
		if (p.designRules != null 
			&& p.designRules.serviceDefPolicy != null 
			&& p.designRules.serviceDefPolicy.operationRules != null
			&& p.designRules.serviceDefPolicy.operationRules.versionEvolution != null) {
			return p.designRules.serviceDefPolicy.operationRules.versionEvolution.extensibleXMLAttributes;
		} else {
			return false
		}
	}		
	def String getOperationsExtensibleParametersClause (Profile p) {
		if (p.operationsUseExtensibleParameters) {
			if (p.designRules.typeDefPolicy.versionEvolution.extensibleXMLClause != null) {
				return p.designRules.serviceDefPolicy.operationRules.versionEvolution.extensibleXMLClause;
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
	def String getOperationsExtensibleXMLAttributesClause (Profile p) {
		if (p.operationsUseExtensibleXMLAttributes) {
			if (p.designRules.serviceDefPolicy.operationRules.versionEvolution.extensibleXMLAttributeClause != null) {
				return p.designRules.serviceDefPolicy.operationRules.versionEvolution.extensibleXMLAttributeClause;
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
	
	def String toOperationWrapperRequestType (Operation op) {
		op.name.toFirstUpper();
	}

	def String toOperationWrapperResponseType (Operation op) {
		op.name.toFirstUpper() + "Response";
	}
	
	def String getWrappedWSDLFileName(Service s) {
		s.toFileNameFragment() + "Wrapped.wsdl";
	}
	def String getWrappedFileNameFragment(Service s) {
		s.toFileNameFragment() + "-Wrapped";
	}
	def String getRegisteredOperationWrapperUrl (Service s, String registryUrl) { 
		if (registryUrl != null && useRegistryBasedFilePaths()) {
			registryUrl + "/" + s.toOperationWrapperXSDFileName();
		} else {
			s.toOperationWrapperXSDFileName();
		}
	}
	
	def collectTechnicalVersionedNamespaceImports (Service service, Profile profile) {
		val Set<VersionedTechnicalNamespace> headerImports = newHashSet
		if (service.findBestMatchingRequestHeader(profile) != null) {
			for (headerImp : techNsImportQueries.allImportedVersionedNS(service.findBestMatchingRequestHeader (profile), versionQualifier.toMajorVersionNumber(service.version))) {
				headerImports.add (headerImp)
			}
		}
		if (service.findBestMatchingResponseHeader(profile) != null) {
			for (headerImp : techNsImportQueries.allImportedVersionedNS(service.findBestMatchingResponseHeader (profile), versionQualifier.toMajorVersionNumber(service.version))) {
				headerImports.add (headerImp)
			}
		}
		return headerImports
	}
	
	def collectTechnicalVersionedNamespaceImports (Resource service, Profile profile) {
		val Set<VersionedTechnicalNamespace> headerImports = newHashSet
		if (service.findBestMatchingRequestHeader(profile) != null) {
			for (headerImp : techNsImportQueries.allImportedVersionedNS(service.findBestMatchingRequestHeader (profile), versionQualifier.toMajorVersionNumber(service.version))) {
				headerImports.add (headerImp)
			}
		}
		if (service.findBestMatchingResponseHeader(profile) != null) {
			for (headerImp : techNsImportQueries.allImportedVersionedNS(service.findBestMatchingResponseHeader (profile), versionQualifier.toMajorVersionNumber(service.version))) {
				headerImports.add (headerImp)
			}
		}
		return headerImports
	}
}