package org.xkonnex.repo.generator.bindingdsl.http

import com.google.inject.Inject
import java.util.Map
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.resource.IEObjectDescription
import org.xkonnex.repo.dsl.basedsl.ref.DependencyDescription
import org.xkonnex.repo.dsl.profiledsl.profileDsl.MessageHeader
import org.xkonnex.repo.dsl.profiledsl.query.ProfileQueries
import org.xkonnex.repo.dsl.profiledsl.query.type.ClassQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.MessageHeaderQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceOperation
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.basedsl.resource.IEObjectDescriptionBuilder
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Enumeration

class HTTPMessagingExtensions {
	
	
	@Inject extension MessageHeaderQuery
	@Inject extension ProfileQueries
	@Inject ClassQueries classQueries
	@Inject extension IEObjectDescriptionBuilder
	
	def toRequestHeaderMap(ResourceOperation op) {
		val headerProps = op.getRequestMessageHeader(op.applicableProfile)
		return toRequestHeaderMap(headerProps)
	}
	
	def toRequestHeaderMap(MessageHeader header) {
		val headerProps = header.parameters
		var Map<String, IEObjectDescription> pathMap = newLinkedHashMap()
		for (headerParam : headerProps) {
			var deps = classQueries.getTransitiveDependencies(headerParam, true, false, newLinkedList(), null)
			val propertyPath = "X"
			flattenDependencyPaths(pathMap, deps.source, propertyPath, deps, header.eResource.resourceSet)
		}
		return pathMap
	}
		
	private def void flattenDependencyPaths (Map<String, IEObjectDescription> pathMap, IEObjectDescription parent, String parentPath, DependencyDescription dependency, ResourceSet rs) {
		for (dep : dependency.dependencies) {
			val source = dep.source
			val propertyPath = parentPath + "-" + source.name.lastSegment
			flattenDependencyPaths(pathMap, dep.source, propertyPath, dep, rs)
		}
		if (dependency.dependencies.nullOrEmpty) {
			val source = dependency.source
			val propertyPath = parentPath + "-" + source.name.lastSegment
			val targetObj = EcoreUtil2.resolve(dependency.target.EObjectOrProxy, rs)
			if (targetObj instanceof org.xkonnex.repo.dsl.profiledsl.profileDsl.Class) {
				val targetClass = targetObj as org.xkonnex.repo.dsl.profiledsl.profileDsl.Class
				val targetProps = ClassQueries.getAllVisibleProperties(targetClass)
				targetProps.forEach[p | pathMap.put(propertyPath + "-" + p.name, p.buildDescription)]
			} else {
				pathMap.put(propertyPath, dependency.source)
			}
		}
	}
		
}