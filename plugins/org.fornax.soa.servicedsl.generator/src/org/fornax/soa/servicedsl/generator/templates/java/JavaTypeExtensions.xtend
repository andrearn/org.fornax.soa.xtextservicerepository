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
	
	def dispatch String toQualifiedJavaTypeName (DataType type, boolean optionalField) {
		switch (type.name) {
			case "date":			"java.util.Date"
			case "datetime":		"java.util.Date"
			case "byte":			if (optionalField) return "Byte" else return "byte"
			case "int":				if (optionalField) return "Integer" else return "int"
			case "long":			if (optionalField) return "Long" else return "long"
			case "float":			if (optionalField) return "Float" else return "float"
			case "double":			if (optionalField) return "Double" else return "double"
			case "decimal":			"java.math.BigDecimal"
			case "binary": 			if (optionalField) return "Byte[]" else return "byte[]"
			case "base64Binary": 	if (optionalField) return "Byte[]" else return "byte[]"
			case "decimal":			"BigDecimal"
			case "boolean":			if (optionalField) return "Boolean" else return "boolean"
			case "char":			if (optionalField) return "Character" else return "char"
			case "string":			return "String"
			case "anyType":			return "Object"
			default: 				if (optionalField) return "Void" else return "void"
		}
	}
	
	def dispatch String toQualifiedJavaTypeName (VersionedType type, boolean optionalField) {
		nameProvider.getFullyQualifiedName(type.eContainer).toString + "." + type.version.toVersionPostfix + "." + type.name
	}
	def String toQualifiedJavaTypeName (Service service, boolean optionalField) {
		nameProvider.getFullyQualifiedName(service.eContainer).toString + "." + service.version.toVersionPostfix + "." + service.name
	}
	def String toQualifiedJavaTypeName (org.fornax.soa.serviceDsl.Exception exception, boolean optionalField) {
		nameProvider.getFullyQualifiedName(exception.eContainer).toString + "." + exception.version.toVersionPostfix + "." + exception.name
	}
	
	
	def dispatch String toQualifiedJavaTypeName (TypeRef typeRef, boolean optionalField) {
		
	}
	def dispatch String toQualifiedJavaTypeName (DataTypeRef typeRef, boolean optionalField) {
		if (typeRef.many)
			if (typeRef.set)
				return "Set<" + typeRef.type.toQualifiedJavaTypeName(true)+">"
			else
				return "List<" + typeRef.type.toQualifiedJavaTypeName(true)+">"
		else
			typeRef.type.toQualifiedJavaTypeName(optionalField)
	}
	def dispatch String toQualifiedJavaTypeName (VersionedTypeRef typeRef, boolean optionalField) {
		if (typeRef.many)
			if (typeRef.set)
				return "Set<" + typeRef.type.toQualifiedJavaTypeName(true)+">"
			else
				return "List<" + typeRef.type.toQualifiedJavaTypeName(true)+">"
		else
			typeRef.type.toQualifiedJavaTypeName(optionalField)
	}
	
	def String toQualifiedJavaTypeName (ExceptionRef exRef, boolean optionalField) {
		exRef.exception.toQualifiedJavaTypeName(optionalField)
	}
	
	/*
	 * returns the Java type name of the property's type
	 */
	def String toQualifiedJavaTypeName (Property property) {
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
			case "binary": 			if (optionalField) return "Byte[]" else return "byte[]"
			case "base64Binary": 	if (optionalField) return "Byte[]" else return "byte[]"
			case "decimal":			"BigDecimal"
			case "boolean":			if (optionalField) return "Boolean" else return "boolean"
			case "char":			if (optionalField) return "Character" else return "char"
			case "string":			return "String"
			case "anyType":			return "Object"
			default: 				if (optionalField) return "Void" else return "void"
		}
	}
	
	def dispatch String toJavaTypeName (VersionedType type, boolean optionalField) {
		type.name
	}
	
	
	def dispatch String toJavaTypeName (TypeRef typeRef, boolean optionalField) {
		
	}
	def dispatch String toJavaTypeName (DataTypeRef typeRef, boolean optionalField) {
		if (typeRef.many)
			if (typeRef.set)
				return "Set<" + typeRef.type.toJavaTypeName(true) + ">"
			else
				return "List<" + typeRef.type.toJavaTypeName(true) + ">"
		else
			return typeRef.type.toJavaTypeName(optionalField)
	}
	def dispatch String toJavaTypeName (VersionedTypeRef typeRef, boolean optionalField) {
		if (typeRef.many)
			if (typeRef.set)
				return "Set<" + typeRef.type.toJavaTypeName(true) + ">"
			else
				return "List<" + typeRef.type.toJavaTypeName(true) + ">"
		else
			return typeRef.type.toJavaTypeName(optionalField)
	}
	def String toJavaTypeName (Service service, boolean optionalField) {
		service.name
	}
	def String toJavaTypeName (org.fornax.soa.serviceDsl.Exception exception, boolean optionalField) {
		exception.name
	}
	
	/*
	 * returns the Java type name of the property's type
	 */
	def toJavaTypeName (Property property) {
		property.type.toJavaTypeName(property.optional)
	}
}