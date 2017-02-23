define([], function() {
	var keywords = "DLL|EAR|JAR|OSGi|OTHER|WAR|WebMethods|ZIP|accepted|artifactId|budgeting|channel|client|default|denied|excluding|external|false|fixedVersion|frozen|groupId|import|including|location|majorVersion|maxVersion|minVersion|module|namespace|operations|optional|owner|parameters|pending|provides|public|qualifier|reference|resource|responsible|service|specific|subject|subscriptions|tags|true|type|uses|version";
	return {
		id: "xtext.moddsl",
		contentTypes: ["xtext/moddsl"],
		patterns: [
			{include: "orion.c-like#comment_singleLine"},
			{include: "orion.c-like#comment_block"},
			{include: "orion.lib#string_doubleQuote"},
			{include: "orion.lib#string_singleQuote"},
			{include: "orion.lib#number_decimal"},
			{include: "orion.lib#brace_open"},
			{include: "orion.lib#brace_close"},
			{name: "keyword.moddsl", match: "\\b(?:" + keywords + ")\\b"}
		]
	};
});
