define([], function() {
	var keywords = "B|GB|MB|PB|TB|accepted|budgeting|days|default|denied|false|fixedVersion|frozen|h|import|kB|license|location|majorVersion|maxVersion|min|minVersion|months|ms|optional|owner|page|pending|responsible|s|section|specific|subject|true|type|version|weeks|years";
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
