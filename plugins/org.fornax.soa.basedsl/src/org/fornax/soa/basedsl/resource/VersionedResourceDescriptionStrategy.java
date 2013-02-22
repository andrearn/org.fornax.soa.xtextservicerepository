package org.fornax.soa.basedsl.resource;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;
import org.fornax.soa.basedsl.version.SimpleScopeVersionResolver;

import com.google.common.collect.Maps;

public class VersionedResourceDescriptionStrategy extends
		DefaultResourceDescriptionStrategy {

	public static final String STATE_KEY = "state";
	public static final String VERSION_KEY = "version";
	private final static Logger LOG = Logger.getLogger(VersionedResourceDescriptionStrategy.class);

	@Override
	public boolean createEObjectDescriptions(EObject eObject,
			IAcceptor<IEObjectDescription> acceptor) {
		if (getQualifiedNameProvider() == null)
			return false;
		try {
			QualifiedName qualifiedName = getQualifiedNameProvider().getFullyQualifiedName(eObject);
			if (qualifiedName != null) {
				Map<String, String> userData = Maps.newHashMap();
				String version = SimpleScopeVersionResolver.INSTANCE.getVersion(eObject);
				if (version != null)
					userData.put(VERSION_KEY, version);
				acceptor.accept (EObjectDescription.create(qualifiedName, eObject, userData));
			}
		} catch (Exception exc) {
			LOG.error(exc.getMessage());
		}
		return true;
	}
}
