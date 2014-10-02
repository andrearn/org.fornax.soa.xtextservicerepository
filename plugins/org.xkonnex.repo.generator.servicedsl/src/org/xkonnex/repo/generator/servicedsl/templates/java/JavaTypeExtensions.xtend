package org.xkonnex.repo.generator.servicedsl.templates.java

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.DataType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider
import com.google.inject.Inject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractVersionedTypeRef
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.ClassRef

/**
 * Derive Java class names from types and type references
 */
class JavaTypeExtensions {
	
	
	@Inject 
	private QualifiedNameProvider nameProvider
	
	@Inject extension SchemaNamespaceExtensions
	
	/**
	 * Returns the fully qualified java class name for a Type.
	 */
	def dispatch String toQualifiedJavaTypeName (Type type) {
		
	}
	def dispatch String toQualifiedJavaTypeName (Type type, boolean optionalField) {
		
	}
	
	/**
	 * Returns the fully qualified java class name for a Type.
	 */
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
			case "attachment":	 	if (optionalField) return "Byte[]" else return "byte[]"
			case "boolean":			if (optionalField) return "Boolean" else return "boolean"
			case "char":			if (optionalField) return "Character" else return "char"
			case "string":			return "String"
			case "anyType":			return "Object"
			default: 				if (optionalField) return "Void" else return "void"
		}
	}
	
	def dispatch String toQualifiedJavaTypeName (VersionedType type, boolean optionalField) {
		type.toQualifiedJavaTypeName
	}
	
	/**
	 * Returns the fully qualified java class name for a Type.
	 */
	def dispatch String toQualifiedJavaTypeName (VersionedType type) {
		nameProvider.getFullyQualifiedName(type.eContainer).toString + "." + type.version.toVersionPostfix + "." + type.name
	}

	/**
	 * Returns the fully qualified java class name for a Type.
	 */
	def dispatch String toQualifiedJavaTypeName (Service service) {
		nameProvider.getFullyQualifiedName(service.eContainer).toString + "." + service.version.toVersionPostfix + "." + service.name
	}

	/**
	 * Returns the fully qualified java class name for a Type.
	 */
	def dispatch String toQualifiedJavaTypeName (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exception) {
		nameProvider.getFullyQualifiedName(exception.eContainer).toString + "." + exception.version.toVersionPostfix + "." + exception.name
	}
	
	/**
	 * Get the full qualified of the Java type derived from the Service DSL type reference
	 */
	def dispatch String toQualifiedJavaTypeName (TypeRef typeRef, boolean optionalField) {
		
	}
	
	/**
	 * Get the full qualified of the Java type derived from the Service DSL type reference
	 */
	def dispatch String toQualifiedJavaTypeName (DataTypeRef typeRef, boolean optionalField) {
		if (typeRef.many)
			if (typeRef.set)
				return "Set<" + typeRef.type.toQualifiedJavaTypeName(true)+">"
			else
				return "List<" + typeRef.type.toQualifiedJavaTypeName(true)+">"
		else
			typeRef.type.toQualifiedJavaTypeName(optionalField)
	}
	
	/**
	 * Get the full qualified of the Java type derived from the Service DSL type reference
	 */
	def dispatch String toQualifiedJavaTypeName (VersionedTypeRef typeRef, boolean optionalField) {
		if (typeRef.many)
			if (typeRef.set)
				return "Set<" + typeRef.type.toQualifiedJavaTypeName(true)+">"
			else
				return "List<" + typeRef.type.toQualifiedJavaTypeName(true)+">"
		else
			typeRef.type.toQualifiedJavaTypeName(optionalField)
	}
	
	/**
	 * Get the full qualified of the Java type derived from the Service DSL type reference
	 */
	def dispatch String toQualifiedJavaTypeName (ExceptionRef exRef, boolean optionalField) {
		exRef.exception.toQualifiedJavaTypeName(optionalField)
	}
	
	/*
	 * returns the Java type name of the property's type
	 */
	def dispatch String toQualifiedJavaTypeName (Property property) {
		property.type.toQualifiedJavaTypeName(property.optional)
	}
	
	
	/**
	 * Returns the Java class name for a Type.
	 */
	def dispatch String toJavaTypeName (Type type, boolean optionalField) {
		
	}
	
	/**
	 * Returns the Java class name for a Type.
	 */
	def dispatch String toJavaTypeName (DataType type, boolean optionalField) {
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
			case "boolean":			if (optionalField) return "Boolean" else return "boolean"
			case "char":			if (optionalField) return "Character" else return "char"
			case "string":			return "String"
			case "anyType":			return "Object"
			default: 				if (optionalField) return "Void" else return "void"
		}
	}
	
	/**
	 * Returns the Java class name for a Type.
	 */
	def dispatch String toJavaTypeName (VersionedType type, boolean optionalField) {
		type.name
	}
	
	/**
	 * Returns the Java class name for a Type.
	 */
	def dispatch String toJavaTypeName (TypeRef typeRef, boolean optionalField) {
		
	}

	/**
	 * Returns the Java class name for a Type.
	 */
	def dispatch String toJavaTypeName (DataTypeRef typeRef, boolean optionalField) {
		if (typeRef.many)
			if (typeRef.set)
				return "Set<" + typeRef.type.toJavaTypeName(true) + ">"
			else
				return "List<" + typeRef.type.toJavaTypeName(true) + ">"
		else
			return typeRef.type.toJavaTypeName(optionalField)
	}

	/**
	 * Returns the Java class name for a Type.
	 */
	def dispatch String toJavaTypeName (VersionedTypeRef typeRef, boolean optionalField) {
		if (typeRef.many)
			if (typeRef.set)
				return "Set<" + typeRef.type.toJavaTypeName(true) + ">"
			else
				return "List<" + typeRef.type.toJavaTypeName(true) + ">"
		else
			return typeRef.type.toJavaTypeName(optionalField)
	}

	/**
	 * Returns the Java class name for a Type.
	 */
	def dispatch String toJavaTypeName (Service service, boolean optionalField) {
		service.name
	}

	/**
	 * Returns the Java class name for a Type.
	 */
	def dispatch String toJavaTypeName (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exception, boolean optionalField) {
		exception.name
	}

	/**
	 * Returns the Java class name of an implementation class of the collection class of a many TypeRef.
	 */
	def dispatch String toImplJavaTypeName (TypeRef typeRef, boolean optionalField) {
		
	}

	/**
	 * Returns the Java class name of an implementation class of the collection class of a many TypeRef.
	 */
	def dispatch String toImplJavaTypeName (DataTypeRef typeRef, boolean optionalField) {
		if (typeRef.many)
			if (typeRef.set)
				return "HashSet<" + typeRef.type.toJavaTypeName(true) + ">"
			else
				return "ArrayList<" + typeRef.type.toJavaTypeName(true) + ">"
		else
			return typeRef.type.toJavaTypeName(optionalField)
	}
	/**
	 * Returns the Java class name of an implementation class of the collection class of a many TypeRef.
	 */
	def dispatch String toImplJavaTypeName (VersionedTypeRef typeRef, boolean optionalField) {
		if (typeRef.many)
			if (typeRef.set)
				return "HashSet<" + typeRef.type.toJavaTypeName(true) + ">"
			else
				return "ArrayList<" + typeRef.type.toJavaTypeName(true) + ">"
		else
			return typeRef.type.toJavaTypeName(optionalField)
	}
	
	/*
	 * returns the Java type name of the property's type
	 */
	def String toJavaTypeName (Property property) {
		property.type.toJavaTypeName(property.optional)
	}
	
	def dispatch String toPackageName (Type type) {
		return null
	}
	def dispatch String toPackageName (VersionedType type) {
		nameProvider.getFullyQualifiedName(type.eContainer).toString + "." + type.version.toVersionPostfix
	}
	def dispatch String toPackageName (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exception) {
		nameProvider.getFullyQualifiedName(exception.eContainer).toString + "." + exception.version.toVersionPostfix
	}
	def dispatch String toPackageName (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Class type) {
		nameProvider.getFullyQualifiedName(type.eContainer).toString + "." + type.version.toVersionPostfix
	}
	def dispatch String toPackageName (TypeRef typeRef) {
		return null
	}
	def dispatch String toPackageName (VersionedTypeRef typeRef) {
		typeRef.type.toPackageName
	}
	def dispatch String toPackageName (ClassRef typeRef) {
		typeRef.type.toPackageName
	}
	def dispatch String toPackageName (Service svc) {
		nameProvider.getFullyQualifiedName(svc.eContainer).toString + "." + svc.version.toVersionPostfix
	}


	// Java file names
	
	/**
	 * Convert a fully qualified class name to the Java file name
	 */
	def String toJavaFileName (String qualifiedClassName) {
		qualifiedClassName.replaceAll("\\.", "/") + ".java"
	}
	
	/**
	 * Get the java file name of a class representing a Type
	 */
	def String toJavaFileName (Type type) {
		type.toQualifiedJavaTypeName (false).toJavaFileName
	}
	
	/**
	 * Get the java file name of a class representing a Service
	 */
	def String toJavaFileName (Service type) {
		type.toQualifiedJavaTypeName (false).toJavaFileName
	}
	
	/**
	 * Get the java file name of a class representing the referenced Type
	 */
	def String toJavaFileName (TypeRef typeRef, boolean isOptional) {
		typeRef.toQualifiedJavaTypeName (isOptional).toJavaFileName
	}
	
	/**
	 * Get the java file name of the exception wrapper class representing the referenced Exception 
	 */
	def String toJavaFileName (ExceptionRef typeRef) {
		typeRef.toQualifiedJavaTypeName (false).toJavaFileName
	}
	
}