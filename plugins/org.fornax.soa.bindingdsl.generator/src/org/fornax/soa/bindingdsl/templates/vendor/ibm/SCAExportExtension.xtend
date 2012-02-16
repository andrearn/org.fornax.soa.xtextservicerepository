package org.fornax.soa.bindingdsl.templates.vendor.ibm

import com.google.inject.Inject
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.SCA
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingdsl.templates.BindingExtensions
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.servicedsl.query.namespace.NamespaceQuery
import org.fornax.soa.servicedsl.templates.xsd.SchemaNamespaceExtensions

class SCAExportExtension {
	
	@Inject extension VersionQualifierExtensions
	@Inject extension SchemaNamespaceExtensions
	@Inject extension NamespaceQuery
	@Inject extension BindingExtensions
	
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