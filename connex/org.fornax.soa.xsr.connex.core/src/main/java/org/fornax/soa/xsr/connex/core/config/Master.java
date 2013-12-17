package org.fornax.soa.xsr.connex.core.config;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

@Retention (RetentionPolicy.RUNTIME)
@Target ({FIELD, METHOD, PARAMETER})
@BindingAnnotation
public @interface Master {

}
