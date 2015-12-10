package org.xkonnex.repo.dsl.environmentdsl.converter;

import javax.inject.Inject;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;

public class EnvironmentDslValueConverterService extends
		DefaultTerminalConverters {
	
	@Inject QualifiedNameValueConverter qualifiedNameValueConverter;
	
	@ValueConverter(rule="QualifiedName")
	public IValueConverter<String> QualifiedName() {
		return qualifiedNameValueConverter;
	}
}
