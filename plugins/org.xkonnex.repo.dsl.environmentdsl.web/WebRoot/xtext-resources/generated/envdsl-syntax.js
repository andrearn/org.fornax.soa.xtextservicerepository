define([], function() {
	var keywords = "AMQP|AppServer|B|Broker|EJB|ESB|Environment|FTP|File|GB|HTTP|IIOP|IMAP|InfrastructureManager|InitialContextFactory|JMS|MB|Native|PB|POP3|REST|RFC|RMI|Registry|SMTP|TB|TCP|Tuxedo|UDDI|URL|accepted|accountingArea|adminUrl|admins|appserver|baseUrl|broker|budgeting|client|cluster|clustered|configuration|connector|connectors|container|containers|dataDir|database|days|default|denied|deployDir|deployUser|dir|esb|executable|external|false|fixedVersion|frozen|h|host|identifier|image|implementation|import|jdbcUrl|jndi|kB|kind|license|location|majorVersion|maxVersion|min|minVersion|months|ms|optional|owner|page|pending|port|private|processserver|public|registries|registry|responsible|s|sap|schema|section|server|specific|subject|tags|to|true|type|url|version|versions|webserver|weeks|years";
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
