package org.xkonnex.repo.dsl.servicedsl.test.scoping.version;

import static org.junit.Assert.assertEquals;

import org.xkonnex.repo.dsl.servicedsl.test.BaseServiceDslTest;
import org.junit.Before;
import org.junit.Test;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Lifecycle;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LifecycleStateComparator;

import com.google.inject.Inject;

public class LifecycleStateComparatorTest extends BaseServiceDslTest {
	

	private LifecycleStateComparator comparator;
	
	@Before
	public void setUp() throws Exception {
		super.setUp ();
		comparator = getInjector ().getInstance (LifecycleStateComparator.class);
		
	}

	@Test
	public void testCompareEqualStates() {
		assertEquals(0, comparator.compare(proposed, proposed));
		assertEquals(0, comparator.compare(defined, defined));
		assertEquals(0, comparator.compare(development, development));
		assertEquals(0, comparator.compare(test, test));
		assertEquals(0, comparator.compare(productive, productive));
		assertEquals(0, comparator.compare(deprecated, deprecated));
		assertEquals(0, comparator.compare(retired, retired));
		
	}
	
	@Test
	public void testCompareHigherStates() {
		assertEquals(-1, comparator.compare(proposed, defined));
		assertEquals(-1, comparator.compare(proposed, development));
		assertEquals(-1, comparator.compare(proposed, test));
		assertEquals(-1, comparator.compare(proposed, productive));
		assertEquals(-1, comparator.compare(proposed, deprecated));
		assertEquals(-1, comparator.compare(proposed, retired));

		assertEquals(-1, comparator.compare(defined, development));
		assertEquals(-1, comparator.compare(defined, test));
		assertEquals(-1, comparator.compare(defined, productive));
		assertEquals(-1, comparator.compare(defined, deprecated));
		assertEquals(-1, comparator.compare(defined, retired));

		assertEquals(-1, comparator.compare(development, test));
		assertEquals(-1, comparator.compare(development, productive));
		assertEquals(-1, comparator.compare(development, deprecated));
		assertEquals(-1, comparator.compare(development, retired));

		assertEquals(-1, comparator.compare(test, productive));
		assertEquals(-1, comparator.compare(test, deprecated));
		assertEquals(-1, comparator.compare(test, retired));

		assertEquals(-1, comparator.compare(productive, deprecated));
		assertEquals(-1, comparator.compare(productive, retired));

		assertEquals(-1, comparator.compare(deprecated, retired));
	}

	@Test
	public void testCompareLowerStates() {
		assertEquals(1, comparator.compare(retired, proposed));
		assertEquals(1, comparator.compare(retired, defined));
		assertEquals(1, comparator.compare(retired, development));
		assertEquals(1, comparator.compare(retired, test));
		assertEquals(1, comparator.compare(retired, productive));
		assertEquals(1, comparator.compare(retired, deprecated));

		assertEquals(1, comparator.compare(deprecated, proposed));
		assertEquals(1, comparator.compare(deprecated, defined));
		assertEquals(1, comparator.compare(deprecated, development));
		assertEquals(1, comparator.compare(deprecated, test));
		assertEquals(1, comparator.compare(deprecated, productive));

		assertEquals(1, comparator.compare(productive, proposed));
		assertEquals(1, comparator.compare(productive, defined));
		assertEquals(1, comparator.compare(productive, development));
		assertEquals(1, comparator.compare(productive, test));

		assertEquals(1, comparator.compare(test, proposed));
		assertEquals(1, comparator.compare(test, defined));
		assertEquals(1, comparator.compare(test, development));

		assertEquals(1, comparator.compare(development, proposed));
		assertEquals(1, comparator.compare(development, defined));

		assertEquals(1, comparator.compare(defined, proposed));
	}

}
