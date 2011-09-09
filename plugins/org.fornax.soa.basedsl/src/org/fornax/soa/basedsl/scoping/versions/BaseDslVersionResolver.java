package org.fornax.soa.basedsl.scoping.versions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.sOABaseDsl.Version;

public class BaseDslVersionResolver implements VersionResolver {
	
	private final static String VERSION_ATTR_NAME = "version";

	public final static BaseDslVersionResolver INSTANCE = new BaseDslVersionResolver();
	
	
	private ResourceSet resSet;
	
	public BaseDslVersionResolver() {
	}
	
	public BaseDslVersionResolver(ResourceSet rs) {
		resSet = rs;
	}
	
	public String getVersion(IEObjectDescription desc) {
		EObject o = desc.getEObjectOrProxy();
		ResourceSet rs = resSet;
		if (rs == null)
			rs = o.eResource().getResourceSet();
		if (o.eIsProxy()) {
			o = EcoreUtil.resolve(o, resSet);
		}
		final EStructuralFeature verFeature1 = o.eClass()
				.getEStructuralFeature(VERSION_ATTR_NAME);
		if (verFeature1 != null && o.eIsSet(verFeature1)) {
			Object verObj = o.eGet (verFeature1, true);
			if (verObj instanceof Version) {
				String v = ((Version) verObj).getVersion();
				return v;
			}
		}

		return null;
	}
	
	public Version getVersionObject (IEObjectDescription desc) {
		EObject o = desc.getEObjectOrProxy();
		ResourceSet rs = resSet;
		if (rs == null)
			rs = o.eResource().getResourceSet();
		if (o.eIsProxy()) {
			o = EcoreUtil.resolve(o, resSet);
		}
		final EStructuralFeature verFeature1 = o.eClass()
				.getEStructuralFeature(VERSION_ATTR_NAME);
		if (verFeature1 != null && o.eIsSet(verFeature1)) {
			Object verObj = o.eGet (verFeature1, true);
			if (verObj instanceof Version) {
				return (Version) verObj;
			}
		}

		return null;
	}

}
