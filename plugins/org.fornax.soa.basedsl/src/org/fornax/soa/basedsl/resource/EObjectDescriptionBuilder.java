package org.fornax.soa.basedsl.resource;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.scoping.versions.BaseDslVersionResolver;
import org.fornax.soa.basedsl.scoping.versions.ServiceDslLifecycleStateResolver;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

public class EObjectDescriptionBuilder implements IEObjectDescriptionBuilder {
	
	@Inject
	private QualifiedNameProvider qualifiedNameProvider;

	/* (non-Javadoc)
	 * @see org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder#buildDescription(org.eclipse.emf.ecore.EObject)
	 */
	public IEObjectDescription buildDescription (EObject eObject) {
		if (eObject != null) {
			QualifiedName qualifiedName = getQualifiedNameProvider().getFullyQualifiedName(eObject);
			if (qualifiedName != null) {
				Map<String, String> userData = Maps.newHashMap();
				String version = BaseDslVersionResolver.INSTANCE.getVersion(eObject);
				if (version != null)
					userData.put(VERSION_KEY, version);
				String state = ServiceDslLifecycleStateResolver.INSTANCE.getLifecycleStateName(eObject);
				if (state != null)
					userData.put(STATE_KEY, state);
				return EObjectDescription.create(qualifiedName, eObject, userData);
			}
		}
		return null;
	}
		
	public void setQualifiedNameProvider(QualifiedNameProvider qualifiedNameProvider) {
		this.qualifiedNameProvider = qualifiedNameProvider;
	}

	public QualifiedNameProvider getQualifiedNameProvider() {
		return qualifiedNameProvider;
	}

}

