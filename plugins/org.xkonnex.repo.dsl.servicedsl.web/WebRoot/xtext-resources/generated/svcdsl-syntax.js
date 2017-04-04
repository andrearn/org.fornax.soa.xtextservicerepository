define([], function() {
	var keywords = "DELETE|GET|HEAD|PATCH|POST|PUT|URI|abstract|accepted|aggregate|as|async|budgeting|businessObject|calling|channel|command|considers|default|deferred|denied|domain|entity|enum|event|exception|extends|false|fixedVersion|frozen|historized|idempotent|import|links|location|majorVersion|mandatory|maxVersion|metadata|minVersion|no|none|oneway|optional|owner|parameter|pattern|pending|persistence|private|public|publishers|queryObject|read|reference|replaces|represents|requires|resource|responsible|returns|service|set|shortname|specific|stateful|statefulness|stateless|subject|subscribers|subscriptions|sync|tags|throws|tolerated|topic|transactional|true|type|updating|valueObject|version|weak|write|yes";
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
