package org.fornax.soa.servicedsl.templates.xsd

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.ArrayList
import java.util.List
import java.util.Set
import org.eclipse.emf.common.util.TreeIterator
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.basedsl.CommonEObjectExtensions
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.fornax.soa.serviceDsl.BusinessObjectRef
import org.fornax.soa.serviceDsl.DomainNamespace
import org.fornax.soa.serviceDsl.EnumTypeRef
import org.fornax.soa.serviceDsl.InternalNamespace
import org.fornax.soa.serviceDsl.OrganizationNamespace
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.ServiceModel
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.VersionedDomainNamespace
import org.fornax.soa.servicedsl.query.ExceptionFinder
import org.fornax.soa.servicedsl.query.ServiceFinder
import org.fornax.soa.servicedsl.query.namespace.NamespaceQuery
import org.fornax.soa.servicedsl.query.type.TypesByLifecycleStateFinder


/*
 * domains.ext
 */
class SchemaNamespaceExtensions {
	
	extension CommonEObjectExtensions

	@Inject extension CommonStringExtensions
	@Inject extension VersionQualifierExtensions
	@Inject extension NamespaceQuery
	@Inject extension TypesByLifecycleStateFinder
	@Inject extension ServiceFinder
	@Inject extension ExceptionFinder
	
	@Inject @Named ("forceRelativePaths") 
	Boolean forceRelativePaths
	
	@Inject @Named ("useNestedPaths") 
	Boolean useNestedPaths
	
	
	def boolean forceRelativePaths () {
		true;
	}
	
	def dispatch String fqn (Object o) {
		null;
	}
	
	def dispatch String fqn (OrganizationNamespace s) {
		s.name.stripXtextEscapes();
	}

	def dispatch List<TechnicalNamespace> toNamespacePath (Object o) {
		newArrayList();
	}

	def dispatch String toUnversionedNamespace (Object o) {
		"unknown";
	}

	def dispatch String fqn (SubNamespace s) {
		(s.findOrgNamespace() as OrganizationNamespace).name.stripXtextEscapes() + "."
			 + toNamespacePath(newArrayList(s)).map(n|n.name.stripXtextEscapes()).join(".");
	}
	
	def dispatch String toNamespace (Object o) {
		null;
	}
	
	def dispatch String toNamespace (OrganizationNamespace domain) {
		var ns = domain.toUnversionedNamespace() + "/" + domain.toVersionPostfix();
		if (domain.hasTrailingSlash() ) {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}
	
	def dispatch String toNamespace (SubNamespace leafDomainNamespace) { 
		var ns = leafDomainNamespace.toUnversionedNamespace() +  "/" + leafDomainNamespace.toVersionPostfix();
		if (leafDomainNamespace.hasTrailingSlash() ) {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}
	
	def dispatch String toNamespace (VersionedDomainNamespace s) { 
		var ns = s.subdomain.toUnversionedNamespace().stripXtextEscapes() + "/" + s.toVersionPostfix(); 
		if (s.subdomain.hasTrailingSlash() )  {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}
	

	def dispatch boolean hasTrailingSlash (Object o) {
		true;
	}


	def dispatch String toVersionPostfix (Object o) { 
		null;
	}
	
	def dispatch String toVersionPostfix (OrganizationNamespace d) {
		toDefaultVersionPostfix();
	}
	
	def dispatch String toVersionPostfix (DomainNamespace s) {
		if (s.version != null && s.version.version != null ) 
			s.version.toVersionPostfix() 
		else
			toDefaultVersionPostfix();
	}
		
	def dispatch String toVersionPostfix (VersionedDomainNamespace s) {
		if (s.version != null) 
			s.version.toVersionPostfix() 
		else
			toDefaultVersionPostfix();
	}

	
	def dispatch String toUnversionedNamespace (OrganizationNamespace domain) {
		"http://" + domain.name.split(".").reverse().join (".");
	}
	
	def dispatch String toUnversionedNamespace (SubNamespace leafDomainNamespace) {
		"http://" + 
		leafDomainNamespace.findOrgNamespace().toHostPart() + "/" + 
		newArrayList (leafDomainNamespace).toSubNamespacePath().map (n|n.name.stripXtextEscapes().replaceAll("\\.","/")).join("/");
	}
	
	def dispatch String toUnversionedNamespace (VersionedDomainNamespace s) {
		s.subdomain.toUnversionedNamespace();
	}

	def dispatch String toHostPart (OrganizationNamespace d) {
		 d.name.split("\\.").reverse().join(".");
	}
	
	def List<SubNamespace> toSubNamespacePath (List<SubNamespace> domList) {
		if (domList.last().eContainer instanceof SubNamespace) {
			domList.add (domList.last().eContainer as SubNamespace) 
			toSubNamespacePath (domList);
			return domList;
		} else { 
			return domList.filter (typeof (SubNamespace)).toList().reverse();
		}
	}




	/*List[sOAProfileDsl::TechnicalNamespace] getNamespacePath (List[SubNamespace] nsList) : 
		SubNamespace.isInstance(nsList.last().eContainer) ? 
			getNamespacePath (nsList.add ((SubNamespace)nsList.last().eContainer) -> nsList)
		: 
			nsList.typeSelect(SubNamespace).reverse();*/
		
	def dispatch List<TechnicalNamespace> toNamespacePath (List<TechnicalNamespace> nsList) { 
		if (nsList.last().eContainer instanceof TechnicalNamespace) {
			nsList.add ((nsList.toList().last().eContainer  as TechnicalNamespace));
			toNamespacePath (nsList);
		} else {
			nsList.filter (typeof (TechnicalNamespace)).toList.reverse();
		}
			
	}
	

		
	def dispatch String toShortName(SubNamespace s) {
		s?.prefix;
	}
	
	def dispatch String toShortName(TechnicalNamespace s) {
		if (s.prefix == null ) s.toPrefix() else s.prefix;
	}


	def dispatch String getRegisteredUrl (Service s, String registryUrl) { 
		if (registryUrl != null && !forceRelativePaths() ) 
			registryUrl + "/" + s.getFileNameFragment() 
		else
			s.getFileNameFragment();
	}
		
	def dispatch String getRegisteredUrl (OrganizationNamespace s, String registryUrl) { 
		if (registryUrl != null && !forceRelativePaths() ) 
			registryUrl + "/" + s.getFileNameFragment() 
		else
			s.getFileNameFragment();
	}
			
	def dispatch String getRegisteredUrl (DomainNamespace s, String registryUrl) { 
		if (registryUrl != null && !forceRelativePaths() ) 
			registryUrl + "/" + s.getFileNameFragment() 
		else
			s.getFileNameFragment();
	} 
	
	def dispatch String getRegisteredUrl (InternalNamespace s, String registryUrl) {
		if (registryUrl != null && !forceRelativePaths() ) 
			registryUrl + "/" + s.getFileNameFragment() 
		else
			s.getFileNameFragment();
	}
	 
	def dispatch String getRegisteredUrl (TechnicalNamespace s, String registryUrl) { 
		if (registryUrl != null && !forceRelativePaths() ) 
			registryUrl + "/" + s.getFileNameFragment() 
		else
			s.getFileNameFragment();
	} 
	def dispatch String getRegisteredUrl (VersionedDomainNamespace s, String registryUrl) { 
		if (registryUrl != null && !forceRelativePaths() ) 
			registryUrl + "/" +s.getFileNameFragment() 
		else
			s.getFileNameFragment(); 
	}
	
	
	def dispatch String getRegisteredUrl (Object o, Void registryUrl) {
		null;
	}
	
	def dispatch String getRegisteredUrl (Service s, Void registryUrl) { 
		s.getFileNameFragment();
	}
		
	def dispatch String getRegisteredUrl (OrganizationNamespace s, Void registryUrl) { 
		s.getFileNameFragment(); 
	}
	
	def dispatch String getRegisteredUrl (DomainNamespace s, Void registryUrl) {
		s.getFileNameFragment();
	}
	
	def dispatch String getRegisteredUrl (InternalNamespace s, Void registryUrl) { 
		s.getFileNameFragment(); 
	}
	
	def dispatch String getRegisteredUrl (TechnicalNamespace s, Void registryUrl) {
		s.getFileNameFragment();
	}
	
	def dispatch String getRegisteredUrl (VersionedDomainNamespace s, Void registryUrl) { 
		s.getFileNameFragment();
	}
	
	
	def String getFileNameFragment (Object s) {
		null;
	}
	
	def dispatch String toFileNameFragment (Service s) { 
		s.eContainer.getFileNameFragment().replaceAll("\\." , "-") + "-" + s.name.stripXtextEscapes() + "-" + s.version.toVersionPostfix();
	}
	
	def dispatch String toFileNameFragment (OrganizationNamespace s) {
		s.findOrgNamespace().shorten().replaceAll("\\." , "-");
	}
	
	def dispatch String toFileNameFragment (DomainNamespace s) {
		val namespaces = new ArrayList<SubNamespace>();
		namespaces.add (s);
		s.findOrgNamespace().shorten().replaceAll("\\." , "-") + "-" + toSubNamespacePath (namespaces).map(n|n.name.stripXtextEscapes().replaceAll("\\." , "-")).join("-");
	}
	
	def dispatch String toFileNameFragment (InternalNamespace s) {
		val namespaces = new ArrayList<SubNamespace>();
		namespaces.add (s);
		s.findOrgNamespace().shorten().replaceAll("\\." , "-") + "-" + toSubNamespacePath (namespaces).map(n|n.name.stripXtextEscapes().replaceAll("\\." , "-")).join("-");
	}
	
	def dispatch String toFileNameFragment (org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace s) {
		s.findOrgNamespace().shorten().replaceAll("\\." , "-") + "-" + newArrayList(s).toNamespacePath().map(n|n.name.stripXtextEscapes().replaceAll("\\." , "-")).join("-");
	}
	
	def dispatch String toFileNameFragment (VersionedDomainNamespace s) {
		s.subdomain.getFileNameFragment() + "-v" + s.version.toMajorVersionNumber();
	}
	
	
	def String getConcreteWsdlFileNameFragment (Service s, String endPointKind) {
		s.eContainer.getFileNameFragment().replaceAll("\\." , "-") + "-" + s.name + endPointKind + "Port" + "-" + s.version.toVersionPostfix();
	}
		
	
	def dispatch String shorten (OrganizationNamespace d) {
		if (d.prefix != null) {
			d.prefix;
		} else { 
			d.name;
			
		}
	}
		
	
	/*
	 * 	XML Namespace prefixes / aliases
	 */
	def dispatch String toPrefix(Object o) {
		"tns";
	}
	def dispatch String toPrefix(OrganizationNamespace o) {
		if (o.prefix != null) {
			o.prefix;
		} else { 
			o.name.replaceAll("\\.", "_");
		}
	}
	
	def dispatch String toPrefix (SubNamespace s) {
		if (s.prefix != null) { 
			s.prefix;
		} else {
			toSubNamespacePath( newArrayList(s)).map(n|n.name.substring(0,1)).join("");
		}
	}
	
	def dispatch String toPrefix (VersionedDomainNamespace s) {
		if (s.shortName != null) {
			s.shortName
		} else {
			toSubNamespacePath (newArrayList (s.subdomain as SubNamespace)).map(n|n.name.substring(0,1)).join("");
		}
	}
	
	def List<ServiceModel> getAllServiceModels (ServiceModel m) {
		var Set<ServiceModel> models = newHashSet(m);
		var TreeIterator<EObject> eAllContIt = m.eAllContents;
		while (eAllContIt.hasNext()) {
			var EObject o = eAllContIt.next();
			if (o instanceof BusinessObjectRef && (o as BusinessObjectRef).type.eRootContainer instanceof ServiceModel) {
				models.add (o as ServiceModel);
			} else if (o instanceof EnumTypeRef && (o as EnumTypeRef).type.eRootContainer instanceof ServiceModel) {
				models.add (o as ServiceModel);
			}
		}
		val List<ServiceModel> result = models.toList();
		return result;
	}
	
	def dispatch boolean hasTypesInMinState (SubNamespace ns, LifecycleState state) {
		ns.typesWithMinState (state).size > 0;
	}
	
	def dispatch boolean hasServicesInMinState (SubNamespace ns, LifecycleState state) {
		ns.servicesWithMinState (state).size > 0;
	}
	
	def dispatch boolean hasExceptionsInMinState (SubNamespace ns, LifecycleState state) {
		ns.exceptionsWithMinState (state).size > 0;
	}
	
	def dispatch boolean hasTypesInMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.typesWithMinState (state).size > 0;
	}
	
	def dispatch boolean hasServicesInMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.servicesWithMinState (state).size > 0;
	}
	
	def dispatch boolean hasExceptionsInMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.exceptionsWithMinState (state).size > 0;
	}
	
}