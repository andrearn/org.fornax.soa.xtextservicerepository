package org.xkonnex.repo.dsl.profiledsl.test;


import org.junit.Before;
import org.junit.Test;
import org.xkonnex.repo.dsl.basedsl.SOABaseDslStandaloneSetup;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType;
import org.xkonnex.repo.dsl.profiledsl.SOAProfileDslStandaloneSetup;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Lifecycle;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfileDslFactory;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LifecycleStateComparator;

import com.google.inject.Injector;

import static org.junit.Assert.*;

public class LifecycleStateComparatorTest {
	
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
	public void testCompare () {
		
		LifecycleStateComparator comparator = injector.getInstance (LifecycleStateComparator.class);
		
		assertEquals(0, comparator.compare (proposed, proposed));
		assertEquals(-1, comparator.compare (proposed, defined));
		assertEquals(-1, comparator.compare (proposed, development));
		assertEquals(-1, comparator.compare (proposed, test));
		assertEquals(-1, comparator.compare (proposed, productive));
		assertEquals(-1, comparator.compare (proposed, deprecated));
		assertEquals(-1, comparator.compare (proposed, retired));
		
		assertEquals(1, comparator.compare (defined, proposed));
		assertEquals(0, comparator.compare (defined, defined));
		assertEquals(-1, comparator.compare (defined, development));
		assertEquals(-1, comparator.compare (defined, test));
		assertEquals(-1, comparator.compare (defined, productive));
		assertEquals(-1, comparator.compare (defined, deprecated));
		assertEquals(-1, comparator.compare (defined, retired));
		
		assertEquals(1, comparator.compare (development, proposed));
		assertEquals(1, comparator.compare (development, defined));
		assertEquals(0, comparator.compare (development, development));
		assertEquals(-1, comparator.compare (development, test));
		assertEquals(-1, comparator.compare (development, productive));
		assertEquals(-1, comparator.compare (development, deprecated));
		assertEquals(-1, comparator.compare (development, retired));
		
		assertEquals(1, comparator.compare (test, proposed));
		assertEquals(1, comparator.compare (test, defined));
		assertEquals(1, comparator.compare (test, development));
		assertEquals(0, comparator.compare (test, test));
		assertEquals(-1, comparator.compare (test, productive));
		assertEquals(-1, comparator.compare (test, deprecated));
		assertEquals(-1, comparator.compare (test, retired));
		
		assertEquals(1, comparator.compare (productive, proposed));
		assertEquals(1, comparator.compare (productive, defined));
		assertEquals(1, comparator.compare (productive, development));
		assertEquals(1, comparator.compare (productive, test));
		assertEquals(0, comparator.compare (productive, productive));
		assertEquals(-1, comparator.compare (productive, deprecated));
		assertEquals(-1, comparator.compare (productive, retired));
		
		assertEquals(1, comparator.compare (deprecated, proposed));
		assertEquals(1, comparator.compare (deprecated, defined));
		assertEquals(1, comparator.compare (deprecated, development));
		assertEquals(1, comparator.compare (deprecated, test));
		assertEquals(1, comparator.compare (deprecated, productive));
		assertEquals(0, comparator.compare (deprecated, deprecated));
		assertEquals(-1, comparator.compare (deprecated, retired));
		
		assertEquals(1, comparator.compare (retired, proposed));
		assertEquals(1, comparator.compare (retired, defined));
		assertEquals(1, comparator.compare (retired, development));
		assertEquals(1, comparator.compare (retired, test));
		assertEquals(1, comparator.compare (retired, productive));
		assertEquals(1, comparator.compare (retired, deprecated));
		assertEquals(0, comparator.compare (retired, retired));

		assertEquals(0, comparator.compare (null, null));
		assertEquals(0, comparator.compare (null, productive));
		assertEquals(0, comparator.compare (productive, null));
	}

}
