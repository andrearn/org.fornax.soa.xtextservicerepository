define([], function() {
	var keywords = "HTTP|JMS|SMTP|SOAP|STRING|accepted|all|as|assertions|attachments|availability|body|costs|default|denied|environment|executable|expression|false|fixedVersion|frozen|header|import|issuer|latency|location|majorVersion|maxVersion|minVersion|none|optional|pending|per|percentile|policies|protocols|reference|server|specific|style|subject|to|transport|true|type|version";
	return {
		id: "xtext.binddsl",
		contentTypes: ["xtext/binddsl"],
		patterns: [
			{include: "orion.c-like#comment_singleLine"},
			{include: "orion.c-like#comment_block"},
			{include: "orion.lib#string_doubleQuote"},
			{include: "orion.lib#string_singleQuote"},
			{include: "orion.lib#number_decimal"},
			{include: "orion.lib#brace_open"},
			{include: "orion.lib#brace_close"},
			{name: "keyword.binddsl", match: "\\b(?:" + keywords + ")\\b"}
		]
	};
});
