package org.xkonnex.repo.dsl.bindingdsl.model.assertion;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.model.DelegatingEObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Assertion;

public class EffectiveAssertion extends DelegatingEObject implements Assertion {

	public EffectiveAssertion(EObject delegate) {
		super(delegate);
	}

}
