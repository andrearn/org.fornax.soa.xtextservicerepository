package org.xkonnex.repo.dsl.environmentdsl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.xkonnex.repo.dsl.basedsl.scoping.AbstractComponentScopeProvider;

public class EnvironmentDslComponentScopeProvider extends
		AbstractComponentScopeProvider {
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		return super.getScope(context, reference);
	}
	
}
