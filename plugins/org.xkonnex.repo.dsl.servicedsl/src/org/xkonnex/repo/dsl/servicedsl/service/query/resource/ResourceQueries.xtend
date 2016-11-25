package org.xkonnex.repo.dsl.servicedsl.service.query.resource

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import java.util.regex.Pattern
import java.util.List
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter

class ResourceQueries {
	
	val Pattern pattern
	
	new() {
		pattern = Pattern.compile("\\$\\{([a-z,A-Z,_]+[0-9]*?)\\}")
	}
	
	def List<String> extractParametersFromURI (String uri) {
		val matcher = pattern.matcher(uri)
		val List<String> paramNames = newArrayList()
		while (matcher.find) {
			val count = matcher.groupCount
			if (count > 0)
				paramNames += matcher.group(1)
		}
		return paramNames
	}
	
	def Iterable<Parameter> extractParametersFromURI (String uri, Operation op) {
		val uriParamNames = uri.extractParametersFromURI.toSet
		op.parameters.filter(p|uriParamNames.contains(p.name))
	}
}