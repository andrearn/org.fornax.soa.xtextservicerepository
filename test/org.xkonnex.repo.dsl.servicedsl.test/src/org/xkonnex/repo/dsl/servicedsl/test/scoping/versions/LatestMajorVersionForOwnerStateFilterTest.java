package org.xkonnex.repo.dsl.servicedsl.test.scoping.versions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xkonnex.repo.dsl.basedsl.version.IScopeVersionResolver;
import org.xkonnex.repo.dsl.basedsl.version.SimpleScopeVersionResolver;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LatestMajorVersionForOwnerStateFilter;
import org.xkonnex.repo.dsl.servicedsl.test.BaseServiceDslTest;
import org.xkonnex.repo.dsl.servicedsl.test.ServiceDslWithDependenciesInjector;

import com.google.inject.Injector;

@RunWith(XtextRunner.class)
@InjectWith(ServiceDslWithDependenciesInjector.class)
public class LatestMajorVersionForOwnerStateFilterTest extends BaseServiceDslTest {

	private LatestMajorVersionForOwnerStateFilter devFilter;
	private LatestMajorVersionForOwnerStateFilter testFilter;
	private LatestMajorVersionForOwnerStateFilter prodFilter;
	private LatestMajorVersionForOwnerStateFilter defFilter;
	private LatestMajorVersionForOwnerStateFilter propFilter;
	private LatestMajorVersionForOwnerStateFilter deprFilter;
	
	@Inject
	private Injector injector;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		IScopeVersionResolver verRes = new SimpleScopeVersionResolver(null);
		ILifecycleStateResolver stateResolver = injector.getInstance(ILifecycleStateResolver.class);
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
		
		injector.injectMembers (devFilter);
		injector.injectMembers (testFilter);
		injector.injectMembers (prodFilter);
		injector.injectMembers (defFilter);
		injector.injectMembers (propFilter);
		injector.injectMembers (deprFilter);
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
