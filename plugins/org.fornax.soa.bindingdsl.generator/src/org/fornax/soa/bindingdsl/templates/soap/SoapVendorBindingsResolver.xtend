package org.fornax.soa.bindingdsl.templates.soap

import com.google.inject.Inject
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.bindingdsl.templates.BindingExtensions
import org.fornax.soa.environmentDsl.AppServer
import org.fornax.soa.environmentDsl.ESB
import org.fornax.soa.environmentDsl.ProcessServer
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.moduledsl.moduleDsl.AssemblyType
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.serviceDsl.OrganizationNamespace
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.templates.xsd.SchemaNamespaceExtensions

class SoapVendorBindingsResolver {
	
	@Inject extension VersionQualifierExtensions
	@Inject extension BindingExtensions
	@Inject extension org.fornax.soa.servicedsl.templates.xsd.SchemaNamespaceExtensions
	
	def dispatch String getEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {}
	
	def dispatch String getEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, ESB server) {
		if (server.serverType != null) {
			switch (server?.serverType.toLowerCase()) {
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
	
	def dispatch String getEndpoint (String ctxRoot, OrganizationNamespace orgNs, SubNamespace subNs, Service s, AppServer server) {
		if (server.serverType != null) {
			switch (server.serverType.toLowerCase()) {
			case "tomcat": 			tomcatEndpoint (ctxRoot, orgNs, subNs, s, server)
			case "websphere":		websphereEndpoint (ctxRoot, orgNs, subNs, s, server)
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
	
	def dispatch String getEndpoint (Module mod, OrganizationNamespace orgNs, SubNamespace subNs, Service s, Server server) {}
	
	def dispatch String getEndpoint (Module mod, OrganizationNamespace orgNs, SubNamespace subNs, Service s, AppServer server) {
		if (server.serverType != null) {
			switch (server.serverType.toLowerCase()) {
			case "tomcat": 			tomcatEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "websphere":		websphereEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "webmethods":		webmethodsEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "oraclesb":		oraclesbEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "weblogic":		weblogicEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "aqualogic":		aqualogicEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "sappi":			sappiEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "sapce":			sapceEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "sapnetweaver":	sapnetweaverEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "jboss":			jbossEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "jbossesb":		jbossesbEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "mule":			muleEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "fuseesb":			fuseesbEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			default: 				defaultPatternEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			}
		} else {
			defaultPatternEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server);
		}
	}
		
	def dispatch String getEndpoint (Module mod, OrganizationNamespace orgNs, SubNamespace subNs, Service s, ESB server) {
		if (server.serverType != null) {
			switch (server.serverType.toLowerCase()) {
			case "tomcat": 			tomcatEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "websphere":		websphereSCAEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "webmethods":		webmethodsEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "oraclesb":		oraclesbEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "weblogic":		weblogicEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "aqualogic":		aqualogicEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "sappi":			sappiEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "sapce":			sapceEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "sapnetweaver":	sapnetweaverEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "jboss":			jbossEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "jbossesb":		jbossesbEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "mule":			muleEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "fuseesb":			fuseesbEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			default: 				defaultPatternEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			}
		} else {
			defaultPatternEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server);
		}
	}
	
	def dispatch String getEndpoint (Module mod, OrganizationNamespace orgNs, SubNamespace subNs, Service s, ProcessServer server) {
		if (server.serverType != null) {
			switch (server.serverType.toLowerCase()) {
			case "tomcat": 			tomcatEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "websphere":		websphereSCAEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "webmethods":		webmethodsEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "oraclesb":		oraclesbEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "weblogic":		weblogicEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "aqualogic":		aqualogicEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "sappi":			sappiEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "sapce":			sapceEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "sapnetweaver":	sapnetweaverEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "jboss":			jbossEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "jbossesb":		jbossesbEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "mule":			muleEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			case "fuseesb":			fuseesbEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			default: 				defaultPatternEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server)
			}
		} else {
			defaultPatternEndpoint (mod.getCtxRootByAssemblyType (server.serverType), orgNs, subNs, s, server);
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
	
		
	def String getCtxRootByAssemblyType (Module mod, String serverType) {
		switch (mod.assemblyType) {
			case AssemblyType::SCA_EAR: mod.name + "Web/sca/"
			case AssemblyType::WEB_METHODS: ""
			default: mod.name + "/"
		}
	}
}