define([], function() {
	var keywords = "AMQP|AppServer|Broker|EJB|ESB|Environment|FTP|File|HTTP|IIOP|IMAP|InfrastructureManager|InitialContextFactory|JMS|Native|POP3|REST|RFC|RMI|Registry|SMTP|TCP|Tuxedo|UDDI|URL|accepted|accountingArea|adminUrl|admins|appserver|baseUrl|broker|budgeting|client|cluster|clustered|configuration|connector|connectors|container|containers|dataDir|database|default|denied|deployDir|deployUser|dir|esb|executable|external|false|fixedVersion|frozen|host|identifier|image|implementation|import|jdbcUrl|jndi|kind|license|location|majorVersion|maxVersion|minVersion|optional|owner|page|pending|port|private|processserver|public|registries|registry|responsible|sap|schema|section|server|specific|subject|tags|to|true|type|url|version|versions|webserver";
	return {
		id: "xtext.envdsl",
		contentTypes: ["xtext/envdsl"],
		patterns: [
			{include: "orion.c-like#comment_singleLine"},
			{include: "orion.c-like#comment_block"},
			{include: "orion.lib#string_doubleQuote"},
			{include: "orion.lib#string_singleQuote"},
			{include: "orion.lib#number_decimal"},
			{include: "orion.lib#brace_open"},
			{include: "orion.lib#brace_close"},
			{name: "keyword.envdsl", match: "\\b(?:" + keywords + ")\\b"}
		]
	};
});
