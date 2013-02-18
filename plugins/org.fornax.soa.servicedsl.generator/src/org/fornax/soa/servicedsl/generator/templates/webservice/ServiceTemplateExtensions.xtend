package org.fornax.soa.servicedsl.generator.templates.webservice

import com.google.inject.Inject
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.Operation
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTemplateExtensions
import java.util.Set
import org.fornax.soa.profiledsl.versioning.VersionedTechnicalNamespace
import org.fornax.soa.profiledsl.query.namespace.TechnicalNamespaceImportQueries
import org.fornax.soa.service.query.HeaderFinder

class ServiceTemplateExtensions {

	@Inject VersionQualifierExtensions versionQualifier
	@Inject TechnicalNamespaceImportQueries techNsImportQueries
	@Inject extension org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
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
	
	
	def boolean operationsUseExtendableParameters (org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile p) {
		if (p.designRules != null 
			&& p.designRules.serviceDefPolicy != null 
			&& p.designRules.serviceDefPolicy.operationRules != null
			&& p.designRules.serviceDefPolicy.operationRules.versionEvolution != null) {
			return p.designRules.serviceDefPolicy.operationRules.versionEvolution.extendibleParameters;
		} else {
			return false
		}
		
	}
	def boolean operationsUseExtendableXMLAttributes (org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile p) {
		if (p.designRules != null 
			&& p.designRules.serviceDefPolicy != null 
			&& p.designRules.serviceDefPolicy.operationRules != null
			&& p.designRules.serviceDefPolicy.operationRules.versionEvolution != null) {
			return p.designRules.serviceDefPolicy.operationRules.versionEvolution.extendibleXMLAttributes;
		} else {
			return false
		}
	}		
	def String getOperationsExtendibleParametersClause (org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile p) {
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
	def String getOperationsExtendibleXMLAttributesClause (org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile p) {
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
		if (registryUrl != null && !forceRelativePaths()) {
			registryUrl + "/" + s.toOpWrapperXSDFileName();
		} else {
			s.toOpWrapperXSDFileName();
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