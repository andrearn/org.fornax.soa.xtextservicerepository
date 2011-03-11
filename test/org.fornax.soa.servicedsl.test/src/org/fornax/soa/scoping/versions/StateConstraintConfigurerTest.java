package org.fornax.soa.scoping.versions;

import static org.junit.Assert.assertEquals;

import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;
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
		assertEquals (LifecycleState.PROPOSED, StateConstraintConfigurer.getMinDevState(s));
		assertEquals (LifecycleState.PROPOSED, StateConstraintConfigurer.getMinDevState(paramBoRef));
		assertEquals (LifecycleState.DEFINED, StateConstraintConfigurer.getMinDevState(stringTypeRef));
	}

	@Test
	public void testGetMinTestState() {
		assertEquals (LifecycleState.TEST, StateConstraintConfigurer.getMinTestState(s));
		assertEquals (LifecycleState.DEVELOPMENT, StateConstraintConfigurer.getMinTestState(attrBo1));
	}

	@Test
	public void testGetMinProdState() {
		assertEquals (LifecycleState.PRODUCTIVE, StateConstraintConfigurer.getMinProdState(s));
		assertEquals (LifecycleState.TEST, StateConstraintConfigurer.getMinProdState(stringTypeRef));
	}

}
