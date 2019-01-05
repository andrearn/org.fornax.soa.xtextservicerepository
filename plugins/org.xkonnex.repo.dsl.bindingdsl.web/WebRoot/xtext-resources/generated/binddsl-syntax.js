define([], function() {
	var keywords = "B|GB|HTTP|JMS|MB|PB|SMTP|SOAP|TB|accepted|accuracy|all|amount|as|attachments|availability|body|budgeting|capacity|cause|costs|days|default|denied|duration|environment|escalation|executable|expression|false|fixedVersion|frozen|h|header|import|kB|latency|license|location|majorVersion|maxVersion|min|minVersion|months|ms|optional|owner|page|penalty|pending|per|percentage|percentile|policies|procedure|protocols|requests|responsible|s|section|server|specific|style|subject|throughput|to|transactions|transport|true|type|version|weeks|years";
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
