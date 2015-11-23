package org.xkonnex.repo.dsl.servicedsl.test;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.Before;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.ProfileDslFactory;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MajorVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslFactory;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version;
import org.xkonnex.repo.dsl.basedsl.baseDsl.VersionRef;
import org.xkonnex.repo.dsl.servicedsl.ServiceDslStandaloneSetup;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ConsiderationParameterRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ConsiderationSpec;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EnumLiteral;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslFactory;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SimpleConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef;

public class BaseServiceDslTest extends AbstractXtextTests {

	protected DomainNamespace dns;
	protected InternalNamespace ins;
	protected Service s;
	protected org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception ex;
	protected BusinessObject bo1;
	protected Property attrBo1;
	protected Property attrBo3;
	protected Property attrBo4;
	protected DataTypeRef stringTypeRef;
	protected BusinessObject bo2;
	protected BusinessObject bo3;
	protected BusinessObject bo4;
	protected Enumeration en;
	protected Operation op;
	protected Parameter p;
	protected VersionedTypeRef paramBoRef;
	protected ConsiderationParameterRef paramRef;
	protected VersionedTypeRef bo1_2_TypeRef;
	protected VersionedTypeRef bo2_1_TypeRef;
	protected DataObjectRef bo1_3_SuperTypeRef;
	protected DataObjectRef bo3_4_SuperTypeRef;
	protected Property attr2Bos1;
	protected Property attr1Bos2;
	
	protected LifecycleState proposed;
	protected LifecycleState defined;
	protected LifecycleState development;
	protected LifecycleState test;
	protected LifecycleState productive;
	protected LifecycleState deprecated;
	protected LifecycleState retired;
	protected Resource resource  = new XtextResource();
	
	private Lifecycle lifecycle;
	

	@Before
	public void setUp() throws Exception {
		super.setUp();
		with (ServiceDslStandaloneSetup.class);
		ProfileDslFactory factory = ProfileDslFactory.eINSTANCE;
		lifecycle = factory.createLifecycle ();
		proposed = factory.createLifecycleState ();
		proposed.setName ("proposed");
		proposed.setIsInitial (true);
		proposed.getQualifiesFor ().add (EnvironmentType.LOCAL);
		
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
		ProfileDslFactory profDslFactory = ProfileDslFactory.eINSTANCE;
		ServiceDslFactory dslFactory = ServiceDslFactory.eINSTANCE;
		bo1 = dslFactory.createBusinessObject();
		bo1.setName("TestBO1");
		Version v1 = baseDslFactory.createVersion();
		v1.setVersion ("1.0");
		bo1.setVersion(v1);
		bo1.setState(development);
		
		org.xkonnex.repo.dsl.profiledsl.profileDsl.DataType stringType = profDslFactory.createDataType();
		stringType.setName("string");
		
		attrBo1 = dslFactory.createProperty();
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

		attr2Bos1 = dslFactory.createProperty();
		attr2Bos1.setName("attr2Bo1");
		attr2Bos1.setType(bo1_2_TypeRef);
		bo1.getProperties().add(attr2Bos1);

		attr1Bos2 = dslFactory.createProperty();
		attr1Bos2.setName("attr1Bo2");
		attr1Bos2.setType(bo2_1_TypeRef);
		bo2.getProperties().add(attr1Bos2);
		
		bo3 = dslFactory.createBusinessObject();
		bo3.setName("TestBO3");
		Version v3 = baseDslFactory.createVersion();
		v3.setVersion("1.0");
		bo3.setVersion(v3);
		bo3.setState(development);

		attrBo3 = dslFactory.createProperty();
		attrBo3.setName("attr3");
		DataTypeRef string3TypeRef = dslFactory.createDataTypeRef();
		string3TypeRef.setType(stringType);
		attrBo3.setType(string3TypeRef);
		
		bo3.getProperties().add(attrBo3);

		attrBo4 = dslFactory.createProperty();
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

		bo1_3_SuperTypeRef = dslFactory.createDataObjectRef();
		bo1_3_SuperTypeRef.setType(bo3);
		MajorVersionRef bo3VerRef = baseDslFactory.createMajorVersionRef();
		bo3VerRef.setMajorVersion(1);
		bo1_3_SuperTypeRef.setVersionRef(bo3VerRef);

		bo3_4_SuperTypeRef = dslFactory.createDataObjectRef();
		bo3_4_SuperTypeRef.setType(bo4);
		MajorVersionRef bo4VerRef = baseDslFactory.createMajorVersionRef();
		bo4VerRef.setMajorVersion(1);
		bo3_4_SuperTypeRef.setVersionRef(bo4VerRef);
		
		bo1.setSuperObject(bo1_3_SuperTypeRef);
		
		bo3.setSuperObject(bo3_4_SuperTypeRef);

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
		
		ConsiderationSpec spec = dslFactory.createConsiderationSpec();
		SimpleConsiderationPropertyRef fetchPropRef = dslFactory.createSimpleConsiderationPropertyRef();
		fetchPropRef.setProperty(attrBo1);
		paramRef = dslFactory.createConsiderationParameterRef();
		paramRef.setParam(p);
		paramRef.getPropertyRef().add(fetchPropRef);
		spec.getConsideredParam().add(paramRef);
		op.setConsiderationSpec(spec);
		
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
		
	}

}
