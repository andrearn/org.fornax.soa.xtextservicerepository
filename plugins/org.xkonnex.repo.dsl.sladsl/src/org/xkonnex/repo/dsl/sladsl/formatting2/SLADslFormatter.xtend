/*
 * generated by Xtext 2.9.1
 */
package org.xkonnex.repo.dsl.sladsl.formatting2

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.xkonnex.repo.dsl.basedsl.baseDsl.AssetRef
import org.xkonnex.repo.dsl.basedsl.formatting2.BaseDslFormatter
import org.xkonnex.repo.dsl.sladsl.sLADsl.Assertion
import org.xkonnex.repo.dsl.sladsl.sLADsl.Party
import org.xkonnex.repo.dsl.sladsl.sLADsl.PriorityDeclaration
import org.xkonnex.repo.dsl.sladsl.sLADsl.Report
import org.xkonnex.repo.dsl.sladsl.sLADsl.SLA
import org.xkonnex.repo.dsl.sladsl.sLADsl.SecurityRequirement
import org.xkonnex.repo.dsl.sladsl.sLADsl.ServiceQualityProperty
import org.xkonnex.repo.dsl.sladsl.sLADsl.SlaModel
import org.xkonnex.repo.dsl.sladsl.services.SLADslGrammarAccess

class SLADslFormatter extends BaseDslFormatter {
	
	@Inject extension SLADslGrammarAccess

	def dispatch void format(SlaModel slaModel, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (SLA agreements : slaModel.getAgreements()) {
			agreements.format;
		}
		for (Assertion assertions : slaModel.getAssertions()) {
			assertions.format;
		}
	}

	def dispatch void format(SLA sLA, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		sLA.getVersion.format;
		for (Party parties : sLA.getParties()) {
			parties.format;
		}
		for (PriorityDeclaration priorities : sLA.getPriorities()) {
			priorities.format;
		}
		for (AssetRef appliesTo : sLA.getAppliesTo()) {
			appliesTo.format;
		}
		sLA.getCosts.format;
		for (ServiceQualityProperty serviceQualityProperties : sLA.getServiceQualityProperties()) {
			serviceQualityProperties.format;
		}
		for (SecurityRequirement securityRequirements : sLA.getSecurityRequirements()) {
			securityRequirements.format;
		}
		sLA.getEscalationProcedure.format;
		for (Report reports : sLA.getReports()) {
			reports.format;
		}
	}
	
	// TODO: implement for Assertion, Cost, Availability, Throughput, Latency, MaxDownTime, CapacityRequirement, AccuracyRequirement, AuthenticationRequirement, SigningRequirement, EncryptionRequirement, CustomerParty, ProviderParty, ThirdParty, AvailabilityAssertion, LatencyAssertion
}
