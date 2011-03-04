package org.fornax.soa.basedsl.scoping.versions;

import java.util.Map;

import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.collect.Maps;

public class NullVersionFilter implements VersionFilter {

	public boolean matches(IEObjectDescription description) {
		return true;
	}

	public Map<String, IEObjectDescription> getBestMatchByNames(
			Iterable<IEObjectDescription> canditates) {
		Map<String, IEObjectDescription> matches = Maps.newLinkedHashMap();
		for (IEObjectDescription ieObjDesc : canditates) {
			if (ieObjDesc != null)
				matches.put(ieObjDesc.getName(), ieObjDesc);
		}
		return matches;
	}

	public Map<String, IEObjectDescription> getBestMatchByQualifedNames(
			Iterable<IEObjectDescription> canditates) {
		Map<String, IEObjectDescription> matches = Maps.newLinkedHashMap();
		for (IEObjectDescription ieObjDesc : canditates) {
					matches.put(ieObjDesc.getQualifiedName(), ieObjDesc);
		}
		return matches;
	}
	
	public boolean equals (Object other) {
		if (other instanceof NullVersionFilter)
			return true;
		else
			return false;
	}

}
