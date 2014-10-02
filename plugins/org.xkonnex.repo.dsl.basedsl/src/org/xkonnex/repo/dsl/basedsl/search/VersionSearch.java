package org.xkonnex.repo.dsl.basedsl.search;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.Version;
import org.xkonnex.repo.dsl.basedsl.version.SimpleScopeVersionResolver;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

public class VersionSearch {
	
	public Iterable<Version> findAvailableVersions (QualifiedName name, IScope scope) {
		Iterable<IEObjectDescription> elements = scope.getElements(name);
		Iterable<Version> versions = Iterables.transform(elements, new Function<IEObjectDescription, Version> () {
			public Version apply(IEObjectDescription from) {
				return SimpleScopeVersionResolver.INSTANCE.getVersion (from);
			}
		});
		return versions;
	}

}
