package org.fornax.soa.basedsl.documentation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider;

public class DocFeatureDocumationProvider extends
		MultiLineCommentDocumentationProvider {

	private static final String DOC_ATTR_NAME = "doc";

	@Override
	protected String findComment(EObject o) {
		String comment = super.findComment(o);
		final EStructuralFeature docFeature = o.eClass().getEStructuralFeature(DOC_ATTR_NAME);
		if (comment == null && !o.eIsProxy()) {
			if (docFeature != null) {
				Object docObj = o.eGet(docFeature, true);
				if (docObj instanceof String) {
					comment = (String) docObj;
				}
			}
		}
		return comment;
	}

}
