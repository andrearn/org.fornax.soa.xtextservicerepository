define([], function() {
	var keywords = "B|Environment|GB|MB|PB|TB|URI|accepted|activity|as|attr|budgeting|by|class|datatype|days|default|denied|deprecating|end|entity|enum|extends|false|fixedVersion|for|frozen|h|import|initial|kB|license|lifecycle|location|majorVersion|maxVersion|messaging|metadata|min|minVersion|months|ms|namespace|operations|optional|other|owner|page|parent|pending|process|profile|publish|replaces|request|response|responsible|rule|s|scope|section|services|set|shorten|shortname|specific|state|subject|subscriptions|tags|to|true|type|types|utility|version|weeks|years";
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
