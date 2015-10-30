package org.xkonnex.repo.server.core.config;

import java.io.File;

import org.xkonnex.repo.server.core.config.impl.ProjectGenerator;

import com.google.inject.ImplementedBy;

@ImplementedBy (ProjectGenerator.class)
public interface IProjectGenerator {
	
	public void generateProject(File folder);

}
