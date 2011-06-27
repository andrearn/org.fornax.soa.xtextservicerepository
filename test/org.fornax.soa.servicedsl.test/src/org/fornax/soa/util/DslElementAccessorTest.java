package org.fornax.soa.util;

import static org.junit.Assert.assertSame;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.serviceDsl.Attribute;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.DataType;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.EagerFetch;
import org.fornax.soa.serviceDsl.EnumLiteral;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.FetchProfile;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;
import org.fornax.soa.serviceDsl.LinkingPolicy;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Parameter;
import org.fornax.soa.serviceDsl.ParameterRef;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceDslFactory;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.serviceDsl.impl.ServiceDslFactoryImpl;
import org.fornax.soa.servicedsl.test.BaseServiceDslTest;
import org.junit.Before;
import org.junit.Test;

public class DslElementAccessorTest extends BaseServiceDslTest {

	
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testGetVersionedOwner() {
		EObject owner = DslElementAccessor.INSTANCE.getVersionedOwner (paramBoRef);
		assertSame(owner, s);
		EObject owner2 = DslElementAccessor.INSTANCE.getVersionedOwner (stringTypeRef);
		assertSame(owner2, bo1);
		EObject owner3 = DslElementAccessor.INSTANCE.getVersionedOwner (paramRef);
		assertSame(owner3, s);
	}

}
