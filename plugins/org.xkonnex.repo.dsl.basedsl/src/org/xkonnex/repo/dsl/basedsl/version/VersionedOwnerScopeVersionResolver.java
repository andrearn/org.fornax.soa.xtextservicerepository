package org.xkonnex.repo.dsl.basedsl.version;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version;

public class VersionedOwnerScopeVersionResolver implements IScopeVersionResolver {

	private final static String VERSION_ATTR_NAME = "version"; 
	
	private ResourceSet resSet;
	
	public VersionedOwnerScopeVersionResolver(ResourceSet rs) {
		resSet = rs;
	}
	
	public String getVersionAsString(IEObjectDescription desc) {
		EObject o = desc.getEObjectOrProxy();
		if (o.eIsProxy()) {
			o = EcoreUtil.resolve(o, resSet);
		}
		while (o.eContainer() != null && o.eClass().getEStructuralFeature(VERSION_ATTR_NAME) == null) {
			o = o.eContainer();
			o = EcoreUtil.resolve(o, resSet);
		}
		EStructuralFeature verFeature1 = o.eClass()
				.getEStructuralFeature(VERSION_ATTR_NAME);
		if (o.eIsSet(verFeature1)) {
			Object verObj = o.eGet (verFeature1, true);
			if (verObj instanceof Version) {
				String v = ((Version) verObj).getVersion();
				return v;
			}
		}

		return null;
	}

	public Version getVersion(IEObjectDescription desc) {
		EObject o = desc.getEObjectOrProxy();
		if (o.eIsProxy()) {
			o = EcoreUtil.resolve(o, resSet);
		}
		while (o.eContainer() != null && o.eClass().getEStructuralFeature(VERSION_ATTR_NAME) == null) {
			o = o.eContainer();
			o = EcoreUtil.resolve(o, resSet);
		}
		EStructuralFeature verFeature1 = o.eClass()
				.getEStructuralFeature(VERSION_ATTR_NAME);
		if (o.eIsSet(verFeature1)) {
			Object verObj = o.eGet (verFeature1, true);
			if (verObj instanceof Version) {
				return (Version) verObj;
			}
		}

		return null;
	}

	public String getVersionAsString(EObject o) {
		if (o.eIsProxy()) {
			o = EcoreUtil.resolve(o, resSet);
		}
		while (o.eContainer() != null && o.eClass().getEStructuralFeature(VERSION_ATTR_NAME) == null) {
			o = o.eContainer();
			o = EcoreUtil.resolve(o, resSet);
		}
		EStructuralFeature verFeature1 = o.eClass()
				.getEStructuralFeature(VERSION_ATTR_NAME);
		if (o.eIsSet(verFeature1)) {
			Object verObj = o.eGet (verFeature1, true);
			if (verObj instanceof Version) {
				String v = ((Version) verObj).getVersion();
				return v;
			}
		}

		return null;
	}

	public Version getVersion(EObject o) {
		if (o.eIsProxy()) {
			o = EcoreUtil.resolve(o, resSet);
		}
		while (o.eContainer() != null && o.eClass().getEStructuralFeature(VERSION_ATTR_NAME) == null) {
			o = o.eContainer();
			o = EcoreUtil.resolve(o, resSet);
		}
		EStructuralFeature verFeature1 = o.eClass()
				.getEStructuralFeature(VERSION_ATTR_NAME);
		if (o.eIsSet(verFeature1)) {
			Object verObj = o.eGet (verFeature1, true);
			if (verObj instanceof Version) {
				return (Version) verObj;
			}
		}

		return null;
	}

}
