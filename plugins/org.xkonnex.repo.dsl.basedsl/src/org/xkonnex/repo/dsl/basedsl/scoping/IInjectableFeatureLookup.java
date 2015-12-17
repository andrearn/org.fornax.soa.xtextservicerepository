package org.xkonnex.repo.dsl.basedsl.scoping;

import java.util.Map;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;

import com.google.inject.ImplementedBy;

@ImplementedBy(InjectableFeatureLookup.class)
public interface IInjectableFeatureLookup {
	
	Map<QualifiedName, JvmFeature> getInjectableFeatures(JvmType type);

}
