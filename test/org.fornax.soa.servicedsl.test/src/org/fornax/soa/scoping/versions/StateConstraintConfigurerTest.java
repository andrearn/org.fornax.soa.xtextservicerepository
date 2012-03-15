package org.fornax.soa.scoping.versions;

import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.scoping.StateConstraintConfigurer;
import org.fornax.soa.servicedsl.test.BaseServiceDslTest;
import org.junit.Before;
import org.junit.Test;

public class StateConstraintConfigurerTest extends BaseServiceDslTest {

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testGetMinDevState() {
		assertEquals (proposed, StateConstraintConfigurer.getMinDevState(s));
		assertEquals (proposed, StateConstraintConfigurer.getMinDevState(paramBoRef));
		assertEquals (defined, StateConstraintConfigurer.getMinDevState(stringTypeRef));
	}

	@Test
	public void testGetMinTestState() {
		assertEquals (test, StateConstraintConfigurer.getMinTestState(s));
		assertEquals (development, StateConstraintConfigurer.getMinTestState(attrBo1));
	}

	@Test
	public void testGetMinProdState() {
		assertEquals (productive, StateConstraintConfigurer.getMinProdState(s));
		assertEquals (test, StateConstraintConfigurer.getMinProdState(dns));
	}

}
