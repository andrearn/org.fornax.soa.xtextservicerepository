define([], function() {
	var keywords = "STRING|accepted|accuracy|all|amount|attachments|availability|body|cancellation|capacity|cause|contents|costs|default|denied|description|duration|email|escalation|expression|false|fixedVersion|frozen|header|import|issuer|latency|location|logging|majorVersion|maxVersion|minVersion|none|optional|penalty|pending|per|percentile|phone|preample|priority|procedure|reference|report|representative|responsibility|restrictions|scope|specific|subject|subscriptions|tags|throughput|true|type|version";
	return {
		id: "xtext.sladsl",
		contentTypes: ["xtext/sladsl"],
		patterns: [
			{include: "orion.c-like#comment_singleLine"},
			{include: "orion.c-like#comment_block"},
			{include: "orion.lib#string_doubleQuote"},
			{include: "orion.lib#string_singleQuote"},
			{include: "orion.lib#number_decimal"},
			{include: "orion.lib#brace_open"},
			{include: "orion.lib#brace_close"},
			{name: "keyword.sladsl", match: "\\b(?:" + keywords + ")\\b"}
		]
	};
});
