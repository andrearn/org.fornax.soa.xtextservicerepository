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
	@Inject extension SchemaNamespaceExtensions
	@Inject extension JavaTypeExtensions
	@Inject QualifiedNameProvider nameProvider
	@Inject JavaTypeExtensions javaTypeExt
	@Inject IEObjectLookup objLookup
	
	/**
	 * Returns the fully qualified JAX-WS-style java class name for a Service.
	 */
	def String toJaxWsQualifiedTypeName (Service service) {
		service.toJaxWsServicePackageName + "." + service.name
	}
	/**
	 * Returns the fully qualified JAX-WS-style java class name for an Exception.
	 */
	def String toJaxWsQualifiedTypeName (org.fornax.soa.serviceDsl.Exception exception, Operation throwingOperation) {
		val service = throwingOperation.eContainer as Service
		service.toJaxWsServicePackageName + "." + exception.name
	}
	
	
	/**
	 * Returns the simple JAX-WS-style java class name for a Service.
	 */
	def String toJaxWsTypeName (Service service, boolean optionalField) {
		service.name
	}
	/**
	 * Returns the simple JAX-WS-style java class name for an Exception.
	 */
	def String toJaxWsTypeName (org.fornax.soa.serviceDsl.Exception exception) {
		exception.name
	}
	
	/**
	 * Returns the simple JAX-WS-style java class name for the Exception referenced by an ExceptionRef .
	 */
	def String toJaxWsTypeName (ExceptionRef exRef) {
		exRef.exception.toJaxWsTypeName
	}

	/**
	 * Get the simple class name JAX-WS-style operation request parameter wrapper type
	 */
	def String toJaxWsRequestTypeName (Operation operation) {
		operation.name.toFirstUpper
	}
	
	/**
	 * Get the simple class name JAX-WS-style operation response parameter wrapper type
	 */
	def String toJaxWsResponseTypeName (Operation operation) {
		operation.name.toFirstUpper + "Response"
	}

	/**
	 * Get the fully qualified class name JAX-WS-style operation request parameter wrapper type
	 */
	def String toJaxWsQualifiedRequestTypeName (Operation operation) {
		val Service service = objLookup.getOwnerByType(operation, typeof (Service))
		service.toJaxWsServicePackageName + "." + operation.name.toFirstUpper
	}
	
	/**
	 * Get the fully qualified class name JAX-WS-style operation response parameter wrapper type
	 */
	def String toJaxWsQualifiedResponseTypeName (Operation operation) {
		val Service service = objLookup.getOwnerByType(operation, typeof (Service))
		service.toJaxWsServicePackageName + "." + operation.name.toFirstUpper + "Response"
	}
	
	/**
	 * Get the Java package name of a Service
	 */
	def String toJaxWsServicePackageName (Service service) {
		nameProvider.getFullyQualifiedName(service.eContainer).toString + "." + service.name.toLowerCase + "." + service.version.toVersionPostfix
	}


	// JAX-WS Java file names

	def String toJaxWsRequestJavaFileName (Operation operation) {
		operation.toJaxWsQualifiedRequestTypeName.toJavaFileName
	}
	
	def String toJaxWsResponseJavaFileName (Operation operation) {
		operation.toJaxWsQualifiedResponseTypeName.toJavaFileName
	}
	
	def String toJaxWsJavaFileName (org.fornax.soa.serviceDsl.Exception exception, Operation throwingOperation) {
		exception.toJaxWsQualifiedTypeName(throwingOperation).toJavaFileName
	}
	
	def String toJaxWsJavaFileName (Service service) {
		service.toJaxWsQualifiedTypeName.toJavaFileName
	}
	
	
	def String toJaxWsJavaFileName (Type type) {
		return null
	}
	
	def String toJaxWsJavaFileName (VersionedType type) {
		type.toQualifiedJavaTypeName.toJavaFileName
	}

}