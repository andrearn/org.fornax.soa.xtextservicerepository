package org.xkonnex.repo.dsl.bindingdsl.model.protocol;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.HTTP;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Verb;

public class EffectiveHTTPProtocol extends EffectiveBindingProtocol implements HTTP {

	private String url;
	private String providerUrl;
	private Verb verb;

	public EffectiveHTTPProtocol(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public void setUrl(String value) {
		this.url = value;
	}

	@Override
	public String getProviderUrl() {
		return providerUrl;
	}

	@Override
	public void setProviderUrl(String value) {
		this.providerUrl = value;
	}

	@Override
	public Verb getVerb() {
		return verb;
	}

	@Override
	public void setVerb(Verb value) {
		this.verb = value;
	}

}
