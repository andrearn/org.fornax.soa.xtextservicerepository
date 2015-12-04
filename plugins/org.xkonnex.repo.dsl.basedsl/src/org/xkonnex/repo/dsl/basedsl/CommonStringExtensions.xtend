package org.xkonnex.repo.dsl.basedsl

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
			result.substring (0, result.length-1) 
		}
		result
	}
	
	def Integer asInteger (String s) {
		try {
			Integer::parseInt(s);
		} catch (Exception ex) {
			
		}
	}
	
}