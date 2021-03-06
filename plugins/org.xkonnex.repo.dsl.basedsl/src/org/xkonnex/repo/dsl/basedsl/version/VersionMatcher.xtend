package org.xkonnex.repo.dsl.basedsl.version

import org.xkonnex.repo.dsl.basedsl.baseDsl.FixedVersionRef
import org.xkonnex.repo.dsl.basedsl.baseDsl.LowerBoundRangeVersionRef
import org.xkonnex.repo.dsl.basedsl.baseDsl.MajorVersionRef
import org.xkonnex.repo.dsl.basedsl.baseDsl.MaxVersionRef
import org.xkonnex.repo.dsl.basedsl.baseDsl.MinVersionRef
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version
import org.xkonnex.repo.dsl.basedsl.baseDsl.VersionRef

import com.google.inject.Inject

class VersionMatcher {
	
	@Inject
	private extension VersionQualifierExtensions
	
	def dispatch boolean versionMatches (Version v, VersionRef r) { false;}
	
	def dispatch boolean versionMatches (Version v, Integer majorVer) {
		v.version.toVersionNumber().split("\\.").get(0) == majorVer.toString() || (v.toVersionNumber().split("\\.").get(0) == majorVer.toString());
	}
		
	def dispatch boolean versionMatches (Version v, MinVersionRef r) {
		VersionComparator::compare(v.toVersionNumber, r.minVersion.toVersionNumber()) >= 0
	}
	
	def dispatch boolean versionMatches (Version v, MaxVersionRef r) {
		VersionComparator::compare(v.toVersionNumber, r.maxVersion.toVersionNumber()) < 0
	}

	def dispatch boolean versionMatches (Version v, LowerBoundRangeVersionRef r) {
		VersionComparator::compare(v.toVersionNumber, r.minVersion.toVersionNumber()) >= 0
		&&	VersionComparator::compare(v.toVersionNumber, r.maxVersion.toVersionNumber()) < 0
	}

	def dispatch boolean versionMatches (Version v, MajorVersionRef r) {
		v.version.toVersionNumber().split("\\.").get(0) == r.majorVersion.toString() || 
		(v.toVersionNumber().split("\\.").get(0) == r.majorVersion.toString());
	}

	def dispatch boolean versionMatches (Version v, FixedVersionRef r) {
		v.toVersionNumber() == r.fixedVersion.toVersionNumber();
	}
	
	def dispatch boolean matchesMajorVersion (org.xkonnex.repo.dsl.basedsl.baseDsl.Version v, String majorVer) {
			v.version.toVersionNumber().split("\\.").head() == majorVer;
	}
		
}