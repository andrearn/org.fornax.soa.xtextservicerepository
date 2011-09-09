package org.fornax.soa.basedsl.search;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.scoping.versions.BaseDslVersionResolver;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

public class VersionSearch {
	
	public Iterable<Version> findAvailableVersions (QualifiedName name, IScope scope) {
		Iterable<IEObjectDescription> elements = scope.getElements(name);
		Iterable<Version> versions = Iterables.transform(elements, new Function<IEObjectDescription, Version> () {
			public Version apply(IEObjectDescription from) {
				return BaseDslVersionResolver.INSTANCE.getVersionObject (from);
			}
		});
		return versions;
	}

}
