package org.xkonnex.repo.generator.servicedsl.templates.json

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import javax.inject.Inject

class JSONSchemaReferenceProvider {
	
	@Inject
	private extension JSONSchemaFilenameProvider
	
	def String toTypeReferenceURI(VersionedType type) {
		'''«type.toFileNameFragment».json'''
	}

	def String toTypeReferenceURI(VersionedType type, String registryBaseUrl) {
		'''«registryBaseUrl»/«type.toFileNameFragment».json'''
	}
	
}