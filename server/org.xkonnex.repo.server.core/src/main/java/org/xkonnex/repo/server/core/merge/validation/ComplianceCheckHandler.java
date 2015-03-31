package org.xkonnex.repo.server.core.merge.validation;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.xtext.validation.Issue;
import org.xkonnex.repo.server.core.merge.MergeContext;
import org.xkonnex.repo.server.core.merge.handler.IComparisonHandler;
import org.xkonnex.repo.server.core.validation.ModelIssues;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class ComplianceCheckHandler implements IComparisonHandler {
	
	@Inject
	private DiffValidatorProvider diffValidatorProvider;

	public void handleComparison(Comparison comparison, MergeContext ctx,ModelIssues issues) {
		EList<Diff> differences = comparison.getDifferences();
		List<IDiffValidator> validators = diffValidatorProvider.get();
		for (Diff diff : differences) {
			for (IDiffValidator validator : validators) {
				validator.validate (diff);
			}
		}
	}

}
