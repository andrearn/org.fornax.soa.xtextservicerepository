package org.fornax.soa.basedsl.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.fornax.soa.basedsl.scoping.versions.VersioningContainerBasedScope;

import com.google.common.base.Predicate;

public class VersionedGlobalScopeProvider extends DefaultGlobalScopeProvider {

	protected IScope createContainerScope (IScope parent, IContainer container, Predicate<IEObjectDescription> filter, EClass type, boolean ignoreCase) {
		return VersioningContainerBasedScope.createScope(parent, container, filter, type, ignoreCase);
	}

}
