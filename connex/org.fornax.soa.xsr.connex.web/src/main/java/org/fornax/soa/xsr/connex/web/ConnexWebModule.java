package org.fornax.soa.xsr.connex.web;

import org.fornax.soa.xsr.connex.core.ConnexCoreModule;

import com.google.inject.AbstractModule;

public class ConnexWebModule extends AbstractModule {

	@Override
	protected void configure() {
		install (new ConnexCoreModule());
		
	}

	
}
