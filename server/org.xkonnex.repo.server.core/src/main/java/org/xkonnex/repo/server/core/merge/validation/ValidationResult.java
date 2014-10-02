package org.xkonnex.repo.server.core.merge.validation;

import java.util.List;

import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;

public class ValidationResult {
	
	private List<Issue> errors = Lists.newArrayList();
	
	public List<Issue> getErrors() {
		return errors;
	}
	
	public boolean hasErrors() {
		return !errors.isEmpty();
	}

}
