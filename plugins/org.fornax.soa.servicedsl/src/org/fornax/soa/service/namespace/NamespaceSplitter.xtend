package org.fornax.soa.service.namespace

import com.google.inject.Inject
import java.util.Set
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.basedsl.sOABaseDsl.Version
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.service.query.type.VersionedTypeFilter
import org.fornax.soa.serviceDsl.BusinessObject
import org.fornax.soa.serviceDsl.Enumeration
import org.fornax.soa.serviceDsl.Exception
import org.fornax.soa.serviceDsl.OrganizationNamespace
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.Type
import org.fornax.soa.serviceDsl.VersionedType

/* 
 * Split SubNamespaces by major major versions of it's owned services, BOs, enums and exceptions
 */
class NamespaceSplitter {
	
	@Inject extension VersionMatcher
	@Inject extension VersionQualifierExtensions
	@Inject extension CommonStringExtensions
	@Inject extension VersionedTypeFilter
	@Inject IQualifiedNameProvider nameProvider
	
	/* 
	 * Split into VersionedDomainNamespace per accounted major version of contained versioned elements
	 */
	def dispatch Set<VersionedDomainNamespace> splitNamespaceByMajorVersion (Object s) {
		newHashSet();
	} 
	
	/* 
	 * Split into VersionedDomainNamespace per accounted major version of contained versioned elements
	 */
	def dispatch Set<VersionedDomainNamespace> splitNamespaceByMajorVersion (SubNamespace s) {
		var Set<VersionedDomainNamespace> verNS = newHashSet();
		
		if (s.types.size > 0 || s.services.size > 0 || s.exceptions.size > 0) {
			verNS.addAll (s.types.map (t|t.createVersionedDomainNamespace()));
			verNS.addAll (s.services.map (svc|svc.createVersionedDomainNamespace()));
			verNS.addAll (s.exceptions.map (e|e.createVersionedDomainNamespace())); 
			return verNS;
		} else {
			return verNS;
		}
	}
	
		
	
	def Set<VersionedDomainNamespace> getAllLatestSubNamespacesByMajorVersion (Set<VersionedDomainNamespace> canditates) { 
		canditates.filter (e|! canditates.exists (
				c|c.version.toMajorVersionNumber() == e.version.toMajorVersionNumber() 
				&& c.version > e.version
			)
		).toSet;
	}
	
	def VersionedDomainNamespace getLatestSubNamespaceByMajorVersion (Set<VersionedDomainNamespace> canditates, int majorVer) { 
		canditates.filter (e|e.version.toMajorVersionNumber() == majorVer)
			.sortBy (e|e.version)
			.reverse()
			.toList().head;
	}
	
	
	
	/* 
	 * Create a VersionedDomainNamespace for a Type
	 */
	def dispatch VersionedDomainNamespace create new VersionedDomainNamespace() createVersionedDomainNamespace (Type type) {
	}
	
	/* 
	 * Create a VersionedDomainNamespace for a Service
	 */
	def VersionedDomainNamespace create new VersionedDomainNamespace() createVersionedDomainNamespace (SubNamespace ns, Version v) {
		if (ns.eContainer   instanceof SubNamespace ) {
			name 		= (ns.eContainer as SubNamespace).name.stripXtextEscapes();
			shortName 	= (ns.eContainer as SubNamespace)?.prefix.stripXtextEscapes();		
		} else {
			name 		= (ns.eContainer as OrganizationNamespace).name.stripXtextEscapes();
			shortName 	= (ns.eContainer as OrganizationNamespace)?.prefix.stripXtextEscapes();
		} 
		subdomain 	= ns;
		fqn 		= nameProvider.getFullyQualifiedName(ns).toString;
		version 	= v.toMajorVersionNumber();
		types 		= ns.allTypesByMajorVersion (v.version.toMajorVersionNumber()).map (t|t as Type).toList;
		services 	= ns.services.filter (t|t.version.matchesMajorVersion (v.version.toMajorVersionNumber())).toList;
		exceptions 	= ns.exceptions.filter (t|t.version.matchesMajorVersion (v.version.toMajorVersionNumber())).toList;
	}

	

	def dispatch VersionedDomainNamespace create new VersionedDomainNamespace() createVersionedDomainNamespace (VersionedType c) {
			if (c.eContainer   instanceof SubNamespace ) {
				name 		= (c.eContainer as SubNamespace).name.stripXtextEscapes();
				shortName 	= (c.eContainer as SubNamespace).prefix?.stripXtextEscapes();		
			} else {
				name 		= (c.eContainer as OrganizationNamespace).name.stripXtextEscapes();
				shortName 	= (c.eContainer as OrganizationNamespace).prefix?.stripXtextEscapes();
			} 
		subdomain 	= c.eContainer;
		fqn 		= nameProvider.getFullyQualifiedName(c.eContainer).toString;
		version 	= c.version.toMajorVersionNumber();
		types 		= (c.eContainer as SubNamespace).allTypesByMajorVersion (c.version.toMajorVersionNumber()).map (t|t as Type).toList;
		services 	= (c.eContainer as SubNamespace).services.filter (t|t.version.matchesMajorVersion (c.version.toMajorVersionNumber())).toList;
		exceptions 	= (c.eContainer as SubNamespace).exceptions.filter (t|t.version.matchesMajorVersion (c.version.toMajorVersionNumber())).toList;
	}
		
//	def dispatch VersionedDomainNamespace create new VersionedDomainNamespace() createVersionedDomainNamespace (org.fornax.soa.serviceDsl.Enumeration c) {
//		if (c.eContainer instanceof SubNamespace)  {
//			name 		= (c.eContainer as SubNamespace).name.stripXtextEscapes();
//			shortName 	= (c.eContainer as SubNamespace).prefix?.stripXtextEscapes();		
//		} else {
//			name 		= (c.eContainer as OrganizationNamespace).name.stripXtextEscapes();
//			shortName 	= (c.eContainer as OrganizationNamespace).prefix?.stripXtextEscapes();
//		}
//		subdomain 	= c.eContainer;
//		fqn 		= nameProvider.getFullyQualifiedName(c.eContainer).toString;
//		version		= c.version.toMajorVersionNumber();
//		types 		= (c.eContainer as SubNamespace).types.filter (typeof (VersionedType)).filter (t|t.version.matchesMajorVersion (c.version.toMajorVersionNumber())).map (t|t as Type).toList;
//		services 	= (c.eContainer as SubNamespace).services.filter (t|t.version.matchesMajorVersion (c.version.toMajorVersionNumber())).toList;
//		exceptions 	= (c.eContainer as SubNamespace).exceptions.filter (t|t.version.matchesMajorVersion (c.version.toMajorVersionNumber())).toList;
//	}
	
	/* 
	 * Create a VersionedDomainNamespace for an Exception
	 */
	def dispatch VersionedDomainNamespace create new VersionedDomainNamespace() createVersionedDomainNamespace (org.fornax.soa.serviceDsl.Exception c) {
		if (c.eContainer instanceof SubNamespace)  {
			name 		= (c.eContainer as SubNamespace).name.stripXtextEscapes();
			shortName 	= (c.eContainer as SubNamespace).prefix?.stripXtextEscapes();		
		} else {
			name 		= (c.eContainer as OrganizationNamespace).name.stripXtextEscapes();
			shortName 	= (c.eContainer as OrganizationNamespace).prefix?.stripXtextEscapes();
		}
		subdomain 	= c.eContainer;
		fqn 		= nameProvider.getFullyQualifiedName(c.eContainer).toString;
		version		= c.version.toMajorVersionNumber();
		types 		= (c.eContainer as SubNamespace).types.filter (typeof (VersionedType)).filter (t|t.version.matchesMajorVersion (c.version.toMajorVersionNumber())).map (t|t as Type).toList;
		services 	= (c.eContainer as SubNamespace).services.filter (t|t.version.matchesMajorVersion (c.version.toMajorVersionNumber())).toList;
		exceptions 	= (c.eContainer as SubNamespace).exceptions.filter (t|t.version.matchesMajorVersion (c.version.toMajorVersionNumber())).toList;
	}
	
	def dispatch VersionedDomainNamespace create new VersionedDomainNamespace() createVersionedDomainNamespace (Service c) {
		if (c.eContainer instanceof SubNamespace)  {
			name 		= (c.eContainer as SubNamespace).name.stripXtextEscapes();
			shortName 	= (c.eContainer as SubNamespace).prefix?.stripXtextEscapes();		
		} else {
			name 		= (c.eContainer as OrganizationNamespace).name.stripXtextEscapes();
			shortName 	= (c.eContainer as OrganizationNamespace).prefix?.stripXtextEscapes();
		}
		subdomain 	= c.eContainer;
		fqn 		= nameProvider.getFullyQualifiedName(c.eContainer).toString;
		version		= c.version.toMajorVersionNumber();
		types 		= (c.eContainer as SubNamespace).types.filter (typeof (VersionedType)).filter (t|t.version.matchesMajorVersion (c.version.toMajorVersionNumber())).map (t|t as Type).toList;
		services 	= (c.eContainer as SubNamespace).services.filter (t|t.version.matchesMajorVersion (c.version.toMajorVersionNumber())).toList;
		exceptions 	= (c.eContainer as SubNamespace).exceptions.filter (t|t.version.matchesMajorVersion (c.version.toMajorVersionNumber())).toList;
	}
}
