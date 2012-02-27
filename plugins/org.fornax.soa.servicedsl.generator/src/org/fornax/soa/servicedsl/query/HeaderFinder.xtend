package org.fornax.soa.servicedsl.query

/* headers.ext */
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.Operation
import org.fornax.soa.serviceDsl.Service
import java.util.List
import java.util.Set
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.VersionedDomainNamespace
import com.google.inject.Inject
import org.fornax.soa.servicedsl.domain.NamespaceSplitter
import org.fornax.soa.servicedsl.query.namespace.NamespaceQuery
import org.fornax.soa.servicedsl.query.type.LatestMatchingTypeFinder
import org.fornax.soa.servicedsl.query.type.TypesByLifecycleStateFinder
import org.fornax.soa.profiledsl.sOAProfileDsl.Type
import org.fornax.soa.basedsl.sOABaseDsl.AbstractType
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef
import org.fornax.soa.profiledsl.sOAProfileDsl.Property
import java.util.HashSet
import java.util.ArrayList
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.fornax.soa.profiledsl.sOAProfileDsl.ClassRef
import org.fornax.soa.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.servicedsl.query.type.VersionedTypeFilter

class HeaderFinder {
	
	@Inject extension VersionMatcher
	@Inject extension VersionQualifierExtensions
	@Inject extension NamespaceSplitter
	@Inject extension NamespaceQuery
	@Inject extension LatestMatchingTypeFinder
	@Inject extension org.fornax.soa.servicedsl.templates.xsd.SchemaNamespaceExtensions
	@Inject extension VersionedTypeFilter
	
	
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
			p.messaging.defaultHeader.header;
		}
	}
	
	def dispatch List<MessageHeader> getLatestMajorVersions (SOAProfile p) {
		p.messaging.messageHeaders;
	}
	
	
	
	def dispatch Set<TechnicalNamespace> allImportedSubNamespaces (Type t) {
		t.allReferencedVersionedTypes ().filter (typeof (VersionedType)).map(e|e.findSubdomain()).toSet();
	}
	
	
	
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (org.fornax.soa.serviceDsl.Type t) {
		t.allReferencedVersionedTypes().map (e|e.createVersionedDomainNamespace()).toSet();
	}
		
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (VersionedDomainNamespace s) { 
		(s.subdomain as SubNamespace).allImportedVersionedNS(s.version);
	}
	
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (TechnicalNamespace s, String nameSpaceMajorVersion) {
		s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.Class))
		.map (e|e.allReferencedVersionedTypes()).flatten
		.map (v|v.createVersionedDomainNamespace()).toSet;
	}
	
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (MessageHeader t, String nameSpaceMajorVersion) {
		t.allReferencedVersionedTypes().map (e|e.createVersionedDomainNamespace()).toSet();
	}
		
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (org.fornax.soa.profiledsl.sOAProfileDsl.Class t) {
		t.properties.filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.Property))
			.map (p|p.type.allReferencedVersionedTypes()).flatten.map (e|e.createVersionedDomainNamespace()).toSet();
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
		t.allReferencedTypeRefs ().filter (typeof (VersionedTypeRef)).map(e|e.selectLatestMatchingType () as VersionedType).toList;
	}
		
	def dispatch List<VersionedType> allReferencedVersionedTypes (MessageHeader t)  { 
		t.parameters.map (p|p.type).filter (typeof (VersionedTypeRef)).map (v|v.type as Type)
			.map (e|e.allReferencedTypeRefs ()).filter (typeof (VersionedTypeRef))
				.map (r|r.selectLatestMatchingType ()).filter (typeof (VersionedType)).toList;
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
		if (t.superClass != null) { 	
			reTypes.addAll (t.properties.filter (typeof (Property)).map (p|p.type));
			reTypes.add (t.superClass as TypeRef);
			reTypes;
		} else {
			t.properties.filter (typeof (Property)).map (p|p.type);
		}
		reTypes.toList;
	}
			
	def dispatch List<TypeRef> allReferencedTypeRefs (MessageHeader t) {
		t.parameters.map (p|p.type).toList;
	}
	
	
	
	def dispatch VersionedType selectLatestMatchingType (VersionedTypeRef ref) {
		ref.type.findSubdomain().types.filter (typeof (VersionedType))
		.filter (t|t.name == ref.type.name && t.version.versionMatches (ref.versionRef))
		.sortBy(e|e.version.version).last();
	}
		
	def dispatch TechnicalNamespace findSubdomain (VersionedType c) {
		if (c.eContainer instanceof TechnicalNamespace) {
			c.eContainer as TechnicalNamespace;
		}
	}
	
	
	
	def dispatch boolean isLatestMatchingType (org.fornax.soa.profiledsl.sOAProfileDsl.Class t, Integer majorVersion) {
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
	
	def dispatch String toTypeNameRef (TypeRef t, VersionedDomainNamespace currNs) {}
	
	def dispatch String toTypeNameRef (ClassRef t, VersionedDomainNamespace currNs) {
		if (t.type.findSubdomain().toUnversionedNamespace() == currNs.subdomain.toUnversionedNamespace()  && currNs.version.toVersion().versionMatches(t.versionRef)) {
			"tns:" +t.type.name
		} else {
			t.type.findSubdomain().toShortName() + t.type.version.toMajorVersionNumber() + ":" +t.type.name;
		}
	}
}