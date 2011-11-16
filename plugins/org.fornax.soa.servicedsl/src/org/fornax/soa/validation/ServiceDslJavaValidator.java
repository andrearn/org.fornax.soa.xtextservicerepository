package org.fornax.soa.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.fornax.soa.basedsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.basedsl.scoping.versions.ServiceDslLifecycleStateResolver;
import org.fornax.soa.basedsl.validation.PluggableChecks;
import org.fornax.soa.query.BusinessObjectQuery;
import org.fornax.soa.serviceDsl.Attribute;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.EnumLiteral;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.GovernanceApproval;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Parameter;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.Reference;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceCategory;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.ServiceRef;
import org.fornax.soa.serviceDsl.SimpleAttribute;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VISIBILITY;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;
import org.fornax.soa.util.ReferencedStateChecker;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@PluggableChecks(validators = {
		org.fornax.soa.validation.GovernanceApprovalValidator.class,
		org.fornax.soa.validation.LifecycleStatefulReferenceValidator.class })
public class ServiceDslJavaValidator extends AbstractServiceDslJavaValidator {

	@Check
	public void checkNoPropertyOverrides(Property prop) {
		if (prop.eContainer() instanceof BusinessObject) {
			BusinessObject bo = (BusinessObject) prop.eContainer();
			if (bo.getSuperBusinessObject() != null
					&& bo.getSuperBusinessObject().getType() != null) {
				final String propName = prop.getName();
				for (BusinessObject superType : BusinessObjectQuery
						.getAllSuperTypes(bo, null)) {
					Iterable<Property> props = Iterables.filter(
							superType.getProperties(),
							new Predicate<Property>() {

								public boolean apply(Property curProp) {
									return curProp.getName().equals(propName);
								}

							});
					List<Property> opList = Lists.newArrayList(props);
					if (opList.size() > 0) {
						StringBuilder errMsg = new StringBuilder("Property ");
						errMsg.append(propName)
								.append(" overrides an inherited property from ")
								.append(superType.getName())
								.append(" version ")
								.append(bo.getVersion().getVersion());
						error(errMsg.toString(),
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
			StringBuilder errMsg = new StringBuilder("Duplicate operation ");
			errMsg.append(opName).append(" in service ").append(svc.getName())
					.append(" version ").append(svc.getVersion().getVersion());
			error(errMsg.toString(), ServiceDslPackage.Literals.OPERATION__NAME);
		}
	}

	@Check
	public void checkUniquePropertyNames(Property prop) {
		if (prop.eContainer() instanceof BusinessObject) {
			BusinessObject bo = (BusinessObject) prop.eContainer();
			final String propName = prop.getName();
			Iterable<Property> props = Iterables.filter(bo.getProperties(),
					new Predicate<Property>() {

						public boolean apply(Property curProp) {
							return curProp.getName().equals(propName);
						}

					});
			List<Property> opList = Lists.newArrayList(props);
			if (opList.size() > 1) {
				StringBuilder errMsg = new StringBuilder("Duplicate property ");
				errMsg.append(propName).append(" in business object ")
						.append(bo.getName()).append(" version ")
						.append(bo.getVersion().getVersion());
				error(errMsg.toString(),
						ServiceDslPackage.Literals.PROPERTY__NAME);
			}
		}
	}

	@Check
	public void checkUniqueEnumLiteral(EnumLiteral enumLit) {
		if (enumLit.eContainer() instanceof Enumeration) {
			Enumeration en = (Enumeration) enumLit.eContainer();
			final String enumLitName = enumLit.getName();
			Iterable<EnumLiteral> enumLiterals = Iterables.filter(
					en.getLiterals(), new Predicate<EnumLiteral>() {

						public boolean apply(EnumLiteral curEnum) {
							return curEnum.getName().equals(enumLitName);
						}

					});
			List<EnumLiteral> opList = Lists.newArrayList(enumLiterals);
			if (opList.size() > 1) {
				StringBuilder errMsg = new StringBuilder(
						"Duplicate enum literal ");
				errMsg.append(enumLitName).append(" in enumeration ")
						.append(en.getName()).append(" version ")
						.append(en.getVersion().getVersion());
				error(errMsg.toString(),
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
			if (s.getCategory() == ServiceCategory.ENTITY) {
				if (svcRef.getService().getCategory() == ServiceCategory.PROCESS) {
					error("Business entity services may not call business process services",
							ServiceDslPackage.Literals.OPERATION__REQUIRES);
				}
			}
		}
	}

	@Check
	public void checkWeakRefHasBusinessKey(final BusinessObjectRef b) {
		if (b.eContainer() instanceof Reference) {
			List<Property> props = new ArrayList<Property>();
			props.addAll(b.getType().getProperties());
			props.addAll(BusinessObjectQuery.getAllInheritedProperties(b
					.getType()));

			Iterable<Property> keys = Iterables.filter(props,
					new Predicate<Property>() {

						public boolean apply(final Property input) {
							return input.isIsBusinessKey();
						}

					});
			if (Lists.newArrayList(keys).isEmpty())
				error("The target businessObject of the weak-ref defines no business-key. "
						+ "The business-key is required to represent and resolve the reference. "
						+ "Remove the weak-ref qualifier or define a single business-key in the target businessObject",
						ServiceDslPackage.Literals.BUSINESS_OBJECT_REF__TYPE);
		}
	}

	@Check
	public void checkWeakRefHasBusinessKey(final VersionedTypeRef b) {
		if (b.eContainer() instanceof Reference
				&& b.getType() instanceof BusinessObject) {
			List<Property> props = new ArrayList<Property>();
			props.addAll(((BusinessObject) b.getType()).getProperties());
			props.addAll(BusinessObjectQuery
					.getAllInheritedProperties((BusinessObject) b.getType()));

			Iterable<Property> keys = Iterables.filter(props,
					new Predicate<Property>() {

						public boolean apply(final Property input) {
							return input.isIsBusinessKey();
						}

					});
			if (Lists.newArrayList(keys).isEmpty())
				error("The target businessObject of the weak-ref defines no business-key. "
						+ "The business-key is required to represent and resolve the reference. "
						+ "Remove the weak-ref qualifier or define a single business-key in the target businessObject",
						ServiceDslPackage.Literals.VERSIONED_TYPE_REF__TYPE);
		}
	}

	@Check
	public void checkWeakRefTargetDefinesOnlyOneBusinessKey(
			final BusinessObjectRef b) {
		if (b.eContainer() instanceof Reference) {
			Iterable<Property> keys = Iterables.filter(b.getType()
					.getProperties(), new Predicate<Property>() {

				public boolean apply(final Property input) {
					// TODO Auto-generated method stub
					return input.isIsBusinessKey();
				}

			});
			if (Lists.newArrayList(keys).size() > 1)
				error("The target businessObject of the weak-ref defines more than one business-key. "
						+ "The business-key is required to represent and resolve the reference. "
						+ "Remove the weak-ref qualifier or define a single business-key in the target businessObject",
						ServiceDslPackage.Literals.BUSINESS_OBJECT_REF__TYPE);

		}
	}

	@Check
	public void checkWeakRefTargetDefinesOnlyOneBusinessKey(
			final VersionedTypeRef b) {
		if (b.eContainer() instanceof Reference
				&& b.getType() instanceof BusinessObject) {
			Iterable<Property> keys = Iterables.filter(
					((BusinessObject) b.getType()).getProperties(),
					new Predicate<Property>() {

						public boolean apply(final Property input) {
							// TODO Auto-generated method stub
							return input.isIsBusinessKey();
						}

					});
			if (Lists.newArrayList(keys).size() > 1)
				error("The target businessObject of the weak-ref defines more than one business-key. "
						+ "The business-key is required to represent and resolve the reference. "
						+ "Remove the weak-ref qualifier or define a single business-key in the target businessObject",
						ServiceDslPackage.Literals.VERSIONED_TYPE_REF__TYPE);

		}
	}

	@Check(CheckType.NORMAL)
	public void checkEntityServicesDontCallActivityServices(ServiceRef svcRef) {
		EObject o = svcRef.eContainer().eContainer();
		if (o instanceof Service) {
			Service s = (Service) o;
			if (s.getCategory() == ServiceCategory.ACTIVITY) {
				if (svcRef.getService().getCategory() == ServiceCategory.PROCESS) {
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
			if (s.getCategory() == ServiceCategory.ACTIVITY) {
				if (svcRef.getService().getCategory() == ServiceCategory.PROCESS) {
					error("Business entity services may not call business rule services",
							ServiceDslPackage.Literals.OPERATION__REQUIRES);
				}
			}
		}
	}

	@Check
	public void checkProvidedContractOnPrivateServiceOnly(Service s) {
		if (s.getProvidedContractUrl() != null
				&& s.getVisibility() != VISIBILITY.PRIVATE)
			error("Only private services may provide a predefined contract such as a WSDL",
					ServiceDslPackage.Literals.SERVICE__PROVIDED_CONTRACT_URL);
	}

	@Check
	public void checkProvidedDefOnInternalBOOnly(BusinessObject o) {
		if (o.getProvidedDefinitionUrl() != null
				&& o.eContainer() instanceof DomainNamespace)
			error("Only internal businessObjects may provide a predefined definition such as an XSD",
					ServiceDslPackage.Literals.VERSIONED_TYPE__PROVIDED_DEFINITION_URL);
	}

	@Check
	public void checkProvidedDefOnInternalEnumOnly(Enumeration o) {
		if (o.getProvidedDefinitionUrl() != null
				&& o.eContainer() instanceof DomainNamespace)
			error("Only internal enums may provide a predefined definition such as an XSD",
					ServiceDslPackage.Literals.VERSIONED_TYPE__PROVIDED_DEFINITION_URL);
	}

	@Check
	public void checkProvidedDefOnInternalEnumOnly(
			org.fornax.soa.serviceDsl.Exception o) {
		if (o.getProvidedDefinitionUrl() != null
				&& o.eContainer() instanceof DomainNamespace)
			error("Only internal exceptions may provide a predefined definition such as an XSD or WSDL",
					ServiceDslPackage.Literals.VERSIONED_TYPE__PROVIDED_DEFINITION_URL);
	}

	// Consistency
	@Check
	public void checkBusinessKeyIsMandatory(Attribute p) {
		if (p.isIsBusinessKey() && p.isOptional())
			error("A business-key attribute may not be optional.",
					ServiceDslPackage.Literals.PROPERTY__IS_BUSINESS_KEY);
	}

	@Check
	public void checkBusinessKeyIsMandatory(Reference p) {
		if (p.isIsBusinessKey() && p.isOptional())
			error("A business-key weak-ref attribute may not be optional.",
					ServiceDslPackage.Literals.PROPERTY__IS_BUSINESS_KEY);
	}

	@Check(CheckType.NORMAL)
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

	private ReferencedStateChecker createStateChecker(EObject owner) {
		LifecycleStateResolver stateResolver = new ServiceDslLifecycleStateResolver(
				owner.eResource().getResourceSet());
		return new ReferencedStateChecker(owner, stateResolver);
	}

	private String getObjectTypeName(EObject o) {
		if (o instanceof BusinessObject)
			return "businessObject";
		else if (o instanceof Enumeration)
			return "enum";
		else if (o instanceof org.fornax.soa.serviceDsl.Exception)
			return "exception";
		else if (o instanceof Service)
			return "service";
		else
			return "";
	}

	private String getContainingObjectTypeName(EObject ele) {
		EObject o = ele.eContainer();
		if (o instanceof BusinessObject)
			return "businessObject";
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
		EObject o = g.eContainer();
		if (o instanceof Service)
			return "public";
		else
			return "canonical";
	}

}
