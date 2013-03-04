package org.fornax.soa.servicedsl.generator.templates.webservice

import org.fornax.soa.serviceDsl.Parameter
import org.fornax.soa.serviceDsl.DataTypeRef
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef
import org.fornax.soa.serviceDsl.TypeRef
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions
import com.google.inject.Inject
import org.fornax.soa.serviceDsl.BusinessObjectRef
import org.fornax.soa.serviceDsl.QueryObjectRef

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