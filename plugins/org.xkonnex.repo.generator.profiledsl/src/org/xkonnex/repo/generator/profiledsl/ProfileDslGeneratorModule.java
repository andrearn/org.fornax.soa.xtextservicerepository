package org.xkonnex.repo.generator.profiledsl;

import org.xkonnex.repo.dsl.profiledsl.SOAProfileDslRuntimeModule;
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaNamespaceExtensions;
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaTypeExtensions;
import org.xkonnex.repo.dsl.profiledsl.query.ProfileVersionQueries;
import org.xkonnex.repo.dsl.profiledsl.query.namespace.TechnicalNamespaceImportQueries;
import org.xkonnex.repo.dsl.profiledsl.query.namespace.TechnicalNamespaceQueries;
import org.xkonnex.repo.dsl.profiledsl.query.type.LatestMatchingTypeFinder;
import org.xkonnex.repo.dsl.profiledsl.query.type.ReferencedTypesFinder;
import org.xkonnex.repo.dsl.profiledsl.query.type.VersionedTypeFilter;
import org.xkonnex.repo.dsl.profiledsl.versioning.TechnicalNamespaceSplitter;

public class ProfileDslGeneratorModule extends SOAProfileDslRuntimeModule {

	public Class<? extends LatestMatchingTypeFinder> bindProfileLatestMatchingTypeFinder () {
		return LatestMatchingTypeFinder.class;
	}
	
	public Class<? extends ReferencedTypesFinder> bindProfileReferencedTypesFinder () {
		return ReferencedTypesFinder.class;
	}
	
	public Class<? extends VersionedTypeFilter> bindProfileVersionedTypeFilter () {
		return VersionedTypeFilter.class;
	}
	
	public Class<? extends TechnicalNamespaceImportQueries> bindProfileNamespaceImportQueries () {
		return TechnicalNamespaceImportQueries.class;
	}
	
	public Class<? extends TechnicalNamespaceQueries> bindProfileNamespaceQueries () {
		return TechnicalNamespaceQueries.class;
	}
	
	public Class<? extends ProfileVersionQueries> bindProfileVersionQueries () {
		return ProfileVersionQueries.class;
	}
	
	public Class<? extends ProfileSchemaNamespaceExtensions> bindProfileSchemaNamespaceExtensions () {
		return ProfileSchemaNamespaceExtensions.class;
	}
	
	public Class<? extends ProfileSchemaTypeExtensions> bindProfileSchemaTypeExtensions () {
		return ProfileSchemaTypeExtensions.class;
	}
	
	public Class<? extends TechnicalNamespaceSplitter> bindTechnicalNamespaceSplitter () {
		return TechnicalNamespaceSplitter.class;
	}
}
