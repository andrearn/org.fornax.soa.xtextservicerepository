package org.fornax.soa.basedsl.generator

class CommonStringExtensions {
	
	def String stripCommentBraces (String s) {
		s.replaceFirst("\\/\\*", "").replaceFirst("\\*\\/","").replaceAll("\\n(\\t)+(\\s)*(\\*)+", "\n\t");
	}
	
	def String stripXtextEscapes (String s) {
		s.replaceFirst("\\^", "");
	}
	
	def String stripTrailingSlash (String s) {
		if (s.endsWith("/") )  {
			s.substring (0, s.length-1) 
		} else { 
			s;
		}
	}
	
	def Integer asInteger (String s) {
		try {
			Integer::parseInt(s);
		} catch (Exception ex) {
			
		}
	}
	
}