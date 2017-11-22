define([], function() {
	var keywords = "URI|accepted|activity|as|attr|budgeting|by|class|datatype|default|denied|deprecating|end|entity|enum|extends|false|fixedVersion|for|frozen|import|initial|lifecycle|location|majorVersion|maxVersion|messaging|metadata|minVersion|namespace|operations|optional|other|owner|parent|pending|process|profile|publish|reference|replaces|request|response|responsible|rule|scope|services|set|shorten|shortname|specific|state|subject|subscriptions|to|true|type|types|utility|version";
	return {
		id: "xtext.profdsl",
		contentTypes: ["xtext/profdsl"],
		patterns: [
			{include: "orion.c-like#comment_singleLine"},
			{include: "orion.c-like#comment_block"},
			{include: "orion.lib#string_doubleQuote"},
			{include: "orion.lib#string_singleQuote"},
			{include: "orion.lib#number_decimal"},
			{include: "orion.lib#brace_open"},
			{include: "orion.lib#brace_close"},
			{name: "keyword.profdsl", match: "\\b(?:" + keywords + ")\\b"}
		]
	};
});
