package org.fornax.soa.businessdsl.documentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class BusinessDslDocumentationProvider extends
		MultiLineCommentDocumentationProvider {

	private static final SimpleAttributeResolver<EObject, String> SHORT_DESCR_ATTR_RESOLVER = SimpleAttributeResolver.newResolver(String.class, "shortDescription");
	private static final SimpleAttributeResolver<EObject, String> DESCR_ATTR_RESOLVER = SimpleAttributeResolver.newResolver(String.class, "description");


	@Inject(optional = true)
	@Named(RULE)
	String ruleName = "ML_COMMENT";

	@Inject(optional = true)
	@Named(START_TAG)
	String startTag = "/\\*\\*?"; // regular expression

	@Inject(optional = true)
	@Named(END_TAG)
	String endTag = "\\*/"; // regular expression

	@Inject(optional = true)
	@Named(LINE_PREFIX)
	String linePrefix = "\\** ?"; // regular expression

	@Inject(optional = true)
	@Named(LINE_POSTFIX)
	String linePostfix = "\\**"; // regular expression

	@Inject(optional = true)
	@Named(WHITESPACE)
	String whitespace = "( |\\t)*"; // regular expression

	
	@Override
	protected String findComment(EObject o) {
		String mlComment = stripCommentBraces (super.findComment (o));
		String comment = DESCR_ATTR_RESOLVER.apply(o);
		if (comment == null)
			comment = SHORT_DESCR_ATTR_RESOLVER.apply(o);
		StringBuilder b = new StringBuilder();
		b.append (comment);
		if (mlComment != null) {
			b.append (" <br/><br/>\n");
			b.append (mlComment);
		}
		return b.toString ();
	}
	
	protected String stripCommentBraces (String s) {
		if (s != null) {
			s = s.replaceAll("\\A" + startTag, "");
			s = s.replaceAll(endTag + "\\z", "");
			s = s.replaceAll("(?m)^"+ whitespace + linePrefix, "");
			s = s.replaceAll("(?m)" + whitespace + linePostfix + whitespace + "$", "");
			return s.trim();
		} else
			return null;

	}

}
