package org.fornax.soa.basedsl.scoping.versions.filter;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

public class NullVersionFilter<T> extends AbstractPredicateVersionFilter<T>  {

	public boolean matches(IEObjectDescription description) {
		return true;
	}

	public Multimap<QualifiedName, IEObjectDescription> getBestMatchByNames(
			Iterable<IEObjectDescription> canditates, boolean ignoreCase) {
		Multimap<QualifiedName, IEObjectDescription> matches = LinkedHashMultimap.create(5,2);
		if (canditates != null) {
			for (IEObjectDescription ieObjDesc : canditates) {
				if (ieObjDesc != null)
					matches.put (ieObjDesc.getName(), ieObjDesc);
			}
		}
		return matches;
	}

	public Multimap<QualifiedName, IEObjectDescription> getBestMatchByQualifiedNames(
			Iterable<IEObjectDescription> canditates, boolean ignoreCase) {
		Multimap<QualifiedName, IEObjectDescription> matches = LinkedHashMultimap.create(5,2);
		if (canditates != null) {
			for (IEObjectDescription ieObjDesc : canditates) {
				matches.put (ieObjDesc.getQualifiedName(), ieObjDesc);
			}
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
