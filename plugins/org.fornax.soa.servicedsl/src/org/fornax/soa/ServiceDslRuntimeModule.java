/*
 * generated by Xtext
 */
package org.fornax.soa;

import org.fornax.soa.basedsl.scoping.VersionedGlobalScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class ServiceDslRuntimeModule extends org.fornax.soa.AbstractServiceDslRuntimeModule {
	
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return VersionedGlobalScopeProvider.class;
	}

}
