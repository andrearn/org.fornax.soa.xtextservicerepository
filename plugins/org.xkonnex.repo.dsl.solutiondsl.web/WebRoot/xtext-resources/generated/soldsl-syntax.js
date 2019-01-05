define([], function() {
	var keywords = "B|GB|MB|PB|TB|accepted|budgeting|calling|days|default|denied|description|domain|false|feature|fixedVersion|frozen|h|import|kB|license|location|majorVersion|maxVersion|min|minVersion|module|months|ms|optional|owner|page|pending|requires|responsible|s|section|solution|specific|subject|subscriptions|tags|true|type|version|weeks|years";
	return {
		id: "xtext.soldsl",
		contentTypes: ["xtext/soldsl"],
		patterns: [
			{include: "orion.c-like#comment_singleLine"},
			{include: "orion.c-like#comment_block"},
			{include: "orion.lib#string_doubleQuote"},
			{include: "orion.lib#string_singleQuote"},
			{include: "orion.lib#number_decimal"},
			{include: "orion.lib#brace_open"},
			{include: "orion.lib#brace_close"},
			{name: "keyword.soldsl", match: "\\b(?:" + keywords + ")\\b"}
		]
	};
});
