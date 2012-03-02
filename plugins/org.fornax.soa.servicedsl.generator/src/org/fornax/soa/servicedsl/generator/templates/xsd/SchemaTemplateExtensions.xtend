package org.fornax.soa.servicedsl.generator.templates.xsd

/* schema.ext */
import org.fornax.soa.serviceDsl.Service
import com.google.inject.Inject

class SchemaTemplateExtensions {
	
	@Inject extension SchemaNamespaceExtensions
	
	def String toOpWrapperXSDFileName (Service s) {
		s.toFileNameFragment() + "-OpWrappers.xsd";
	}
}