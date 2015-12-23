package org.xkonnex.repo.dsl.basedsl

import java.util.Collections
import java.util.List

class CommonStringExtensions {
	
	def String stripCommentBraces (String s) {
		s.replaceFirst("\\/\\*", "").replaceFirst("\\*\\/","").replaceAll("\\n(\\t)+(\\s)*(\\*)+", "\n\t");
	}
	
	def String stripXtextEscapes (String s) {
		s.replaceFirst("\\^", "")
	}
	
	def String stripTrailingSlash (String s) {
		var result = s
		while (result.endsWith("/") )  {
			result = result.substring (0, result.length-1) 
		}
		result
	}
	
	def Integer asInteger (String s) {
		try {
			Integer::parseInt(s);
		} catch (Exception ex) {
			
		}
	}
	
	def List<String> segments (String fqn) {
		Collections.unmodifiableList(fqn.stripXtextEscapes.split("\\."))
	}
	
}