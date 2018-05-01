package org.fornax.soa.servicedsl.generator.templates

import com.google.inject.Inject
import org.fornax.soa.basedsl.sOABaseDsl.LowerBoundRangeVersionRef
import org.fornax.soa.basedsl.sOABaseDsl.MaxVersionRef
import org.fornax.soa.basedsl.sOABaseDsl.MinVersionRef
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState

class CommonTemplateExtensions {
	
	@Inject extension VersionQualifierExtensions

	def dispatch String versionRangeText(VersionRef v) {
		"";
	}
	
	def dispatch String versionRangeText(MinVersionRef v) {
		">= " + v.minVersion.toVersionNumber();
	}
	
	def dispatch String versionRangeText(LowerBoundRangeVersionRef v) {
		v.minVersion.toVersionNumber() + " to <" + v.maxVersion.toVersionNumber();
	}
	
	def dispatch String versionRangeText(MaxVersionRef v) {
		"<= " + v.maxVersion.toVersionNumber();
	}
	
	def String toStateName (LifecycleState state) {
		if (state != null)
			state.name
		else
			"undefined"
	}
	
}