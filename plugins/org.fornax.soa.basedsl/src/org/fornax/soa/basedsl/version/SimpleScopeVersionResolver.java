package org.fornax.soa.basedsl.version;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.fornax.soa.basedsl.sOABaseDsl.Version;

public class SimpleScopeVersionResolver implements IScopeVersionResolver {
	
	private final static String VERSION_ATTR_NAME = "version";

	public final static SimpleScopeVersionResolver INSTANCE = new SimpleScopeVersionResolver();
	
	
	private ResourceSet resSet;
	
	public SimpleScopeVersionResolver() {
	}
	
	public SimpleScopeVersionResolver(ResourceSet rs) {
		resSet = rs;
	}
	
	public String getVersion(EObject o) {
		ResourceSet rs = resSet;
		if (rs == null) {
			if (o.eResource() != null) {
				rs = o.eResource().getResourceSet();
				if (o.eIsProxy()) {
					o = EcoreUtil.resolve (o, resSet);
				}
			}
		}
		if (!o.eIsProxy()) {
			final EStructuralFeature verFeature1 = o.eClass()
					.getEStructuralFeature(VERSION_ATTR_NAME);
			if (verFeature1 != null && o.eIsSet(verFeature1)) {
				Object verObj = o.eGet (verFeature1, true);
				if (verObj instanceof Version) {
					String v = ((Version) verObj).getVersion();
					return v;
				}
			}
		}
		return null;
	}
	
	public String getVersionAsString(IEObjectDescription desc) {
		EObject o = desc.getEObjectOrProxy();
		ResourceSet rs = resSet;
		if (rs == null) {
			if (o.eResource() != null) {
				rs = o.eResource().getResourceSet();
				if (o.eIsProxy()) {
					o = EcoreUtil.resolve (o, resSet);
				}
			}
		}
		final EStructuralFeature verFeature1 = o.eClass().getEStructuralFeature(VERSION_ATTR_NAME);
		if (!o.eIsProxy()) {
			if (verFeature1 != null && o.eIsSet(verFeature1)) {
				Object verObj = o.eGet (verFeature1, true);
				if (verObj instanceof Version) {
					String v = ((Version) verObj).getVersion();
					return v;
				}
			}
		} else {
			String versionLiteral = desc.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY);
			if (versionLiteral != null) {
				return versionLiteral;
			}
		}
		return null;
	}
	
	public Version getVersion (IEObjectDescription desc) {
		EObject o = desc.getEObjectOrProxy();
		ResourceSet rs = resSet;
		if (rs == null) {
			if (o.eResource() != null) {
				rs = o.eResource().getResourceSet();
				if (o.eIsProxy()) {
					o = EcoreUtil.resolve (o, resSet);
				}
			}
		}
		if (!o.eIsProxy()) {
			final EStructuralFeature verFeature1 = o.eClass()
					.getEStructuralFeature(VERSION_ATTR_NAME);
			if (verFeature1 != null && o.eIsSet(verFeature1)) {
				Object verObj = o.eGet (verFeature1, true);
				if (verObj instanceof Version) {
					return (Version) verObj;
				}
			}
		}
		return null;
	}

}
