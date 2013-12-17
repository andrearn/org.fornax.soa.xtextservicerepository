package org.fornax.soa.xsr.connex.core.merge.handler;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.xtext.validation.Issue;
import org.fornax.soa.xsr.connex.core.merge.MergeContext;
import org.fornax.soa.xsr.connex.core.merge.MergePhase;

public interface IComparisonHandler {
	
	public Iterable<Issue> handleComparison (Comparison comparison, MergeContext ctx);

}
