/*
* generated by Xtext
*/
package org.fornax.soa.sladsl.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class SLADslAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/fornax/soa/sladsl/parser/antlr/internal/InternalSLADsl.tokens");
	}
}