package org.fornax.soa.profiledsl.generator;

import org.fornax.soa.profiledsl.SOAProfileDslRuntimeModule;
import org.fornax.soa.profiledsl.versioning.TechnicalNamespaceSplitter;
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaNamespaceExtensions;
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaTypeExtensions;
import org.fornax.soa.profiledsl.query.namespace.TechnicalNamespaceImportQueries;
import org.fornax.soa.profiledsl.query.namespace.TechnicalNamespaceQueries;
import org.fornax.soa.profiledsl.query.ProfileVersionQueries;
import org.fornax.soa.profiledsl.query.type.LatestMatchingTypeFinder;
import org.fornax.soa.profiledsl.query.type.ReferencedTypesFinder;
import org.fornax.soa.profiledsl.query.type.VersionedTypeFilter;

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