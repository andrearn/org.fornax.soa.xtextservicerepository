package org.xkonnex.repo.dsl.basedsl.scoping;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

public class JavaNamespaceAwareScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		List<ImportNormalizer> result = newArrayList();
		result.add(createImportedNamespaceResolver("java.lang.*", ignoreCase));
		return result;
	}

	@Override
	protected boolean isRelativeImport() {
		return false;
	}

}
