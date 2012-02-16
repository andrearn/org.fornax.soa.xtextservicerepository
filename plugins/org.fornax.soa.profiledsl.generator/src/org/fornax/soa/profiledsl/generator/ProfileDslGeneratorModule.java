package org.fornax.soa.profiledsl.generator;

import org.fornax.soa.profiledsl.ProfileSchemaNamespaceExtensions;
import org.fornax.soa.profiledsl.ProfileSchemaTypeExtensions;
import org.fornax.soa.profiledsl.SOAProfileDslRuntimeModule;
import org.fornax.soa.profiledsl.TechnicalNamespaceSplitter;
import org.fornax.soa.profiledsl.query.NamespaceImportQueries;
import org.fornax.soa.profiledsl.query.NamespaceQueries;
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
	
	public Class<? extends NamespaceImportQueries> bindProfileNamespaceImportQueries () {
		return NamespaceImportQueries.class;
	}
	
	public Class<? extends NamespaceQueries> bindProfileNamespaceQueries () {
		return NamespaceQueries.class;
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
