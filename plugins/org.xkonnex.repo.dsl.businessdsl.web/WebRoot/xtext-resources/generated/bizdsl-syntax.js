define([], function() {
	var keywords = "accepted|adding|automated|budgeting|capability|competence|context|default|denied|description|domain|external|false|fixedVersion|frozen|head|import|input|inputs|license|location|majorVersion|manual|maxVersion|minVersion|optional|org|outcome|outcomes|owner|pending|reference|removing|replacing|responsible|specific|subject|subscriptions|tags|true|type|uses|version|with";
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
