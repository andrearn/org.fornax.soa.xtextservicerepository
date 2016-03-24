package org.xkonnex.repo.dsl.bindingdsl.model.protocol;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.REST;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Verb;

public class EffectiveRESTProtocol extends EffectiveBindingProtocol implements
		REST {

	private String path;
	private String providerUrl;
	private Verb verb;
	private EList<String> provides;

	public EffectiveRESTProtocol(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public void setPath(String value) {
		this.path = value;
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

	@Override
	public EList<String> getConsumes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<String> getProvides() {
		return provides;
	}

}
