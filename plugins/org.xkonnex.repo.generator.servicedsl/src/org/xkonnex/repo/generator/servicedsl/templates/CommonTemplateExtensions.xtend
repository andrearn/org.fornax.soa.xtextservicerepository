package org.xkonnex.repo.generator.servicedsl.templates

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.LowerBoundRangeVersionRef
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.MaxVersionRef
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.MinVersionRef
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.VersionRef
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState

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