package org.xkonnex.repo.dsl.bindingdsl.model.policy;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.baseDsl.CipherAlgorithmKind;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.EncryptionPolicy;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.MessagePartRef;

public class EffectiveEncryptionPolicy extends EffectivePolicy implements
		EncryptionPolicy {

	private EList<CipherAlgorithmKind> supportedCipherAlgorithms;
	private CipherAlgorithmKind requiredCipherAlgorithm;
	private EList<MessagePartRef> encryptedParts;

	public EffectiveEncryptionPolicy(EObject delegate) {
		super(delegate);
	}

	@Override
	public EList<CipherAlgorithmKind> getSupportedCipherAlgorithms() {
		return supportedCipherAlgorithms;
	}

	@Override
	public CipherAlgorithmKind getRequiredCipherAlgorithm() {
		return requiredCipherAlgorithm;
	}

	@Override
	public void setRequiredCipherAlgorithm(CipherAlgorithmKind value) {
		this.requiredCipherAlgorithm = value;
	}

	@Override
	public EList<MessagePartRef> getEncryptedParts() {
		return encryptedParts;
	}

}
