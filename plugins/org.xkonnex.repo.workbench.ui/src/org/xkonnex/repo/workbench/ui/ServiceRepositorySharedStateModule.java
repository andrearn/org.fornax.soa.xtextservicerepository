package org.xkonnex.repo.workbench.ui;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.xkonnex.repo.dsl.basedsl.version.IScopeVersionResolver;
import org.xkonnex.repo.dsl.basedsl.version.SimpleScopeVersionResolver;
import org.xkonnex.repo.dsl.basedsl.version.VersionComparator;

import com.google.inject.Provider;

public class ServiceRepositorySharedStateModule extends SharedStateModule {
	
	
	public Provider<IWorkspace> provideIWorkspace(){
		return new Provider<IWorkspace>() {
			public IWorkspace get() {
				return ResourcesPlugin.getWorkspace();
			}
		};
	}
	
	public Class<? extends IScopeVersionResolver> bindVersionResolver () {
		return SimpleScopeVersionResolver.class;
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
