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

class JavaTypeExtensions {
	@Inject QualifiedNameProvider nameProvider
	@Inject extension SchemaNamespaceExtensions
	
	/*
	 * Returns the fully qualified java class name for a Type.
	 */
	def dispatch toQualifiedJavaTypeName (Type type, boolean optionalField) {
		
	}
	
	def dispatch toQualifiedJavaTypeName (DataType type, boolean optionalField) {
		switch (type.name) {
			case "date":			"java.util.Date"
			case "datetime":		"java.util.Date"
			case "byte":			if (optionalField) return "Byte" else return "byte"
			case "int":				if (optionalField) return "Integer" else return "int"
			case "long":			if (optionalField) return "Long" else return "long"
			case "float":			if (optionalField) return "Float" else return "float"
			case "double":			if (optionalField) return "Double" else return "double"
			case "decimal":			"java.math.BigDecimal"
			case "binary": 			"byte[]"
			case "base64Binary": 	"byte[]"
			case "decimal":			"BigDecimal"
			case "boolean":			if (optionalField) return "Boolean" else return "boolean"
			case "char":			if (optionalField) return "Character" else return "char"
			case "string":			return "String"
			case "anyType":			return "Object"
			default: 				return "void"
		}
	}
	
	def dispatch toQualifiedJavaTypeName (VersionedType type, boolean optionalField) {
		nameProvider.getFullyQualifiedName(type.eContainer).toString + "." + type.version.toVersionPostfix + "." + type.name
	}
	def toQualifiedJavaTypeName (Service service, boolean optionalField) {
		nameProvider.getFullyQualifiedName(service.eContainer).toString + "." + service.version.toVersionPostfix + "." + service.name
	}
	def toQualifiedJavaTypeName (org.fornax.soa.serviceDsl.Exception exception, boolean optionalField) {
		nameProvider.getFullyQualifiedName(exception.eContainer).toString + "." + exception.version.toVersionPostfix + "." + exception.name
	}
	
	
	def dispatch toQualifiedJavaTypeName (TypeRef typeRef, boolean optionalField) {
		
	}
	def dispatch toQualifiedJavaTypeName (DataTypeRef typeRef, boolean optionalField) {
		typeRef.type.toQualifiedJavaTypeName(optionalField)
	}
	def dispatch toQualifiedJavaTypeName (VersionedTypeRef typeRef, boolean optionalField) {
		typeRef.type.toQualifiedJavaTypeName(optionalField)
	}
	def toQualifiedJavaTypeName (ExceptionRef exRef, boolean optionalField) {
		exRef.exception.toQualifiedJavaTypeName(optionalField)
	}
	
	/*
	 * returns the Java type name of the property's type
	 */
	def toQualifiedJavaTypeName (Property property) {
		property.type.toQualifiedJavaTypeName(property.optional)
	}
	
	
	
	
	/*
	 * Returns the Java class name for a Type.
	 */
	def dispatch toJavaTypeName (Type type, boolean optionalField) {
		
	}
	
	def dispatch toJavaTypeName (DataType type, boolean optionalField) {
		switch (type.name) {
			case "date":			"Date"
			case "datetime":		"Date"
			case "byte":			if (optionalField) return "Byte" else return "byte"
			case "int":				if (optionalField) return "Integer" else return "int"
			case "long":			if (optionalField) return "Long" else return "long"
			case "float":			if (optionalField) return "Float" else return "float"
			case "double":			if (optionalField) return "Double" else return "double"
			case "decimal":			"BigDecimal"
			case "binary": 			"byte[]"
			case "base64Binary": 	"byte[]"
			case "decimal":			"BigDecimal"
			case "boolean":			if (optionalField) return "Boolean" else return "boolean"
			case "char":			if (optionalField) return "Character" else return "char"
			case "string":			return "String"
			case "anyType":			return "Object"
			default: 				return "void"
		}
	}
	
	def dispatch toJavaTypeName (VersionedType type, boolean optionalField) {
		type.name
	}
	
	
	def dispatch toJavaTypeName (TypeRef typeRef, boolean optionalField) {
		
	}
	def dispatch toJavaTypeName (DataTypeRef typeRef, boolean optionalField) {
		typeRef.type.toJavaTypeName(optionalField)
	}
	def dispatch toJavaTypeName (VersionedTypeRef typeRef, boolean optionalField) {
		typeRef.type.toJavaTypeName(optionalField)
	}
	def toJavaTypeName (Service service, boolean optionalField) {
		service.name
	}
	def toJavaTypeName (org.fornax.soa.serviceDsl.Exception exception, boolean optionalField) {
		exception.name
	}
	
	/*
	 * returns the Java type name of the property's type
	 */
	def toJavaTypeName (Property property) {
		property.type.toJavaTypeName(property.optional)
	}
}