package org.xkonnex.repo.dsl.bindingdsl.test.binding.query;

import javax.inject.Inject;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xkonnex.repo.dsl.bindingdsl.binding.ModuleContextRootProvider;
import org.xkonnex.repo.dsl.bindingdsl.test.BindingDslWithDependenciesInjectorProvider;

@RunWith(XtextRunner.class)
@InjectWith(BindingDslWithDependenciesInjectorProvider.class)
public class ModuleContextRootProviderTest {
	
	@Inject
	private ModuleContextRootProvider ctxRootProvider;
	
	@Test
	public void testGetContextRootWithModuleAndProtocol() {
		
	}

}
