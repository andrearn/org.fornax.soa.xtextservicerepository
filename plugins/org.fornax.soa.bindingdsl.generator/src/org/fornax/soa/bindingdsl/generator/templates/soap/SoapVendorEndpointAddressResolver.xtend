package org.fornax.soa.bindingdsl.generator.templates.soap

import com.google.inject.Inject
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.environmentDsl.AppServer
import org.fornax.soa.environmentDsl.Broker
import org.fornax.soa.environmentDsl.Database
import org.fornax.soa.environmentDsl.ESB
import org.fornax.soa.environmentDsl.ProcessServer
import org.fornax.soa.environmentDsl.Registry
import org.fornax.soa.environmentDsl.SAP
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.environmentDsl.WebServer
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.serviceDsl.OrganizationNamespace
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.binding.ContextRootProvider
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.bindingdsl.generator.templates.naming.DefaultEndpointQualifierNameProvider
import org.fornax.soa.bindingdsl.generator.templates.naming.IEndpointQualifierNameProvider

class SoapVendorEndpointAddressResolver {
	
	@Inject extension IEndpointQualifierNameProvider
	@Inject extension org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
	@Inject ContextRootProvider ctxRootProvider
	@Inject SoapBindingResolver soapBindRes
	
	
	def dispatch String toEndpointAddressPath (Module mod, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		val serverType = server.toServerTypeName ();
		val serverVersion = server.toServerTypeVersion ();
		val ctxRoot = ctxRootProvider.getContextRoot(mod, serverType, serverVersion, prot);
		toEndpointAddressPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
	}
	
	def dispatch String toEndpointAddressPath (ServiceBinding bind, BindingProtocol prot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {
		val serverType = server.toServerTypeName ();
		val serverVersion = server.toServerTypeVersion ();
		val ctxRoot = ctxRootProvider.getContextRoot(bind);
		toEndpointAddressPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
	}
	
	
	def dispatch String toEndpointAddressPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		val serverType = server.toServerTypeName ();
		val serverVersion = server.toServerTypeVersion ();
		if (serverType != null) {
			switch (serverType.toLowerCase()) {
			case "tomcat": 			tomcatEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
			case "websphere":		websphereSCAEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
			case "webmethods":		webmethodsEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
			case "oraclesb":		oraclesbEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
			case "weblogic":		weblogicEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
			case "aqualogic":		aqualogicEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
			case "sappi":			sappiEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
			case "sapce":			sapceEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
			case "sapnetweaver":	sapNetweaverEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
			case "jboss":			jbossEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
			case "jbossesb":		jbossesbEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
			case "mule":			muleEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
			case "fuseesb":			fuseesbEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
			default: 				defaultPatternEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot)
			}
		} else {
			defaultPatternEndpointPath (ctxRoot, orgNs, subNs, s, server, bind, prot);
		}
	}
	def String toServerTypeName (Server s) {
		var serverTypeName = "undefined"
		switch (s) {
			AppServer: 		serverTypeName = (s as AppServer).serverType
			ESB:			serverTypeName = (s as ESB).serverType
			ProcessServer:	serverTypeName = (s as ProcessServer).serverType
			Broker:			serverTypeName = (s as Broker).serverType
			WebServer:		serverTypeName = (s as WebServer).serverType
			SAP:			serverTypeName = "saperp"
			Database:		serverTypeName = (s as Database).serverType
			Registry:		serverTypeName = (s as Registry).serverType
			default: return "undefined"
		}
		if (serverTypeName != null)
			return serverTypeName
		else
			return "undefined"
	}
	
	def String toServerTypeVersion (Server s) {
		var serverTypeVersion = "undefined"
		switch (s) {
			AppServer: 		serverTypeVersion = (s as AppServer).serverVersion
			ESB:			serverTypeVersion = (s as ESB).serverVersion
			ProcessServer:	serverTypeVersion = (s as ProcessServer).serverVersion
			Broker:			serverTypeVersion = (s as Broker).serverVersion
			WebServer:		serverTypeVersion = (s as WebServer).serverVersion
			SAP:			return "undefined"
			Database:		serverTypeVersion = (s as Database).serverVersion
			Registry:		serverTypeVersion = (s as Registry).serverVersion
			default: return "undefined"
		}
		if (serverTypeVersion != null)
			return serverTypeVersion
		else 
			return "undefined"
	}
		
	def String defaultPatternEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String tomcatEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String websphereEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String websphereSCAEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		ctxRoot
		+ orgNs.toPrefix() + "_" 
		+ subNs.name.replaceAll("\\.","_") +"_" + s.name + "SOAP" + bind.getEndpointQualifierName (s, prot) + "_" + s.version.toVersionPostfix();
	}
	
	def String webmethodsEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		val servicePath = ctxRoot
		+ orgNs.name + "." 
		+ subNs.name + "." + s.name + "." + s.version.toVersionPostfix() + ":" + s.name;
		var scopedPortName = ""
		if (prot instanceof SOAP) {
			scopedPortName = soapBindRes.toScopedPortName (s, bind, prot as SOAP, bind.getEndpointQualifierName (s, prot))
		}
		if (server instanceof ESB) {
			val esb = (server as ESB)
			val esbVersion = esb.serverVersion
			if (esbVersion != null) {
				val esbVersionDigits = esbVersion.split("\\.")
				if (esbVersionDigits.get(0) >= "8" && scopedPortName != "") {
					return servicePath + "/" + scopedPortName
				}
			}
		}
		return servicePath
	}
	
	def String oraclesbEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String weblogicEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String aqualogicEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String sappiEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String sapceEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String sapNetweaverEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String jbossEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String jbossesbEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String muleEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String fuseesbEndpointPath (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server, Binding bind, BindingProtocol prot) {
		ctxRoot
		+ orgNs.name.replaceAll("\\.","/") + "/" 
		+ subNs.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
}