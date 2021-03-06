package org.xkonnex.repo.dsl.basedsl.scoping;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.JavaReflectAccess;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

public class InjectableFeatureLookup implements IInjectableFeatureLookup {

	@Inject 
	private JavaReflectAccess reflectAccess;

	public Map<QualifiedName, JvmFeature> getInjectableFeatures(JvmType type) {
		Map<QualifiedName, JvmFeature> result = Maps.newHashMap();
		collectFeatures(type, result);
		return ImmutableMap.copyOf(result);
	}
	
	@SuppressWarnings("restriction")
	public void collectFeatures(JvmType containerType, Map<QualifiedName, JvmFeature> result) {
		if (containerType == null || containerType.eIsProxy())
			return;		
		if (containerType instanceof JvmDeclaredType) {
			JvmDeclaredType containerDeclaredType = (JvmDeclaredType) containerType;
			List<JvmTypeReference> superTypes = containerDeclaredType.getSuperTypes();
			for(JvmTypeReference superType: superTypes) {
				if (superType.getType() != null)
					collectFeatures(superType.getType(), result);
			}
			List<JvmMember> members = containerDeclaredType.getMembers();
			for(JvmMember member: members) {
				if (member instanceof JvmOperation) {
					JvmOperation op = (JvmOperation) member;
					String simpleName = op.getSimpleName();
					if (simpleName != null && simpleName.length() > 3 && 
							(simpleName.startsWith("add") || simpleName.startsWith("set"))) {
						if (op.getParameters().size() == 1) {
							Class<?> rawType = reflectAccess.getRawType(op.getParameters().get(0).getParameterType().getType());
							boolean isCollectionType = Collection.class.isAssignableFrom(rawType);
							if (!isCollectionType) {
								String name = Strings.toFirstLower(op.getSimpleName().substring(3));
								result.put(QualifiedName.create(name), op);
							}
						}
					}
				}
				if (member instanceof JvmEnumerationLiteral) {
					JvmEnumerationLiteral literal = (JvmEnumerationLiteral)member;
					String simpleName = literal.getSimpleName();
					result.put(QualifiedName.create(simpleName), literal);
				}
			}
		}
	}

}
