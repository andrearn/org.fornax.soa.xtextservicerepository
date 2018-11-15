/*
 * generated by Xtext 2.9.1
 */
package org.xkonnex.repo.dsl.businessdsl.formatting2

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.xkonnex.repo.dsl.basedsl.baseDsl.Import
import org.xkonnex.repo.dsl.basedsl.formatting2.BaseDslFormatter
import org.xkonnex.repo.dsl.businessdsl.businessDsl.BusinessFunction
import org.xkonnex.repo.dsl.businessdsl.businessDsl.BusinessModel
import org.xkonnex.repo.dsl.businessdsl.businessDsl.Domain
import org.xkonnex.repo.dsl.businessdsl.businessDsl.Organization
import org.xkonnex.repo.dsl.businessdsl.services.BusinessDslGrammarAccess

class BusinessDslFormatter extends BaseDslFormatter {
	
	@Inject extension BusinessDslGrammarAccess

	def dispatch void format(BusinessModel businessModel, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (Import imports : businessModel.getImports()) {
			imports.format;
		}
		for (Domain domains : businessModel.getDomains()) {
			domains.format;
		}
		for (Organization organizations : businessModel.getOrganizations()) {
			organizations.format;
		}
	}

	def dispatch void format(Organization organization, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (BusinessFunction businessFunctions : organization.getBusinessFunctions()) {
			businessFunctions.format;
		}
	}
	
	// TODO: implement for Domain, BusinessFunction, CapabilityGroup, SimpleCapability, CapabilityVariant, CapabilityVariation, CapabilityReplacement, CapabilityRef, User, Role
}
