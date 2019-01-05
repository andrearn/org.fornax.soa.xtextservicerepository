define([], function() {
	var keywords = "B|DELETE|GB|GET|HEAD|MB|PATCH|PB|POST|PUT|TB|URI|abstract|accepted|aggregate|as|async|budgeting|businessObject|calling|channel|command|considers|days|default|deferred|denied|domain|entity|enum|event|exception|extends|false|fixedVersion|frozen|h|historized|idempotent|import|kB|license|links|location|majorVersion|mandatory|maxVersion|metadata|min|minVersion|months|ms|no|none|oneway|optional|owner|page|parameter|pattern|pending|persistence|private|public|publishers|queryObject|read|replaces|requires|resource|responsible|returns|s|section|service|set|shortname|specific|stateful|statefulness|stateless|subject|subscribers|subscriptions|sync|tags|throws|tolerated|topic|transactional|true|type|updating|valueObject|version|weak|weeks|write|years|yes";
	return {
		id: "xtext.svcdsl",
		contentTypes: ["xtext/svcdsl"],
		patterns: [
			{include: "orion.c-like#comment_singleLine"},
			{include: "orion.c-like#comment_block"},
			{include: "orion.lib#string_doubleQuote"},
			{include: "orion.lib#string_singleQuote"},
			{include: "orion.lib#number_decimal"},
			{include: "orion.lib#brace_open"},
			{include: "orion.lib#brace_close"},
			{include: "orion.lib#parenthesis_open"},
			{include: "orion.lib#parenthesis_close"},
			{name: "keyword.svcdsl", match: "\\b(?:" + keywords + ")\\b"}
		]
	};
});
