package org.xkonnex.repo.dsl.bindingdsl.test.binding.query

import static org.junit.Assert.*

import com.google.inject.Inject
import com.google.inject.Injector
import java.util.List
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.junit.runner.RunWith
import org.xkonnex.repo.core.resource.XKonneXReader
import org.xkonnex.repo.core.validation.ModelIssues
import org.xkonnex.repo.dsl.bindingdsl.binding.query.BindingLookup
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.test.BindingDslWithDependenciesInjectorProvider
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.junit.Test
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.OperationBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding

@RunWith(typeof(XtextRunner)) 
@InjectWith(typeof(BindingDslWithDependenciesInjectorProvider)) 
class BindingLookupTest {
	
	@Inject
	private BindingLookup bindingLookup
	@Inject 
	private Injector injector
	@Inject 
	private ResourceSetBasedResourceDescriptions descriptions
	
	@Test
	def testGetMostSpecificOperationBinding() {
		val reader = injector.getInstance(typeof(XKonneXReader))
		val modelIssues = new ModelIssues
		val List<String> pathes = newArrayList("model/bindings")
		val rs = reader.read(pathes, modelIssues)
		descriptions.setContext(rs);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);
		
		val op = rs.allContents.toIterable.filter(typeof(Operation)).findFirst[name == "getCustomerDetails"]
		val opFindByNameAndCity = rs.allContents.toIterable.filter(typeof(Operation)).findFirst[name == "findByNameAndCity"]
		val bind = rs.allContents.toIterable.filter(typeof(ModuleBinding)).findFirst[name == "org.example.sales.esb.dev"]
		val specBinding = bindingLookup.getMostSpecificOperationBinding(op, bind)
		
		assertTrue(specBinding instanceof OperationBinding)
		
		val findByNameAndCityBinding = bindingLookup.getMostSpecificOperationBinding(opFindByNameAndCity, bind)
		assertTrue(findByNameAndCityBinding instanceof ServiceBinding)
		
	}
	
	@Test
	def testGetBottomUpHierarchyForSpecificBinding() {
		val reader = injector.getInstance(typeof(XKonneXReader))
		val modelIssues = new ModelIssues
		val List<String> pathes = newArrayList("model/bindings")
		val rs = reader.read(pathes, modelIssues)
		descriptions.setContext(rs);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);
		
		val op = rs.allContents.toIterable.filter(typeof(Operation)).findFirst[name == "getCustomerDetails"]
		val bind = rs.allContents.toIterable.filter(typeof(ModuleBinding)).findFirst[name == "org.example.sales.esb.dev"]
		val specBinding = bindingLookup.getMostSpecificOperationBinding(op, bind)
		
		val bindingHierarchy = bindingLookup.getBottomUpHierarchyForSpecificBinding(specBinding)
		
		assertEquals(3, bindingHierarchy.size)
		assertTrue(bindingHierarchy.get(0) instanceof OperationBinding)
		assertTrue(bindingHierarchy.get(1) instanceof ServiceBinding)
		assertTrue(bindingHierarchy.get(2) instanceof ModuleBinding)
	}
	
}