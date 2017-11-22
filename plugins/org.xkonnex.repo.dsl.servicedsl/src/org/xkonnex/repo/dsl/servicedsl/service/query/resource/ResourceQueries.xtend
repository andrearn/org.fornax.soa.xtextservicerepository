package org.xkonnex.repo.dsl.servicedsl.service.query.resource

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import java.util.regex.Pattern
import java.util.List
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractOperation

class ResourceQueries {
	
	val Pattern pattern
	
	new() {
		pattern = Pattern.compile("\\$\\{([a-z,A-Z,_]+[0-9]*?)\\}")
	}
	
	def List<String> extractParametersFromURI (String uri) {
		val List<String> paramNames = newArrayList()
		if (uri !== null) {
			val matcher = pattern.matcher(uri)
			while (matcher.find) {
				val count = matcher.groupCount
				if (count > 0)
					paramNames += matcher.group(1)
			}
			
		}
		return paramNames
	}
	
	def Iterable<Parameter> extractParametersFromURI (String uri, AbstractOperation op) {
		val uriParamNames = extractParametersFromURI(uri).toSet
		op.parameters.filter(p|uriParamNames.contains(p.name))
	}
}