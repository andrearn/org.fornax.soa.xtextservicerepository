package org.fornax.soa.basedsl.search;

import org.eclipse.xtext.resource.IReferenceDescription;

import com.google.common.base.Predicate;

public class ReferrerTypePredicate implements Predicate<IReferenceDescription> {
	
	public ReferrerTypePredicate(String referrerEClassName) {
		super();
		this.referrerEClassName = referrerEClassName;
	}

	private String referrerEClassName;

	public boolean apply(IReferenceDescription input) {
		if (referrerEClassName != null && 
				referrerEClassName.equals (input.getEReference().eContainer().eClass().getName())) {
			return true;
		}
		return false;
	}

}
