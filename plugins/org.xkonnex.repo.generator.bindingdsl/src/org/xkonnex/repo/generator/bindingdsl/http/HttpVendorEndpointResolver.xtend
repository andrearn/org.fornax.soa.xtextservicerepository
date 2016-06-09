package org.xkonnex.repo.generator.bindingdsl.http

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.bindingdsl.binding.IContextRootProvider
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.HTTP
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.AppServer
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Broker
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Database
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ESB
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ProcessServer
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Registry
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SAP
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.WebServer
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceNameFragmentProvider
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.generator.bindingdsl.templates.naming.IEndpointQualifierNameProvider
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.dsl.bindingdsl.model.EffectiveBinding
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource

class HttpVendorEndpointResolver {
	
	@Inject extension IEObjectLookup
	@Inject extension IEndpointQualifierNameProvider
	@Inject extension SchemaNamespaceExtensions
	@Inject extension ServiceNamespaceNameFragmentProvider
	@Inject IContextRootProvider ctxRootProvider
	@Inject HttpBindingResolver httpBindRes
	
	
	def dispatch String toEndpointAddressPath (Module mod, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val serverType = server.toServerTypeName ();
		val serverVersion = server.toServerTypeVersion ();
		val ctxRoot = ctxRootProvider.getContextRoot(mod, serverType, serverVersion, prot);
		toEndpointAddressPath (ctxRoot, s, server, bind, prot)
	}	
	
	def dispatch String toEndpointAddressPath (EffectiveBinding bind, ExtensibleProtocol prot, Service s, Server server) {
		val ctxRoot = ctxRootProvider.getContextRoot(bind);
		toEndpointAddressPath (ctxRoot, s, server, bind, prot)
	}
	def dispatch String toEndpointAddressPath (Module mod, Resource s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val serverType = server.toServerTypeName ();
		val serverVersion = server.toServerTypeVersion ();
		val ctxRoot = ctxRootProvider.getContextRoot(mod, serverType, serverVersion, prot);
		toEndpointAddressPath (ctxRoot, s, server, bind, prot)
	}	
	
	def dispatch String toEndpointAddressPath (EffectiveBinding bind, ExtensibleProtocol prot, Resource s, Server server) {
		val ctxRoot = ctxRootProvider.getContextRoot(bind);
		toEndpointAddressPath (ctxRoot, s, server, bind, prot)
	}
	
	def dispatch String toEndpointAddressPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val serverType = server.toServerTypeName ();
		if (serverType != null) {
			switch (serverType.toLowerCase()) {
			case "tomcat": 			tomcatEndpointPath (ctxRoot, s, server, bind, prot)
			case "websphere":		websphereSCAEndpointPath (ctxRoot, s, server, bind, prot)
			case "webmethods":		webmethodsEndpointPath (ctxRoot, s, server, bind, prot)
			case "oraclesb":		oraclesbEndpointPath (ctxRoot, s, server, bind, prot)
			case "weblogic":		weblogicEndpointPath (ctxRoot, s, server, bind, prot)
			case "aqualogic":		aqualogicEndpointPath (ctxRoot, s, server, bind, prot)
			case "sappi":			sappiEndpointPath (ctxRoot, s, server, bind, prot)
			case "sapce":			sapceEndpointPath (ctxRoot, s, server, bind, prot)
			case "sapnetweaver":	sapNetweaverEndpointPath (ctxRoot, s, server, bind, prot)
			case "jboss":			jbossEndpointPath (ctxRoot, s, server, bind, prot)
			case "jbossesb":		jbossesbEndpointPath (ctxRoot, s, server, bind, prot)
			case "mule":			muleEndpointPath (ctxRoot, s, server, bind, prot)
			case "fuseesb":			fuseesbEndpointPath (ctxRoot, s, server, bind, prot)
			default: 				defaultPatternEndpointPath (ctxRoot, s, server, bind, prot)
			}
		} else {
			defaultPatternEndpointPath (ctxRoot, s, server, bind, prot);
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
		
	def String defaultPatternEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		ctxRoot	+ namespace.namespaceFQN.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String tomcatEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		ctxRoot	+ namespace.namespaceFQN.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String websphereEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		ctxRoot	+ namespace.namespaceFQN.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String websphereSCAEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(SubNamespace)
		ctxRoot
		+ namespace.organizationShortnameFragment + "_" 
		+ namespace.subNamespaceFragment.replaceAll("\\.","_") +"_" + s.name + "HTTP" + bind.getEndpointQualifierName (s, prot) + "_" + s.version.toVersionPostfix();
	}
	
	def String webmethodsEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		val servicePath = ctxRoot
		+ namespace.namespaceFQN + "." + s.name + "." + s.version.toVersionPostfix() + ":" + s.name;
		var scopedPortName = ""
		if (prot.type.identifier == HTTP.getClass().canonicalName) {
			scopedPortName = httpBindRes.toScopedPortName (s, bind, prot, bind.getEndpointQualifierName (s, prot))
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
	
	def String oraclesbEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		ctxRoot	+ namespace.namespaceFQN.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String weblogicEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		ctxRoot	+ namespace.namespaceFQN.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String aqualogicEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		ctxRoot	+ namespace.namespaceFQN.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String sappiEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		ctxRoot	+ namespace.namespaceFQN.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String sapceEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		ctxRoot	+ namespace.namespaceFQN.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String sapNetweaverEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		ctxRoot	+ namespace.namespaceFQN.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String jbossEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		ctxRoot	+ namespace.namespaceFQN.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String jbossesbEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		ctxRoot	+ namespace.namespaceFQN.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String muleEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		ctxRoot	+ namespace.namespaceFQN.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def String fuseesbEndpointPath (String ctxRoot, Service s, Server server, EffectiveBinding bind, ExtensibleProtocol prot) {
		val namespace = s.getOwnerByType(Namespace)
		ctxRoot	+ namespace.namespaceFQN.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
}