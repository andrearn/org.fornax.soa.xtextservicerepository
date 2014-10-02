package org.xkonnex.repo.dsl.basedsl.test.version;

import org.junit.Before;
import org.junit.Test;
import org.xkonnex.repo.dsl.basedsl.version.VersionComparator;

import static org.junit.Assert.*;

public class VersionComparatorTest {

	@Before
	public void setUp () throws Exception {
	}
	
	@Test
	public void testSimpleVersionStringComparision () {
		assertTrue (VersionComparator.compare ("1.0", "1.1") < 0);
		assertTrue (VersionComparator.compare ("1.1.1", "1.1") > 0);
		assertTrue (VersionComparator.compare ("1.0", "1.0") == 0);
		assertTrue (VersionComparator.compare ("1.0.0", "1.0") == 0);
		assertTrue (VersionComparator.compare ("1.0.1", "1.1.0") < 0);
		assertTrue (VersionComparator.compare ("2.0.0", "3.1") < 0);
		assertTrue (VersionComparator.compare ("1", "2") < 0);
		assertTrue (VersionComparator.compare ("2", "1") > 0);
		assertTrue (VersionComparator.compare ("1", "1") == 0);
		assertTrue (VersionComparator.compare ("1", "1.1") < 0);
		assertTrue (VersionComparator.compare ("1.1", "1") > 0);
		assertTrue (VersionComparator.compare ("2", "1.1") > 0);
		assertTrue (VersionComparator.compare ("1.1", "2") < 0);
		
	}
	
	@Test
	public void testSpecialVersionStringComparision () {
		assertTrue (VersionComparator.compare ("1.0", "1.0.Final") == 0);
		assertTrue (VersionComparator.compare ("1.0.Final", "1.0") == 0);
		assertTrue (VersionComparator.compare ("1.0.0", "1.0.Final") == 0);
		assertTrue (VersionComparator.compare ("1.0.Final", "1.0.0") == 0);
		assertTrue (VersionComparator.compare ("1.0", "1.0.beta1") > 0);
		assertTrue (VersionComparator.compare ("1.0.1", "1.0.beta1") > 0);
		assertTrue (VersionComparator.compare ("1.1", "1.0.beta1") > 0);
		assertTrue (VersionComparator.compare ("1.0", "1.0.M1") > 0);
		assertTrue (VersionComparator.compare ("1.0", "1.0.milestone-1") > 0);
		assertTrue (VersionComparator.compare ("1.0", "1.0.alpha1") > 0);
		assertTrue (VersionComparator.compare ("1.0", "1.0.RC1") > 0);
		assertTrue (VersionComparator.compare ("1.0", "1.0.CR1") > 0);
		assertTrue (VersionComparator.compare ("1.0.RC1", "1.0.CR1") == 0);
		assertTrue (VersionComparator.compare ("1.0.final", "1.0.beta1") > 0);

		assertTrue (VersionComparator.compare ("1.0.aplha1", "1.0.m1") > 0);
		assertTrue (VersionComparator.compare ("1.0.beta1", "1.0.m1") > 0);
		assertTrue (VersionComparator.compare ("1.0.RC1", "1.0.m1") > 0);
		assertTrue (VersionComparator.compare ("1.0.CR1", "1.0.m1") > 0);
		assertTrue (VersionComparator.compare ("1.0.Final", "1.0.m1") > 0);

		assertTrue (VersionComparator.compare ("1.0.beta1", "1.0.alpha1") > 0);
		assertTrue (VersionComparator.compare ("1.0.RC1", "1.0.alpha1") > 0);
		assertTrue (VersionComparator.compare ("1.0.CR1", "1.0.alpha1") > 0);
		assertTrue (VersionComparator.compare ("1.0.Final", "1.0.alpha1") > 0);

		assertTrue (VersionComparator.compare ("1.0.RC1", "1.0.beta1") > 0);
		assertTrue (VersionComparator.compare ("1.0.CR1", "1.0.beta1") > 0);
		assertTrue (VersionComparator.compare ("1.0.Final", "1.0.beta1") > 0);

		assertTrue (VersionComparator.compare ("1.0.Final", "1.0.CR1") > 0);
		assertTrue (VersionComparator.compare ("1.0.Final", "1.0.RC1") > 0);
		assertTrue (VersionComparator.compare ("1.0-SNAPSHOT", "1.0") < 0);
		assertTrue (VersionComparator.compare ("1.0", "1.0-SNAPSHOT") > 0);
		assertTrue (VersionComparator.compare ("1.0-SNAPSHOT", "1.1") < 0);
		assertTrue (VersionComparator.compare ("1.1", "1.0-SNAPSHOT") > 0);
		assertTrue (VersionComparator.compare ("1.0.Beta1", "1.0-Beta1_SNAPSHOT") > 0);
		assertTrue (VersionComparator.compare ("1.0-Beta1", "1.0-Beta1_SNAPSHOT") > 0);
		assertTrue (VersionComparator.compare ("1.0-Beta1", "1.0-Beta1-SNAPSHOT") > 0);
		assertTrue (VersionComparator.compare ("1.0.beta1", "1.0.beta0") > 0);
		assertTrue (VersionComparator.compare ("1.0.beta1", "1.0.beta11") < 0);
		assertTrue (VersionComparator.compare ("1.0.beta1", "1.0.beta9") < 0);
		assertTrue (VersionComparator.compare ("1.0.alpha9", "1.0.beta9") < 0);
	}		

}
