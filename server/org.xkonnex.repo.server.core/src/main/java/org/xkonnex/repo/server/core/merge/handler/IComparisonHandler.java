package org.xkonnex.repo.server.core.merge.handler;

import org.eclipse.emf.compare.Comparison;
import org.xkonnex.repo.core.validation.ModelIssues;
import org.xkonnex.repo.server.core.merge.MergeContext;

public interface IComparisonHandler {
	
	public void handleComparison (Comparison comparison, MergeContext ctx, ModelIssues issues);

}
