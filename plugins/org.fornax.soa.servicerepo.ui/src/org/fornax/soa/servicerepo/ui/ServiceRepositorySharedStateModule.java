package org.fornax.soa.servicerepo.ui;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.service.AbstractGenericModule;

import com.google.inject.Provider;

public class ServiceRepositorySharedStateModule extends AbstractGenericModule {
	
	
	public Provider<IWorkspace> provideIWorkspace(){
		return new Provider<IWorkspace>() {
			public IWorkspace get() {
				return ResourcesPlugin.getWorkspace();
			}
		};
	}
	
	public Provider<IWorkbench> provideIWorkbench(){
		return new Provider<IWorkbench>() {
			public IWorkbench get() {
				return PlatformUI.getWorkbench();
			}
		};
	}


}
