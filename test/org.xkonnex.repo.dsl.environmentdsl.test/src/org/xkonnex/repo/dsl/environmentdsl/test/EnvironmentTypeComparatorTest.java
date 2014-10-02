package org.xkonnex.repo.dsl.environmentdsl.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentDslFactory;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType;
import org.xkonnex.repo.dsl.environmentdsl.util.EnvironmentTypeComparator;

public class EnvironmentTypeComparatorTest {

	@Before
	public void setUp () throws Exception {
	}

	@Test
	public void testCompare () {
		EnvironmentTypeComparator comparator = new EnvironmentTypeComparator();
		assertEquals (0, comparator.compare (EnvironmentType.LOCAL, EnvironmentType.LOCAL));
		assertEquals (-1, comparator.compare (EnvironmentType.LOCAL, EnvironmentType.DEV));
		assertEquals (-1, comparator.compare (EnvironmentType.LOCAL, EnvironmentType.TEST));
		assertEquals (-1, comparator.compare (EnvironmentType.LOCAL, EnvironmentType.STAGING));
		assertEquals (-1, comparator.compare (EnvironmentType.LOCAL, EnvironmentType.PROD));
		assertEquals (-1, comparator.compare (EnvironmentType.LOCAL, EnvironmentType.OTHER));

		assertEquals (1, comparator.compare (EnvironmentType.DEV, EnvironmentType.LOCAL));
		assertEquals (0, comparator.compare (EnvironmentType.DEV, EnvironmentType.DEV));
		assertEquals (-1, comparator.compare (EnvironmentType.DEV, EnvironmentType.TEST));
		assertEquals (-1, comparator.compare (EnvironmentType.DEV, EnvironmentType.STAGING));
		assertEquals (-1, comparator.compare (EnvironmentType.DEV, EnvironmentType.PROD));
		assertEquals (1, comparator.compare (EnvironmentType.DEV, EnvironmentType.OTHER));

		assertEquals (1, comparator.compare (EnvironmentType.TEST, EnvironmentType.LOCAL));
		assertEquals (1, comparator.compare (EnvironmentType.TEST, EnvironmentType.DEV));
		assertEquals (0, comparator.compare (EnvironmentType.TEST, EnvironmentType.TEST));
		assertEquals (-1, comparator.compare (EnvironmentType.TEST, EnvironmentType.STAGING));
		assertEquals (-1, comparator.compare (EnvironmentType.TEST, EnvironmentType.PROD));
		assertEquals (1, comparator.compare (EnvironmentType.TEST, EnvironmentType.OTHER));

		assertEquals (1, comparator.compare (EnvironmentType.STAGING, EnvironmentType.LOCAL));
		assertEquals (1, comparator.compare (EnvironmentType.STAGING, EnvironmentType.DEV));
		assertEquals (1, comparator.compare (EnvironmentType.STAGING, EnvironmentType.TEST));
		assertEquals (0, comparator.compare (EnvironmentType.STAGING, EnvironmentType.STAGING));
		assertEquals (-1, comparator.compare (EnvironmentType.STAGING, EnvironmentType.PROD));
		assertEquals (1, comparator.compare (EnvironmentType.STAGING, EnvironmentType.OTHER));

		assertEquals (1, comparator.compare (EnvironmentType.OTHER, EnvironmentType.LOCAL));
		assertEquals (-1, comparator.compare (EnvironmentType.OTHER, EnvironmentType.DEV));
		assertEquals (-1, comparator.compare (EnvironmentType.OTHER, EnvironmentType.TEST));
		assertEquals (-1, comparator.compare (EnvironmentType.OTHER, EnvironmentType.STAGING));
		assertEquals (-1, comparator.compare (EnvironmentType.OTHER, EnvironmentType.PROD));
		assertEquals (0, comparator.compare (EnvironmentType.OTHER, EnvironmentType.OTHER));

		assertEquals (1, comparator.compare (EnvironmentType.PROD, EnvironmentType.LOCAL));
		assertEquals (1, comparator.compare (EnvironmentType.PROD, EnvironmentType.DEV));
		assertEquals (1, comparator.compare (EnvironmentType.PROD, EnvironmentType.TEST));
		assertEquals (1, comparator.compare (EnvironmentType.PROD, EnvironmentType.STAGING));
		assertEquals (0, comparator.compare (EnvironmentType.PROD, EnvironmentType.PROD));
		assertEquals (1, comparator.compare (EnvironmentType.PROD, EnvironmentType.OTHER));
	}

}
