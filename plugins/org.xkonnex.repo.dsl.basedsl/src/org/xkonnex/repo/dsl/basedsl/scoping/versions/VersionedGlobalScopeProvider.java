package org.xkonnex.repo.dsl.basedsl.scoping.versions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.common.types.xtext.TypesAwareDefaultGlobalScopeProvider;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;

import com.google.common.base.Predicate;

@SuppressWarnings("restriction")
public class VersionedGlobalScopeProvider extends TypesAwareDefaultGlobalScopeProvider {

	protected IScope createContainerScope (IScope parent, IContainer container, Predicate<IEObjectDescription> filter, EClass type, boolean ignoreCase) {
		return VersioningContainerBasedScope.createScope(parent, container, filter, type, ignoreCase);
	}

}
