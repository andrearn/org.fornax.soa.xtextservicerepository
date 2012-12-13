package org.fornax.soa.servicerepo.ui;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.fornax.soa.basedsl.scoping.versions.BaseDslVersionResolver;
import org.fornax.soa.basedsl.scoping.versions.VersionComparator;
import org.fornax.soa.basedsl.scoping.versions.VersionResolver;

import com.google.inject.Provider;

public class ServiceRepositorySharedStateModule extends SharedStateModule {
	
	
	public Provider<IWorkspace> provideIWorkspace(){
		return new Provider<IWorkspace>() {
			public IWorkspace get() {
				return ResourcesPlugin.getWorkspace();
			}
		};
	}
	
	public Class<? extends VersionResolver> bindVersionResolver () {
		return BaseDslVersionResolver.class;
	}
	
	public Class<? extends VersionComparator> bindVersionComparator () {
		return VersionComparator.class;
	}
	
//	public Provider<IWorkbench> provideIWorkbench(){
//		return new Provider<IWorkbench>() {
//			public IWorkbench get() {
//				return PlatformUI.getWorkbench();
//			}
//		};
//	}


}
