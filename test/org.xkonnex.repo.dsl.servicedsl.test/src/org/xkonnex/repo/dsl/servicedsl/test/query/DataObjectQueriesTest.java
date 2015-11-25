package org.xkonnex.repo.dsl.servicedsl.test.query;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.servicedsl.test.BaseServiceDslTest;
import org.xkonnex.repo.dsl.servicedsl.test.ServiceDslWithDependenciesInjector;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xkonnex.repo.dsl.basedsl.ref.DependencyDescription;
import org.xkonnex.repo.dsl.basedsl.resource.IEObjectDescriptionBuilder;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.util.BaseDslEqualityHelper;
import org.xkonnex.repo.dsl.servicedsl.service.query.type.DataObjectQueries;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(ServiceDslWithDependenciesInjector.class)
public class DataObjectQueriesTest extends BaseServiceDslTest {
	
	@Inject
	private
	DataObjectQueries dataObjQueries;
	
	@Inject
	private
	IQualifiedNameProvider nameProvider;
	
	@Inject
	IEObjectDescriptionBuilder descriptionBuilder;
	
	@Inject
	IEObjectLookup eObjectLookup;

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testGetAllInheritedProperties () {
		List<Property> props = dataObjQueries.getAllInheritedProperties (bo1);
		assertFalse (props.contains(attrBo1));
		assertTrue (props.contains(attrBo3));
		assertTrue (props.contains(attrBo4));
	}
	
	@Test
	public void testGetAllVisibleProperties () {
		List<Property> props = dataObjQueries.getAllVisibleProperties (bo1);
		assertTrue (props.contains(attrBo1));
		assertTrue (props.contains(attrBo3));
		assertTrue (props.contains(attrBo4));
	}
	 
	@Test
	public void testGetAllSuperTypes () {
		List<BusinessObject> superTypes = Lists.newArrayList();
		List<DataObject> allSuperTypes = dataObjQueries.getAllSuperTypes (bo1, superTypes);
		assertTrue (superTypes.contains (bo3));
		assertTrue (superTypes.contains (bo4));
		assertFalse(superTypes.contains (bo1));
		assertFalse(superTypes.contains (bo2));
	}
	
	@Test
	public void testGetTransitiveDependencies () {
		DependencyDescription transitiveDependencies = dataObjQueries.getTransitiveDependencies(attr2Bos1, false, true, null, null);
		Iterator<DependencyDescription> transDepIt = transitiveDependencies.iterator();
		assertTrue (transDepIt.hasNext());
		
		final IEObjectDescription bo2Desc = descriptionBuilder.buildDescription (bo2);
		Iterable<DependencyDescription> filtered = Iterables.filter (transitiveDependencies, new Predicate<DependencyDescription> () {

			public boolean apply(DependencyDescription input) {
				assertNotNull (input.getTarget());
				assertNotNull (input.getSource());
				return BaseDslEqualityHelper.isEqual (bo2Desc, input.getTarget());
			}
			
		});
		Iterator<DependencyDescription> depIt = filtered.iterator();
		assertTrue (depIt.hasNext());
		List<DependencyDescription> filteredDeps = Lists.newArrayList(filtered);
		assertEquals(1, filteredDeps.size());
		
		
	}
	

	public void setNameProvider (IQualifiedNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}

	public IQualifiedNameProvider getNameProvider() {
		return nameProvider;
	}

	public void setDataObjectQueries (DataObjectQueries boQuery) {
		this.dataObjQueries = boQuery;
	}

	public DataObjectQueries getDataObjectQueries() {
		return dataObjQueries;
	}

}
