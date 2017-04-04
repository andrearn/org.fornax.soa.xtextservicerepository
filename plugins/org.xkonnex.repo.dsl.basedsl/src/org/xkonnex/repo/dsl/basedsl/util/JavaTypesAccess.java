package org.xkonnex.repo.dsl.basedsl.util;

import java.lang.reflect.Method;
import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;

import com.google.common.collect.Lists;

@Named
public class JavaTypesAccess {
	
	public Class<?> getRawType(JvmType type) {
		if (type instanceof JvmArrayType) {
			JvmType componentType = ((JvmArrayType) type).getComponentType();
			Class<?> componentClass = getRawType(componentType);
			try {
				return Class.forName(componentClass.getName() + "[]");
			} catch (ClassNotFoundException e) {
				return null;
			}
		}
		if (type instanceof JvmTypeParameter) {
			JvmTypeParameter tp = (JvmTypeParameter) type;
			EList<JvmTypeConstraint> constraints = tp.getConstraints();
			for (JvmTypeConstraint jvmTypeConstraint : constraints) {
				if (jvmTypeConstraint instanceof JvmUpperBound) {
					return getRawType(jvmTypeConstraint.getTypeReference());
				}
			}
			return Object.class;
		}
		try {
			return Class.forName(type.getIdentifier());
		} catch (ClassNotFoundException e) {
		}
		return null;
	}

	private Class<?> getRawType(JvmTypeReference ref) {
		Class<?> result = getRawType(ref.getType());
		return result;
	}
	
	public Method getMethod(JvmOperation operation) {
		Class<?> declaringType = getRawType(operation.getDeclaringType());
		if (declaringType == null)
			return null;
		Class<?>[] paramTypes = getParamTypes(operation);
		try {
			return declaringType.getDeclaredMethod(operation.getSimpleName(), paramTypes);
		} catch (Exception e) {
		}
		return null;
	}

	protected Class<?>[] getParamTypes(JvmExecutable exe) {
		List<JvmFormalParameter> parameters = exe.getParameters();
		List<Class<?>> result = Lists.newArrayList();
		for (JvmFormalParameter p : parameters) {
			result.add(getRawType(p.getParameterType()));
		}
		return result.toArray(new Class<?>[result.size()]);
	}
}
