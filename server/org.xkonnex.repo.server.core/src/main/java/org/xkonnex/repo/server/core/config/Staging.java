package org.xkonnex.repo.server.core.config;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

@BindingAnnotation
@Target ({FIELD, METHOD, PARAMETER})
@Retention (RetentionPolicy.RUNTIME)
public @interface Staging {

}
