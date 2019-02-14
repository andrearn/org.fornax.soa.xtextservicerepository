define([], function() {
	var keywords = "Environment|URI|accepted|activity|as|attr|budgeting|by|class|datatype|default|denied|deprecating|end|entity|enum|extends|false|fixedVersion|for|frozen|import|initial|license|lifecycle|location|majorVersion|maxVersion|messaging|metadata|minVersion|namespace|operations|optional|other|owner|page|parent|pending|process|profile|publish|replaces|request|response|responsible|rule|scope|section|services|set|shorten|shortname|specific|state|subject|subscriptions|tags|to|true|type|types|utility|version";
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
