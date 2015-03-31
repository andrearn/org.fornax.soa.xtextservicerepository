package org.xkonnex.repo.server.web;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.xkonnex.repo.server.web.HomePage;
import org.xkonnex.repo.server.web.XKonneXRepoApplication;
import org.xkonnex.repo.server.web.auth.SignInPage;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage
{
	private WicketTester tester;

	@Before
	public void setUp()
	{
		tester = new WicketTester(new XKonneXRepoApplication());
	}

	@Test
	public void homepageRendersSuccessfully()
	{
		//start and render the test page
		tester.startPage(HomePage.class);

		//assert rendered page class
		tester.assertRenderedPage(SignInPage.class);
	}
}
