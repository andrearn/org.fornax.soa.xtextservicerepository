package org.fornax.soa.profiledsl.test;


import org.fornax.soa.basedsl.SOABaseDslStandaloneSetup;
import org.fornax.soa.environmentDsl.EnvironmentType;
import org.fornax.soa.profiledsl.SOAProfileDslStandaloneSetup;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfileDslFactory;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Injector;

public class DefaultStateMatcher {
	private LifecycleState proposed;
	private LifecycleState defined;
	private LifecycleState development;
	private LifecycleState test;
	private LifecycleState productive;
	private LifecycleState deprecated;
	private LifecycleState retired;
	
	private Lifecycle lifecycle;
	
	private SOAProfileDslStandaloneSetup setup;
	private Injector injector;

	@Before
	public void setUp () throws Exception {
		SOAProfileDslFactory factory = SOAProfileDslFactory.eINSTANCE;
		lifecycle = factory.createLifecycle ();
		proposed = factory.createLifecycleState ();
		proposed.setName ("proposed");
		proposed.setIsInitial (true);
		proposed.getQualifiesFor ().add (EnvironmentType.LOCAL);
		proposed.getQualifiesFor ().add (EnvironmentType.DEV);
		
		defined = factory.createLifecycleState ();
		defined.setName ("defined");
		defined.getQualifiesFor ().add (EnvironmentType.LOCAL);
		defined.getQualifiesFor ().add (EnvironmentType.DEV);
		
		development = factory.createLifecycleState ();
		development.setName ("development");
		development.getQualifiesFor ().add (EnvironmentType.LOCAL);
		development.getQualifiesFor ().add (EnvironmentType.DEV);
		
		test = factory.createLifecycleState ();
		test.setName ("test");
		test.getQualifiesFor ().add (EnvironmentType.LOCAL);
		test.getQualifiesFor ().add (EnvironmentType.DEV);
		test.getQualifiesFor ().add (EnvironmentType.TEST);
		test.getQualifiesFor ().add (EnvironmentType.STAGING);
		
		productive = factory.createLifecycleState ();
		productive.setName ("productive");
		productive.getQualifiesFor ().add (EnvironmentType.LOCAL);
		productive.getQualifiesFor ().add (EnvironmentType.DEV);
		productive.getQualifiesFor ().add (EnvironmentType.TEST);
		productive.getQualifiesFor ().add (EnvironmentType.STAGING);
		productive.getQualifiesFor ().add (EnvironmentType.PROD);
		
		deprecated = factory.createLifecycleState ();
		deprecated.setName ("deprecated");
		deprecated.getQualifiesFor ().add (EnvironmentType.LOCAL);
		deprecated.getQualifiesFor ().add (EnvironmentType.DEV);
		deprecated.getQualifiesFor ().add (EnvironmentType.TEST);
		deprecated.getQualifiesFor ().add (EnvironmentType.STAGING);
		deprecated.getQualifiesFor ().add (EnvironmentType.PROD);
		
		retired = factory.createLifecycleState ();
		retired.setName ("retired");
		retired.setIsEnd (true);
		
		lifecycle.getStates ().add (proposed);
		lifecycle.getStates ().add (defined);
		lifecycle.getStates ().add (development);
		lifecycle.getStates ().add (test);
		lifecycle.getStates ().add (productive);
		lifecycle.getStates ().add (deprecated);
		lifecycle.getStates ().add (retired);

		setup = new SOAProfileDslStandaloneSetup();
		injector = setup.createInjectorAndDoEMFRegistration ();
	}
	
	@Test
	public void testMatches () {
		IStateMatcher matcher = injector.getInstance (IStateMatcher.class);
		assertTrue (matcher.matches (proposed, proposed));
		assertTrue (matcher.matches (proposed, defined));
		assertTrue (matcher.matches (proposed, development));
		assertTrue (matcher.matches (proposed, test));
		assertTrue (matcher.matches (proposed, productive));
		assertTrue (matcher.matches (proposed, deprecated));
		assertFalse (matcher.matches (proposed, retired));

		assertTrue (matcher.matches (defined, proposed));
		assertTrue (matcher.matches (defined, defined));
		assertTrue (matcher.matches (defined, development));
		assertTrue (matcher.matches (defined, test));
		assertTrue (matcher.matches (defined, productive));
		assertTrue (matcher.matches (defined, deprecated));
		assertFalse (matcher.matches (defined, retired));

		assertTrue (matcher.matches (development, proposed));
		assertTrue (matcher.matches (development, defined));
		assertTrue (matcher.matches (development, development));
		assertTrue (matcher.matches (development, test));
		assertTrue (matcher.matches (development, productive));
		assertTrue (matcher.matches (development, deprecated));
		assertFalse (matcher.matches (development, retired));

		assertFalse (matcher.matches (test, proposed));
		assertFalse (matcher.matches (test, defined));
		assertFalse (matcher.matches (test, development));
		assertTrue (matcher.matches (test, test));
		assertTrue (matcher.matches (test, productive));
		assertTrue (matcher.matches (test, deprecated));
		assertFalse (matcher.matches (test, retired));

		assertFalse (matcher.matches (productive, proposed));
		assertFalse (matcher.matches (productive, defined));
		assertFalse (matcher.matches (productive, development));
		assertFalse (matcher.matches (productive, test));
		assertTrue (matcher.matches (productive, productive));
		assertTrue (matcher.matches (productive, deprecated));
		assertFalse (matcher.matches (productive, retired));

		assertFalse (matcher.matches (deprecated, proposed));
		assertFalse (matcher.matches (deprecated, defined));
		assertFalse (matcher.matches (deprecated, development));
		assertFalse (matcher.matches (deprecated, test));
		assertTrue (matcher.matches (deprecated, productive));
		assertTrue (matcher.matches (deprecated, deprecated));
		assertFalse (matcher.matches (deprecated, retired));

		assertTrue (matcher.matches (retired, proposed));
		assertTrue (matcher.matches (retired, defined));
		assertTrue (matcher.matches (retired, development));
		assertTrue (matcher.matches (retired, test));
		assertTrue (matcher.matches (retired, productive));
		assertTrue (matcher.matches (retired, deprecated));
		assertTrue (matcher.matches (retired, retired));

	}
	
	@Test
	public void testMatchesWithMinStates () {
		IStateMatcher matcher = injector.getInstance (IStateMatcher.class);
		assertTrue (matcher.matches (proposed, proposed, proposed, test, productive));
		assertTrue (matcher.matches (proposed, defined, proposed, test, productive));
		assertTrue (matcher.matches (proposed, development, proposed, test, productive));
		assertTrue (matcher.matches (proposed, test, proposed, test, productive));
		assertTrue (matcher.matches (proposed, productive, proposed, test, productive));
		assertTrue (matcher.matches (proposed, deprecated, proposed, test, productive));
		assertFalse (matcher.matches (proposed, retired, proposed, test, productive));

		assertTrue (matcher.matches (defined, proposed, proposed, test, productive));
		assertTrue (matcher.matches (defined, defined, proposed, test, productive));
		assertTrue (matcher.matches (defined, development, proposed, test, productive));
		assertTrue (matcher.matches (defined, test, proposed, test, productive));
		assertTrue (matcher.matches (defined, productive, proposed, test, productive));
		assertTrue (matcher.matches (defined, deprecated, proposed, test, productive));
		assertFalse (matcher.matches (defined, retired, proposed, test, productive));

		assertTrue (matcher.matches (development, proposed, proposed, test, productive));
		assertTrue (matcher.matches (development, defined, proposed, test, productive));
		assertTrue (matcher.matches (development, development, proposed, test, productive));
		assertTrue (matcher.matches (development, test, proposed, test, productive));
		assertTrue (matcher.matches (development, productive, proposed, test, productive));
		assertTrue (matcher.matches (development, deprecated, proposed, test, productive));
		assertFalse (matcher.matches (development, retired, proposed, test, productive));

		assertFalse (matcher.matches (test, proposed, proposed, test, productive));
		assertFalse (matcher.matches (test, defined, proposed, test, productive));
		assertFalse (matcher.matches (test, development, proposed, test, productive));
		assertTrue (matcher.matches (test, test, proposed, test, productive));
		assertTrue (matcher.matches (test, productive, proposed, test, productive));
		assertTrue (matcher.matches (test, deprecated, proposed, test, productive));
		assertFalse (matcher.matches (test, retired, proposed, test, productive));

		assertFalse (matcher.matches (productive, proposed, proposed, test, productive));
		assertFalse (matcher.matches (productive, defined, proposed, test, productive));
		assertFalse (matcher.matches (productive, development, proposed, test, productive));
		assertFalse (matcher.matches (productive, test, proposed, test, productive));
		assertTrue (matcher.matches (productive, productive, proposed, test, productive));
		assertTrue (matcher.matches (productive, deprecated, proposed, test, productive));
		assertFalse (matcher.matches (productive, retired, proposed, test, productive));

		assertFalse (matcher.matches (deprecated, proposed, proposed, test, productive));
		assertFalse (matcher.matches (deprecated, defined, proposed, test, productive));
		assertFalse (matcher.matches (deprecated, development, proposed, test, productive));
		assertFalse (matcher.matches (deprecated, test, proposed, test, productive));
		assertTrue (matcher.matches (deprecated, productive, proposed, test, productive));
		assertTrue (matcher.matches (deprecated, deprecated, proposed, test, productive));
		assertFalse (matcher.matches (deprecated, retired, proposed, test, productive));

		assertTrue (matcher.matches (retired, proposed, proposed, test, productive));
		assertTrue (matcher.matches (retired, defined, proposed, test, productive));
		assertTrue (matcher.matches (retired, development, proposed, test, productive));
		assertTrue (matcher.matches (retired, test, proposed, test, productive));
		assertTrue (matcher.matches (retired, productive, proposed, test, productive));
		assertTrue (matcher.matches (retired, deprecated, proposed, test, productive));
		assertTrue (matcher.matches (retired, retired, proposed, test, productive));

	}

}
