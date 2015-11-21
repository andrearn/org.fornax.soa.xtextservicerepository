package org.xkonnex.repo.dsl.basedsl.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.RangeBasedDiagnostic;

public class BaseRangeBasedDiagnostic extends RangeBasedDiagnostic {

	protected BaseRangeBasedDiagnostic (int severity, String message, EObject source, int offset, int length, CheckType checkType, String issueCode,
			String[] issueData) {
		super(severity, message, source, offset, length, checkType, issueCode, issueData);
	}

}
