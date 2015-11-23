package org.xkonnex.repo.dsl.profiledsl.test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.xkonnex.repo.dsl.basedsl.BaseDslStandaloneSetup;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType;
import org.xkonnex.repo.dsl.profiledsl.ProfileDslStandaloneSetup;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.ProfileDslFactory;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher;

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
	
	private ProfileDslStandaloneSetup setup;
	private Injector injector;

	@Before
	public void setUp () throws Exception {
		ProfileDslFactory factory = ProfileDslFactory.eINSTANCE;
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

		setup = new ProfileDslStandaloneSetup();
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
	

}
