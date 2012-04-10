package org.fornax.soa.basedsl.test.version;

import org.fornax.soa.basedsl.scoping.versions.VersionComparator;
import org.junit.Before;
import org.junit.Test;
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
	}		

}
