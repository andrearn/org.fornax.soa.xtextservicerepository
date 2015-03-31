package org.xkonnex.repo.server.web;

import org.xkonnex.repo.server.core.XKonneXRepoCoreModule;

import com.google.inject.AbstractModule;

public class XKonneXRepoWebModule extends AbstractModule {

	@Override
	protected void configure() {
		install (new XKonneXRepoCoreModule());
		
	}

	
}
