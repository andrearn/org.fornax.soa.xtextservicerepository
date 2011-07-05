package org.fornax.soa.basedsl.validation;


public @interface PluggableChecks {

	Class<? extends AbstractPluggableDeclarativeValidator>[] validators();

}
