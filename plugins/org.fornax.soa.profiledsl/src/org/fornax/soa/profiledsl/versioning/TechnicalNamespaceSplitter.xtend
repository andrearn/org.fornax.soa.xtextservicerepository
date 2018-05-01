package org.fornax.soa.profiledsl.versioning

import com.google.inject.Inject
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.basedsl.CommonEObjectExtensions
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.fornax.soa.profiledsl.sOAProfileDsl.Type
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType

class TechnicalNamespaceSplitter {

	
	@Inject extension VersionQualifierExtensions
	@Inject extension CommonStringExtensions
	@Inject extension CommonEObjectExtensions
	
	
	/* 
	 * Split into VersionedDomainNamespace per accounted major version of contained versioned elements
	 */
	def Set<VersionedTechnicalNamespace> toVersionedTechnicalNamespaces (TechnicalNamespace s) {
		 if (s.types.size > 0 )
		 	s.types.map (t|t.createVersionedTechnicalNamespace()).toSet()
		 else 
		 	newHashSet();
	}
	
	
	def Set<VersionedTechnicalNamespace> getAllLatestSubNamespacesByMajorVersion (Set<VersionedTechnicalNamespace> canditates) { 
		canditates.filter (e|! canditates.exists (
				c|c.version.toMajorVersionNumber() == e.version.toMajorVersionNumber() 
				&& c.version > e.version
			)
		).toSet;
	}
	
	def VersionedTechnicalNamespace getLatestSubNamespaceByMajorVersion (Set<VersionedTechnicalNamespace> canditates, int majorVer) { 
		canditates.filter (e|e.version.toMajorVersionNumber() == majorVer)
			.sortBy (e|e.version)
			.reverse()
			.toList().head;
	}
	
		
	def dispatch VersionedTechnicalNamespace create new VersionedTechnicalNamespace() createVersionedTechnicalNamespace (EObject c) {
		
	}
		
	def dispatch VersionedTechnicalNamespace create new VersionedTechnicalNamespace() createVersionedTechnicalNamespace (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType c) {
		if (c.eContainer instanceof TechnicalNamespace) {
			name 		= (c.eContainer as org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace).name.stripXtextEscapes();
			shortName 	= (c.eContainer as TechnicalNamespace).prefix?.stripXtextEscapes();		
		} 
		else 	
		{
			name 		= (c.eContainer as org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace).name.stripXtextEscapes();
			shortName 	= (c.eContainer as org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace).prefix.stripXtextEscapes();
		} 
		namespace 		= c.eContainer as TechnicalNamespace;
		fqn 			= c.eContainer.fqn();
		version 		= c.version.toMajorVersionNumber();
	}
	
	def dispatch VersionedTechnicalNamespace create new VersionedTechnicalNamespace() createVersionedTechnicalNamespace (org.fornax.soa.profiledsl.sOAProfileDsl.Type c) {
		if (c.eContainer instanceof TechnicalNamespace) {
			name 		= (c.eContainer as org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace).name.stripXtextEscapes();
			shortName 	= (c.eContainer as TechnicalNamespace).prefix?.stripXtextEscapes();		
		} 
		else 	
		{
			name 		= (c.eContainer as org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace).name.stripXtextEscapes();
			shortName 	= (c.eContainer as org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace).prefix.stripXtextEscapes();
		} 
		namespace 		= c.eContainer as TechnicalNamespace;
		fqn 			= c.eContainer.fqn();
	}
	
}