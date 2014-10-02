package org.xkonnex.repo.dsl.basedsl.documentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;
import org.eclipse.xtext.util.SimpleAttributeResolver;

public class DocFeatureDocumationProvider extends
		MultiLineCommentDocumentationProvider {

	private static final SimpleAttributeResolver<EObject, String> DOC_ATTR_RESOLVER = SimpleAttributeResolver.newResolver(String.class, "doc");

	@Override
	protected String findComment(EObject o) {
		return DOC_ATTR_RESOLVER.apply(o);
	}

}
