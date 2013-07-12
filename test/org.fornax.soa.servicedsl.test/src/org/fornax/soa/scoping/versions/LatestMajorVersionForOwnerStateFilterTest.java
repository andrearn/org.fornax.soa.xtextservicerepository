package org.fornax.soa.scoping.versions;

import org.fornax.soa.basedsl.version.IScopeVersionResolver;
import org.fornax.soa.basedsl.version.SimpleScopeVersionResolver;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.LatestMajorVersionForOwnerStateFilter;
import org.fornax.soa.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.servicedsl.test.BaseServiceDslTest;
import org.junit.Before;
import org.junit.Ignore;
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
		IScopeVersionResolver verRes = new SimpleScopeVersionResolver(null);
		ILifecycleStateResolver stateResolver = getInjector().getInstance(ILifecycleStateResolver.class);
		String majorVersion = "1";
		LifecycleState minDevLifecycleState = defined;
		LifecycleState minTestLifecycleState = test;
		LifecycleState minProdLifecycleState = productive;
		
		
		devFilter =  new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , development, resource.getResourceSet());
		testFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , test, resource.getResourceSet());
		prodFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , productive, resource.getResourceSet());
		defFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , defined, resource.getResourceSet());
		propFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , proposed, resource.getResourceSet());
		deprFilter = new LatestMajorVersionForOwnerStateFilter(verRes, majorVersion, stateResolver , deprecated, resource.getResourceSet());
		
		getInjector().injectMembers (devFilter);
		getInjector().injectMembers (testFilter);
		getInjector().injectMembers (prodFilter);
		getInjector().injectMembers (defFilter);
		getInjector().injectMembers (propFilter);
		getInjector().injectMembers (deprFilter);
	}

	
	@Ignore
	public void testGetBestMatchByNames() {
	}

	@Ignore
	public void testMatches() {
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

	@Ignore
	public void testToMajorVersion() {
	}

	@Ignore
	public void testGetBestMatchByQualifedNames() {
	}

}
