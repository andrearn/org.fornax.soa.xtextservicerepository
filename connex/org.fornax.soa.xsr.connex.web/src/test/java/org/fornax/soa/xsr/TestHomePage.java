package org.fornax.soa.xsr;

import org.apache.wicket.util.tester.WicketTester;
import org.fornax.soa.xsr.connex.web.ConnexApplication;
import org.fornax.soa.xsr.connex.web.HomePage;
import org.junit.Before;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage
{
	private WicketTester tester;

	@Before
	public void setUp()
	{
		tester = new WicketTester(new ConnexApplication());
	}

	@Test
	public void homepageRendersSuccessfully()
	{
		//start and render the test page
		tester.startPage(HomePage.class);

		//assert rendered page class
		tester.assertRenderedPage(HomePage.class);
	}
}
