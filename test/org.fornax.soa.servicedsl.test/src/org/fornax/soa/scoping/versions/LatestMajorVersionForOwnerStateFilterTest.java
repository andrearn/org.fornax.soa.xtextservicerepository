package org.fornax.soa.scoping.versions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;
import org.fornax.soa.basedsl.scoping.versions.LatestMajorVersionForOwnerStateFilter;
import org.fornax.soa.basedsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.basedsl.scoping.versions.ServiceDslLifecycleStateResolver;
import org.fornax.soa.basedsl.scoping.versions.BaseDslVersionResolver;
import org.fornax.soa.basedsl.scoping.versions.VersionResolver;
import org.fornax.soa.servicedsl.test.BaseServiceDslTest;
import org.junit.Before;
import org.junit.Test;

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
		LifecycleStateResolver stateResolver = new ServiceDslLifecycleStateResolver(null);
		String majorVersion = "1";
		LifecycleState minDevLifecycleState = LifecycleState.DEFINED;
		LifecycleState minTestLifecycleState = LifecycleState.TEST;
		LifecycleState minProdLifecycleState = LifecycleState.PRODUCTIVE;
		devFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , LifecycleState.DEVELOPMENT, minDevLifecycleState, minTestLifecycleState, minProdLifecycleState);
		testFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , LifecycleState.TEST, minDevLifecycleState, minTestLifecycleState, minProdLifecycleState);
		prodFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , LifecycleState.PRODUCTIVE, minDevLifecycleState, minTestLifecycleState, minProdLifecycleState);
		defFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , LifecycleState.DEFINED, minDevLifecycleState, minTestLifecycleState, minProdLifecycleState);
		propFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , LifecycleState.PROPOSED, minDevLifecycleState, minTestLifecycleState, minProdLifecycleState);
		deprFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , LifecycleState.DEPRECATED, minDevLifecycleState, minTestLifecycleState, minProdLifecycleState);
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
		assertFalse (devFilter.stateMatches(LifecycleState.PROPOSED));
		assertTrue (devFilter.stateMatches(LifecycleState.DEFINED));
		assertTrue (devFilter.stateMatches(LifecycleState.DEVELOPMENT));
		assertTrue (defFilter.stateMatches(LifecycleState.DEFINED));
		assertFalse (testFilter.stateMatches(LifecycleState.DEVELOPMENT));
		assertFalse (prodFilter.stateMatches(LifecycleState.TEST));
		assertTrue (testFilter.stateMatches(LifecycleState.TEST));
		assertTrue (prodFilter.stateMatches(LifecycleState.PRODUCTIVE));
		assertTrue (deprFilter.stateMatches(LifecycleState.PRODUCTIVE));
		assertTrue (deprFilter.stateMatches(LifecycleState.DEPRECATED));
		assertFalse (defFilter.stateMatches(LifecycleState.RETIRED));
		assertFalse (devFilter.stateMatches(LifecycleState.RETIRED));
		assertFalse (testFilter.stateMatches(LifecycleState.RETIRED));
		assertFalse (prodFilter.stateMatches(LifecycleState.RETIRED));
		assertFalse (deprFilter.stateMatches(LifecycleState.RETIRED));
		
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
