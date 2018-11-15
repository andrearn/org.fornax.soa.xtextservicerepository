define([], function() {
	var keywords = "AMQP|Adabas|AppServer|Broker|CouchDB|DB2|Derby|EJB|ESB|Environment|FTP|File|HTTP|Hadoop|HyperSonic|IIOP|IMAP|InfrastructureManager|Ingres|InitialContextFactory|JMS|MSSQL|MongoDB|MySQL|Native|Neo4J|Oracle|Other|POP3|Postgres|REST|RFC|RMI|Registry|SMTP|Sybase|TCP|Tuxedo|UDDI|URL|accepted|accountingArea|adminUrl|admins|appserver|baseUrl|broker|budgeting|client|cluster|clustered|configuration|connector|connectors|container|containers|dataDir|database|default|denied|deployDir|deployUser|dir|esb|executable|external|false|fixedVersion|frozen|gateway|host|identifier|image|implementation|import|jdbcUrl|jndi|kind|license|location|majorVersion|maxVersion|minVersion|optional|owner|pending|port|private|processserver|public|reference|registries|registry|responsible|sap|schema|server|specific|subject|subscriptions|tags|to|true|type|url|version|versions|webserver";
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
