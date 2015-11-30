package org.xkonnex.repo.dsl.profiledsl.namespace

import java.util.List
import javax.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace
import org.xkonnex.repo.dsl.basedsl.namespace.NamespaceNameFragmentProvider
import org.xkonnex.repo.dsl.basedsl.namespace.VersionedNamespace
import org.xkonnex.repo.dsl.profiledsl.namespace.NamespaceNameTransformer
import org.xkonnex.repo.dsl.profiledsl.profileDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.profiledsl.query.namespace.TechnicalNamespaceQueries
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.query.ProfileQueries

class DefaultProfileNamespaceNameFragmentProvider implements ProfileNamespaceNameFragmentProvider {

	@Inject extension CommonStringExtensions
	@Inject extension IQualifiedNameProvider
	@Inject extension TechnicalNamespaceQueries
	@Inject extension NamespaceNameTransformer
	@Inject extension ProfileQueries
	
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
	
	override getOrganizationShortnameFragment(Namespace ns) {
		ns.toOrgShortnameFragment
	}
	
	override getOrganizationShortnameFragment(VersionedNamespace ns) {
		ns.namespace.toOrgShortnameFragment
	}
	
	
	private def dispatch String toOrgShortnameFragment(Namespace ns) {
		return baseDslNsNameFragmentProvider.getOrganizationNameFragment(ns)
	}
	
	private def dispatch String toOrgShortnameFragment(TechnicalNamespace ns) {
		val orgNs = ns.findOrgNamespace
		if (orgNs != null) {
			return orgNs.toOrgShortnameFragment
		} else {
			val profile = ns.getApplicableProfile
			val orgNsFQN = ns.fullyQualifiedName.toString
			val shortName = orgNsFQN.getNamespaceShortBaseName(profile)
			if (shortName != null)
				return shortName
		}
		return baseDslNsNameFragmentProvider.getOrganizationNameFragment(ns)
	}
	
	private def dispatch String toOrgShortnameFragment(OrganizationNamespace ns) {
		if (ns.prefix != null)
			return ns.prefix
		else {
			val profile = ns.applicableProfile
			val orgNsFQN = ns.fullyQualifiedName.toString
			val shortName = orgNsFQN.getNamespaceShortBaseName(profile)
			if (shortName != null)
				return shortName
			else
				return baseDslNsNameFragmentProvider.getOrganizationNameFragment(ns)
		} 
	}
	
	
	private def dispatch String toOrgNameFragment(Namespace ns) {
		baseDslNsNameFragmentProvider.getOrganizationNameFragment(ns)
	}
	private def dispatch String toOrgNameFragment(OrganizationNamespace ns) {
		ns.fullyQualifiedName.toString
	}
	
	private def dispatch String toSubNamespaceFragment(Namespace ns) {
		baseDslNsNameFragmentProvider.getSubNamespaceFragment(ns)
	}
	
	private def dispatch String toSubNamespaceFragment(TechnicalNamespace ns) {
		val subNamespaces = ns.allSubNamespaces
		val nameFragment = subNamespaces.map(n|n.name.stripXtextEscapes).join(".")
		if (ns.findOrgNamespace != null)
			return nameFragment
		else
			baseDslNsNameFragmentProvider.getSubNamespaceFragment(nameFragment)
	}
	
	private def List<TechnicalNamespace> getAllSubNamespaces (TechnicalNamespace ns) {
		val List<TechnicalNamespace> nsList = newLinkedList(ns)
		return getAllSubNamespaces(nsList)
	}
	
	private def List<TechnicalNamespace> getAllSubNamespaces (List<TechnicalNamespace> domList) {
		if (domList.head()?.eContainer instanceof TechnicalNamespace) {
			domList.add (0, domList.head().eContainer as TechnicalNamespace) 
			getAllSubNamespaces (domList);
			return domList;
		} else { 
			return domList.filter (typeof (TechnicalNamespace)).toList();
		}
	}
	
		
}