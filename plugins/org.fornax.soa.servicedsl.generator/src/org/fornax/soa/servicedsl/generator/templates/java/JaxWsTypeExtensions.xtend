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

class JaxWsTypeExtensions {
	@Inject QualifiedNameProvider nameProvider
	@Inject extension SchemaNamespaceExtensions
	@Inject JavaTypeExtensions javaTypeExt
	
	/*
	 * Returns the fully qualified java class name for a Type.
	 */
	def dispatch toQualifiedJaxWsTypeName (Type type, boolean optionalField) {
		
	}
	
	def dispatch toQualifiedJaxWsTypeName (DataType type, boolean optionalField) {
		javaTypeExt.toQualifiedJavaTypeName(type, optionalField)
	}
	
	def dispatch toQualifiedJaxWsTypeName (VersionedType type, boolean optionalField) {
		nameProvider.getFullyQualifiedName(type.eContainer).toString + "." + type.version.toVersionPostfix + "." + type.name
	}
	def toQualifiedJaxWsTypeName (Service service, boolean optionalField) {
		nameProvider.getFullyQualifiedName(service.eContainer).toString + "." + service.name.toLowerCase + "." + service.version.toVersionPostfix + "." + service.name
	}
	def toQualifiedJaxWsTypeName (org.fornax.soa.serviceDsl.Exception exception, Operation throwingOperation, boolean optionalField) {
		val service = throwingOperation.eContainer as Service
		nameProvider.getFullyQualifiedName(exception.eContainer).toString + "." + service.name.toLowerCase + "." + exception.version.toVersionPostfix + "." + exception.name
	}
	
	
	def dispatch toQualifiedJavaTypeName (TypeRef typeRef, boolean optionalField) {
		
	}
	def dispatch toQualifiedJaxWsTypeName (DataTypeRef typeRef, boolean optionalField) {
		typeRef.type.toQualifiedJaxWsTypeName(optionalField)
	}
	def dispatch toQualifiedJaxWsTypeName (VersionedTypeRef typeRef, boolean optionalField) {
		typeRef.type.toQualifiedJaxWsTypeName(optionalField)
	}
	def toQualifiedJaxWsTypeName (ExceptionRef exRef, boolean optionalField) {
		exRef.exception.toQualifiedJaxWsTypeName(exRef.eContainer as Operation, optionalField)
	}
	
	/*
	 * returns the Java type name of the property's type
	 */
	def toQualifiedJaxWsTypeName (Property property) {
		property.type.toQualifiedJavaTypeName(property.optional)
	}
	
	
	
	
	/*
	 * Returns the Java class name for a Type.
	 */
	def dispatch toJaxWsTypeName (Type type, boolean optionalField) {
		
	}
	
	def dispatch toJaxWsTypeName (DataType type, boolean optionalField) {
		javaTypeExt.toJavaTypeName(type, optionalField)
	}
	
	def dispatch toJaxWsTypeName (VersionedType type, boolean optionalField) {
		type.name
	}
	def toJaxWsTypeName (Service service, boolean optionalField) {
		service.name
	}
	def toJaxWsTypeName (org.fornax.soa.serviceDsl.Exception exception, boolean optionalField) {
		exception.name
	}
	
	
	def dispatch toJaxWsTypeName (TypeRef typeRef, boolean optionalField) {
		
	}
	def dispatch toJaxWsTypeName (DataTypeRef typeRef, boolean optionalField) {
		typeRef.type.toJaxWsTypeName(optionalField)
	}
	def dispatch toJaxWsTypeName (VersionedTypeRef typeRef, boolean optionalField) {
		typeRef.type.toJaxWsTypeName(optionalField)
	}
	def toJaxWsTypeName (ExceptionRef exRef, boolean optionalField) {
		exRef.exception.toJaxWsTypeName(optionalField)
	}
	
	/*
	 * returns the Java type name of the property's type
	 */
	def toJavaTypeName (Property property) {
		property.type.toJaxWsTypeName(property.optional)
	}
}