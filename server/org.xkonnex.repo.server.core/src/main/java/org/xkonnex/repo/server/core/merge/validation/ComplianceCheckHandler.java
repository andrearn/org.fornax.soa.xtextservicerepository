package org.xkonnex.repo.server.core.merge.validation;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.xkonnex.repo.core.validation.ModelIssues;
import org.xkonnex.repo.server.core.merge.MergeContext;
import org.xkonnex.repo.server.core.merge.handler.IComparisonHandler;

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
