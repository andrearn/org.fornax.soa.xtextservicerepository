package org.fornax.soa.service.query

import com.google.inject.Inject
import java.util.ArrayList
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.basedsl.sOABaseDsl.AbstractType
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader
import org.fornax.soa.profiledsl.sOAProfileDsl.Property
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.fornax.soa.profiledsl.sOAProfileDsl.Type
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef
import org.fornax.soa.profiledsl.versioning.TechnicalNamespaceSplitter
import org.fornax.soa.profiledsl.versioning.VersionedTechnicalNamespace
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.service.namespace.NamespaceSplitter
import org.fornax.soa.service.query.namespace.NamespaceImportQueries
import org.fornax.soa.service.query.type.VersionedTypeFilter
import org.fornax.soa.serviceDsl.Operation
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace

/* 
 * Find the most specific message header declaration to be used by a service operation
 */
class HeaderFinder {
	
	@Inject extension VersionMatcher
	@Inject extension TechnicalNamespaceSplitter
	@Inject extension VersionedTypeFilter
	@Inject NamespaceSplitter namespaceSplitter
	@Inject NamespaceImportQueries nsImportQueries
	
	
	def dispatch MessageHeader findBestMatchingHeader (EObject o, SOAProfile p ) { 
		p.messaging.defaultHeader.header;
	}
		
	def dispatch MessageHeader findBestMatchingHeader (Operation o, SOAProfile p ) {
		if (o.messageHeader?.header != null) { 
			o.messageHeader.header;
		} else {
			o.eContainer.findBestMatchingHeader (p);
		}
	}
			
	def dispatch MessageHeader findBestMatchingHeader (Service s, SOAProfile p ) {
		if (s.messageHeader?.header != null) { 
			s.messageHeader.header;
		} else {
			s.eContainer.findBestMatchingHeader (p);
		}
	}
	
	def List<MessageHeader> getLatestMajorVersions (SOAProfile p) {
		p.messaging.messageHeaders;
	}
	
	
	
	def Set<TechnicalNamespace> allImportedSubNamespaces (Type t) {
		t.allReferencedVersionedTypes ().filter (typeof (VersionedType)).map(e|e.findSubdomain()).toSet();
	}
	
	
	
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (org.fornax.soa.serviceDsl.Type t) {
		t.allReferencedVersionedTypes().map (e| namespaceSplitter.createVersionedDomainNamespace(e)).toSet();
	}
		
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (VersionedDomainNamespace s) { 
		nsImportQueries.allImportedVersionedNS((s.subdomain as SubNamespace), s.version);
	}
	def dispatch Set<VersionedTechnicalNamespace> allImportedVersionedNS (VersionedTechnicalNamespace s) { 
		s.namespace.allImportedVersionedNS(s.version);
	}
	
	def dispatch Set<VersionedTechnicalNamespace> allImportedVersionedNS (TechnicalNamespace s, String nameSpaceMajorVersion) {
		s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.Class))
		.map (e|e.allReferencedVersionedTypes()).flatten
		.map (v|v.createVersionedTechnicalNamespace()).toSet;
	}
	
	def dispatch Set<VersionedTechnicalNamespace> allImportedVersionedNS (MessageHeader t, String nameSpaceMajorVersion) {
		t.allReferencedVersionedTypes().map (e|e.createVersionedTechnicalNamespace()).toSet();
	}
		
	def dispatch Set<VersionedTechnicalNamespace> allImportedVersionedNS (org.fornax.soa.profiledsl.sOAProfileDsl.Class t) {
		t.properties.filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.Property))
			.map (p|p.type.allReferencedVersionedTypes()).flatten.map (e|e.createVersionedTechnicalNamespace()).toSet();
	}
	
	
	
	def dispatch List<org.fornax.soa.serviceDsl.VersionedType> allReferencedVersionedTypes (AbstractType t) {
		newArrayList();
	}
	
	def dispatch List<org.fornax.soa.serviceDsl.VersionedType> allReferencedVersionedTypes (org.fornax.soa.serviceDsl.Type t) {
		newArrayList();
	}
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (Type t) {
		newArrayList();
	}
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (TypeRef t) {
		newArrayList();
	}
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (org.fornax.soa.profiledsl.sOAProfileDsl.Class t) {
		val typeRefs = t.allReferencedTypeRefs ().filter (typeof (VersionedTypeRef));
		typeRefs.map(e|e.selectLatestMatchingType () as VersionedType).toList;
	}
		
	def dispatch List<VersionedType> allReferencedVersionedTypes (MessageHeader t)  { 
		val types = t.parameters.map (p|p.type).filter (typeof (VersionedTypeRef)).map (v|v.type as Type);
		val transitiveTypeRefs = types.map (e|e.allReferencedTypeRefs ()).flatten.filter (typeof (VersionedTypeRef))
		transitiveTypeRefs.map (r|r.selectLatestMatchingType ()).filter (typeof (VersionedType)).toList;
	}	
	
	
	def dispatch List<TypeRef> allReferencedTypeRefs (Type t) {
		new ArrayList<TypeRef>();
	}
	def dispatch List<TypeRef> allReferencedTypeRefs (TypeRef t) {
		new ArrayList<TypeRef>();
	}
	
	def dispatch List<TypeRef> allReferencedTypeRefs (VersionedType t) {
		new ArrayList<TypeRef>();
	}
	
	def dispatch List<TypeRef> allReferencedTypeRefs (org.fornax.soa.profiledsl.sOAProfileDsl.Class t) {
		var reTypes = new HashSet<TypeRef>();
		var propTypes = t.properties.filter (typeof (Property)).map (p|p.type);
		reTypes.addAll (propTypes);
		if (t.superClass != null) { 	
			reTypes.add (t.superClass as TypeRef);
		}
		reTypes.toList;
	}
			
	def dispatch List<TypeRef> allReferencedTypeRefs (MessageHeader t) {
		t.parameters.map (p|p.type).toList;
	}
	
	
	
	def VersionedType selectLatestMatchingType (VersionedTypeRef ref) {
		ref.type.findSubdomain().types.filter (typeof (VersionedType))
		.filter (t|t.name == ref.type.name && t.version.versionMatches (ref.versionRef))
		.sortBy(e|e.version.version).last();
	}
		
	def TechnicalNamespace findSubdomain (VersionedType c) {
		if (c.eContainer instanceof TechnicalNamespace) {
			c.eContainer as TechnicalNamespace;
		}
	}
	
	
	
	def boolean isLatestMatchingType (org.fornax.soa.profiledsl.sOAProfileDsl.Class t, Integer majorVersion) {
		var canditateClasses = (t.eContainer as TechnicalNamespace).types
			.filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.Class))
			.filter (e|e.name == t.name).toList;
		return (findLatestMatchingClass (canditateClasses, majorVersion) == t);
	}
		
	def private Type findLatestMatchingClass (List<org.fornax.soa.profiledsl.sOAProfileDsl.Class> types, Integer majorVersion) {
		types.filter (e|e.version.versionMatches (majorVersion))
		.sortBy(e|e.version.version).last();
	}
	
	def dispatch boolean isMany (TypeRef t) {
		false;
	}
	def dispatch boolean isMany (VersionedTypeRef t) {
		t.many;
	}
}