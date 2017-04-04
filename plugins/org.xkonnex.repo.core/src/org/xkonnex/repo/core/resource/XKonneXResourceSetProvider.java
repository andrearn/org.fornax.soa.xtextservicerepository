package org.xkonnex.repo.core.resource;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("restriction") 
public class XKonneXResourceSetProvider implements Provider<XtextResourceSet>{

	@Inject
	private Provider<IJvmTypeProvider.Factory> typeProviderFactory;
	
	public XtextResourceSet get() {
		XtextResourceSet result = new SynchronizedXtextResourceSet() {
			@Override
			public void setClasspathURIContext(Object classpathURIContext) {
				super.setClasspathURIContext(classpathURIContext);
				if (isExpectedContext(classpathURIContext))
					ensureTypeFactoryExists(this);
			}
		};
		return result;
	}
	
	protected boolean isExpectedContext(Object classpathURIContext) {
		return true;
	}

	protected void ensureTypeFactoryExists(ResourceSet resourceSet) {
		IJvmTypeProvider.Factory factory = typeProviderFactory.get();
		factory.findOrCreateTypeProvider(resourceSet);
	}

}
