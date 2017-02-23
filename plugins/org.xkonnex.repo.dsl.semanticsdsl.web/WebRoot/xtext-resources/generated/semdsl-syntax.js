define([], function() {
	var keywords = "extends|import|qualifier|tag";
	return {
		id: "xtext.semdsl",
		contentTypes: ["xtext/semdsl"],
		patterns: [
			{include: "orion.c-like#comment_singleLine"},
			{include: "orion.c-like#comment_block"},
			{include: "orion.lib#string_doubleQuote"},
			{include: "orion.lib#string_singleQuote"},
			{include: "orion.lib#number_decimal"},
			{name: "keyword.semdsl", match: "\\b(?:" + keywords + ")\\b"}
		]
	};
});
