define([], function() {
	var keywords = "accepted|budgeting|default|denied|false|fixedVersion|frozen|import|license|location|majorVersion|maxVersion|minVersion|optional|owner|pending|reference|responsible|specific|subject|subscriptions|true|type|version";
	return {
		id: "xtext.basedsl",
		contentTypes: ["xtext/basedsl"],
		patterns: [
			{include: "orion.c-like#comment_singleLine"},
			{include: "orion.c-like#comment_block"},
			{include: "orion.lib#string_doubleQuote"},
			{include: "orion.lib#string_singleQuote"},
			{include: "orion.lib#number_decimal"},
			{include: "orion.lib#brace_open"},
			{include: "orion.lib#brace_close"},
			{name: "keyword.basedsl", match: "\\b(?:" + keywords + ")\\b"}
		]
	};
});
