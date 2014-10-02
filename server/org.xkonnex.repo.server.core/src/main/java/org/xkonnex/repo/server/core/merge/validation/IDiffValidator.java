package org.xkonnex.repo.server.core.merge.validation;

import java.util.List;

import org.eclipse.emf.compare.Diff;
import org.eclipse.xtext.validation.Issue;

public interface IDiffValidator {
	
	List<Issue> validate (Diff diff);

}
