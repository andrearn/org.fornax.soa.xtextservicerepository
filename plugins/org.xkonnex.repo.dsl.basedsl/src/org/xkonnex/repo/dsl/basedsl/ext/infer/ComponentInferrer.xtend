package org.xkonnex.repo.dsl.basedsl.ext.infer

import com.google.inject.Inject
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.util.JavaReflectAccess
import org.eclipse.xtext.util.Strings
import org.xkonnex.repo.dsl.basedsl.baseDsl.Assignment
import org.xkonnex.repo.dsl.basedsl.baseDsl.BooleanValue
import org.xkonnex.repo.dsl.basedsl.baseDsl.Component
import org.xkonnex.repo.dsl.basedsl.baseDsl.EnumLiteralValue
import org.xkonnex.repo.dsl.basedsl.baseDsl.IntValue
import org.xkonnex.repo.dsl.basedsl.baseDsl.StringValue
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.xkonnex.repo.dsl.basedsl.scoping.ComponentExtensions
import java.beans.Introspector

@SuppressWarnings("restriction") 
class ComponentInferrer implements IComponentInferrer {
	
	@Inject JavaReflectAccess reflectAccess
	@Inject extension ComponentExtensions
	
	override <T> inferComponent(Component component) {
		if (component.assignment != null)
			inferComponent(component.type, component.assignment)
		else
			inferComponent(component.type)
	}

	@SuppressWarnings("unchecked") 
	override <T> T inferComponent(JvmType type) {
		var Object compInst = createInstance(type)
		if (compInst !== null) {
			return (compInst as T)
		}
		return null
	}
	
	@SuppressWarnings("unchecked") 
	override <T> T inferComponent(JvmType type, List<Assignment> assignments) {
		var Object compInst = createInstance(type)
		if (compInst !== null) {
			internalApplyAssignments(compInst, type, assignments)
			return (compInst as T)
		}
		return null
	}

	def protected void internalApplyAssignments(Object o, JvmType type, List<Assignment> assignments) {
		for (Assignment assignment : assignments) {
			var Method setter = findSetter(type, assignment.getFeature().getSimpleName())
			var Object value = getValue(assignment.value, assignment.feature)
			try {
				setter.invoke(o, value)
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace()
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace()
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace()
			}

		}
	}

	def dispatch private Object getValue(Object value, JvmIdentifiableElement feature) {
		return null
	}
	
	def dispatch private Object getValue(Component value, JvmIdentifiableElement feature) {
		val nestedComponent = inferComponent(value.actualType, value.assignment)
		return nestedComponent
	}
	
	def dispatch private Object getValue(BooleanValue value, JvmIdentifiableElement feature) {
		return value.isTrue
	}
	
	def dispatch private Object getValue(StringValue value, JvmIdentifiableElement feature) {
		return value.value
	}
	
	def dispatch private Object getValue(IntValue value, JvmIdentifiableElement feature) {
		return value.value
	}
	
	def dispatch private Object getValue(EnumLiteralValue value, JvmIdentifiableElement feature) {
		val literal = value.value
		return createInstance(literal.declaringType, literal)
	}
	

	def private Method findSetter(JvmType type, String featureName) {
		if (type instanceof JvmDeclaredType) {
			var JvmDeclaredType declaredType = (type as JvmDeclaredType)
			var EList<JvmMember> members = declaredType.getMembers()
			var JvmOperation setterOp = findSetterJvmOp(featureName, members)
			if (setterOp !== null) {
				return reflectAccess.getMethod(setterOp)
			}
		}
		return null
	}

	def private JvmOperation findSetterJvmOp(String featureName, EList<JvmMember> members) {
		for (JvmMember member : members) {
			if (member instanceof JvmOperation) {
				var JvmOperation op = (member as JvmOperation)
				var String simpleName = op.getSimpleName()
				if (simpleName.equals(featureName)) {
					return op
				}
			}
		}
		return null
	}

	def private Object createInstance(JvmType type) {
		var Object compInst = null
		var Class<?> compClazz = reflectAccess.getRawType(type)
		compInst = compClazz.newInstance()
		return compInst
	}
	
	def private Object createInstance(JvmType type, JvmEnumerationLiteral enumLiteral) {
		var Object enumInst = null
		var Class<?> enumClazz = reflectAccess.getRawType(type)
		val valueOfMethod = enumClazz.getMethod("valueOf", typeof(String))
		enumInst = valueOfMethod.invoke(null, enumLiteral.simpleName)
		return enumInst
	}
	
}
