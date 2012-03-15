package org.fornax.soa.scoping.versions;


import org.fornax.soa.basedsl.sOABaseDsl.MajorVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.SOABaseDslFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReferenceKeyTest {

	private MajorVersionRef major1;
	private MajorVersionRef major11;
	private MajorVersionRef major2;
	
	
	@Before
	public void setUp() throws Exception {
		major1 = SOABaseDslFactory.eINSTANCE.createMajorVersionRef();
		major1.setMajorVersion(1);
		major11 = SOABaseDslFactory.eINSTANCE.createMajorVersionRef();
		major11.setMajorVersion(1);
		major2 = SOABaseDslFactory.eINSTANCE.createMajorVersionRef();
		major2.setMajorVersion(2);
	}
	
	@Test
	public void testVersionRefComparison () {
		Assert.assertTrue(major1.getMajorVersion () == (major11.getMajorVersion ()));
		
		Assert.assertFalse (major1.getMajorVersion () == major2.getMajorVersion ());
	}

}
