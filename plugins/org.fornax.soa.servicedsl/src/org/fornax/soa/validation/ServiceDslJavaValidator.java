package org.fornax.soa.validation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.fornax.soa.basedsl.ref.DependencyDescription;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.basedsl.validation.NameAndVersionAreUniqueValidator;
import org.fornax.soa.basedsl.validation.PluggableChecks;
import org.fornax.soa.profiledsl.sOAProfileDsl.ServiceBaseCategory;
import org.fornax.soa.profiledsl.util.ReferencedStateChecker;
import org.fornax.soa.service.query.type.DataObjectQueries;
import org.fornax.soa.service.validation.version.BusinessObjectVersionValidator;
import org.fornax.soa.service.validation.version.EnumerationVersionValidator;
import org.fornax.soa.service.validation.version.ExceptionVersionValidator;
import org.fornax.soa.service.validation.version.ServiceVersionValidator;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.DataObject;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.EnumLiteral;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.GovernanceApproval;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Parameter;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.QueryObject;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.ServiceRef;
import org.fornax.soa.serviceDsl.SimpleAttribute;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;
import org.fornax.soa.serviceDsl.Visibility;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

@PluggableChecks (validators = {
		GovernanceApprovalValidator.class,
		LifecycleStatefulReferenceValidator.class,
		ServiceVersionValidator.class,
		BusinessObjectVersionValidator.class,
		EnumerationVersionValidator.class,
		ExceptionVersionValidator.class,
		ServiceUsageValidator.class,
		NameAndVersionAreUniqueValidator.class
		})
public class ServiceDslJavaValidator extends AbstractServiceDslJavaValidator {
	
	@Inject
	IQualifiedNameProvider nameProvider;
	
	@Inject
	private	DataObjectQueries dataObjQuery;
	
	@Inject
	IPredicateSearch predicateSearch;
	
	@Inject
	IResourceDescriptions resourceDescriptions;

	@Inject ReferencedStateChecker referencedStateChecker;
	
	@Check
	public void checkNoPropertyOverrides(Property prop) {
		if (prop.eContainer() instanceof DataObject) {
			DataObject dataObject = (DataObject) prop.eContainer();
			if (dataObject.getSuperObject() != null
					&& dataObject.getSuperObject().getType() != null) {
				final String propName = prop.getName();
				for (DataObject superType : dataObjQuery
						.getAllSuperTypes(dataObject, null)) {
					
					Iterable<Property> props = Iterables.filter (
							superType.getProperties(),
							new Predicate<Property>() {

								public boolean apply (Property curProp) {
									return curProp.getName().equals(propName);
								}

							});
					
					List<Property> opList = Lists.newArrayList(props);
					if (opList.size() > 0) {
						StringBuilder errMsg = new StringBuilder("Property ");
						errMsg.append (propName)
								.append (" overrides an inherited property from ")
								.append (superType.getName())
								.append (" version ")
								.append (dataObject.getVersion().getVersion());
						error (errMsg.toString(),
								ServiceDslPackage.Literals.PROPERTY__NAME);
					}
				}
			}
		}
	}

	@Check
	public void checkUniqueOperationNames(Operation op) {
		Service svc = (Service) op.eContainer();
		final String opName = op.getName();
		
		Iterable<Operation> ops = Iterables.filter(svc.getOperations(),
				new Predicate<Operation>() {

					public boolean apply(Operation curOp) {
						return curOp.getName().equals(opName);
					}

				});
		
		List<Operation> opList = Lists.newArrayList(ops);
		if (opList.size() > 1) {
			StringBuilder errMsg = new StringBuilder ("Duplicate operation ");
			errMsg.append (opName).append(" in service ").append (svc.getName())
					.append (" version ").append (svc.getVersion().getVersion());
			error (errMsg.toString(), ServiceDslPackage.Literals.OPERATION__NAME);
		}
	}

	@Check
	public void checkUniquePropertyNames(Property prop) {
		if (prop.eContainer() instanceof BusinessObject) {
			BusinessObject bo = (BusinessObject) prop.eContainer();
			final String propName = prop.getName();
			
			Iterable<Property> props = Iterables.filter(bo.getProperties(),
					new Predicate<Property>() {

						public boolean apply (Property curProp) {
							return curProp.getName().equals(propName);
						}

					});
			
			List<Property> opList = Lists.newArrayList(props);
			if (opList.size() > 1) {
				StringBuilder errMsg = new StringBuilder("Duplicate property ");
				errMsg.append (propName).append (" in business object ")
						.append (bo.getName()).append(" version ")
						.append (bo.getVersion().getVersion());
				error (errMsg.toString(),
						ServiceDslPackage.Literals.PROPERTY__NAME);
			}
		}
	}

	@Check
	public void checkUniqueEnumLiteral(EnumLiteral enumLit) {
		if (enumLit.eContainer() instanceof Enumeration) {
			Enumeration en = (Enumeration) enumLit.eContainer();
			final String enumLitName = enumLit.getName();
			
			Iterable<EnumLiteral> enumLiterals = Iterables.filter (
					en.getLiterals(), new Predicate<EnumLiteral>() {

						public boolean apply(EnumLiteral curEnum) {
							return curEnum.getName().equals(enumLitName);
						}

					});
			
			List<EnumLiteral> opList = Lists.newArrayList (enumLiterals);
			if (opList.size() > 1) {
				StringBuilder errMsg = new StringBuilder(
						"Duplicate enum literal ");
				errMsg.append (enumLitName).append(" in enumeration ")
						.append (en.getName()).append(" version ")
						.append (en.getVersion().getVersion());
				error  (errMsg.toString(),
						ServiceDslPackage.Literals.ENUM_LITERAL__NAME);
			}
		}

	}

	@Check
	public void checkUniqueSimpleAttributeNames(SimpleAttribute prop) {
		if (prop.eContainer() instanceof org.fornax.soa.serviceDsl.Exception) {
			org.fornax.soa.serviceDsl.Exception exc = (org.fornax.soa.serviceDsl.Exception) prop
					.eContainer();
			final String propName = prop.getName();
			
			Iterable<SimpleAttribute> props = Iterables.filter(
					exc.getProperties(), new Predicate<SimpleAttribute>() {

						public boolean apply(SimpleAttribute curProp) {
							return curProp.getName().equals(propName);
						}

					});
			
			List<SimpleAttribute> opList = Lists.newArrayList(props);
			if (opList.size() > 1) {
				StringBuilder errMsg = new StringBuilder("Duplicate attribute ");
				errMsg.append(propName).append(" in exception ")
						.append(exc.getName()).append(" version ")
						.append(exc.getVersion().getVersion());
				error(errMsg.toString(),
						ServiceDslPackage.Literals.SIMPLE_ATTRIBUTE__NAME);
			}
		}
	}

	@Check
	public void checkUniqueParamName(Parameter param) {
		Operation op = (Operation) param.eContainer();
		if (param.eContainingFeature().getName().equals("parameters")) {
			final String paramName = param.getName();
			Iterable<Parameter> params = Iterables.filter(op.getParameters(),
					new Predicate<Parameter>() {

						public boolean apply(Parameter curParam) {
							return curParam.getName().equals(paramName);
						}

					});
			List<Parameter> paramList = Lists.newArrayList(params);
			if (paramList.size() > 1) {
				StringBuilder errMsg = new StringBuilder("Duplicate parameter ");
				errMsg.append(paramName).append(" in operation ")
						.append(op.getName());
				error(errMsg.toString(),
						ServiceDslPackage.Literals.PARAMETER__NAME);
			}

		} else if (param.eContainingFeature().getName().equals("return")) {
			final String paramName = param.getName();
			Iterable<Parameter> params = Iterables.filter(op.getReturn(),
					new Predicate<Parameter>() {

						public boolean apply(Parameter curParam) {
							return curParam.getName().equals(paramName);
						}

					});
			List<Parameter> paramList = Lists.newArrayList(params);
			if (paramList.size() > 1) {
				StringBuilder errMsg = new StringBuilder(
						"Duplicate return parameter ");
				errMsg.append(paramName).append(" in operation ")
						.append(op.getName());
				error(errMsg.toString(),
						ServiceDslPackage.Literals.PARAMETER__NAME);
			}

		}
	}

	// Call semantics
	@Check(CheckType.NORMAL)
	public void checkEntityServicesDontCallProcessServices(ServiceRef svcRef) {
		EObject o = svcRef.eContainer().eContainer();
		if (o instanceof Service) {
			Service s = (Service) svcRef.eContainer().eContainer();
			if (s.getCategory() != null && s.getCategory().getBaseCategory () == ServiceBaseCategory.ENTITY) {
				if (svcRef.getService().getCategory().getBaseCategory () == ServiceBaseCategory.PROCESS) {
					error("Business entity services may not call business process services",
							ServiceDslPackage.Literals.OPERATION__REQUIRES);
				}
			}
		}
	}

	@Check(CheckType.NORMAL)
	public void checkEntityServicesDontCallActivityServices(ServiceRef svcRef) {
		EObject o = svcRef.eContainer().eContainer();
		if (o instanceof Service) {
			Service s = (Service) o;
			if (s.getCategory() != null && s.getCategory().getBaseCategory () == ServiceBaseCategory.ACTIVITY) {
				if (svcRef.getService().getCategory()!= null && svcRef.getService().getCategory().getBaseCategory () == ServiceBaseCategory.PROCESS) {
					error("Business entity services may not call business activity services",
							ServiceDslPackage.Literals.OPERATION__REQUIRES);
				}
			}
		}
	}

	@Check(CheckType.NORMAL)
	public void checkEntityServicesDontCallRuleServices(ServiceRef svcRef) {
		EObject o = svcRef.eContainer().eContainer();
		if (o instanceof Service) {
			Service s = (Service) svcRef.eContainer().eContainer();
			if (s.getCategory() != null && s.getCategory().getBaseCategory () == ServiceBaseCategory.ACTIVITY) {
				if (svcRef.getService().getCategory()!= null && svcRef.getService().getCategory().getBaseCategory () == ServiceBaseCategory.PROCESS) {
					error("Business entity services may not call business rule services",
							ServiceDslPackage.Literals.OPERATION__REQUIRES);
				}
			}
		}
	}

	@Check
	public void checkProvidedContractOnPrivateServiceOnly(Service s) {
		if (s.getProvidedContractUrl() != null
				&& s.getVisibility() != Visibility.PRIVATE)
			error("Only private services may provide a predefined contract such as a WSDL",
					ServiceDslPackage.Literals.SERVICE__PROVIDED_CONTRACT_URL);
	}

	@Check
	public void checkProvidedDefOnInternalBOOnly(VersionedType o) {
		if (o.getProvidedContractUrl() != null
				&& o.eContainer() instanceof DomainNamespace)
			error("Only internal " + getObjectTypeName(o) + "s may provide a predefined definition such as an XSD",
					ServiceDslPackage.Literals.VERSIONED_TYPE__PROVIDED_CONTRACT_URL);
	}

	@Check
	public void checkProvidedDefOnInternalEnumOnly(Enumeration o) {
		if (o.getProvidedContractUrl() != null
				&& o.eContainer() instanceof DomainNamespace)
			error("Only internal " + getObjectTypeName(o) + "s may provide a predefined definition such as an XSD",
					ServiceDslPackage.Literals.VERSIONED_TYPE__PROVIDED_CONTRACT_URL);
	}

	@Check
	public void checkProvidedDefOnInternalEnumOnly(
			org.fornax.soa.serviceDsl.Exception o) {
		if (o.getProvidedContractUrl() != null
				&& o.eContainer() instanceof DomainNamespace)
			error("Only internal exceptions may provide a predefined definition such as an XSD or WSDL",
					ServiceDslPackage.Literals.VERSIONED_TYPE__PROVIDED_CONTRACT_URL);
	}

	// Consistency
	@Check
	public void checkBusinessKeyIsMandatory(Property p) {
		if (p.isIsBusinessKey() && p.isOptional())
			error("A business-key attribute may not be optional.",
					ServiceDslPackage.Literals.PROPERTY__IS_BUSINESS_KEY);
	}


	@Check
	public void checkNoDirectNamespaceCycle(Property p) {
		if (p.getType() instanceof VersionedTypeRef) {
			final EObject ownNs = p.eContainer().eContainer();
			VersionedType refType = ((VersionedTypeRef) p.getType()).getType();
			EList<Type> refNsTypes = ((SubNamespace) refType.eContainer())
					.getTypes();
			for (Type refNsType : refNsTypes) {
				if (!refNsType.equals (p.eContainer())) {
					if (refNsType instanceof BusinessObject && !ownNs.equals(refNsType.eContainer())) {
						BusinessObject refNsBO = (BusinessObject) refNsType;
						for (Property refNsProp : refNsBO.getProperties()) {
							TypeRef refNsPropType = refNsProp.getType();
							if (refNsPropType instanceof VersionedTypeRef) {
								VersionedType refNsPropVerType = ((VersionedTypeRef) refNsPropType).getType();
								if (ownNs.equals(refNsPropVerType.eContainer())) {
									warning("The property references a type from another namespace that references a type from this namespace leading to a dependency cycle",
											ServiceDslPackage.Literals.PROPERTY__TYPE);
									return;
								}
							}
						}
					}
				}
			}
		}
	}
	
	@Check (CheckType.NORMAL)
	public void checkNoTransitiveNamespaceCycle(final Property p) {
		if (p.getType() instanceof VersionedTypeRef) {
			VersionedType targetType = ((VersionedTypeRef) p.getType()).getType();
			if (!targetType.eContainer().equals (p.eContainer().eContainer())) {
				DependencyDescription transDepsRoot = dataObjQuery.getTransitiveDependencies (p, true, true, null, null);
				boolean hasTransitImport = false;
				boolean rootVisited = false;
				
				List<String> foundPaths = new ArrayList<String>();
				for (DependencyDescription dep : transDepsRoot) {
					if (rootVisited) {
						VersionedType verType = dataObjQuery.toVersionedType (dep.getTarget(), p.eResource());
						if (verType != null) {
							if (!nameProvider.getFullyQualifiedName (p.eContainer().eContainer()).equals (dep.getContainer().getName())) {
								hasTransitImport = true;
							}
							List<QualifiedName> otherTypeNsRefersToNs = dataObjQuery.getOtherTypeNsRefsToNs (verType, (SubNamespace)p.eContainer().eContainer());	
							if (hasTransitImport && !otherTypeNsRefersToNs.isEmpty()) {
								StringBuilder msg = new StringBuilder();
								String path = getReferrerDependencyPath (dep, new StringBuilder());
								if (!foundPaths.contains (path)) {
									foundPaths.add (path);
									msg.append ("The property " + p.getName() + " references a type from another namespace that leads to an import cycle via:\n");
									msg.append (path);
									if (otherTypeNsRefersToNs != null && !otherTypeNsRefersToNs.isEmpty()) {
										msg.append ("\n for the following business object properties in namespace ");
										msg.append (dep.getContainer().getName().toString());
										msg.append (":\n");
										Iterator<QualifiedName> otherTypeNsRefersToNsIt = otherTypeNsRefersToNs.iterator();
										while (otherTypeNsRefersToNsIt.hasNext()) {
											QualifiedName name = otherTypeNsRefersToNsIt.next();
											msg.append (getPropertyShortName(name));
											if (otherTypeNsRefersToNsIt.hasNext()) {
												msg.append(", ");
											}
										}
									}
									warning (msg.toString(), ServiceDslPackage.Literals.PROPERTY__TYPE);
								}
							}
						}
					} else {
						rootVisited = true;
					}
				}
			}
		}
	}
	
	@Check 
	void checkPropertyLessBOisAbstractOrProposal (BusinessObject bo) {
//		if (BusinessObjectQuery.getAllVisibleProperties(bo).isEmpty())
//			if (bo.getState() == LifecycleState.PROPOSED && !bo.isAbstract())
//				warning ("The businessObject " + bo.getName() + " version " + bo.getVersion().getVersion() + " has no own or inherited properties! As the businessObject is treaded as an proposal this is toleraed. However, it must have properties after leaving the proposal state or must be declared abstract!", ServiceDslPackage.Literals.VERSIONED_TYPE__NAME);
//			else if (!bo.isAbstract())
//				error ("The businessObject " + bo.getName() + " version " + bo.getVersion().getVersion() + " has no own or inherited properties! The businessObject must be declared abstract!", ServiceDslPackage.Literals.VERSIONED_TYPE__NAME);
	}



	private String getObjectTypeName (EObject o) {
		if (o instanceof BusinessObject)
			return "businessObject";
		else if (o instanceof QueryObject)
			return "queryObject";
		else if (o instanceof Enumeration)
			return "enum";
		else if (o instanceof org.fornax.soa.serviceDsl.Exception)
			return "exception";
		else if (o instanceof Service)
			return "service";
		else
			return "";
	}
	
	private String getContainingObjectTypeName (EObject ele) {
		EObject o = ele.eContainer();
		if (o instanceof BusinessObject)
			return "businessObject";
		else if (o instanceof QueryObject)
			return "queryObject";
		else if (o instanceof Enumeration)
			return "enum";
		else if (o instanceof org.fornax.soa.serviceDsl.Exception)
			return "exception";
		else if (o instanceof Service)
			return "service";
		else
			return "";
	}

	private String getPubCanocicalName(GovernanceApproval g) {
		return "canonical";
	}
	
	private String getReferrerDependencyPath (DependencyDescription leaf, StringBuilder path) {
		if (path == null)
			path = new StringBuilder();
		if (path.length() > 0) {
			path.insert(0, " -> ");
		}
		path.insert(0, leaf.getTarget().getName().getLastSegment());
		if (leaf.getReferrer() != null) {
			getReferrerDependencyPath(leaf.getReferrer(), path);
		}
		return path.toString();
	}
	
	private String getPropertyShortName (QualifiedName propName) {
		StringBuilder shortName = new StringBuilder();
		if (propName.getSegmentCount() > 2) {
			for (int i = 0; i < propName.getSegmentCount(); i++) {
				if (i > propName.getSegmentCount()-3) {
					shortName.append(propName.getSegment(i));
					if (i < propName.getSegmentCount()-1)
						shortName.append(".");
				}
			}
			return shortName.toString();
		}
		return propName.toString();
	}

	public DataObjectQueries getDataObjectQuery() {
		return dataObjQuery;
	}

	public void setQoQuery(DataObjectQueries dataObjectQuery) {
		this.dataObjQuery = dataObjectQuery;
	}

}
