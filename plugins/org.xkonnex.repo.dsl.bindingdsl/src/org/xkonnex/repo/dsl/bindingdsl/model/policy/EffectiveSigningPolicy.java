package org.xkonnex.repo.dsl.bindingdsl.model.policy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.baseDsl.SigningAlgorithm;
import org.xkonnex.repo.dsl.sladsl.sLADsl.MessagePartRef;
import org.xkonnex.repo.dsl.sladsl.sLADsl.SigningPolicy;

public class EffectiveSigningPolicy extends EffectivePolicy implements
		SigningPolicy {

	public EffectiveSigningPolicy(EObject delegate) {
		super(delegate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EList<SigningAlgorithm> getSupportedSigningAlgorithms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SigningAlgorithm getRequiredSigningAlgorithm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRequiredSigningAlgorithm(SigningAlgorithm value) {
		// TODO Auto-generated method stub

	}

	@Override
	public EList<MessagePartRef> getSignedParts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String value) {
		// TODO Auto-generated method stub
		
	}

}
