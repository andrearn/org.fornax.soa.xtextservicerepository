package org.fornax.soa.servicedsl.generator.templates.java

import org.fornax.soa.serviceDsl.Property
import org.fornax.soa.serviceDsl.DataTypeRef
import org.fornax.soa.serviceDsl.VersionedTypeRef
import org.fornax.soa.serviceDsl.TypeRef
import org.fornax.soa.profiledsl.sOAProfileDsl.DataType
import org.fornax.soa.serviceDsl.Type
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider
import com.google.inject.Inject
import org.fornax.soa.serviceDsl.VersionedType
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.Operation
import org.fornax.soa.basedsl.search.IEObjectLookup
import org.fornax.soa.serviceDsl.SubNamespace

class JaxWsTypeExtensions {
	@Inject QualifiedNameProvider nameProvider
	@Inject extension SchemaNamespaceExtensions
	@Inject JavaTypeExtensions javaTypeExt
	@Inject IEObjectLookup objLookup
	
	/*
	 * Returns the fully qualified java class name for a Type.
	 */
	def String toQualifiedJaxWsTypeName (Service service, boolean optionalField) {
		nameProvider.getFullyQualifiedName(service.eContainer).toString + "." + service.name.toLowerCase + "." + service.version.toVersionPostfix + "." + service.name
	}
	def String toQualifiedJaxWsTypeName (org.fornax.soa.serviceDsl.Exception exception, Operation throwingOperation, boolean optionalField) {
		val service = throwingOperation.eContainer as Service
		nameProvider.getFullyQualifiedName(exception.eContainer).toString + "." + service.name.toLowerCase + "." + exception.version.toVersionPostfix + "." + exception.name
	}
	def String toJaxWsTypeName (Service service, boolean optionalField) {
		service.name
	}
	def String toJaxWsTypeName (org.fornax.soa.serviceDsl.Exception exception, boolean optionalField) {
		exception.name
	}
	
	def String toJaxWsTypeName (ExceptionRef exRef, boolean optionalField) {
		exRef.exception.toJaxWsTypeName(optionalField)
	}

	/**
	 * Get the qualified class name 
	 */
	def String toJaxWsRequestTypeName (Operation operation, boolean optionalField) {
		operation.name.toFirstUpper
	}
	
	def String toJaxWsResponseTypeName (Operation operation, boolean optionalField) {
		operation.name.toFirstUpper + "Response"
	}

	/**
	 * Get the qualified class name 
	 */
	def String toQualifiedJaxWsRequestTypeName (Operation operation, boolean optionalField) {
		val Service service = objLookup.getOwnerByType(operation, typeof (Service))
		nameProvider.getFullyQualifiedName(service).toString + "." + service.name.toLowerCase + "." + service.version.toVersionPostfix + "." + operation.name.toFirstUpper
	}
	
	def String toQualifiedJaxWsResponseTypeName (Operation operation, boolean optionalField) {
		val Service service = objLookup.getOwnerByType(operation, typeof (Service))
		val SubNamespace namespace = objLookup.getOwnerByType(operation, typeof (SubNamespace))
		nameProvider.getFullyQualifiedName (namespace).toString + "." + service.name.toLowerCase + "." + service.version.toVersionPostfix + "." + operation.name.toFirstUpper + "Response"
	}

}