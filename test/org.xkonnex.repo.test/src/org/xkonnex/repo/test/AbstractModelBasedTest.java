package org.xkonnex.repo.test;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.mwe.ResourceLoadingSlotEntry;
import org.junit.Before;

import com.google.common.collect.Lists;

public class AbstractModelBasedTest {

	protected List<Resource> resources = Lists.newArrayList();
	protected TestReader reader;

	@Before
	public void setUp() throws Exception {
		IWorkflowContext ctx = new WorkflowContextImpl();

		reader = new TestReader();
		reader.addRegister(new org.xkonnex.repo.dsl.servicedsl.ServiceDslStandaloneSetup());
		reader.addRegister(new org.xkonnex.repo.dsl.semanticsdsl.SemanticsDslStandaloneSetup());
		reader.addRegister(new org.xkonnex.repo.dsl.businessdsl.BusinessDslStandaloneSetup());
		reader.addRegister(new org.xkonnex.repo.dsl.bindingdsl.BindingDslStandaloneSetup());
		reader.addRegister(new org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslStandaloneSetup());
		reader.addRegister(new org.xkonnex.repo.dsl.sladsl.SLADslStandaloneSetup());
		reader.addRegister(new org.xkonnex.repo.dsl.basedsl.BaseDslStandaloneSetup());
		reader.addRegister(new org.xkonnex.repo.dsl.profiledsl.ProfileDslStandaloneSetup());
		reader.addRegister(new org.xkonnex.repo.dsl.moduledsl.ModuleDslStandaloneSetup());

		ResourceLoadingSlotEntry slotEntry = new ResourceLoadingSlotEntry();
		slotEntry.setSlot("model");
		reader.addLoadResource(slotEntry);
		reader.addPath("model");

		reader.invoke(ctx);
		Object object = ctx.get("model");
		if (object instanceof Iterable) {
			Iterable<?> iterable = (Iterable<?>) object;
			for (Object object2 : iterable) {
				if (!(object2 instanceof Resource)) {
					throw new IllegalStateException(
							"Slot contents was not a Resource but a '"
									+ object.getClass().getSimpleName() + "'!");
				}
				resources.add((Resource) object2);
			}
		} else if (object instanceof Resource) {
			resources.add((Resource) object);
		}

	}
}
