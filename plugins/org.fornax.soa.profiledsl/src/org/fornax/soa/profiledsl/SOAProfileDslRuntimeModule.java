/*
 * generated by Xtext
 */
package org.fornax.soa.profiledsl;

import org.fornax.soa.basedsl.scoping.VersionedGlobalScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class SOAProfileDslRuntimeModule extends org.fornax.soa.profiledsl.AbstractSOAProfileDslRuntimeModule {

	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return VersionedGlobalScopeProvider.class;
	}

}
