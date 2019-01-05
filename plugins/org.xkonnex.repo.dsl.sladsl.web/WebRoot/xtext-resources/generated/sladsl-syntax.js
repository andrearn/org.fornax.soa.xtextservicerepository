define([], function() {
	var keywords = "B|GB|MB|PB|TB|accepted|accuracy|all|amount|attachments|availability|body|budgeting|cancellation|capacity|cause|contents|costs|days|default|denied|description|duration|email|escalation|expression|false|fixedVersion|frozen|h|header|import|issuer|kB|latency|license|location|majorVersion|maxVersion|min|minVersion|months|ms|none|optional|owner|page|penalty|pending|per|percentage|percentile|phone|preample|priority|procedure|report|representative|requests|responsibility|responsible|restrictions|s|scope|section|specific|subject|subscriptions|tags|throughput|transactions|true|type|version|weeks|years";
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
