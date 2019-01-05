package org.xkonnex.repo.dsl.bindingdsl.model.policy;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.baseDsl.AuthToken;
import org.xkonnex.repo.dsl.basedsl.baseDsl.HashAlgorithm;
import org.xkonnex.repo.dsl.sladsl.sLADsl.AuthenticationPolicy;

public class EffectiveAuthenticationPolicy extends EffectivePolicy implements
		AuthenticationPolicy {
	
	private String name;
	private boolean optional;
	private EList<AuthToken> authTokens = new BasicEList<AuthToken>();
	private EList<HashAlgorithm> hashAlgorithms = new BasicEList<HashAlgorithm>(); 
	private boolean useNonce;
	private String issuer;

	public EffectiveAuthenticationPolicy(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public boolean isOptional() {
		return optional;
	}

	@Override
	public void setOptional(boolean value) {
		this.optional = value;
	}

	@Override
	public EList<AuthToken> getAuthTokens() {
		return authTokens;
	}

	@Override
	public EList<HashAlgorithm> getHashAlgorithms() {
		return hashAlgorithms;
	}

	@Override
	public boolean isUseNonce() {
		return useNonce;
	}

	@Override
	public void setUseNonce(boolean value) {
		this.useNonce = value;
	}

	@Override
	public String getIssuer() {
		return issuer;
	}

	@Override
	public void setIssuer(String value) {
		this.issuer = value;
	}

}
