package org.xkonnex.repo.generator.servicedsl.templates.java

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.DataType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import com.google.inject.Inject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.eclipse.xtext.naming.IQualifiedNameProvider

class JaxWsTypeExtensions {
	@Inject extension SchemaNamespaceExtensions
	@Inject extension JavaTypeExtensions
	@Inject IQualifiedNameProvider nameProvider
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
	def String toJaxWsQualifiedTypeName (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exception, Operation throwingOperation) {
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
	def String toJaxWsTypeName (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exception) {
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
	def String toJaxWsOperationRequestTypeName (Operation operation) {
		operation.name.toFirstUpper
	}
	
	/**
	 * Get the simple class name JAX-WS-style operation response parameter wrapper type
	 */
	def String toJaxWsOperationResponseTypeName (Operation operation) {
		operation.name.toFirstUpper + "Response"
	}

	/**
	 * Get the fully qualified class name JAX-WS-style operation request parameter wrapper type
	 */
	def String toJaxWsQualifiedOperationRequestTypeName (Operation operation) {
		val Service service = objLookup.getOwnerByType(operation, typeof (Service))
		service.toJaxWsServicePackageName + "." + operation.name.toFirstUpper
	}
	
	/**
	 * Get the fully qualified class name JAX-WS-style operation response parameter wrapper type
	 */
	def String toJaxWsQualifiedOperationResponseTypeName (Operation operation) {
		val Service service = objLookup.getOwnerByType(operation, typeof (Service))
		service.toJaxWsServicePackageName + "." + operation.name.toFirstUpper + "Response"
	}
	
	def String toJaxWsQualifiedExceptionTypeName (ExceptionRef exRef) {
		exRef.toJaxWsServiceExceptionPackageName + "." + exRef.exception.toJaxWsTypeName
	}
	
	/**
	 * Get the JAX-WS-style Java package name of a Service
	 */
	def String toJaxWsServicePackageName (Service service) {
		nameProvider.getFullyQualifiedName(service.eContainer).toString + "." + service.name.toLowerCase + "." + service.version.toVersionPostfix
	}
	
	/**
	 * Get the JAX-WS-style Java package name of a Service Operation
	 */
	def String toJaxWsServiceOperationPackageName (Operation operation) {
		val Service service = objLookup.getOwnerByType(operation, typeof (Service))
		if (service != null) {
			return nameProvider.getFullyQualifiedName(service.eContainer).toString + "." + service.name.toLowerCase + "." + service.version.toVersionPostfix
		} else {
			return null
		}
	}
	
	/**
	 * Get the JAX-WS-style Java package name of a Service Exception
	 */
	def String toJaxWsServiceExceptionPackageName (ExceptionRef exceptionRef) {
		val Service service = objLookup.getOwnerByType(exceptionRef, typeof (Service))
		if (service != null) {
			return nameProvider.getFullyQualifiedName(service.eContainer).toString + "." + service.name.toLowerCase + "." + service.version.toVersionPostfix
		} else {
			return null
		}
	}


	// JAX-WS Java file names

	def String toJaxWsOperationRequestJavaFileName (Operation operation) {
		operation.toJaxWsQualifiedOperationRequestTypeName.toJavaFileName
	}
	
	def String toJaxWsOperationResponseJavaFileName (Operation operation) {
		operation.toJaxWsQualifiedOperationResponseTypeName.toJavaFileName
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
	
	def String toJaxWsServiceExceptionJavaFileName (ExceptionRef exceptionRef) {
		val Operation throwingOperation = objLookup.getOwnerByType(exceptionRef, typeof (Operation))
		exceptionRef.exception.toJaxWsServiceExceptionJavaFileName (throwingOperation)
	}
	
	def private String toJaxWsServiceExceptionJavaFileName (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exception, Operation throwingOperation) {
		exception.toJaxWsQualifiedTypeName(throwingOperation).toJavaFileName
	}

}