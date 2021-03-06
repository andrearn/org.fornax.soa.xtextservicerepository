/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.environmentdsl.scoping;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScope;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.xkonnex.repo.dsl.basedsl.baseDsl.AbstractType;
import org.xkonnex.repo.dsl.basedsl.scoping.ComponentAwareVersionedScopeProvider;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.AbstractPredicateVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.NullVersionFilter;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ExtensibleConnector;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ExtensibleServer;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class EnvironmentDslScopeProvider extends ComponentAwareVersionedScopeProvider {
	
	@Inject IQualifiedNameProvider nameProvider;

	@Override
	protected AbstractPredicateVersionFilter<IEObjectDescription> getVersionFilterFromContext(
			EObject context, EReference reference) {
		return new NullVersionFilter<IEObjectDescription>();
	}
	
	
	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		List<ImportNormalizer> result = newArrayList();
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.cluster.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.connector.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.container.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.db.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.executable.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.gateway.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.image.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.management.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.registry.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.server.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.server.corba.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.server.esb.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.server.jee.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.server.messaging.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.server.process.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.script.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.security.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.environmentdsl.ext.vm.*", ignoreCase));
		return result;
	}

}
