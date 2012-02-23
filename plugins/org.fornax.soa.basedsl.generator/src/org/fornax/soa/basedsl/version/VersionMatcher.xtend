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
	
	@Inject extension VersionQualifierExtensions
	
	def boolean versionMatches (Version v, VersionRef r) { false;}
	
	def boolean versionMatches (Version v, Integer majorVer) {
		v.version.toVersionNumber().split("\\.").get(0) == majorVer.toString() || (v.toVersionNumber().split("\\.").get(0) == majorVer.toString());
	}
		
	def boolean versionMatches (Version v, MinVersionRef r) {
		v.toVersionNumber() == r.minVersion.toVersionNumber() || 
		v.toVersionNumber() > r.minVersion.toVersionNumber();
	}
	
	def boolean versionMatches (Version v, MaxVersionRef r) {
		v.toVersionNumber() == r.maxVersion.toVersionNumber() || 
		v.toVersionNumber() < r.maxVersion.toVersionNumber();
	}

	def boolean versionMatches (Version v, LowerBoundRangeVersionRef r) {
		v.version.toVersionNumber() == r.minVersion.toVersionNumber() || 
		(v.toVersionNumber() > r.minVersion.toVersionNumber() && v.toVersionNumber < r.maxVersion.toVersionNumber());
	}

	def boolean versionMatches (Version v, MajorVersionRef r) {
		v.version.toVersionNumber().split("\\.").get(0) == r.majorVersion.toString() || 
		(v.toVersionNumber().split("\\.").get(0) == r.majorVersion.toString());
	}

	def boolean versionMatches (Version v, FixedVersionRef r) {
		v.toVersionNumber() == r.fixedVersion.toVersionNumber();
	}
	
	def boolean matchesMajorVersion (org.fornax.soa.basedsl.sOABaseDsl.Version v, String majorVer) {
			v.version.toVersionNumber().split("\\.").head() == majorVer;
	}
	
}