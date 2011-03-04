package org.fornax.soa.servicedsl.test;

import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;
import org.fornax.soa.basedsl.sOABaseDsl.MajorVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.SOABaseDslFactory;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfileDslFactory;
import org.fornax.soa.serviceDsl.Attribute;
import org.fornax.soa.serviceDsl.BusinessObject;
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

public class BaseServiceDslTest {

	protected DomainNamespace dns;
	protected InternalNamespace ins;
	protected Service s;
	protected org.fornax.soa.serviceDsl.Exception ex;
	protected BusinessObject bo1;
	protected Attribute attrBo1;
	protected DataTypeRef stringTypeRef;
	protected BusinessObject bo2;
	protected Enumeration en;
	protected Operation op;
	protected Parameter p;
	protected VersionedTypeRef paramBoRef;
	protected ParameterRef paramRef;
	protected VersionedTypeRef bo1_2_TypeRef;
	protected Attribute attr2Bos1;
	protected LinkingPolicy pol;
	protected LinkingPolicy svcpol;

	@Before
	public void setUp() throws Exception {
		SOABaseDslFactory baseDslFactory = SOABaseDslFactory.eINSTANCE;
		SOAProfileDslFactory profDslFactory = SOAProfileDslFactory.eINSTANCE;
		ServiceDslFactory dslFactory = ServiceDslFactory.eINSTANCE;
		bo1 = dslFactory.createBusinessObject();
		bo1.setName("TestBO1");
		Version v1 = baseDslFactory.createVersion();
		v1.setVersion("1.0");
		bo1.setVersion(v1);
		bo1.setState(LifecycleState.DEVELOPMENT);
		
		org.fornax.soa.profiledsl.sOAProfileDsl.DataType stringType = profDslFactory.createDataType();
		stringType.setName("string");
		
		attrBo1 = dslFactory.createAttribute();
		attrBo1.setName("attr1");
		stringTypeRef = dslFactory.createDataTypeRef();
		stringTypeRef.setType(stringType);
		attrBo1.setType(stringTypeRef);
		
		bo1.getProperties().add(attrBo1);
		
		bo2 = dslFactory.createBusinessObject();
		bo2.setName("TestBO1");
		bo2.setVersion(v1);
		bo2.setState(LifecycleState.DEFINED);
		
		bo1_2_TypeRef = dslFactory.createVersionedTypeRef();
		bo1_2_TypeRef.setType(bo2);
		MajorVersionRef verRef = baseDslFactory.createMajorVersionRef();
		verRef.setMajorVersion(1);
		bo1_2_TypeRef.setVersionRef(verRef);
		
		attr2Bos1 = dslFactory.createAttribute();
		attr2Bos1.setName("attr2Bo1");
		attr2Bos1.setType(bo1_2_TypeRef);
		bo1.getProperties().add(attr2Bos1);

		s = dslFactory.createService();
		s.setName("TestService");
		s.setVersion(v1);
		s.setState(LifecycleState.DEVELOPMENT);
		
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
		en.setState(LifecycleState.DEFINED);
		
		dns = dslFactory.createDomainNamespace();
		dns.setName("domain");
		dns.getTypes().add(bo1);
		dns.getTypes().add(en);
		dns.getServices().add(s);
		
		pol = dslFactory.createLinkingPolicy();
		pol.setMinDevState(LifecycleState.DEFINED);
		pol.setMinTestState(LifecycleState.DEVELOPMENT);
		pol.setMinProdState(LifecycleState.TEST);
		
		svcpol = dslFactory.createLinkingPolicy();
		svcpol.setMinDevState(LifecycleState.PROPOSED);
		svcpol.setMinTestState(LifecycleState.TEST);
		svcpol.setMinProdState(LifecycleState.PRODUCTIVE);
		
		s.setLinkingPolicy(svcpol);
		dns.setLinkingPolicy(pol);
	}

}
