/*
 * generated by Xtext 2.9.1
 */
package org.xkonnex.repo.dsl.environmentdsl.formatting2

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.xkonnex.repo.dsl.basedsl.baseDsl.User
import org.xkonnex.repo.dsl.basedsl.formatting2.BaseDslFormatter
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvImport
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvModel
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Host
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server
import org.xkonnex.repo.dsl.environmentdsl.services.EnvironmentDslGrammarAccess

class EnvironmentDslFormatter extends BaseDslFormatter {
	
	@Inject extension EnvironmentDslGrammarAccess

	def dispatch void format(EnvModel envModel, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (EnvImport imports : envModel.getImports()) {
			imports.format;
		}
		for (User users : envModel.getUsers()) {
			users.format;
		}
		for (Environment environments : envModel.getEnvironments()) {
			environments.format;
		}
	}

	def dispatch void format(Environment environment, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (Host hosts : environment.getHosts()) {
			hosts.format;
		}
		for (Server servers : environment.getServers()) {
			servers.format;
		}
	}
	
	// TODO: implement for ExtensibleServer, ESB, Registry, AppServer, WebServer, ProcessServer, Broker, Database, SAP, ExtensibleConnector, SOAPHTTP, SOAPJMS, REST, EJB, IIOP, RMI, Tuxedo, JMS, AMQP, RFC, FTP, IMAP, POP3, SMTP, HTTP, TCP
}
