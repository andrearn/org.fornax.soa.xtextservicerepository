package org.xkonnex.repo.dsl.servicedsl.test.scoping.versions;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MajorVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslFactory;

public class ReferenceKeyTest {

	private MajorVersionRef major1;
	private MajorVersionRef major11;
	private MajorVersionRef major2;
	
	
	@Before
	public void setUp() throws Exception {
		major1 = BaseDslFactory.eINSTANCE.createMajorVersionRef();
		major1.setMajorVersion(1);
		major11 = BaseDslFactory.eINSTANCE.createMajorVersionRef();
		major11.setMajorVersion(1);
		major2 = BaseDslFactory.eINSTANCE.createMajorVersionRef();
		major2.setMajorVersion(2);
	}
	
	@Test
	public void testVersionRefComparison () {
		Assert.assertTrue(major1.getMajorVersion () == (major11.getMajorVersion ()));
		
		Assert.assertFalse (major1.getMajorVersion () == major2.getMajorVersion ());
	}

}
