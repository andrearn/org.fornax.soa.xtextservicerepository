package org.xkonnex.repo.generator.servicedsl.templates.json

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import javax.inject.Inject
import javax.inject.Named

class JSONSchemaReferenceProvider {
	
	@Inject @Named ("useRegistryBasedFilePaths") 
	Boolean useRegistryBasedFilePaths
	
	@Inject @Named ("useNestedPaths") 
	Boolean useNestedPaths

	@Inject
	private extension JSONSchemaFilenameProvider
	
	def String toTypeReferenceURI(VersionedType type) {
		'''«type.toFileNameFragment».json'''
	}

	def String toTypeReferenceURI(VersionedType type, String registryBaseUrl) {
		if (useRegistryBasedFilePaths)
			'''«registryBaseUrl»/«type.toFileNameFragment».json'''
		else
			type.toTypeReferenceURI
	}
	
}