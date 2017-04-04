package org.xkonnex.repo.generator.basedsl;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslFactory;
import org.xkonnex.repo.dsl.basedsl.baseDsl.impl.BaseDslFactoryImpl;
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher;
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions;
import org.xkonnex.repo.dsl.basedsl.BaseDslRuntimeModule;

public class BaseDslGeneratorModule extends BaseDslRuntimeModule {

	
	public Class<? extends BaseDslFactory> bindSOABaseDslFactory () {
		return BaseDslFactoryImpl.class;
	}
	
	public Class<? extends VersionQualifierExtensions> bindVersionQualifierExtensions () {
		return VersionQualifierExtensions.class;
	}
	
	public Class<? extends VersionMatcher> bindVersionMatcher () {
		return VersionMatcher.class;
	}	
	
	public Class<? extends IFileSystemAccess> bindIFileSystemAccess () {
		return JavaIoFileSystemAccess.class;
	}


}
