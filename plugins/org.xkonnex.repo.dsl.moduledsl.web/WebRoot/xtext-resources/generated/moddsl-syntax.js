define([], function() {
	var keywords = "B|DLL|EAR|GB|JAR|MB|OSGi|OTHER|PB|TB|WAR|WebMethods|ZIP|accepted|artifactId|budgeting|channel|client|days|default|denied|excluding|external|false|fixedVersion|frozen|groupId|h|import|including|kB|license|location|majorVersion|maxVersion|min|minVersion|module|months|ms|namespace|operations|optional|owner|page|parameters|pending|provides|public|qualifier|resource|responsible|s|section|service|specific|subject|subscriptions|tags|true|type|uses|version|weeks|years";
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
