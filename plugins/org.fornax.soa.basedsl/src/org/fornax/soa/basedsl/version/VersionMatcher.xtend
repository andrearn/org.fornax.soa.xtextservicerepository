package org.fornax.soa.basedsl.version

import org.fornax.soa.basedsl.sOABaseDsl.FixedVersionRef
import org.fornax.soa.basedsl.sOABaseDsl.LowerBoundRangeVersionRef
import org.fornax.soa.basedsl.sOABaseDsl.MajorVersionRef
import org.fornax.soa.basedsl.sOABaseDsl.MaxVersionRef
import org.fornax.soa.basedsl.sOABaseDsl.MinVersionRef
import org.fornax.soa.basedsl.sOABaseDsl.Version
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef

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
	
	def dispatch boolean matchesMajorVersion (org.fornax.soa.basedsl.sOABaseDsl.Version v, String majorVer) {
			v.version.toVersionNumber().split("\\.").head() == majorVer;
	}
		
}