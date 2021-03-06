/*
 * generated by Xtext 2.9.1
 */
package org.xkonnex.repo.dsl.solutiondsl.formatting2

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.xkonnex.repo.dsl.basedsl.baseDsl.Import
import org.xkonnex.repo.dsl.basedsl.formatting2.BaseDslFormatter
import org.xkonnex.repo.dsl.solutiondsl.services.SolutionDslGrammarAccess
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.Feature
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.InterfaceRef
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.Model
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.Module
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.Solution

class SolutionDslFormatter extends BaseDslFormatter {
	
	@Inject extension SolutionDslGrammarAccess

	def dispatch void format(Model model, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (Import imports : model.getImports()) {
			imports.format;
		}
		for (Solution solution : model.getSolution()) {
			solution.format;
		}
	}

	def dispatch void format(Solution solution, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		solution.getVersion.format;
		solution.getProductVersion.format;
		solution.getAdditionalInfo.format;
		for (InterfaceRef requires : solution.getRequires()) {
			requires.format;
		}
		for (Feature features : solution.getFeatures()) {
			features.format;
		}
		for (Module modules : solution.getModules()) {
			modules.format;
		}
	}
	
	// TODO: implement for Module, Feature, ServiceRef, CapabilityRef, EventRef
}
