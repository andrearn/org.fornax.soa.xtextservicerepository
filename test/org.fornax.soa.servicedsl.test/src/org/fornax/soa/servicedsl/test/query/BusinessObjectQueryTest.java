package org.fornax.soa.servicedsl.test.query;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.fornax.soa.basedsl.ref.DependencyDescription;
import org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.util.BaseDslEqualityHelper;
import org.fornax.soa.basedsl.util.TreeNode;
import org.fornax.soa.query.BusinessObjectQuery;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.ServiceModel;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.servicedsl.test.BaseServiceDslTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

@RunWith(XtextRunner.class)
public class BusinessObjectQueryTest extends BaseServiceDslTest {
	
	@Inject
	private
	BusinessObjectQuery boQuery;
	
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
		injectMembers(this);
	}
	
	@Test
	public void testGetAllInheritedProperties () {
		List<Property> props = BusinessObjectQuery.getAllInheritedProperties (bo1);
		assertFalse (props.contains(attrBo1));
		assertTrue (props.contains(attrBo3));
		assertTrue (props.contains(attrBo4));
	}
	
	@Test
	public void testGetAllVisibleProperties () {
		List<Property> props = BusinessObjectQuery.getAllVisibleProperties (bo1);
		assertTrue (props.contains(attrBo1));
		assertTrue (props.contains(attrBo3));
		assertTrue (props.contains(attrBo4));
	}
	
	@Test
	public void testGetAllSuperTypes () {
		List<BusinessObject> superTypes = Lists.newArrayList();
		List<BusinessObject> allSuperTypes = BusinessObjectQuery.getAllSuperTypes (bo1, superTypes);
		assertTrue (superTypes.contains (bo3));
		assertTrue (superTypes.contains (bo4));
		assertFalse(superTypes.contains (bo1));
		assertFalse(superTypes.contains (bo2));
	}
	
	@Test
	public void testGetTransitiveDependencies () {
		DependencyDescription transitiveDependencies = getBoQuery().getTransitiveDependencies(attr2Bos1, false, true, null, null);
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

	public void setBoQuery (BusinessObjectQuery boQuery) {
		this.boQuery = boQuery;
	}

	public BusinessObjectQuery getBoQuery() {
		return boQuery;
	}

}
