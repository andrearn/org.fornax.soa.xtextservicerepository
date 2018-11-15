define([], function() {
	var keywords = "Batch|BusinessLogic|OTHER|Persistence|Security|UI|accepted|budgeting|calling|default|denied|description|domain|false|feature|fixedVersion|frozen|import|kind|license|location|majorVersion|maxVersion|minVersion|module|optional|owner|pending|reference|requires|responsible|solution|specific|subject|subscriptions|tags|true|type|version";
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
