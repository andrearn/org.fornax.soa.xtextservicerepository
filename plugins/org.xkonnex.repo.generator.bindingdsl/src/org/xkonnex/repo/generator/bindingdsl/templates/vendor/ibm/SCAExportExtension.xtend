package org.xkonnex.repo.generator.bindingdsl.templates.vendor.ibm

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.SCA
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceNameFragmentProvider
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.generator.bindingdsl.templates.naming.DefaultEndpointQualifierNameProvider
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.IProtocol

class SCAExportExtension {
	
	@Inject extension SchemaNamespaceExtensions
	@Inject extension DefaultEndpointQualifierNameProvider
	@Inject extension ServiceNamespaceNameFragmentProvider
	@Inject extension IEObjectLookup
	
	def dispatch String getExportName (Service s, BindingProtocol prot) { 
		val namespace = s.getOwnerByType(Namespace)
		namespace.organizationShortnameFragment + "_" + namespace.subNamespaceFragment.replaceAll("\\.", "_") + "_" + 
			s.name + s.getServiceVisibilityName() + "_" + s.version.toVersionPostfix();
	}
	
	def dispatch String getExportName (Service s, SOAP prot) { 
		val namespace = s.getOwnerByType(Namespace)
		namespace.organizationShortnameFragment + "_" + namespace.subNamespaceFragment.replaceAll("\\.", "_") + "_" + 
		s.name + "SOAP" + s.getServiceVisibilityName() + "_" + s.version.toVersionPostfix();
	}
	
	def dispatch String getExportName (Service s, SCA prot) { 
		if (prot.promote != null) {
			prot.promote;
		} else {
			val namespace = s.getOwnerByType(Namespace)
			(namespace.organizationShortnameFragment + "_" + namespace.subNamespaceFragment.replaceAll("\\.", "_") + "_" + 
			s.name + "SCA" + s.getServiceVisibilityName() + "_" + s.version.toVersionPostfix());
		}
	}
	
	def dispatch String getExportDisplayName (Service s, BindingProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		namespace.organizationShortnameFragment + "." + namespace.subNamespaceFragment + "." + 
			s.name + s.getServiceVisibilityName() + "." + s.version.toVersionPostfix();
	}
	
	def dispatch String getExportDisplayName (Service s, SOAP prot) {
		val namespace = s.getOwnerByType(Namespace)
		namespace.organizationShortnameFragment + "." + namespace.subNamespaceFragment + "." + 
			s.name + "SOAP" + s.getServiceVisibilityName() + "." + s.version.toVersionPostfix();
	}
	
	def dispatch String getExportDisplayName (Service s, SCA prot) {
		if (prot.promote != null) {
			prot.promote;
		} else {
			val namespace = s.getOwnerByType(Namespace)
			(namespace.organizationShortnameFragment + "." + namespace.subNamespaceFragment + "." + 
			s.name + "SCA" + s.getServiceVisibilityName() + "." + s.version.toVersionPostfix());
		}
	}
	
		
	def String getExportFileName (Service s, IProtocol prot) {
		s.getExportName (prot) + ".export";
	}
	
	def String getExportFileName (Service s, BindingProtocol prot) {
		s.getExportName (prot) + ".export";
	}
	
		
}