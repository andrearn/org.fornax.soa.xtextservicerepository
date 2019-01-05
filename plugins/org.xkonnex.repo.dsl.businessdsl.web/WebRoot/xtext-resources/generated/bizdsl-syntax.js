define([], function() {
	var keywords = "B|GB|MB|PB|TB|accepted|adding|automated|budgeting|capability|competence|context|days|default|denied|description|domain|external|false|fixedVersion|frozen|h|head|import|input|inputs|kB|license|location|majorVersion|manual|maxVersion|min|minVersion|months|ms|optional|org|outcome|outcomes|owner|page|pending|removing|replacing|responsible|s|section|specific|subject|subscriptions|tags|true|type|uses|version|weeks|with|years";
	return {
		id: "xtext.bizdsl",
		contentTypes: ["xtext/bizdsl"],
		patterns: [
			{include: "orion.c-like#comment_singleLine"},
			{include: "orion.c-like#comment_block"},
			{include: "orion.lib#string_doubleQuote"},
			{include: "orion.lib#string_singleQuote"},
			{include: "orion.lib#number_decimal"},
			{include: "orion.lib#brace_open"},
			{include: "orion.lib#brace_close"},
			{name: "keyword.bizdsl", match: "\\b(?:" + keywords + ")\\b"}
		]
	};
});
