package org.xkonnex.repo.server.core.merge.handler;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.xtext.validation.Issue;
import org.xkonnex.repo.server.core.merge.MergeContext;
import org.xkonnex.repo.server.core.merge.MergePhase;

public interface IComparisonHandler {
	
	public Iterable<Issue> handleComparison (Comparison comparison, MergeContext ctx);

}
