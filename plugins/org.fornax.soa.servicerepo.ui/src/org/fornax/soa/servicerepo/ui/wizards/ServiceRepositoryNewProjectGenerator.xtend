package org.fornax.soa.servicerepo.ui.wizards

import org.eclipse.xtext.generator.IFileSystemAccess

class ServiceRepositoryNewProjectGenerator {
	
	def generateProject (IFileSystemAccess fsa) {
		generateProfile (fsa)
	}
	
	def generateProfile (IFileSystemAccess fsa) {
		val content = '''
			datatype int
			datatype byte
			datatype long
			datatype float
			datatype double
			datatype string
			datatype char
			datatype date
			datatype datetime
			datatype boolean
			datatype decimal
			datatype base64Binary
			datatype binary
			datatype anyType
			
			soa-profile ExampleOrgSOA {
				scope "Example.org"
				
				lifecycle DefaultLifecycle {
					initial state proposed {
						qualifies-for Local-Environment
						-> defined 
					}
					state defined {
						qualifies-for Local-Environment, Development-Environment
						-> development
						-> proposed
					}
					state development {
						qualifies-for Local-Environment, Development-Environment
						-> test
						-> proposed
					}
					state test {
						qualifies-for Local-Environment, Development-Environment, Test-Environment
						-> productive
						-> development
						-> proposed
					}
					state productive {
						qualifies-for Local-Environment, Development-Environment, Test-Environment, Staging-Environment, Production-Environment
						-> deprecated
						-> test
						-> proposed
					}
					state deprecated {
						qualifies-for Local-Environment, Development-Environment, Test-Environment, Staging-Environment, Production-Environment
						-> retired
						-> productive
						-> proposed
					}
					end state retired {
						-> proposed
					}
				}
				
				
				service-categories {
					^activity base-category activity
					^entity base-category entity
					^process base-category process
					^rule base-category rule
					^utility base-category utility
				}
			
				// define messaging rules like message headers here in the messaging section
				
				
				design-rules {
					
					internal-namespace-rule internal {
						internal-qualifier must-contain-internal-qualifier
						qualifying-name internal
					}
					
					types {
						extendable-properties
						extendable-XML-attributes
						allow-enums
						allow-inheritance
						allow-polymorphism
					}
					
					services {
						operations {
							allow-polymorphism
						}
					}	
				}
				
				// major version number is part of the namespace
				versioning-strategy namespace-based
			}
		'''
		fsa.generateFile("model/profile.profdsl", content)
	}
	
}