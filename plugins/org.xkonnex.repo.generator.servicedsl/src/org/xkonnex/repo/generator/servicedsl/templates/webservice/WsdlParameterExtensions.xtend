package org.xkonnex.repo.generator.servicedsl.templates.webservice

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaTypeExtensions
import com.google.inject.Inject

class WsdlParameterExtensions {
	
	@Inject extension SchemaTypeExtensions
	
	def String toElementType (Parameter param) {
		if (param.type instanceof DataTypeRef && param.attachmentRef) {
			"ref:swaRef"
		} else {
			param.type.toTypeNameRef
		}
	}
}