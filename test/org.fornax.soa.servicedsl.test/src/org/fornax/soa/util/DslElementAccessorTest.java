package org.fornax.soa.util;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.service.util.ServiceDslElementAccessor;
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
		EObject owner = ServiceDslElementAccessor.INSTANCE.getVersionedOwner (paramBoRef);
		assertSame(owner, s);
		EObject owner2 = ServiceDslElementAccessor.INSTANCE.getVersionedOwner (stringTypeRef);
		assertSame(owner2, bo1);
		EObject owner3 = ServiceDslElementAccessor.INSTANCE.getVersionedOwner (paramRef);
		assertSame(owner3, s);
	}

}
