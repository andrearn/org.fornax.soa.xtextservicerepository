package org.xkonnex.repo.dsl.profiledsl.versioning

import com.google.inject.Inject
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.basedsl.CommonEObjectExtensions
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Type
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedType

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
		
	def dispatch VersionedTechnicalNamespace create new VersionedTechnicalNamespace() createVersionedTechnicalNamespace (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedType c) {
		if (c.eContainer instanceof TechnicalNamespace) {
			name 		= (c.eContainer as org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TechnicalNamespace).name.stripXtextEscapes();
			shortName 	= (c.eContainer as TechnicalNamespace).prefix?.stripXtextEscapes();		
		} 
		else 	
		{
			name 		= (c.eContainer as org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.OrganizationNamespace).name.stripXtextEscapes();
			shortName 	= (c.eContainer as org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.OrganizationNamespace).prefix.stripXtextEscapes();
		} 
		namespace 		= c.eContainer as TechnicalNamespace;
		fqn 			= c.eContainer.fqn();
		version 		= c.version.toMajorVersionNumber();
	}
	
	def dispatch VersionedTechnicalNamespace create new VersionedTechnicalNamespace() createVersionedTechnicalNamespace (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Type c) {
		if (c.eContainer instanceof TechnicalNamespace) {
			name 		= (c.eContainer as org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TechnicalNamespace).name.stripXtextEscapes();
			shortName 	= (c.eContainer as TechnicalNamespace).prefix?.stripXtextEscapes();		
		} 
		else 	
		{
			name 		= (c.eContainer as org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.OrganizationNamespace).name.stripXtextEscapes();
			shortName 	= (c.eContainer as org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.OrganizationNamespace).prefix.stripXtextEscapes();
		} 
		namespace 		= c.eContainer as TechnicalNamespace;
		fqn 			= c.eContainer.fqn();
	}
	
}