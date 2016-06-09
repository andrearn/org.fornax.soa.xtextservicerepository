define(["ace/lib/oop", "ace/mode/text", "ace/mode/text_highlight_rules"], function(oop, mText, mTextHighlightRules) {
	var HighlightRules = function() {
		var keywords = "DELETE|GET|HEAD|PATCH|POST|PUT|URI|abstract|accepted|aggregate|async|budgeting|businessObject|calling|channel|command|considers|default|deferred|denied|domain|entity|enum|event|exception|extends|false|fixedVersion|frozen|historized|idempotent|import|links|location|majorVersion|mandatory|maxVersion|metadata|minVersion|no|none|oneway|optional|owner|parameter|pattern|pending|persistence|private|public|publishers|queryObject|read|reference|replaces|represents|requires|resource|responsible|returns|service|shortname|specific|stateful|statefulness|stateless|subject|subscribers|subscriptions|sync|tags|throws|tolerated|topic|transactional|true|type|updating|valueObject|version|weak|write|yes";
		this.$rules = {
			"start": [
				{token: "comment", regex: "\\/\\/.*$"},
				{token: "comment", regex: "\\/\\*", next : "comment"},
				{token: "string", regex: '["](?:(?:\\\\.)|(?:[^"\\\\]))*?["]'},
				{token: "string", regex: "['](?:(?:\\\\.)|(?:[^'\\\\]))*?[']"},
				{token: "constant.numeric", regex: "[+-]?\\d+(?:(?:\\.\\d*)?(?:[eE][+-]?\\d+)?)?\\b"},
				{token: "lparen", regex: "[({]"},
				{token: "rparen", regex: "[)}]"},
				{token: "keyword", regex: "\\b(?:" + keywords + ")\\b"}
			],
			"comment": [
				{token: "comment", regex: ".*?\\*\\/", next : "start"},
				{token: "comment", regex: ".+"}
			]
		};
	};
	oop.inherits(HighlightRules, mTextHighlightRules.TextHighlightRules);
	
	var Mode = function() {
		this.HighlightRules = HighlightRules;
	};
	oop.inherits(Mode, mText.Mode);
	Mode.prototype.$id = "xtext/svcdsl";
	Mode.prototype.getCompletions = function(state, session, pos, prefix) {
		return [];
	}
	
	return {
		Mode: Mode
	};
});
