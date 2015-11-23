package org.xkonnex.repo.dsl.profiledsl.test;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.service.DefaultRuntimeModule;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xkonnex.repo.dsl.basedsl.BaseDslRuntimeModule;
import org.xkonnex.repo.dsl.basedsl.BaseDslStandaloneSetup;
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslFactory;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version;
import org.xkonnex.repo.dsl.basedsl.baseDsl.impl.BaseDslFactoryImpl;
import org.xkonnex.repo.dsl.basedsl.resource.EObjectDescriptionBuilder;
import org.xkonnex.repo.dsl.basedsl.resource.IEObjectDescriptionBuilder;
import org.xkonnex.repo.dsl.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.xkonnex.repo.dsl.basedsl.search.DefaultPredicateSearch;
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch;
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider;
import org.xkonnex.repo.dsl.basedsl.validation.ReflectivePluggableValidatorProvider;
import org.xkonnex.repo.dsl.basedsl.version.IScopeVersionResolver;
import org.xkonnex.repo.dsl.basedsl.version.SimpleScopeVersionResolver;
import org.xkonnex.repo.dsl.basedsl.version.VersionedOwnerScopeVersionResolver;
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslRuntimeModule;
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslStandaloneSetup;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType;
import org.xkonnex.repo.dsl.profiledsl.ProfileDslRuntimeModule;
import org.xkonnex.repo.dsl.profiledsl.ProfileDslStandaloneSetup;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Class;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.ProfileDslFactory;
import org.xkonnex.repo.dsl.profiledsl.search.predicate.VersionAndLifecycleStatePredicate;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Injector;

@RunWith (XtextRunner.class)
public class VersionAndLifecycleStatePredicateTest extends AbstractXtextTests {
	
	private LifecycleState proposed;
	private LifecycleState defined;
	private LifecycleState development;
	private LifecycleState test;
	private LifecycleState productive;
	private LifecycleState deprecated;
	private LifecycleState retired;
	
	private Lifecycle lifecycle;
	private Injector testInjector;
	
	private org.xkonnex.repo.dsl.profiledsl.profileDsl.Class versionedAsset;
	
	private ProfileDslStandaloneSetup setup;
	private BaseDslStandaloneSetup baseDslSetup;
	private ResourceSet resourceSet = new  ResourceSetImpl();

	@Before
	public void setUp () throws Exception {
		super.setUp();
		setup = new ProfileDslStandaloneSetup();
		with (setup);
		testInjector = getInjector().createChildInjector(new AbstractModule () {

			@Override
			protected void configure () {
				
				bind(IEObjectDescriptionBuilder.class).toInstance (new EObjectDescriptionBuilder());
				
				bind(IScopeVersionResolver.class).to(SimpleScopeVersionResolver.class);
				
				bind(BaseDslFactory.class).to( BaseDslFactoryImpl.class);
			}
		});
		
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
		
		BaseDslFactory baseDslFactory = BaseDslFactory.eINSTANCE;
		Version version = baseDslFactory.createVersion();
		version.setVersion("1.1");
		
		versionedAsset = factory.createClass();
		versionedAsset.setName("TestAssetClass");
		versionedAsset.setVersion(version);
		versionedAsset.setState(development);

		setup = new ProfileDslStandaloneSetup();
	}
	
	@Test
	public void testVersionMatches () {
		IEObjectDescriptionBuilder iEObjDescBuilder = testInjector.getInstance(IEObjectDescriptionBuilder.class);
		IEObjectDescription assetDesc =iEObjDescBuilder.buildDescription(versionedAsset);

		VersionAndLifecycleStatePredicate sameVersionPredicate = new VersionAndLifecycleStatePredicate(development, null, "1.1", null, resourceSet);
		testInjector.injectMembers(sameVersionPredicate);
		assertTrue (sameVersionPredicate.apply(assetDesc));
		
		VersionAndLifecycleStatePredicate sameVersionPredicate2 = new VersionAndLifecycleStatePredicate(development, true, null, false, "1.1", null, true, false, resourceSet);
		testInjector.injectMembers(sameVersionPredicate2);
		assertTrue (sameVersionPredicate2.apply(assetDesc));

		VersionAndLifecycleStatePredicate higherMinVersionPredicate = new VersionAndLifecycleStatePredicate(development, true, null, true, "1.2", "2.0", true, true, resourceSet);
		testInjector.injectMembers(higherMinVersionPredicate);
		assertFalse (higherMinVersionPredicate.apply(assetDesc));
		
		VersionAndLifecycleStatePredicate higherMinVersionPredicate2 = new VersionAndLifecycleStatePredicate(development, true, null, true, "1.2", "2.0", true, false, resourceSet);
		testInjector.injectMembers(higherMinVersionPredicate2);
		assertFalse (higherMinVersionPredicate2.apply(assetDesc));
		
		VersionAndLifecycleStatePredicate higherMinVersionPredicate3 = new VersionAndLifecycleStatePredicate(development, true, null, true, "1.2", "2.0", false, false, resourceSet);
		testInjector.injectMembers(higherMinVersionPredicate3);
		assertFalse (higherMinVersionPredicate3.apply(assetDesc));
		
		VersionAndLifecycleStatePredicate higherMinVersionPredicate4 = new VersionAndLifecycleStatePredicate(development, null, "1.2", "2.0", resourceSet);
		testInjector.injectMembers(higherMinVersionPredicate4);
		assertFalse (higherMinVersionPredicate4.apply(assetDesc));
	}

}
