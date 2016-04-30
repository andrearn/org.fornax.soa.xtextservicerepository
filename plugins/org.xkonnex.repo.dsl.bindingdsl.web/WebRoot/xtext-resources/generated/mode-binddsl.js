define(["ace/lib/oop", "ace/mode/text", "ace/mode/text_highlight_rules"], function(oop, mText, mTextHighlightRules) {
	var HighlightRules = function() {
		var keywords = "AMQP|CREATE|DELETE|EJB|FILE|FTP|GET|HTTP|IDOC|IIOP|JMS|POST|PUT|REST|RETRIEVE|RFC|SAP|SCA|SMTP|SOAP|STRING|UPDATE|accepted|access|all|as|assertions|attachments|availability|body|client|consumes|costs|default|denied|environment|expression|false|fixedVersion|frozen|header|import|interval|issuer|latency|location|majorVersion|maxVersion|minVersion|none|optional|path|pending|per|percentile|policies|promote|protocols|provides|queue|read|reference|server|specific|style|subject|to|topic|transport|true|type|url|verb|version|write";
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
	Mode.prototype.$id = "xtext/binddsl";
	Mode.prototype.getCompletions = function(state, session, pos, prefix) {
		return [];
	}
	
	return {
		Mode: Mode
	};
});
