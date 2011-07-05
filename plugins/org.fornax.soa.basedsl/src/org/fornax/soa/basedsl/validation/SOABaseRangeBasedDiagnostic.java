package org.fornax.soa.basedsl.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.RangeBasedDiagnostic;

public class SOABaseRangeBasedDiagnostic extends RangeBasedDiagnostic {

	protected SOABaseRangeBasedDiagnostic (int severity, String message, EObject source, int offset, int length, CheckType checkType, String issueCode,
			String[] issueData) {
		super(severity, message, source, offset, length, checkType, issueCode, issueData);
	}

}
