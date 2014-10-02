package org.xkonnex.repo.generator.bindingdsl.templates.vendor.ibm

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SCA
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.generator.bindingdsl.templates.naming.DefaultEndpointQualifierNameProvider

class SCAExportExtension {
	
	@Inject extension org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
	@Inject extension NamespaceQuery
	@Inject extension DefaultEndpointQualifierNameProvider
	
	def dispatch String getExportName (Service s, BindingProtocol prot) { 
		s.findOrgNamespace().toPrefix() + "_" + s.findSubdomain().name.replaceAll("\\.", "_") + "_" + 
			s.name + s.getServiceVisibilityName() + "_" + s.version.toVersionPostfix();
	}
	
	def dispatch String getExportName (Service s, SOAP prot) { 
		s.findOrgNamespace().toPrefix() + "_" + s.findSubdomain().name.replaceAll("\\.", "_") + "_" + 
		s.name + "SOAP" + s.getServiceVisibilityName() + "_" + s.version.toVersionPostfix();
	}
	
	def dispatch String getExportName (Service s, SCA prot) { 
		if (prot.promote != null) {
			prot.promote;
		} else {
			(s.findOrgNamespace().toPrefix() + "_" + s.findSubdomain().name.replaceAll("\\.", "_") + "_" + 
			s.name + "SCA" + s.getServiceVisibilityName() + "_" + s.version.toVersionPostfix());
		}
	}
	
	def dispatch String getExportDisplayName (Service s, BindingProtocol prot) {
		s.findOrgNamespace().toPrefix() + "." + s.findSubdomain().name.replaceAll("\\.", ".") + "." + 
			s.name + s.getServiceVisibilityName() + "." + s.version.toVersionPostfix();
	}
	
	def dispatch String getExportDisplayName (Service s, SOAP prot) {
		s.findOrgNamespace().toPrefix() + "." + s.findSubdomain().name.replaceAll("\\.", ".") + "." + 
			s.name + "SOAP" + s.getServiceVisibilityName() + "." + s.version.toVersionPostfix();
	}
	
	def dispatch String getExportDisplayName (Service s, SCA prot) {
		if (prot.promote != null) {
			prot.promote;
		} else {
			(s.findOrgNamespace().toPrefix() + "." + s.findSubdomain().name.replaceAll("\\.", ".") + "." + 
			s.name + "SCA" + s.getServiceVisibilityName() + "." + s.version.toVersionPostfix());
		}
	}
	
		
	def String getExportFileName (Service s, BindingProtocol prot) {
		s.getExportName (prot) + ".export";
	}
	
		
}