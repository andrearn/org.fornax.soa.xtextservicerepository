package org.fornax.soa.basedsl.resource;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.version.SimpleScopeVersionResolver;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

public class EObjectDescriptionBuilder implements IEObjectDescriptionBuilder {
	
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	/* (non-Javadoc)
	 * @see org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder#buildDescription(org.eclipse.emf.ecore.EObject)
	 */
	public IEObjectDescription buildDescription (EObject eObject) {
		if (eObject != null) {
			QualifiedName qualifiedName = getQualifiedNameProvider().getFullyQualifiedName(eObject);
			if (qualifiedName != null) {
				Map<String, String> userData = Maps.newHashMap();
				String version = SimpleScopeVersionResolver.INSTANCE.getVersionAsString(eObject);
				if (version != null)
					userData.put(VERSION_KEY, version);
				return EObjectDescription.create(qualifiedName, eObject, userData);
			}
		}
		return null;
	}
		
	public void setQualifiedNameProvider(IQualifiedNameProvider qualifiedNameProvider) {
		this.qualifiedNameProvider = qualifiedNameProvider;
	}

	public IQualifiedNameProvider getQualifiedNameProvider() {
		return qualifiedNameProvider;
	}

}

