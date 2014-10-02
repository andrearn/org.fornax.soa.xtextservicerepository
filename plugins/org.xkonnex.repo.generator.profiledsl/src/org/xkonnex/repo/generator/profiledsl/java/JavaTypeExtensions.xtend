package org.xkonnex.repo.generator.profiledsl.java

import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Type
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.DataType
import com.google.inject.Inject
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaNamespaceExtensions
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedType
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TypeRef
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.DataTypeRef
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedTypeRef
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Property

class JavaTypeExtensions {
	
	@Inject QualifiedNameProvider nameProvider
	@Inject extension ProfileSchemaNamespaceExtensions
	
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
	
	
	def dispatch toQualifiedJavaTypeName (TypeRef typeRef, boolean optionalField) {
		
	}
	def dispatch toQualifiedJavaTypeName (DataTypeRef typeRef, boolean optionalField) {
		typeRef.type.toQualifiedJavaTypeName(optionalField)
	}
	def dispatch toQualifiedJavaTypeName (VersionedTypeRef typeRef, boolean optionalField) {
		typeRef.type.toQualifiedJavaTypeName(optionalField)
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
		typeRef.type.toQualifiedJavaTypeName(optionalField)
	}
	def dispatch toJavaTypeName (VersionedTypeRef typeRef, boolean optionalField) {
		typeRef.type.toQualifiedJavaTypeName(optionalField)
	}
	
	/*
	 * returns the Java type name of the property's type
	 */
	def toJavaTypeName (Property property) {
		property.type.toJavaTypeName(property.optional)
	}
	
}