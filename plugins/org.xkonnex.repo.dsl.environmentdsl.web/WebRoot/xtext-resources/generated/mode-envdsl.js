define(["ace/lib/oop", "ace/mode/text", "ace/mode/text_highlight_rules"], function(oop, mText, mTextHighlightRules) {
	var HighlightRules = function() {
		var keywords = "AMQP|Adabas|AppServer|Broker|CouchDB|DB2|Derby|EJB|ESB|FTP|File|HTTP|Hadoop|HyperSonic|IIOP|IMAP|Ingres|InitialContextFactory|JMS|MSSQL|MongoDB|MySQL|Native|Neo4J|Oracle|Other|POP3|Postgres|REST|RFC|RMI|Registry|SMTP|Sybase|TCP|Tuxedo|UDDI|URL|accepted|accountingArea|adminUrl|admins|appserver|baseUrl|broker|client|cluster|clustered|configuration|connector|connectors|container|containers|dataDir|database|default|denied|deployDir|deployUser|dir|email|environment|esb|executable|external|false|firstname|fixedVersion|frozen|host|identifier|image|implementation|import|jdbcUrl|jndi|kind|lastname|location|majorVersion|maxVersion|minVersion|optional|owner|pending|phone|port|private|processserver|public|reference|registries|registry|sap|schema|server|specific|subject|tags|true|type|url|user|version|versions|webserver";
		this.$rules = {
			"start": [
				{token: "comment", regex: "\\/\\/.*$"},
				{token: "comment", regex: "\\/\\*", next : "comment"},
				{token: "string", regex: '["](?:(?:\\\\.)|(?:[^"\\\\]))*?["]'},
				{token: "string", regex: "['](?:(?:\\\\.)|(?:[^'\\\\]))*?[']"},
				{token: "constant.numeric", regex: "[+-]?\\d+(?:(?:\\.\\d*)?(?:[eE][+-]?\\d+)?)?\\b"},
				{token: "lparen", regex: "[{]"},
				{token: "rparen", regex: "[}]"},
				{token: "keyword", regex: "\\b(?:" + keywords + ")\\b"}
			],
			"comment": [
				{token: "comment", regex: ".*?\\*\\/", next : "start"},
				{token: "comment", regex: ".+"}
			]
		};
	};
	oop.inherits(HighlightRules, mTextHighlightRules.TextHighlightRules);
	
	var Mode = function() {
		this.HighlightRules = HighlightRules;
	};
	oop.inherits(Mode, mText.Mode);
	Mode.prototype.$id = "xtext/envdsl";
	Mode.prototype.getCompletions = function(state, session, pos, prefix) {
		return [];
	}
	
	return {
		Mode: Mode
	};
});
