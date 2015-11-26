package org.xkonnex.repo.dsl.servicedsl.service.namespace

import java.util.List
import javax.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace
import org.xkonnex.repo.dsl.basedsl.namespace.NamespaceNameFragmentProvider
import org.xkonnex.repo.dsl.basedsl.namespace.VersionedNamespace
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace

class DefaultServiceNamespaceNameFragmentProvider implements ServiceNamespaceNameFragmentProvider {

	@Inject extension CommonStringExtensions
	@Inject extension IQualifiedNameProvider
	@Inject extension NamespaceQuery
	@Inject NamespaceNameFragmentProvider baseDslNsNameFragmentProvider
	
	override getOrganizationNameFragment(Namespace ns) {
		ns.toOrgNameFragment
	}
	
	override getOrganizationNameFragment(VersionedNamespace ns) {
		ns.namespace.toOrgNameFragment
	}
	
	override getSubNamespaceFragment(Namespace ns) {
		ns.toSubNamespaceFragment
	}
	
	override getSubNamespaceFragment(VersionedNamespace ns) {
		ns.namespace.toSubNamespaceFragment
	}
	
	private def dispatch String toOrgNameFragment(Namespace ns) {
		val orgNs = ns.findOrgNamespace
		if (orgNs != null) {
			orgNs.toOrgNameFragment
		} else {
			baseDslNsNameFragmentProvider.getOrganizationNameFragment(ns)
		}
	}
	private def dispatch String toOrgNameFragment(OrganizationNamespace ns) {
		ns.fullyQualifiedName.toString
	}
	
	private def dispatch String toSubNamespaceFragment(Namespace ns) {
		baseDslNsNameFragmentProvider.getSubNamespaceFragment(ns)
	}
	
	private def dispatch String toSubNamespaceFragment(SubNamespace ns) {
		val subNamespaces = ns.allSubNamespaces
		val nameFragment = subNamespaces.map(n|n.name.stripXtextEscapes).join(".")
		if (ns.findOrgNamespace != null)
			return nameFragment
		else
			baseDslNsNameFragmentProvider.getSubNamespaceFragment(nameFragment)
	}
	
	private def List<SubNamespace> getAllSubNamespaces (SubNamespace ns) {
		val List<SubNamespace> nsList = newLinkedList(ns)
		return getAllSubNamespaces(nsList)
	}
	
	private def List<SubNamespace> getAllSubNamespaces (List<SubNamespace> domList) {
		if (domList.head()?.eContainer instanceof SubNamespace) {
			domList.add (0, domList.head().eContainer as SubNamespace) 
			getAllSubNamespaces (domList);
			return domList;
		} else { 
			return domList.filter (typeof (SubNamespace)).toList();
		}
	}
	
		
}