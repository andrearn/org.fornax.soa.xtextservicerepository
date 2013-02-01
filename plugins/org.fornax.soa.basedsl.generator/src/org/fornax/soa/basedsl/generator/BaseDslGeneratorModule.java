package org.fornax.soa.basedsl.generator;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.fornax.soa.basedsl.SOABaseDslRuntimeModule;
import org.fornax.soa.basedsl.sOABaseDsl.SOABaseDslFactory;
import org.fornax.soa.basedsl.sOABaseDsl.impl.SOABaseDslFactoryImpl;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;

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
