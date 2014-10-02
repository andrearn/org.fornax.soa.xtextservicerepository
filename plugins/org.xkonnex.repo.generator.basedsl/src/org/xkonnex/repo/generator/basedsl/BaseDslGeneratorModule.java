package org.xkonnex.repo.generator.basedsl;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.SOABaseDslFactory;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.impl.SOABaseDslFactoryImpl;
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher;
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions;
import org.xkonnex.repo.dsl.basedsl.SOABaseDslRuntimeModule;

public class BaseDslGeneratorModule extends SOABaseDslRuntimeModule {

	
	public Class<? extends SOABaseDslFactory> bindSOABaseDslFactory () {
		return SOABaseDslFactoryImpl.class;
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
