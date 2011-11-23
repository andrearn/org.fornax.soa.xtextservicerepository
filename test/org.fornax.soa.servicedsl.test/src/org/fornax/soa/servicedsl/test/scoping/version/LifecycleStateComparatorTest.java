package org.fornax.soa.servicedsl.test.scoping.version;

import static org.junit.Assert.assertEquals;

import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;
import org.fornax.soa.basedsl.scoping.versions.LifecycleStateComparator;
import org.junit.Before;
import org.junit.Test;

public class LifecycleStateComparatorTest {
	
	private LifecycleState proposedState;
	private LifecycleState definedState;
	private LifecycleState developmentState;
	private LifecycleState testState;
	private LifecycleState productiveState;
	private LifecycleState deprecatedState;
	private LifecycleState retiredState;
	

	@Before
	public void setUp() throws Exception {
		proposedState = LifecycleState.PROPOSED;
		definedState = LifecycleState.DEFINED;
		developmentState = LifecycleState.DEVELOPMENT;
		testState = LifecycleState.TEST;
		productiveState = LifecycleState.PRODUCTIVE;
		deprecatedState = LifecycleState.DEPRECATED;
		retiredState = LifecycleState.RETIRED;
	}

	@Test
	public void testCompareEqualStates() {
		assertEquals(0, LifecycleStateComparator.compare(proposedState, proposedState));
		assertEquals(0, LifecycleStateComparator.compare(definedState, definedState));
		assertEquals(0, LifecycleStateComparator.compare(developmentState, developmentState));
		assertEquals(0, LifecycleStateComparator.compare(testState, testState));
		assertEquals(0, LifecycleStateComparator.compare(productiveState, productiveState));
		assertEquals(0, LifecycleStateComparator.compare(deprecatedState, deprecatedState));
		assertEquals(0, LifecycleStateComparator.compare(retiredState, retiredState));
		
	}
	
	@Test
	public void testCompareHigherStates() {
		assertEquals(1, LifecycleStateComparator.compare(proposedState, definedState));
		assertEquals(1, LifecycleStateComparator.compare(proposedState, developmentState));
		assertEquals(1, LifecycleStateComparator.compare(proposedState, testState));
		assertEquals(1, LifecycleStateComparator.compare(proposedState, productiveState));
		assertEquals(1, LifecycleStateComparator.compare(proposedState, deprecatedState));
		assertEquals(1, LifecycleStateComparator.compare(proposedState, retiredState));

		assertEquals(1, LifecycleStateComparator.compare(definedState, developmentState));
		assertEquals(1, LifecycleStateComparator.compare(definedState, testState));
		assertEquals(1, LifecycleStateComparator.compare(definedState, productiveState));
		assertEquals(1, LifecycleStateComparator.compare(definedState, deprecatedState));
		assertEquals(1, LifecycleStateComparator.compare(definedState, retiredState));

		assertEquals(1, LifecycleStateComparator.compare(developmentState, testState));
		assertEquals(1, LifecycleStateComparator.compare(developmentState, productiveState));
		assertEquals(1, LifecycleStateComparator.compare(developmentState, deprecatedState));
		assertEquals(1, LifecycleStateComparator.compare(developmentState, retiredState));

		assertEquals(1, LifecycleStateComparator.compare(testState, productiveState));
		assertEquals(1, LifecycleStateComparator.compare(testState, deprecatedState));
		assertEquals(1, LifecycleStateComparator.compare(testState, retiredState));

		assertEquals(1, LifecycleStateComparator.compare(productiveState, deprecatedState));
		assertEquals(1, LifecycleStateComparator.compare(productiveState, retiredState));

		assertEquals(1, LifecycleStateComparator.compare(deprecatedState, retiredState));
	}

	@Test
	public void testCompareLowerStates() {
		assertEquals(-1, LifecycleStateComparator.compare(retiredState, proposedState));
		assertEquals(-1, LifecycleStateComparator.compare(retiredState, definedState));
		assertEquals(-1, LifecycleStateComparator.compare(retiredState, developmentState));
		assertEquals(-1, LifecycleStateComparator.compare(retiredState, testState));
		assertEquals(-1, LifecycleStateComparator.compare(retiredState, productiveState));
		assertEquals(-1, LifecycleStateComparator.compare(retiredState, deprecatedState));

		assertEquals(-1, LifecycleStateComparator.compare(deprecatedState, proposedState));
		assertEquals(-1, LifecycleStateComparator.compare(deprecatedState, definedState));
		assertEquals(-1, LifecycleStateComparator.compare(deprecatedState, developmentState));
		assertEquals(-1, LifecycleStateComparator.compare(deprecatedState, testState));
		assertEquals(0, LifecycleStateComparator.compare(deprecatedState, productiveState));

		assertEquals(-1, LifecycleStateComparator.compare(productiveState, proposedState));
		assertEquals(-1, LifecycleStateComparator.compare(productiveState, definedState));
		assertEquals(-1, LifecycleStateComparator.compare(productiveState, developmentState));
		assertEquals(-1, LifecycleStateComparator.compare(productiveState, testState));

		assertEquals(-1, LifecycleStateComparator.compare(testState, proposedState));
		assertEquals(-1, LifecycleStateComparator.compare(testState, definedState));
		assertEquals(-1, LifecycleStateComparator.compare(testState, developmentState));

		assertEquals(-1, LifecycleStateComparator.compare(developmentState, proposedState));
		assertEquals(-1, LifecycleStateComparator.compare(developmentState, definedState));

		assertEquals(-1, LifecycleStateComparator.compare(definedState, proposedState));
	}

}
