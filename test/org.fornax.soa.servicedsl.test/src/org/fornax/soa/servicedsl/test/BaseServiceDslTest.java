package org.fornax.soa.servicedsl.test;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.fornax.soa.ServiceDslStandaloneSetup;
import org.fornax.soa.basedsl.sOABaseDsl.MajorVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.SOABaseDslFactory;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.environmentDsl.EnvironmentType;
import org.fornax.soa.profiledsl.SOAProfileDslStandaloneSetup;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfileDslFactory;
import org.fornax.soa.serviceDsl.Attribute;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.EagerFetch;
import org.fornax.soa.serviceDsl.EnumLiteral;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.FetchProfile;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.serviceDsl.LinkingPolicy;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Parameter;
import org.fornax.soa.serviceDsl.ParameterRef;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceDslFactory;
import org.fornax.soa.serviceDsl.VersionedTypeRef;
import org.junit.Before;

public class BaseServiceDslTest extends AbstractXtextTests {

	protected DomainNamespace dns;
	protected InternalNamespace ins;
	protected Service s;
	protected org.fornax.soa.serviceDsl.Exception ex;
	protected BusinessObject bo1;
	protected Attribute attrBo1;
	protected Attribute attrBo3;
	protected Attribute attrBo4;
	protected DataTypeRef stringTypeRef;
	protected BusinessObject bo2;
	protected BusinessObject bo3;
	protected BusinessObject bo4;
	protected Enumeration en;
	protected Operation op;
	protected Parameter p;
	protected VersionedTypeRef paramBoRef;
	protected ParameterRef paramRef;
	protected VersionedTypeRef bo1_2_TypeRef;
	protected VersionedTypeRef bo2_1_TypeRef;
	protected BusinessObjectRef bo1_3_SuperTypeRef;
	protected BusinessObjectRef bo3_4_SuperTypeRef;
	protected Attribute attr2Bos1;
	protected Attribute attr1Bos2;
	protected LinkingPolicy pol;
	protected LinkingPolicy svcpol;
	
	protected LifecycleState proposed;
	protected LifecycleState defined;
	protected LifecycleState development;
	protected LifecycleState test;
	protected LifecycleState productive;
	protected LifecycleState deprecated;
	protected LifecycleState retired;
	
	private Lifecycle lifecycle;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		with (ServiceDslStandaloneSetup.class);
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

		SOABaseDslFactory baseDslFactory = SOABaseDslFactory.eINSTANCE;
		SOAProfileDslFactory profDslFactory = SOAProfileDslFactory.eINSTANCE;
		ServiceDslFactory dslFactory = ServiceDslFactory.eINSTANCE;
		bo1 = dslFactory.createBusinessObject();
		bo1.setName("TestBO1");
		Version v1 = baseDslFactory.createVersion();
		v1.setVersion ("1.0");
		bo1.setVersion(v1);
		bo1.setState(development);
		
		org.fornax.soa.profiledsl.sOAProfileDsl.DataType stringType = profDslFactory.createDataType();
		stringType.setName("string");
		
		attrBo1 = dslFactory.createAttribute();
		attrBo1.setName("attr1");
		stringTypeRef = dslFactory.createDataTypeRef();
		stringTypeRef.setType(stringType);
		attrBo1.setType(stringTypeRef);
		
		bo1.getProperties().add(attrBo1);
		
		bo2 = dslFactory.createBusinessObject();
		bo2.setName("TestBO2");
		Version v2 = baseDslFactory.createVersion();
		v2.setVersion("1.0");

		bo2.setVersion(v2);
		bo2.setState(defined);
		
		bo1_2_TypeRef = dslFactory.createVersionedTypeRef();
		bo1_2_TypeRef.setType(bo2);
		MajorVersionRef verRef = baseDslFactory.createMajorVersionRef();
		verRef.setMajorVersion(1);
		bo1_2_TypeRef.setVersionRef(verRef);

		bo2_1_TypeRef = dslFactory.createVersionedTypeRef();
		bo2_1_TypeRef.setType(bo1);
		MajorVersionRef verRef2 = baseDslFactory.createMajorVersionRef();
		verRef2.setMajorVersion(1);
		bo2_1_TypeRef.setVersionRef(verRef);

		attr2Bos1 = dslFactory.createAttribute();
		attr2Bos1.setName("attr2Bo1");
		attr2Bos1.setType(bo1_2_TypeRef);
		bo1.getProperties().add(attr2Bos1);

		attr1Bos2 = dslFactory.createAttribute();
		attr1Bos2.setName("attr1Bo2");
		attr1Bos2.setType(bo2_1_TypeRef);
		bo2.getProperties().add(attr1Bos2);
		
		bo3 = dslFactory.createBusinessObject();
		bo3.setName("TestBO3");
		Version v3 = baseDslFactory.createVersion();
		v3.setVersion("1.0");
		bo3.setVersion(v3);
		bo3.setState(development);

		attrBo3 = dslFactory.createAttribute();
		attrBo3.setName("attr3");
		DataTypeRef string3TypeRef = dslFactory.createDataTypeRef();
		string3TypeRef.setType(stringType);
		attrBo3.setType(string3TypeRef);
		
		bo3.getProperties().add(attrBo3);

		attrBo4 = dslFactory.createAttribute();
		attrBo4.setName("attr4");
		DataTypeRef string4TypeRef = dslFactory.createDataTypeRef();
		string4TypeRef.setType(stringType);
		attrBo4.setType(string4TypeRef);
		
		bo4 = dslFactory.createBusinessObject();
		bo4.setName("TestBO4");
		Version v4 = baseDslFactory.createVersion();
		v4.setVersion("1.0");
		bo4.setVersion(v4);
		bo4.setState(development);
		
		bo4.getProperties().add (attrBo4);

		bo1_3_SuperTypeRef = dslFactory.createBusinessObjectRef();
		bo1_3_SuperTypeRef.setType(bo3);
		MajorVersionRef bo3VerRef = baseDslFactory.createMajorVersionRef();
		bo3VerRef.setMajorVersion(1);
		bo1_3_SuperTypeRef.setVersionRef(bo3VerRef);

		bo3_4_SuperTypeRef = dslFactory.createBusinessObjectRef();
		bo3_4_SuperTypeRef.setType(bo4);
		MajorVersionRef bo4VerRef = baseDslFactory.createMajorVersionRef();
		bo4VerRef.setMajorVersion(1);
		bo3_4_SuperTypeRef.setVersionRef(bo4VerRef);
		
		bo1.setSuperBusinessObject(bo1_3_SuperTypeRef);
		
		bo3.setSuperBusinessObject(bo3_4_SuperTypeRef);

		s = dslFactory.createService();
		s.setName("TestService");
		s.setVersion(v1);
		s.setState(development);
		
		op = dslFactory.createOperation();
		p  = dslFactory.createParameter();
		p.setName("param");
		paramBoRef = dslFactory.createVersionedTypeRef();
		paramBoRef.setType(bo1);
		VersionRef vRef = baseDslFactory.createVersionRef();
		paramBoRef.setVersionRef(vRef);
		p.setType(paramBoRef);
		op.getParameters().add(p);
		
		s.getOperations().add(op);
		
		FetchProfile profile = dslFactory.createFetchProfile();
		profile.setProfileName("defaultProfile");
		EagerFetch spec = dslFactory.createEagerFetch();
		paramRef = dslFactory.createParameterRef();
		paramRef.setParam(p);
		paramRef.setProperty(attrBo1);
		spec.getEagerFetchAssoc().add(paramRef);
		profile.setFetchSpec(spec);
		op.getFetchProfile().add(profile);
		
		en = dslFactory.createEnumeration();
		EnumLiteral lit = dslFactory.createEnumLiteral();
		lit.setName("LITERAL");
		en.getLiterals().add(lit);
		en.setName("Enum1");
		en.setVersion(v1);
		en.setState(defined);
		
		dns = dslFactory.createDomainNamespace();
		dns.setName("domain");
		dns.getTypes().add(bo1);
		dns.getTypes().add(en);
		dns.getServices().add(s);
		
		pol = dslFactory.createLinkingPolicy();
		pol.setMinDevState(defined);
		pol.setMinTestState(development);
		pol.setMinProdState(test);
		svcpol = dslFactory.createLinkingPolicy ();
		
		svcpol.setMinDevState(proposed);
		svcpol.setMinTestState(test);
		svcpol.setMinProdState(productive);
		
		s.setLinkingPolicy(svcpol);
		dns.setLinkingPolicy(pol);
	}

}
