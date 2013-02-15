package org.fornax.soa.binding;

import java.util.HashMap;
import java.util.Map;

import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.semanticsDsl.Qualifier;

public class EndpointQualifierDescriptor {
	
	private Qualifier effectiveEndpointQualifier;
	
	private Map<BindingProtocol, Qualifier> potentialEndpointQualifiers = new HashMap<BindingProtocol, Qualifier>();

	public Qualifier getEffectiveEndpointQualifier() {
		return effectiveEndpointQualifier;
	}
	public Qualifier getEffectiveEndpointQualifier(BindingProtocol protocol) {
		Qualifier potentialEndpointQualifier = potentialEndpointQualifiers.get(protocol);
		if (potentialEndpointQualifier != null)
			return potentialEndpointQualifier;
		else 
			return effectiveEndpointQualifier;
	}

	public void setEffectiveEndpointQualifier(Qualifier effectiveEndpointQualifier) {
		this.effectiveEndpointQualifier = effectiveEndpointQualifier;
	}

	public boolean containsEndpointQualifier(Qualifier referredEndpointQualifier) {
		if (referredEndpointQualifier == null)
			return false;
		if (referredEndpointQualifier.equals(effectiveEndpointQualifier))
			return true;
		else {
			for (BindingProtocol key : potentialEndpointQualifiers.keySet()) {
				if (referredEndpointQualifier.equals (potentialEndpointQualifiers.get(key))) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Map<BindingProtocol, Qualifier> getPotentialEndpointQualifiers() {
		return potentialEndpointQualifiers;
	}
	
	public void addPotentialEndpointQualifiers(BindingProtocol protocol, Qualifier endpointQualifier) {
		potentialEndpointQualifiers.put (protocol, endpointQualifier);
	}

	public void setPotentialEndpointQualifiers(
			Map<BindingProtocol, Qualifier> potentialEndpointQualifiers) {
		this.potentialEndpointQualifiers = potentialEndpointQualifiers;
	}

}
