/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.servicedsl.scoping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.xkonnex.repo.dsl.basedsl.baseDsl.AssetRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslPackage;
import org.xkonnex.repo.dsl.basedsl.baseDsl.FixedVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.LowerBoundRangeVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MajorVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MaxVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MinVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.VersionRef;
import org.xkonnex.repo.dsl.basedsl.scoping.ComponentAwareVersionedScopeProvider;
import org.xkonnex.repo.dsl.basedsl.scoping.MapBasedScope;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.VersionFilteringScope;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.AbstractPredicateVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.FixedVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.LatestMajorVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.LatestMaxExclVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.LatestMinInclMaxExclRangeVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.LatestMinInclVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.NullVersionFilter;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.version.IScopeVersionResolver;
import org.xkonnex.repo.dsl.basedsl.version.SimpleScopeVersionResolver;
import org.xkonnex.repo.dsl.basedsl.version.VersionedOwnerScopeVersionResolver;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.RelaxedLatestMajorVersionForOwnerStateFilter;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.RelaxedLatestMinMaxVersionForOwnerStateFilter;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.RelaxedLatestMinVersionForOwnerStateFilter;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.RelaxedMaxVersionForOwnerStateFilter;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.xkonnex.repo.dsl.servicedsl.service.query.type.DataObjectQueries;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.CapabilityRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ComplexConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ConsiderationParameterRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ConsiderationSpec;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EnumTypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EventRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.MessageHeaderRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OperationRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.RequiredServiceRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SimpleConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class ServiceDslScopeProvider extends ComponentAwareVersionedScopeProvider {
	private static final Logger logger = Logger.getLogger(ServiceDslScopeProvider.class);

	
	@Inject Injector injector;

	@Inject
	private IQualifiedNameProvider nameProvider;
	@Inject
	private StateAttributeLifecycleStateResolver staticStateResolver;
	
	@Inject IEObjectLookup objLookup;
	@Inject DataObjectQueries dataObjQueries;

	public void setNameProvider(IQualifiedNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}

	public IQualifiedNameProvider getNameProvider() {
		return nameProvider;
	}
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (reference == ServiceDslPackage.Literals.CALL_OPERATION_REF__OPERATION) {
			RequiredServiceRef requiredServiceRef = EcoreUtil2.getContainerOfType(context, RequiredServiceRef.class);
			if (requiredServiceRef != null && requiredServiceRef.getService() != null) {
				Service service = requiredServiceRef.getService();
				EList<Operation> operations = service.getOperations();
				Map<QualifiedName, EObject> opsMap = Maps.newHashMap();
				for (Operation operation : operations) {
					opsMap.put(QualifiedName.create(operation.getName()), operation);
				}
				MapBasedScope scope = new MapBasedScope(opsMap);
				return scope;
			}
		}
		return super.getScope(context, reference);
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
		
		} else if (reference==ServiceDslPackage.Literals.DATA_OBJECT_REF__TYPE 
				&& ctx instanceof DataObjectRef) {
			final VersionRef v = ((DataObjectRef) ctx).getVersionRef();
			return createVersionFilter (v, objLookup.getVersionedOwner(ctx));
		
			//FIXME verify this ref
		} else if (reference==ServiceDslPackage.Literals.DATA_OBJECT__SUPER_OBJECT 
				&& ctx instanceof DataObjectRef) {
			final VersionRef v = ((DataObjectRef) ctx).getVersionRef();
			return createVersionFilter (v, objLookup.getVersionedOwner(ctx));
		
		} else if (reference == ServiceDslPackage.Literals.ENUM_TYPE_REF__TYPE 
				&& ctx instanceof EnumTypeRef) {
			final VersionRef v = ((EnumTypeRef) ctx).getVersionRef();
			return createVersionFilter (v, objLookup.getVersionedOwner(ctx));
		
		} else if (reference == ServiceDslPackage.Literals.RESOURCE_REF__RESOURCE 
				&& ctx instanceof ResourceRef) {
			final VersionRef v = ((ResourceRef) ctx).getVersionRef();
			return createVersionFilter (v, objLookup.getVersionedOwner(ctx));
		
		} else if (reference == ServiceDslPackage.Literals.SERVICE_REF__SERVICE 
				&& ctx instanceof ServiceRef) {
			final VersionRef v = ((ServiceRef) ctx).getVersionRef();
			return createVersionFilter (v, objLookup.getVersionedOwner(ctx));
		
		} else if (reference == ServiceDslPackage.Literals.EXCEPTION_REF__EXCEPTION 
				&& ctx instanceof ExceptionRef) {
			final VersionRef v = ((ExceptionRef) ctx).getVersionRef();
			return createVersionFilter (v, objLookup.getVersionedOwner(ctx));

		} else if (reference == ServiceDslPackage.Literals.EVENT_REF__EVENT 
				&& ctx instanceof EventRef) {
			final VersionRef v = ((EventRef) ctx).getVersionRef();
			return createVersionFilter(v, objLookup.getVersionedOwner(ctx));
		
		} else if (reference == ServiceDslPackage.Literals.OPERATION_REF__OPERATION && ctx instanceof OperationRef) {
			final VersionRef v = ((OperationRef) ctx).getVersionRef();
			return createEContainerVersionFilter(v, objLookup.getVersionedOwner(ctx));
		
			
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
			AbstractPredicateVersionFilter<IEObjectDescription> f = new NullVersionFilter<IEObjectDescription>();
			if (typeRef instanceof DataObjectRef) 
				f = createEContainerVersionFilter (((DataObjectRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
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
			
			if (typeRef instanceof DataObjectRef) 
				f = createEContainerVersionFilter (((DataObjectRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
			else if (typeRef instanceof EnumTypeRef)
				f = createEContainerVersionFilter (((EnumTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
			if (typeRef instanceof VersionedTypeRef) {
				VersionedTypeRef verTypeRef = (VersionedTypeRef) typeRef;
				attachConsidersPropertyFilter(f, verTypeRef);
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
		} else if (reference == BaseDslPackage.Literals.ASSET_REF__ASSET
				&& ctx instanceof AssetRef) {
			final VersionRef v = ((AssetRef) ctx).getVersionRef();
			return createVersionFilter (v);
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
		
		if (typeRef instanceof DataObjectRef) 
			f = createVersionFilter (((DataObjectRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
		else if (typeRef instanceof EnumTypeRef)
			f = createVersionFilter (((EnumTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
		if (typeRef instanceof VersionedTypeRef) {
			f = createVersionFilter (((VersionedTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
			VersionedTypeRef verTypeRef = (VersionedTypeRef) typeRef;
			attachConsidersPropertyFilter(f, verTypeRef);
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
		
		if (typeRef instanceof DataObjectRef) 
			f = createVersionFilter (((DataObjectRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
		else if (typeRef instanceof EnumTypeRef)
			f = createVersionFilter (((EnumTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
		if (typeRef instanceof VersionedTypeRef) {
			f = createVersionFilter (((VersionedTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
			VersionedTypeRef verTypeRef = (VersionedTypeRef) typeRef;
			attachConsidersPropertyFilter(f, verTypeRef);
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
		if (typeRef instanceof DataObjectRef) {
			versionFilter = createEContainerVersionFilter (((DataObjectRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
			DataObjectRef verTypeRef = (DataObjectRef) typeRef;
			attachConsidersPropertyFilter(versionFilter, verTypeRef);
		} else if (typeRef instanceof EnumTypeRef) {
			versionFilter = createEContainerVersionFilter (((EnumTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
		} else if (typeRef instanceof VersionedTypeRef) {
			versionFilter = createVersionFilter (((VersionedTypeRef)typeRef).getVersionRef(), objLookup.getVersionedOwner(ctx));
			VersionedTypeRef verTypeRef = (VersionedTypeRef) typeRef;
			attachConsidersPropertyFilter(versionFilter, verTypeRef);
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

	private void attachConsidersPropertyFilter(
			AbstractPredicateVersionFilter<IEObjectDescription> f,
			VersionedTypeRef verTypeRef) {
		final List<QualifiedName> verTypeNameList = new ArrayList<QualifiedName>();
		if (verTypeRef.getType() instanceof DataObject) {
			List<DataObject> allSuperTypes = dataObjQueries.getAllSuperTypes ((DataObject)verTypeRef.getType(), new ArrayList<DataObject>());
			for (DataObject dataObj : allSuperTypes) {
				verTypeNameList.add (nameProvider.getFullyQualifiedName (dataObj));
			}
		}
		final QualifiedName verTypeName = nameProvider.getFullyQualifiedName (verTypeRef.getType());	
		verTypeNameList.add (verTypeName);
		f.setPreFilterPredicate(new Predicate<IEObjectDescription> () {

			public boolean apply(IEObjectDescription input) {
				for (QualifiedName name : verTypeNameList) {
					if (input.getQualifiedName() != null && name != null && input.getQualifiedName().startsWith(name))
						return true;
				}
				return false;
			}
			
		});
	}
	
	private void attachConsidersPropertyFilter(
			AbstractPredicateVersionFilter<IEObjectDescription> f,
			DataObjectRef verTypeRef) {
		final List<QualifiedName> verTypeNameList = new ArrayList<QualifiedName>();
		List<DataObject> allSuperTypes = dataObjQueries.getAllSuperTypes (verTypeRef.getType(), new ArrayList<DataObject>());
		for (DataObject dataObj : allSuperTypes) {
			verTypeNameList.add (nameProvider.getFullyQualifiedName (dataObj));
		}
		final QualifiedName verTypeName = nameProvider.getFullyQualifiedName (verTypeRef.getType());	
		verTypeNameList.add (verTypeName);
		f.setPreFilterPredicate(new Predicate<IEObjectDescription> () {

			public boolean apply(IEObjectDescription input) {
				for (QualifiedName name : verTypeNameList) {
					if (input.getQualifiedName() != null && name != null && input.getQualifiedName().startsWith(name))
						return true;
				}
				return false;
			}
			
		});
	}

	@Override
	protected AbstractPredicateVersionFilter<IEObjectDescription> createVersionFilter(final VersionRef v, EObject owner) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = new NullVersionFilter<IEObjectDescription>();
		if (v != null) {
			IScopeVersionResolver verResolver = new SimpleScopeVersionResolver (v.eResource().getResourceSet());
			LifecycleState ownerState = staticStateResolver.getLifecycleState(owner);
			if (v instanceof MajorVersionRef) {
				RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> (verResolver, new Integer(((MajorVersionRef)v).getMajorVersion()).toString(), staticStateResolver, ownerState, v.eResource().getResourceSet());
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
			LifecycleState ownerState = staticStateResolver.getLifecycleState(owner);
			if (v instanceof MajorVersionRef) {
				RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> (verResolver, new Integer(((MajorVersionRef)v).getMajorVersion()).toString(), staticStateResolver, ownerState, v.eResource().getResourceSet());
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof MaxVersionRef) {
				RelaxedMaxVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedMaxVersionForOwnerStateFilter<IEObjectDescription> (verResolver, ((MaxVersionRef)v).getMaxVersion(), staticStateResolver, ownerState, v.eResource().getResourceSet());
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof MinVersionRef) {
				RelaxedLatestMinVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMinVersionForOwnerStateFilter<IEObjectDescription> (verResolver, ((MinVersionRef)v).getMinVersion(), staticStateResolver, ownerState, v.eResource().getResourceSet());
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof LowerBoundRangeVersionRef) {
				RelaxedLatestMinMaxVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMinMaxVersionForOwnerStateFilter<IEObjectDescription> (verResolver, ((LowerBoundRangeVersionRef)v).getMinVersion(), ((LowerBoundRangeVersionRef)v).getMaxVersion(), staticStateResolver, ownerState, v.eResource().getResourceSet());
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof FixedVersionRef)
				return new FixedVersionFilter<IEObjectDescription>(verResolver, ((FixedVersionRef) v).getFixedVersion());
		}
		return filter;
	}

}
