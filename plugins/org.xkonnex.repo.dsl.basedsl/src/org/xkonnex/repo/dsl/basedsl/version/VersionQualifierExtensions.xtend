package org.xkonnex.repo.dsl.basedsl.version

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.SOABaseDslFactory
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.Version

class VersionQualifierExtensions {
	
	@Inject SOABaseDslFactory dslFactory
	
	def dispatch String toVersionNumber (Integer v) {
		v.toString();
	}
	
	def dispatch String toVersionNumber (String v) {
		v.replaceFirst("\\[", "").replaceFirst("\\]", "");
	}
	
	def dispatch String toVersionNumber (Version v) {
		v.version;
	}
	
	def dispatch String toMajorVersionNumber (Integer v) {
		v.toString();
	}
	
	def dispatch String toMajorVersionNumber (String v) { 
		if  (v != null && v != "" ) v.toVersionNumber().split("\\.").head() else "1";
	}
	
	def dispatch String toMajorVersionNumber (Version v) { 
		if (v != null) v.toVersionNumber().split("\\.").head() else "1";
	}
	
	def dispatch String toVersionPostfix (String v) {
		"v" + v.toMajorVersionNumber();
	}
	
	def dispatch String toVersionPostfix (Integer v) {
		"v" + v.toMajorVersionNumber();
	}
	
	def dispatch String toVersionPostfix (Version v) {
		"v" + v.toMajorVersionNumber();
	}
	
	def String toDefaultVersionPostfix () {
		"v" + toDefaultMajorVersion ();
	}
	
	def String toDefaultMajorVersion () {
		"1";
	}
	
	/*
	 * returns the default version string 1.0
	 */
	def String toDefaultVersion () {
		"1.0";
	}

	def Version create dslFactory.createVersion() toVersion (String v) {
		version = v;
	}
	
	
}