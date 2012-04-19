package org.fornax.soa.bindingdsl.generator.templates.soap

import com.google.inject.Inject
import org.fornax.soa.basedsl.generator.version.VersionQualifierExtensions
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.environmentDsl.AppServer
import org.fornax.soa.environmentDsl.ESB
import org.fornax.soa.environmentDsl.ProcessServer
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.moduledsl.moduleDsl.AssemblyType
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.serviceDsl.OrganizationNamespace
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.environmentDsl.Broker
import org.fornax.soa.environmentDsl.WebServer
import org.fornax.soa.environmentDsl.SAP
import org.fornax.soa.environmentDsl.Database
import org.fornax.soa.environmentDsl.Registry
import org.fornax.soa.environmentDsl.UDDIRegistry
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.bindingDsl.BindingProtocol

class SoapVendorBindingsResolver {
	
	@Inject extension VersionQualifierExtensions
	@Inject extension BindingExtensions
	@Inject extension org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
	@Inject ContextRootProvider ctxRootProvider
	@Inject SoapBindingResolver soapBindRes
	
	
	def dispatch String getEndpoint (Module mod, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		val serverType = server.toServerTypeName ();
		val ctxRoot = ctxRootProvider.getContextRoot(mod, serverType);
		getEndpoint (ctxRoot, orgNs, subNs, s, server)
	}
	
	def dispatch String getEndpoint (DomainBinding bind, BindingProtocol prot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		val serverType = server.toServerTypeName ();
		val ctxRoot = soapBindRes.getContextRoot(bind, s);
		getEndpoint (ctxRoot, orgNs, subNs, s, server)
	}
	
	def dispatch String getEndpoint (ServiceBinding bind, BindingProtocol prot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		val serverType = server.toServerTypeName ();
		val ctxRoot = soapBindRes.getContextRoot(bind);
		getEndpoint (ctxRoot, orgNs, subNs, s, server)
	}
	
	
	def dispatch String getPrivateEndpoint (DomainBinding bind, BindingProtocol prot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		val serverType = server.toServerTypeName ();
		val ctxRoot = soapBindRes.getProviderContextRoot(bind, s);
		getEndpoint (ctxRoot, orgNs, subNs, s, server)
	}
	
	def dispatch String getPrivateEndpoint (ServiceBinding bind, BindingProtocol prot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		val serverType = server.toServerTypeName ();
		val ctxRoot = soapBindRes.getProviderContextRoot(bind);
		getEndpoint (ctxRoot, orgNs, subNs, s, server)
	}
	
	
	def dispatch String getEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		val serverType = server.toServerTypeName ();
		if (serverType != null) {
			switch (serverType.toLowerCase()) {
			case "tomcat": 			tomcatEndpoint (ctxRoot, orgNs, subNs, s, server)
			case "websphere":		websphereSCAEndpoint (ctxRoot, orgNs, subNs, s, server)
			case "webmethods":		webmethodsEndpoint (ctxRoot, orgNs, subNs, s, server)
			case "oraclesb":		oraclesbEndpoint (ctxRoot, orgNs, subNs, s, server)
			case "weblogic":		weblogicEndpoint (ctxRoot, orgNs, subNs, s, server)
			case "aqualogic":		aqualogicEndpoint (ctxRoot, orgNs, subNs, s, server)
			case "sappi":			sappiEndpoint (ctxRoot, orgNs, subNs, s, server)
			case "sapce":			sapceEndpoint (ctxRoot, orgNs, subNs, s, server)
			case "sapnetweaver":	sapnetweaverEndpoint (ctxRoot, orgNs, subNs, s, server)
			case "jboss":			jbossEndpoint (ctxRoot, orgNs, subNs, s, server)
			case "jbossesb":		jbossesbEndpoint (ctxRoot, orgNs, subNs, s, server)
			case "mule":			muleEndpoint (ctxRoot, orgNs, subNs, s, server)
			case "fuseesb":			fuseesbEndpoint (ctxRoot, orgNs, subNs, s, server)
			default: 				defaultPatternEndpoint (ctxRoot, orgNs, subNs, s, server)
			}
		} else {
			defaultPatternEndpoint (ctxRoot, orgNs, subNs, s, server);
		}
	}
	
	def String toServerTypeName (Server s) {
		switch (s) {
			AppServer: 		(s as AppServer).serverType
			ESB:			(s as ESB).serverType
			ProcessServer:	(s as ProcessServer).serverType
			Broker:			(s as Broker).serverType
			WebServer:		(s as WebServer).serverType
			SAP:			"saperp"
			Database:		(s as Database).serverType
			Registry:		(s as Registry).serverType
			default: null
		}
	}
		
	def String defaultPatternEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String tomcatEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String websphereEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String websphereSCAEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.toPrefix() + "_" 
		+ subNs.name.replaceAll("\\.","_") +"_" + s.name + "SOAP" + s.getServiceVisibilityName() + "_" + s.version.toVersionPostfix();
	}
	
	def String webmethodsEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.name + "." 
		+ subNs.name + "." + s.name + "." + s.version.toVersionPostfix() + ":" + s.name;
	}
	
	def String oraclesbEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String weblogicEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String aqualogicEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String sappiEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String sapceEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String sapnetweaverEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String jbossEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String jbossesbEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String muleEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String fuseesbEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
}