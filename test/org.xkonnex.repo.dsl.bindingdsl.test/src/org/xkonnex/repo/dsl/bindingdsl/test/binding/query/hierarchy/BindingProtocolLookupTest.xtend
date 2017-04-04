package org.xkonnex.repo.dsl.bindingdsl.test.binding.query.hierarchy

import com.google.inject.Inject
import com.google.inject.Injector
import java.util.List
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.access.TypeResource
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.xkonnex.repo.core.resource.XKonneXReader
import org.xkonnex.repo.core.validation.ModelIssues
import org.xkonnex.repo.dsl.basedsl.ext.infer.ComponentInferrer
import org.xkonnex.repo.dsl.bindingdsl.binding.query.BindingLookup
import org.xkonnex.repo.dsl.bindingdsl.binding.query.hierarchy.BindingProtocolLookup
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.REST
import org.xkonnex.repo.dsl.bindingdsl.test.BindingDslWithDependenciesInjectorProvider
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpointProtocol
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation

import static org.junit.Assert.*
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.IProtocol
import org.eclipse.xtext.resource.ResourceSetContext

@RunWith(typeof(XtextRunner)) 
@InjectWith(typeof(BindingDslWithDependenciesInjectorProvider)) 
class BindingProtocolLookupTest {

	@Inject 
	private Injector injector
	@Inject 
	private ResourceSetBasedResourceDescriptions descriptions
	@Inject
	private BindingProtocolLookup protocolLookup
	@Inject
	private BindingLookup bindingLookup
	@Inject
	private ComponentInferrer componentInferrer
	@Inject
	private ClassLoader classLoader
	
	@Test
	def testCollectCorrespondingProtocolsFromHierarchy() {
		val reader = injector.getInstance(typeof(XKonneXReader))
		val modelIssues = new ModelIssues
		val List<String> pathes = newArrayList("model/bindings")
		val rs = reader.read(pathes, modelIssues)
		descriptions.setContext(rs);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);

		val op = rs.allContents.toIterable.filter(typeof(Operation)).findFirst[name == "getCustomerDetails"]
		val bind = rs.allContents.toIterable.filter(typeof(ModuleBinding)).findFirst[name == "org.example.sales.esb.dev"]
		val specBinding = bindingLookup.getMostSpecificOperationBinding(op, bind)
		val bindingHierarchy = bindingLookup.getBottomUpHierarchyForSpecificBinding(specBinding);
		
		val List<BindingProtocol> protDefs = protocolLookup.collectCorrespondingProtocolsFromHierarchy(bindingHierarchy, specBinding.protocol.head)
		assertEquals(2, protDefs.size)
		
		val REST opProt = componentInferrer.inferComponent(protDefs.get(0), rs)
		val REST svcProt = componentInferrer.inferComponent(protDefs.get(1), rs)
		
		assertEquals("customer", svcProt.path)
		assertEquals("customer/details", opProt.path)
	}

}