package org.fornax.soa.test;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.mwe.ResourceLoadingSlotEntry;
import org.junit.Before;

import com.google.common.collect.Lists;


public class AbstractModelBasedTest extends AbstractXtextTests {
	
	protected  List<Resource> resources = Lists.newArrayList ();
	protected TestReader reader;
	
	@Before
	public void setUp() throws Exception {
		super.setUp ();
		IWorkflowContext ctx = new WorkflowContextImpl();
		
		reader = new TestReader();
		reader.addRegister (new org.fornax.soa.ServiceDslStandaloneSetup ());
		reader.addRegister (new org.fornax.soa.SemanticsDslStandaloneSetup ());
		reader.addRegister (new org.fornax.soa.BusinessDslStandaloneSetup ());
		reader.addRegister (new org.fornax.soa.BindingDslStandaloneSetup ());
		reader.addRegister (new org.fornax.soa.EnvironmentDslStandaloneSetup ());
		reader.addRegister (new org.fornax.soa.sladsl.SLADslStandaloneSetup ());
		reader.addRegister (new org.fornax.soa.basedsl.SOABaseDslStandaloneSetup ());
		reader.addRegister (new org.fornax.soa.profiledsl.SOAProfileDslStandaloneSetup ());
		reader.addRegister (new org.fornax.soa.moduledsl.ModuleDslStandaloneSetup ());
		
		ResourceLoadingSlotEntry slotEntry = new ResourceLoadingSlotEntry ();
		slotEntry.setSlot ("model");
		reader.addLoadResource (slotEntry);
		reader.addPath ("model");
		
		reader.invoke (ctx);
		Object object = ctx.get("model");
		if (object instanceof Iterable) {
			Iterable<?> iterable = (Iterable<?>) object;
			for (Object object2 : iterable) {
				if (!(object2 instanceof Resource)) {
					throw new IllegalStateException("Slot contents was not a Resource but a '"+object.getClass().getSimpleName()+"'!");
				}
				resources.add ((Resource) object2);
			}
		} else if (object instanceof Resource) {
			resources.add ((Resource) object);
		}
		
	}
}
