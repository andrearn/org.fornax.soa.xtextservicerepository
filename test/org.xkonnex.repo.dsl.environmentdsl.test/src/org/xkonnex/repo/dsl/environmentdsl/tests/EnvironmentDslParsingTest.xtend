/*
 * generated by Xtext 2.9.1
 */
package org.xkonnex.repo.dsl.environmentdsl.tests

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvModel

@RunWith(XtextRunner)
@InjectWith(EnvironmentDslInjectorProvider)
class EnvironmentDslParsingTest{

	@Inject
	ParseHelper<EnvModel> parseHelper;

	@Test 
	def void loadModel() {
		val result = parseHelper.parse('''
			import org.example.SomeConnector
			
			/*
			 * We define a development environment
			 */
			environment Dev of type Development-Environment {
				
				/*
				 * Host, that can host servers. This one is for the ESB
				 */
				host dev_airport {
					full-qualified-name "airport-dev.example.org"
				}
				
				
				/*
				 * We have an ESB on the dev_airport host
				 */
				esb DevESB {
					host dev_airport
					connectors {
						default SOAP/HTTP defaultSoap {
							endpoint-visibility public
							port 8080
							secured-port 8443
							context-root "sca"
						}
						connector mqtt type MQTTConnector {
							endpoint-visibility private
							protocol-versions "1.1" "1.2"
							configuration {
								^port = 8080
							}
						}
						connector some type SomeConnector {
							endpoint-visibility private 
							configuration {
								^port		= 9090
								monitored 	= true
								something 	= "someValue"
								someEnum 	= two
								nested 		= {
									prop = "nestedValue"
									someList = "first"
									someList = "second"
								}
							}
						}
					}
				}
			}
		''')
		Assert.assertNotNull(result)
	}

}