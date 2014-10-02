package org.xkonnex.repo.server.web.connex.web;

import org.xkonnex.repo.server.web.connex.core.ConnexCoreModule;

import com.google.inject.AbstractModule;

public class ConnexWebModule extends AbstractModule {

	@Override
	protected void configure() {
		install (new ConnexCoreModule());
		
	}

	
}
