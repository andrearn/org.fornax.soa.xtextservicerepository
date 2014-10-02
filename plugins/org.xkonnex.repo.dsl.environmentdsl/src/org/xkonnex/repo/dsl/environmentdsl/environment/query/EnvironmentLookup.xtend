package org.xkonnex.repo.dsl.environmentdsl.environment.query

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.eclipse.emf.ecore.resource.ResourceSet
import com.google.common.base.Predicates
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import java.util.List
import org.eclipse.xtext.EcoreUtil2
import java.util.Set
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType

/*
 * Search for Environment and related entities
 */
class EnvironmentLookup {
	@Inject
	private IPredicateSearch lookup
	
	
	/*
	 * find all defined Environments and initialize EMF proxies 
	 */
	def Set<Environment> findAllEnvironments (ResourceSet resourceSet) {
		var envDescs = lookup.search("Environment ", Predicates::alwaysTrue)
		var List<Environment> allEnvironments = newArrayList()
		for (moduleDesc : envDescs) {
			val obj = moduleDesc.EObjectOrProxy
			if (obj instanceof Environment) {
				val env = obj as Environment
				if (env.eIsProxy) {
					val resolvedEnv = EcoreUtil2::resolve (env, resourceSet) as Environment
					if (!resolvedEnv.eIsProxy) {
						allEnvironments.add (resolvedEnv)
					}
				} else {
					allEnvironments.add (env)
				}
			}
		}
		return allEnvironments.toSet
	}
	
	/*
	 * Collect all used EnvironmentTypes from all Environments define in the model
	 */
	def Set<EnvironmentType> getAllUsedEnvironmentTypes (ResourceSet resourceSet) {
		val allEnvs = findAllEnvironments (resourceSet)
		return allEnvs.map (e | e.type).toSet
	}
	
	/*
	 * Filters a collection of EnvironmentTypes in such a way, that it only
	 * contains the overall used EnvironmentTypes from Environments defined in
	 * themodel
	 */
	def List<EnvironmentType> filterByUsedEnvironmentTypes (List<EnvironmentType> environmentTypes, ResourceSet resourceSet) {
		val allDefEnvs = getAllUsedEnvironmentTypes (resourceSet)
		return environmentTypes.filter(e | allDefEnvs.contains(e)).toList
	} 
	
	
}