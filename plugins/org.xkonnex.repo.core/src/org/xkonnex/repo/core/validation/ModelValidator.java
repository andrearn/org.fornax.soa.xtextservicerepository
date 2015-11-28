package org.xkonnex.repo.core.validation;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;

public class ModelValidator {
	
	public void validate(ResourceSet resourceSet, IResourceServiceProvider.Registry registry, ModelIssues modelIssues) {
		List<Resource> resources = Lists.newArrayList(resourceSet.getResources());
		for (Resource resource : resources) {
			try {
				resource.load(null);
				IResourceServiceProvider provider = registry.getResourceServiceProvider(resource.getURI());
				if (provider != null) {
					List<Issue> result = provider.getResourceValidator().validate(resource, CheckMode.ALL, null);
					for (Issue issue : result) {
						modelIssues.addIssue(issue);
					}
				}
			} catch (IOException e) {
				throw new RuntimeException("Couldn't load resource (" + resource.getURI() + ")", e);
			}
		}
	}

}
