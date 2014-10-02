package org.xkonnex.repo.dsl.servicedsl.service.validation.version;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch;
import org.xkonnex.repo.dsl.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.xkonnex.repo.dsl.basedsl.version.VersionComparator;
import org.xkonnex.repo.dsl.servicedsl.service.util.TypeRefMatcher;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public abstract class AbstractServiceDslVersionValidator extends AbstractPluggableDeclarativeValidator {
	
	@Inject 
	protected IPredicateSearch lookup;
	
	@Inject 
	protected IQualifiedNameProvider nameProvider;
	
	@Inject 
	protected VersionComparator versionComp;
	
	@Inject 
	protected TypeRefMatcher typeRefMatcher;

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage.eINSTANCE);
		return result;
	}
	
	protected IEObjectDescription getNextLesserVersion (final String name, final String version, final String typeName) {
		final String majorVersion = version.split ("\\.")[0];
		Iterable<IEObjectDescription> candBOs = lookup.search (name.toString () + " ", typeName, new Predicate<IEObjectDescription>() {
			
			public boolean apply (IEObjectDescription iEObjDesc) {
				String objVersion = iEObjDesc.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY);
				final String objMajorVersion = objVersion.split ("\\.")[0];
				int verComp = versionComp.compare (version, objVersion);
				return majorVersion.equals (objMajorVersion) && verComp > 0;
			}
			
		});
		ArrayList<IEObjectDescription> iEObjCandList = Lists.newArrayList (candBOs);
		Collections.sort (iEObjCandList, new Comparator<IEObjectDescription>() {

			public int compare (IEObjectDescription o1, IEObjectDescription o2) {
				String ver1 = o1.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY);
				String ver2 = o2.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY);
				return versionComp.compare (ver1, ver2);
			}
		});
		if (!iEObjCandList.isEmpty ())
			return iEObjCandList.get (iEObjCandList.size () - 1);
		else
			return null;
	}

}
