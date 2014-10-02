package org.xkonnex.repo.generator.servicedsl.templates.webservice

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfile
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaTemplateExtensions
import java.util.Set
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.query.namespace.TechnicalNamespaceImportQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.HeaderFinder

class ServiceTemplateExtensions {

	@Inject VersionQualifierExtensions versionQualifier
	@Inject TechnicalNamespaceImportQueries techNsImportQueries
	@Inject extension org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
	@Inject extension SchemaTemplateExtensions
	@Inject extension HeaderFinder
	
	def dispatch String toTargetNamespace (Object svc) {
		"";
	}
	def dispatch String toTargetNamespace (Service svc) { 
		var tns = svc.eContainer.toUnversionedNamespace() + "/" + svc.name + "/" + svc.toVersionPostfix() + "/";
		tns;
	}
	
	def dispatch String toWrapperTargetNamespace (Object svc) {"";}
	def dispatch String toWrapperTargetNamespace (Service svc) {
		svc.eContainer.toUnversionedNamespace() + 
		"/" + svc.name + "Wrapped/" + svc.toVersionPostfix() + "/wrapper/";
	}
	
	def String toWrapperServiceTargetNamespace (Service svc) {
		svc.eContainer.toUnversionedNamespace() + 
		"/" + svc.name + "Wrapped/" + svc.toVersionPostfix() + "/";
	}
		
	def String toVersionPostfix (Service svc) {
		if (svc.version != null) {
			versionQualifier.toVersionPostfix(svc.version);
		} else {
			versionQualifier.toDefaultVersionPostfix();
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
	
	
	def boolean operationsUseExtendableParameters (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfile p) {
		if (p.designRules != null 
			&& p.designRules.serviceDefPolicy != null 
			&& p.designRules.serviceDefPolicy.operationRules != null
			&& p.designRules.serviceDefPolicy.operationRules.versionEvolution != null) {
			return p.designRules.serviceDefPolicy.operationRules.versionEvolution.extendibleParameters;
		} else {
			return false
		}
		
	}
	def boolean operationsUseExtendableXMLAttributes (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfile p) {
		if (p.designRules != null 
			&& p.designRules.serviceDefPolicy != null 
			&& p.designRules.serviceDefPolicy.operationRules != null
			&& p.designRules.serviceDefPolicy.operationRules.versionEvolution != null) {
			return p.designRules.serviceDefPolicy.operationRules.versionEvolution.extendibleXMLAttributes;
		} else {
			return false
		}
	}		
	def String getOperationsExtendibleParametersClause (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfile p) {
		if (p.operationsUseExtendableParameters) {
			if (p.designRules.typeDefPolicy.versionEvolution.extendibleXMLClause != null) {
				return p.designRules.serviceDefPolicy.operationRules.versionEvolution.extendibleXMLClause;
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
	def String getOperationsExtendibleXMLAttributesClause (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfile p) {
		if (p.operationsUseExtendableXMLAttributes) {
			if (p.designRules.serviceDefPolicy.operationRules.versionEvolution.extendibleXMLAttributeClause != null) {
				return p.designRules.serviceDefPolicy.operationRules.versionEvolution.extendibleXMLAttributeClause;
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
	
	def collectTechnicalVersionedNamespaceImports (Service service, SOAProfile profile) {
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