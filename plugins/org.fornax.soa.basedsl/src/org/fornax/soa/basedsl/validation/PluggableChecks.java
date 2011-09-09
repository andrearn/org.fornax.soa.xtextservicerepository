package org.fornax.soa.basedsl.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE})
public @interface PluggableChecks {

	Class<? extends AbstractPluggableDeclarativeValidator>[] validators();

}
