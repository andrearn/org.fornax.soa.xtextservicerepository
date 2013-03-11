/*
 * generated by Xtext
 */
package org.fornax.soa.scoping;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.fornax.soa.basedsl.sOABaseDsl.FixedVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.LowerBoundRangeVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MajorVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MaxVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MinVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.scoping.versions.VersionFilteringScope;
import org.fornax.soa.basedsl.scoping.versions.filter.AbstractPredicateVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.FixedVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.LatestMajorVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.LatestMaxExclVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.LatestMinInclMaxExclRangeVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.LatestMinInclVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.NullVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.VersionedImportedNamespaceAwareScopeProvider;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.version.IScopeVersionResolver;
import org.fornax.soa.basedsl.version.SimpleScopeVersionResolver;
import org.fornax.soa.basedsl.version.VersionedOwnerScopeVersionResolver;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.RelaxedLatestMajorVersionForOwnerStateFilter;
import org.fornax.soa.profiledsl.scoping.versions.RelaxedLatestMinMaxVersionForOwnerStateFilter;
import org.fornax.soa.profiledsl.scoping.versions.RelaxedLatestMinVersionForOwnerStateFilter;
import org.fornax.soa.profiledsl.scoping.versions.RelaxedMaxVersionForOwnerStateFilter;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.service.util.ServiceDslElementAccessor;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.CapabilityRef;
import org.fornax.soa.serviceDsl.ComplexConsiderationPropertyRef;
import org.fornax.soa.serviceDsl.ConsiderationParameterRef;
import org.fornax.soa.serviceDsl.ConsiderationPropertyRef;
import org.fornax.soa.serviceDsl.ConsiderationSpec;
import org.fornax.soa.serviceDsl.EnumTypeRef;
import org.fornax.soa.serviceDsl.EventRef;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.MessageHeaderRef;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.OperationRef;
import org.fornax.soa.serviceDsl.Parameter;
import org.fornax.soa.serviceDsl.RequiredServiceRef;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.ServiceRef;
import org.fornax.soa.serviceDsl.SimpleConsiderationPropertyRef;
import org.fornax.soa.serviceDsl.SimpleOperationRef;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedTypeRef;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class ServiceDslScopeProvider extends VersionedImportedNamespaceAwareScopeProvider {
	private static final Logger logger = Logger.getLogger(ServiceDslScopeProvider.class);

	
	@Inject Injector injector;

	@Inject
	private IQualifiedNameProvider nameProvider;
	
	@Inject IEObjectLookup objLookup;

	public void setNameProvider(IQualifiedNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}

	public IQualifiedNameProvider getNameProvider() {
		return nameProvider;
	}
	
	@Override
	protected IScope getLocalElementsScope(IScope parent, final EObject ctx,
			final EReference reference) {
		if (parent instanceof VersionFilteringScope && ctx instanceof ConsiderationPropertyRef ) {
			IScope currentParent = parent;
			while (currentParent instanceof VersionFilteringScope && ((VersionFilteringScope) currentParent).getParent() instanceof VersionFilteringScope) {
				currentParent  = ((VersionFilteringScope) currentParent).getParent();
			}
			if (currentParent != null) {
				IScope result = super.getLocalElementsScope(currentParent, ctx, reference);
				return result;
			}
		}
		return super.getLocalElementsScope(parent, ctx, reference);
		
	}

	@Override
	protected AbstractPredicateVersionFilter<IEObjectDescription> getVersionFilterFromContext (
			EObject ctx, final EReference reference) {
		if (reference==ServiceDslPackage.Literals.VERSIONED_TYPE_REF__TYPE 
				&& ctx instanceof VersionedTypeRef) {
			final VersionRef v = ((VersionedTypeRef) ctx).getVersionRef();
			return createVersionFilter (v, objLookup.getVersionedOwner(ctx));
		
		} else if (reference==ServiceDslPackage.Literals.BUSINESS_OBJECT_REF__TYPE 
				&& ctx instanceof BusinessObjectRef) {
			final VersionRef v = ((BusinessObjectRef) ctx).getVersionRef();
			return createVersionFilter (v, objLookup.getVersionedOwner(ctx));
		
			//FIXME verify this ref
		} else if (reference==ServiceDslPackage.Literals.BUSINESS_OBJECT__SUPER_BUSINESS_OBJECT 
				&& ctx instanceof BusinessObjectRef) {
			final VersionRef v = ((BusinessObjectRef) ctx).getVersionRef();
			return createVersionFilter (v, objLookup.getVersionedOwner(ctx));
		
		} else if (reference == ServiceDslPackage.Literals.ENUM_TYPE_REF__TYPE 
				&& ctx instanceof EnumTypeRef) {
			final VersionRef v = ((EnumTypeRef) ctx).getVersionRef();
			return createVersionFilter (v, objLookup.getVersionedOwner(ctx));
		
		} else if (reference == ServiceDslPackage.Literals.SERVICE_REF__SERVICE 
				&& ctx instanceof ServiceRef) {
			final VersionRef v = ((ServiceRef) ctx).getVersionRef();
			return createVersionFilter (v, objLookup.getVersionedOwner(ctx));
		
		} else if (reference == ServiceDslPackage.Literals.EXCEPTION_REF__EXCEPTION 
				&& ctx instanceof ExceptionRef) {
			final VersionRef v = ((ExceptionRef) ctx).getVersion();
			return createVersionFilter (v, objLookup.getVersionedOwner(ctx));

		} else if (reference == ServiceDslPackage.Literals.EVENT_REF__EVENT 
				&& ctx instanceof EventRef) {
			final VersionRef v = ((EventRef) ctx).getVersionRef();
			return createVersionFilter(v, objLookup.getVersionedOwner(ctx));
		
		} else if (reference == ServiceDslPackage.Literals.OPERATION_REF__OPERATION 
				&& ctx instanceof OperationRef) {
			final VersionRef v = ((OperationRef) ctx).getVersionRef();
			return createEContainerVersionFilter(v, objLookup.getVersionedOwner(ctx));
		
			
		} else if (reference == ServiceDslPackage.Literals.SIMPLE_OPERATION_REF__OPERATION 
				&& ctx instanceof SimpleOperationRef && ctx.eContainer() instanceof RequiredServiceRef) {
			RequiredServiceRef requiredServiceRef =	(RequiredServiceRef) ctx.eContainer();
			final VersionRef v = requiredServiceRef.getVersionRef();
			final QualifiedName serviceName = nameProvider.getFullyQualifiedName(requiredServiceRef.getService());
			AbstractPredicateVersionFilter<IEObjectDescription> versionFilter = createEContainerVersionFilter(v, objLookup.getVersionedOwner(ctx));
			versionFilter.setPreFilterPredicate(new Predicate<IEObjectDescription>() {

				public boolean apply(IEObjectDescription input) {
					if (input.getQualifiedName().startsWith(serviceName))
						return true;
					else
						return false;
				}
				
			});
			return versionFilter;
		} else if (reference == ServiceDslPackage.Literals.CONSIDERATION_PARAMETER_REF__PARAM 
				&& ctx instanceof ConsiderationParameterRef 
				&& ctx.eContainer() instanceof ConsiderationSpec) {
			ConsiderationParameterRef paramRef = (ConsiderationParameterRef)ctx;
			AbstractPredicateVersionFilter<IEObjectDescription> scopeFilter = createConsiderationParameterScopeFilter(paramRef);
			if (scopeFilter != null)
				return scopeFilter;

		} else if (reference == ServiceDslPackage.Literals.CONSIDERATION_PARAMETER_REF__PROPERTY_REF 
				&& ctx instanceof ConsiderationParameterRef) {
			TypeRef typeRef = ((ConsiderationParameterRef) ctx).getParam().getType();
			AbstractPredicateVersionFilter<IEObjectDescription> f = AbstractPredicateVersionFilter.NULL_VERSION_FILTER;
			if (typeRef instanceof BusinessObjectRef) 
				f = createEContainerVersionFilter (((BusinessObjectRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
			else if (typeRef instanceof EnumTypeRef)
				f = createEContainerVersionFilter (((EnumTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
			return f;
		} else if (reference == ServiceDslPackage.Literals.SIMPLE_CONSIDERATION_PROPERTY_REF 
				&& ctx instanceof SimpleConsiderationPropertyRef) {
			TypeRef typeRef = null;
			if (ctx.eContainer() instanceof ComplexConsiderationPropertyRef) {
				typeRef = ((ComplexConsiderationPropertyRef) ctx.eContainer()).getParentProperty().getType();
			} else {
				typeRef = ((SimpleConsiderationPropertyRef) ctx).getProperty().getType();
			}
			AbstractPredicateVersionFilter<IEObjectDescription> f = new NullVersionFilter<IEObjectDescription>();
			
			if (typeRef instanceof BusinessObjectRef) 
				f = createEContainerVersionFilter (((BusinessObjectRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
			else if (typeRef instanceof EnumTypeRef)
				f = createEContainerVersionFilter (((EnumTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
			if (typeRef instanceof VersionedTypeRef) {
				VersionedTypeRef verTypeRef = (VersionedTypeRef) typeRef;
				final QualifiedName verTypeName = nameProvider.getFullyQualifiedName (verTypeRef.getType());	
				f.setPreFilterPredicate(new Predicate<IEObjectDescription> () {

					public boolean apply(IEObjectDescription input) {
						if (input.getQualifiedName().startsWith(verTypeName))
							return true;
						else
							return false;
					}
					
				});
			}
			return f;
		} else if (reference == ServiceDslPackage.Literals.SIMPLE_CONSIDERATION_PROPERTY_REF__PROPERTY 
				&& ctx instanceof SimpleConsiderationPropertyRef) {
			return createFilterForSimpleConsPropRefProperty(ctx);
		} else if (
				reference == ServiceDslPackage.Literals.SIMPLE_CONSIDERATION_PROPERTY_REF__PROPERTY && 
				ctx instanceof ComplexConsiderationPropertyRef) {
			//intermediate state in content assist -> block all canditates
			return createBlockingFilter(ctx);			
		} else if (reference == ServiceDslPackage.Literals.MESSAGE_HEADER_REF__HEADER 
				&& ctx instanceof MessageHeaderRef) {
			final VersionRef v = ((MessageHeaderRef) ctx).getVersionRef();
			return createStateLessVersionFilter (v, objLookup.getVersionedOwner(ctx));
		} else if (reference==ServiceDslPackage.Literals.CAPABILITY_REF__VERSION_REF 
				&& ctx instanceof CapabilityRef) {
			final VersionRef v = ((CapabilityRef) ctx).getVersionRef();
			return createVersionFilter (v, objLookup.getVersionedOwner(ctx));

		} else if (reference.eContainer() instanceof EClass && "operation".equals(reference.getName()) 
				&& ctx instanceof RequiredServiceRef) {
			return createFilterForOperationRef(ctx);
			
		} else if (reference == ServiceDslPackage.Literals.SIMPLE_CONSIDERATION_PROPERTY_REF__PROPERTY 
				&& ctx.eContainer() instanceof ConsiderationParameterRef) {
			//FIXME obsolete
			return createFilterForSimpleConsPropRefBelowConsParamRef(ctx);

		} else if (reference == ServiceDslPackage.Literals.SIMPLE_CONSIDERATION_PROPERTY_REF__PROPERTY && ctx instanceof ConsiderationParameterRef) {
			try {
				TypeRef typeRef = ((ConsiderationParameterRef) ctx).getParam().getType();
				return getPropertyFilterFromTypeRef(ctx, typeRef);
			} catch (Throwable ex) {
				logger.warn("Error resolving a SimpleConsiderationPropertyRef propertyRef of a ConsiderationParameterRef", ex);
			}
		} else if (reference == ServiceDslPackage.Literals.COMPLEX_CONSIDERATION_PROPERTY_REF__PARENT_PROPERTY  && ctx instanceof ConsiderationParameterRef) {
			try {
				TypeRef typeRef = ((ConsiderationParameterRef) ctx).getParam().getType();
				return getPropertyFilterFromTypeRef(ctx, typeRef);
			} catch (Throwable ex) {
				logger.warn("Error resolving a ComplexConsiderationProperty parentPropertyRef of a ConsiderationParameterRef", ex);
			}
		} else if (reference == ServiceDslPackage.Literals.COMPLEX_CONSIDERATION_PROPERTY_REF__PARENT_PROPERTY  && ctx instanceof ComplexConsiderationPropertyRef) {
			//FIXME only required for content assist, resolution of static defined model leads to linking cycles
			try {
				TypeRef typeRef = ((ComplexConsiderationPropertyRef) ctx).getParentProperty().getType();
				return getPropertyFilterFromTypeRef(ctx, typeRef);
			} catch (Throwable ex) {
//				logger.debug("Error resolving a ComplexConsiderationProperty parentPropertyRef of a ComplexConsiderationPropertyRef", ex);
			}
		}
		

		return new NullVersionFilter<IEObjectDescription>();
	}

	private AbstractPredicateVersionFilter<IEObjectDescription> createFilterForOperationRef(
			EObject ctx) {
		RequiredServiceRef requiredServiceRef =	(RequiredServiceRef) ctx;
		final VersionRef v = requiredServiceRef.getVersionRef();
		final QualifiedName serviceName = nameProvider.getFullyQualifiedName(requiredServiceRef.getService());
		AbstractPredicateVersionFilter<IEObjectDescription> versionFilter = createEContainerVersionFilter(v, objLookup.getVersionedOwner(ctx));
		versionFilter.setPreFilterPredicate(new Predicate<IEObjectDescription>() {

			public boolean apply(IEObjectDescription input) {
				if (input.getQualifiedName().startsWith(serviceName))
					return true;
				else
					return false;
			}
			
		});
		return versionFilter;
	}

	private AbstractPredicateVersionFilter<IEObjectDescription> createFilterForSimpleConsPropRefProperty(
			EObject ctx) {
		TypeRef typeRef = null;
		if (ctx.eContainer() instanceof ComplexConsiderationPropertyRef) {
			typeRef = ((ComplexConsiderationPropertyRef) ctx.eContainer()).getParentProperty().getType();
		} else if (ctx.eContainer() instanceof ConsiderationParameterRef){
			typeRef = ((ConsiderationParameterRef) ctx.eContainer()).getParam().getType();
		} else if (ctx.eContainer() instanceof SimpleConsiderationPropertyRef) {
			typeRef = ((ConsiderationParameterRef) ctx.eContainer()).getParam().getType();
		}
		AbstractPredicateVersionFilter<IEObjectDescription> f = new NullVersionFilter<IEObjectDescription>();
		
		if (typeRef instanceof BusinessObjectRef) 
			f = createVersionFilter (((BusinessObjectRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
		else if (typeRef instanceof EnumTypeRef)
			f = createVersionFilter (((EnumTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
		if (typeRef instanceof VersionedTypeRef) {
			f = createVersionFilter (((VersionedTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
			VersionedTypeRef verTypeRef = (VersionedTypeRef) typeRef;
			final QualifiedName verTypeName = nameProvider.getFullyQualifiedName (verTypeRef.getType());	
			f.setPreFilterPredicate(new Predicate<IEObjectDescription> () {

				public boolean apply(IEObjectDescription input) {
					QualifiedName qualifiedName = input.getQualifiedName();
					if (qualifiedName.startsWith(verTypeName))
						return true;
					else
						return false;
				}
				
			});
		}
		return f;
	}

	private AbstractPredicateVersionFilter<IEObjectDescription> createFilterForPropertyOfComplexConsPropertyRef(
			EObject ctx) {
		TypeRef typeRef = null;
		if (ctx.eContainer() instanceof ComplexConsiderationPropertyRef) {
			typeRef = ((ComplexConsiderationPropertyRef) ctx.eContainer()).getParentProperty().getType();
		} else {
				typeRef = ((ComplexConsiderationPropertyRef) ctx).getParentProperty().getType();
		}
		AbstractPredicateVersionFilter<IEObjectDescription> f = new NullVersionFilter<IEObjectDescription>();
		
		if (typeRef instanceof BusinessObjectRef) 
			f = createVersionFilter (((BusinessObjectRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
		else if (typeRef instanceof EnumTypeRef)
			f = createVersionFilter (((EnumTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
		if (typeRef instanceof VersionedTypeRef) {
			f = createVersionFilter (((VersionedTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
			VersionedTypeRef verTypeRef = (VersionedTypeRef) typeRef;
			final QualifiedName verTypeName = nameProvider.getFullyQualifiedName (verTypeRef.getType());	
			f.setPreFilterPredicate(new Predicate<IEObjectDescription> () {

				public boolean apply(IEObjectDescription input) {
					QualifiedName qualifiedName = input.getQualifiedName();
					if (qualifiedName.startsWith(verTypeName))
						return true;
					else
						return false;
				}
				
			});
		}
		return f;
	}

	private AbstractPredicateVersionFilter<IEObjectDescription> createBlockingFilter (EObject ctx) {
		AbstractPredicateVersionFilter<IEObjectDescription> f = new NullVersionFilter<IEObjectDescription>();
		f.setPreFilterPredicate(new Predicate<IEObjectDescription> () {

			public boolean apply(IEObjectDescription input) {
				return false;
			}
			
		});
		return f;
	}


	private AbstractPredicateVersionFilter<IEObjectDescription> createFilterForSimpleConsPropRefBelowConsParamRef(
			EObject ctx) {
		TypeRef typeRef = ((ConsiderationParameterRef) ctx.eContainer()).getParam().getType();
		return getPropertyFilterFromTypeRef(ctx, typeRef);
	}

	private AbstractPredicateVersionFilter<IEObjectDescription> getPropertyFilterFromTypeRef(
			EObject ctx, TypeRef typeRef) {
		AbstractPredicateVersionFilter<IEObjectDescription> versionFilter = new NullVersionFilter<IEObjectDescription>();
		if (typeRef instanceof BusinessObjectRef) {
			versionFilter = createEContainerVersionFilter (((BusinessObjectRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
			BusinessObjectRef verTypeRef = (BusinessObjectRef) typeRef;
			final QualifiedName verTypeName = nameProvider.getFullyQualifiedName (verTypeRef.getType());
			versionFilter.setPreFilterPredicate(new Predicate<IEObjectDescription> () {

				public boolean apply(IEObjectDescription input) {
					if (input.getQualifiedName().startsWith(verTypeName))
						return true;
					else
						return false;
				}
				
			});
		} else if (typeRef instanceof EnumTypeRef) {
			versionFilter = createEContainerVersionFilter (((EnumTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
		} else if (typeRef instanceof VersionedTypeRef) {
			versionFilter = createVersionFilter (((VersionedTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
			VersionedTypeRef verTypeRef = (VersionedTypeRef) typeRef;
			final QualifiedName verTypeName = nameProvider.getFullyQualifiedName (verTypeRef.getType());
			versionFilter.setPreFilterPredicate(new Predicate<IEObjectDescription> () {

				public boolean apply(IEObjectDescription input) {
					if (input.getQualifiedName().startsWith(verTypeName))
						return true;
					else
						return false;
				}
				
			});
		}
		return versionFilter;
	}
	
	private AbstractPredicateVersionFilter<IEObjectDescription> createConsiderationParameterScopeFilter(ConsiderationParameterRef paramRef) {
		try {
			Operation op = objLookup.getOwnerByType(paramRef, Operation.class);
			if (op != null) {
				Iterable<Parameter> params = Iterables.concat(op.getParameters(), op.getReturn());
				final Iterable<QualifiedName> paramNames = Iterables.transform(params, new Function<Parameter, QualifiedName>() {

					public QualifiedName apply(Parameter input) {
						return nameProvider.getFullyQualifiedName(input);
					}
					
				});
				AbstractPredicateVersionFilter<IEObjectDescription> filter = new NullVersionFilter<IEObjectDescription>();
				filter.setPreFilterPredicate (new Predicate<IEObjectDescription>(){
					
					public boolean apply(IEObjectDescription input) {
						try {
							for(QualifiedName paramName : paramNames) {
								if (paramName.equals (input.getQualifiedName()))
									return true;
							}
						} catch (Exception e) {
							logger.error("Error filtering Parameters", e);
						}
						return false;
					}
					
				});
				return filter;
			}
		} catch (Exception ex) {
			logger.error("Error creating scope filter for ConsiderationParameterRefs", ex);
		}
		return null;
	}

	@Override
	protected AbstractPredicateVersionFilter<IEObjectDescription> createVersionFilter(final VersionRef v, EObject owner) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = new NullVersionFilter<IEObjectDescription>();
		if (v != null) {
			IScopeVersionResolver verResolver = new SimpleScopeVersionResolver (v.eResource().getResourceSet());
			ILifecycleStateResolver stateResolver = new StateAttributeLifecycleStateResolver (v.eResource().getResourceSet());
			LifecycleState ownerState = stateResolver.getLifecycleState(owner);
			if (v instanceof MajorVersionRef) {
				RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> (verResolver, new Integer(((MajorVersionRef)v).getMajorVersion()).toString(), stateResolver, ownerState);
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof MaxVersionRef)
				return new LatestMaxExclVersionFilter<IEObjectDescription>(verResolver, ((MaxVersionRef)v).getMaxVersion());
			if (v instanceof MinVersionRef)
				return new LatestMinInclVersionFilter<IEObjectDescription>(verResolver, ((MinVersionRef)v).getMinVersion());
			if (v instanceof LowerBoundRangeVersionRef)
				return new LatestMinInclMaxExclRangeVersionFilter<IEObjectDescription>(verResolver, ((LowerBoundRangeVersionRef)v).getMinVersion(), ((LowerBoundRangeVersionRef)v).getMaxVersion());
		}
		return filter;
	}
	
	private AbstractPredicateVersionFilter<IEObjectDescription> createStateLessVersionFilter(final VersionRef v, EObject owner) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = new NullVersionFilter<IEObjectDescription>();
		if (v != null) {
			IScopeVersionResolver verResolver = new SimpleScopeVersionResolver (v.eResource().getResourceSet());
			if (v instanceof MajorVersionRef)
				return new LatestMajorVersionFilter<IEObjectDescription> (verResolver, new Integer(((MajorVersionRef)v).getMajorVersion()).toString());
			if (v instanceof MaxVersionRef)
				return new LatestMaxExclVersionFilter<IEObjectDescription> (verResolver, ((MaxVersionRef)v).getMaxVersion());
			if (v instanceof MinVersionRef)
				return new LatestMinInclVersionFilter<IEObjectDescription> (verResolver, ((MinVersionRef)v).getMinVersion());
			if (v instanceof LowerBoundRangeVersionRef)
				return new LatestMinInclMaxExclRangeVersionFilter<IEObjectDescription> (verResolver, ((LowerBoundRangeVersionRef)v).getMinVersion(), ((LowerBoundRangeVersionRef)v).getMaxVersion());
			if (v instanceof FixedVersionRef)
				return new FixedVersionFilter<IEObjectDescription>(verResolver, ((FixedVersionRef) v).getFixedVersion());
		}
		return filter;
	}

	private AbstractPredicateVersionFilter<IEObjectDescription> createEContainerVersionFilter(final VersionRef v, EObject owner) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = new NullVersionFilter<IEObjectDescription>();
		if (v != null) {
			IScopeVersionResolver verResolver = new VersionedOwnerScopeVersionResolver (v.eResource().getResourceSet());
			ILifecycleStateResolver stateResolver = new StateAttributeLifecycleStateResolver (v.eResource().getResourceSet());
			LifecycleState ownerState = stateResolver.getLifecycleState(owner);
			if (v instanceof MajorVersionRef) {
				RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> (verResolver, new Integer(((MajorVersionRef)v).getMajorVersion()).toString(), stateResolver, ownerState);
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof MaxVersionRef) {
				RelaxedMaxVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedMaxVersionForOwnerStateFilter<IEObjectDescription> (verResolver, ((MaxVersionRef)v).getMaxVersion(), stateResolver, ownerState);
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof MinVersionRef) {
				RelaxedLatestMinVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMinVersionForOwnerStateFilter<IEObjectDescription> (verResolver, ((MinVersionRef)v).getMinVersion(), stateResolver, ownerState);
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof LowerBoundRangeVersionRef) {
				RelaxedLatestMinMaxVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMinMaxVersionForOwnerStateFilter<IEObjectDescription> (verResolver, ((LowerBoundRangeVersionRef)v).getMinVersion(), ((LowerBoundRangeVersionRef)v).getMaxVersion(), stateResolver, ownerState);
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof FixedVersionRef)
				return new FixedVersionFilter<IEObjectDescription>(verResolver, ((FixedVersionRef) v).getFixedVersion());
		}
		return filter;
	}

}
