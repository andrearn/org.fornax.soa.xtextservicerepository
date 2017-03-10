package org.xkonnex.repo.dsl.basedsl.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmType
import org.xkonnex.repo.dsl.basedsl.baseDsl.Component
import org.xkonnex.repo.dsl.basedsl.baseDsl.Assignment
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.xkonnex.repo.dsl.basedsl.baseDsl.EnumLiteralValue

class ComponentExtensions {
	
	
	def JvmType getActualType(Component component) {
		val JvmType result = component.type;
		if (result != null)
			return result;
		val EObject container = component.eContainer();
		if (container instanceof Assignment) {
			val JvmIdentifiableElement containerFeature = (container as Assignment).getFeature();
			if (containerFeature != null && containerFeature instanceof JvmOperation) {
				val JvmFormalParameter parameter = (containerFeature as JvmOperation).getParameters().get(0);
				return parameter.getParameterType().getType();
			}
		}
		return result;
		
	}
	
	def JvmType getActualType(Assignment assignment) {
		val JvmIdentifiableElement containerFeature = assignment.getFeature();
		if (containerFeature != null && containerFeature instanceof JvmOperation) {
			val JvmFormalParameter parameter = (containerFeature as JvmOperation).getParameters().get(0);
			return parameter.getParameterType().getType();
		}
		return null;
	}
	
	def JvmType getActualType(EnumLiteralValue component) {
		val EObject container = component.eContainer();
		if (container instanceof Assignment) {
			val JvmIdentifiableElement containerFeature = (container as Assignment).getFeature();
			if (containerFeature != null && containerFeature instanceof JvmOperation) {
				val JvmFormalParameter parameter = (containerFeature as JvmOperation).getParameters().get(0);
				return parameter.getParameterType().getType();
			}
		}
		return null
		
	}
}