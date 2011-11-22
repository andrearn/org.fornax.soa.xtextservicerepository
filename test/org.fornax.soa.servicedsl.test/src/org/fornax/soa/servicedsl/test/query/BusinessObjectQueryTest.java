package org.fornax.soa.servicedsl.test.query;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.fornax.soa.query.BusinessObjectQuery;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.servicedsl.test.BaseServiceDslTest;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class BusinessObjectQueryTest extends BaseServiceDslTest {

	@Before
	public void setUp() throws Exception {
		super.setUp();
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
		assertTrue (superTypes.contains(bo3));
		assertTrue (superTypes.contains(bo4));
		assertFalse(superTypes.contains(bo1));
		assertFalse(superTypes.contains(bo2));
	}

}
