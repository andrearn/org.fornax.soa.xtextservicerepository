package org.fornax.soa.service.query.namespace

import org.fornax.soa.serviceDsl.BusinessObject
import org.fornax.soa.serviceDsl.Enumeration
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.Type
import org.fornax.soa.serviceDsl.VersionedType
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.VersionedTypeRef
import org.fornax.soa.serviceDsl.BusinessObjectRef
import org.fornax.soa.serviceDsl.EnumTypeRef
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.service.query.LifecycleQueries
import com.google.inject.Inject
import org.fornax.soa.serviceDsl.TypeRef
import org.fornax.soa.serviceDsl.ServiceRef
import org.fornax.soa.serviceDsl.DomainNamespace
import org.fornax.soa.serviceDsl.OrganizationNamespace
import org.fornax.soa.serviceDsl.InternalNamespace
import org.fornax.soa.serviceDsl.QueryObject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.xbase.lib.StringExtensions
import org.fornax.soa.basedsl.CommonStringExtensions

/*
 * Namespace lookup functions
 */
class NamespaceQuery {
	
	@Inject extension LifecycleQueries
	@Inject extension CommonStringExtensions
	

	def dispatch OrganizationNamespace findOrgNamespace (Object o) {
	}

	def dispatch OrganizationNamespace findOrgNamespace (Service o) {
		o.eContainer.eContainer as org.fornax.soa.serviceDsl.OrganizationNamespace;
	}
	
	def dispatch OrganizationNamespace findOrgNamespace (DomainNamespace o) { 
		if (o.eContainer instanceof OrganizationNamespace)  
			o.eContainer as OrganizationNamespace
		else
			this?.findOrgNamespace (o.eContainer as DomainNamespace) as OrganizationNamespace;
	}
	
	def dispatch OrganizationNamespace findOrgNamespace (InternalNamespace o) { 
		if (o.eContainer instanceof OrganizationNamespace)  
			o.eContainer as OrganizationNamespace
		else
			this?.findOrgNamespace (o.eContainer as SubNamespace) as OrganizationNamespace;
	}

	def dispatch SubNamespace findSubdomain (Type t) {
		null;
	}
	
	def dispatch SubNamespace findSubdomain (VersionedType c) {
		if (c.eContainer instanceof SubNamespace)
			c.eContainer as SubNamespace
		else
			null;
	}
		
	def dispatch SubNamespace findSubdomain (BusinessObject c) {
		if (c.eContainer instanceof SubNamespace) 
			c.eContainer as SubNamespace 
		else 
			null;
	}
	def dispatch SubNamespace findSubdomain (QueryObject c) {
		if (c.eContainer instanceof SubNamespace) 
			c.eContainer as SubNamespace 
		else 
			null;
	}
	def dispatch SubNamespace findSubdomain (Enumeration c) { 
		if (c.eContainer instanceof SubNamespace) 
			c.eContainer as SubNamespace 
		else 
			null;
	}
	def dispatch SubNamespace findSubdomain (org.fornax.soa.serviceDsl.Exception c) {
			if (c.eContainer instanceof SubNamespace) 
			c.eContainer as SubNamespace 
		else 
			null;
	}
		
	def dispatch SubNamespace findSubdomain (Service c) {
		if (c.eContainer instanceof SubNamespace) 
			c.eContainer as SubNamespace 
		else 
			null;
	}

	/**
	 *	Find the owning namespace of the owner of the type, service or exception reference
	 */
	// TODO make this safe for cases when there is no stateful owner 
	def dispatch SubNamespace findOwnerSubdomain (TypeRef t) {
		t.getStatefulOwner()?.eContainer as SubNamespace;
	}
	
	def dispatch SubNamespace findOwnerSubdomain (VersionedTypeRef c) {
		c?.getStatefulOwner()?.eContainer as SubNamespace;
	}
	
	def dispatch SubNamespace findOwnerSubdomain (BusinessObjectRef c) {
		c?.getStatefulOwner()?.eContainer as SubNamespace;
	}
	
	def dispatch SubNamespace findOwnerSubdomain (EnumTypeRef c) {
		c?.getStatefulOwner()?.eContainer as SubNamespace;
	}
	
	def dispatch SubNamespace findOwnerSubdomain (ExceptionRef e) {
		e?.getStatefulOwner()?.eContainer as SubNamespace;
	}
	
	def dispatch SubNamespace findOwnerSubdomain (ServiceRef s) {
		s?.getStatefulOwner()?.eContainer as SubNamespace;
	}
	
	def dispatch String fqn (EObject o) {
		null;
	}
	
	def dispatch String fqn (OrganizationNamespace s) {
		s.name.stripXtextEscapes();
	}
		
}