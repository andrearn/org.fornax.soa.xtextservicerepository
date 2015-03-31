package org.xkonnex.repo.server.core.merge.handler;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.xtext.validation.Issue;
import org.xkonnex.repo.server.core.merge.MergeContext;
import org.xkonnex.repo.server.core.merge.MergePhase;
import org.xkonnex.repo.server.core.validation.ModelIssues;

public interface IComparisonHandler {
	
	public void handleComparison (Comparison comparison, MergeContext ctx, ModelIssues issues);

}
