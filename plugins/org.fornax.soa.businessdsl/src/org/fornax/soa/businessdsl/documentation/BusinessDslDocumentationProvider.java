package org.fornax.soa.businessdsl.documentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;
import org.eclipse.xtext.util.SimpleAttributeResolver;

public class BusinessDslDocumentationProvider extends
		MultiLineCommentDocumentationProvider {

	private static final SimpleAttributeResolver<EObject, String> SHORT_DESCR_ATTR_RESOLVER = SimpleAttributeResolver.newResolver(String.class, "shortDescription");
	private static final SimpleAttributeResolver<EObject, String> DESCR_ATTR_RESOLVER = SimpleAttributeResolver.newResolver(String.class, "description");

	@Override
	protected String findComment(EObject o) {
		String comment = DESCR_ATTR_RESOLVER.apply(o);
		if (comment == null)
			comment = SHORT_DESCR_ATTR_RESOLVER.apply(o);
		return comment;
	}

}
