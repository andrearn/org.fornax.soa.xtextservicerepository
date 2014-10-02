package org.xkonnex.repo.dsl.basedsl.documentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;
import org.eclipse.xtext.util.SimpleAttributeResolver;

public class DescriptionFeatureDocumentationProvider extends
		MultiLineCommentDocumentationProvider {

	private static final SimpleAttributeResolver<EObject, String> DESCR_ATTR_RESOLVER = SimpleAttributeResolver.newResolver(String.class, "description");

	@Override
	protected String findComment(EObject o) {
		return DESCR_ATTR_RESOLVER.apply(o);
	}

}
