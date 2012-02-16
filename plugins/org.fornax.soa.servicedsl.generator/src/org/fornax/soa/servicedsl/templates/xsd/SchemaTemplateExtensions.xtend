package org.fornax.soa.servicedsl.templates.xsd

/* schema.ext */
import org.fornax.soa.serviceDsl.Service
import com.google.inject.Inject

class SchemaTemplateExtensions {
	
	@Inject extension SchemaNamespaceExtensions
	
	def String toOpWrapperXSDFileName (Service s) {
		s.getFileNameFragment() + "-OpWrappers.xsd";
	}
}