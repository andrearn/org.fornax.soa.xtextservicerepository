package org.xkonnex.repo.generator.servicedsl.templates.xsd

/* schema.ext */
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import com.google.inject.Inject

class SchemaTemplateExtensions {
	
	@Inject extension SchemaNamespaceExtensions
	
	def String toOperationWrapperXSDFileName (Service s) {
		s.toFileNameFragment() + "-OpWrappers.xsd";
	}
}