package org.fornax.soa.scoping.versions;

import org.fornax.soa.basedsl.scoping.versions.BaseDslVersionResolver;
import org.fornax.soa.basedsl.scoping.versions.VersionResolver;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.LatestMajorVersionForOwnerStateFilter;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.servicedsl.test.BaseServiceDslTest;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class LatestMajorVersionForOwnerStateFilterTest extends BaseServiceDslTest {

	private LatestMajorVersionForOwnerStateFilter devFilter;
	private LatestMajorVersionForOwnerStateFilter testFilter;
	private LatestMajorVersionForOwnerStateFilter prodFilter;
	private LatestMajorVersionForOwnerStateFilter defFilter;
	private LatestMajorVersionForOwnerStateFilter propFilter;
	private LatestMajorVersionForOwnerStateFilter deprFilter;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		VersionResolver verRes = new BaseDslVersionResolver(null);
		LifecycleStateResolver stateResolver = new StateAttributeLifecycleStateResolver(null);
		String majorVersion = "1";
		LifecycleState minDevLifecycleState = defined;
		LifecycleState minTestLifecycleState = test;
		LifecycleState minProdLifecycleState = productive;
		devFilter =  new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , development, minDevLifecycleState, minTestLifecycleState, minProdLifecycleState);
		testFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , test, minDevLifecycleState, minTestLifecycleState, minProdLifecycleState);
		prodFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , productive, minDevLifecycleState, minTestLifecycleState, minProdLifecycleState);
		defFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , defined, minDevLifecycleState, minTestLifecycleState, minProdLifecycleState);
		propFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , proposed, minDevLifecycleState, minTestLifecycleState, minProdLifecycleState);
		deprFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , deprecated, minDevLifecycleState, minTestLifecycleState, minProdLifecycleState);
		
		getInjector().injectMembers (devFilter);
		getInjector().injectMembers (testFilter);
		getInjector().injectMembers (prodFilter);
		getInjector().injectMembers (defFilter);
		getInjector().injectMembers (propFilter);
		getInjector().injectMembers (deprFilter);
	}

	
	@Test
	public void testGetBestMatchByNames() {
		fail("Not yet implemented");
	}

	@Test
	public void testMatches() {
		fail("Not yet implemented");
	}

	@Test
	public void testStateMatches() {
		assertFalse (devFilter.stateMatches(proposed));
		assertTrue (devFilter.stateMatches(defined));
		assertTrue (devFilter.stateMatches(development));
		assertTrue (defFilter.stateMatches(defined));
		assertFalse (testFilter.stateMatches(development));
		assertFalse (prodFilter.stateMatches(test));
		assertTrue (testFilter.stateMatches(test));
		assertTrue (prodFilter.stateMatches(productive));
		assertTrue (deprFilter.stateMatches(productive));
		assertTrue (deprFilter.stateMatches(deprecated));
		assertFalse (defFilter.stateMatches(retired));
		assertFalse (devFilter.stateMatches(retired));
		assertFalse (testFilter.stateMatches(retired));
		assertFalse (prodFilter.stateMatches(retired));
		assertFalse (deprFilter.stateMatches(retired));
		
	}

	@Test
	public void testToMajorVersion() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBestMatchByQualifedNames() {
		fail("Not yet implemented");
	}

}
