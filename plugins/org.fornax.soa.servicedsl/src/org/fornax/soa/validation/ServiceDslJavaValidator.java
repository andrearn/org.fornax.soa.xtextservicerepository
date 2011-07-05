package org.fornax.soa.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.fornax.soa.basedsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.basedsl.scoping.versions.ServiceDslLifecycleStateResolver;
import org.fornax.soa.query.BusinessObjectQueryHelper;
import org.fornax.soa.serviceDsl.Attribute;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.GovernanceApproval;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.Reference;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceCategory;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.ServiceRef;
import org.fornax.soa.serviceDsl.VISIBILITY;
import org.fornax.soa.serviceDsl.VersionedTypeRef;
import org.fornax.soa.util.ReferencedStateChecker;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.common.collect.Lists;

@ComposedChecks (validators = {
		org.fornax.soa.validation.GovernanceApprovalValidator.class,
		org.fornax.soa.validation.LifecycleStatefulReferenceValidator.class
		})
public class ServiceDslJavaValidator extends AbstractServiceDslJavaValidator {

	@Inject
	private Injector injector;

	// @Check
	// public void checkTypeNameStartsWithCapital(Type type) {
	// if (!Character.isUpperCase(type.getName().charAt(0))) {
	// warning("Name should start with a capital", MyDslPackage.TYPE__NAME);
	// }
	// }


	public void registerExtensions (EValidatorRegistrar registrar, AbstractDeclarativeValidator validator) {
		List<EPackage> packages = getEPackages();
		for (EPackage ePackage : packages) {
			registrar.register(ePackage, validator);
		}
	}
	
	// Naming
	@Check
	public void checkServiceNameStartsWithCapital(Service s) {
		if (!Character.isUpperCase(s.getName().charAt(0))) {
			warning("Name should start with a capital",
					ServiceDslPackage.Literals.SERVICE__NAME);
		}
	}

	@Check
	public void checkEntityServiceNameEndsWithBES(Service s) {
		if (s.getCategory() == ServiceCategory.ENTITY
				&& !s.getName().endsWith("BES")) {
			warning("The name of an entity service should end with BES",
					ServiceDslPackage.Literals.SERVICE__NAME);
		}
	}

	@Check
	public void checkActivityServiceNameEndsWithBAS(Service s) {
		if (s.getCategory() == ServiceCategory.ACTIVITY
				&& !s.getName().endsWith("BAS")) {
			warning("The name of an activity service should end with BAS",
					ServiceDslPackage.Literals.SERVICE__NAME);
		}
	}

	@Check
	public void checkProcessServiceNameEndsWithBPS(Service s) {
		if (s.getCategory() == ServiceCategory.PROCESS
				&& !s.getName().endsWith("BPS")) {
			warning("The name of a process service should end with BPS",
					ServiceDslPackage.Literals.SERVICE__NAME);
		}
	}

	@Check
	public void checkUtilityServiceNameEndsWithUS(Service s) {
		if (s.getCategory() == ServiceCategory.UTILITY
				&& !s.getName().endsWith("US")
				&& !(s.eContainer() instanceof InternalNamespace || s
						.getVisibility() == VISIBILITY.PRIVATE)) {
			warning("The name of a utility service should end with US",
					ServiceDslPackage.Literals.SERVICE__NAME);
		}
	}

	@Check
	public void checkRuleServiceNameEndsWithBRS(Service s) {
		if (s.getCategory() == ServiceCategory.RULE
				&& !s.getName().endsWith("BRS")) {
			warning("The name of a rule service should end with BRS",
					ServiceDslPackage.Literals.SERVICE__NAME);
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
	public void checkWeakRefHasBusinessKey (final BusinessObjectRef b) {
		if (b.eContainer() instanceof Reference) {
			List<Property> props = new ArrayList<Property>();
			props.addAll (b.getType().getProperties());
			props.addAll (BusinessObjectQueryHelper.getAllInheritedProperties (b.getType()));
			
			Iterable<Property> keys = Iterables.filter(props, new Predicate<Property> () {
	
				public boolean apply(final Property input) {
					return input.isIsBusinessKey();
				}
				
			});
			if (Lists.newArrayList(keys).isEmpty())
				error ("The target businessObject of the weak-ref defines no business-key. " +
						"The business-key is required to represent and resolve the reference. " +
						"Remove the weak-ref qualifier or define a single business-key in the target businessObject", ServiceDslPackage.Literals.BUSINESS_OBJECT_REF__TYPE );
		}
	}
	
	@Check
	public void checkWeakRefHasBusinessKey (final VersionedTypeRef b) {
		if (b.eContainer() instanceof Reference && b.getType() instanceof BusinessObject) {
			List<Property> props = new ArrayList<Property>();
			props.addAll (((BusinessObject)b.getType()).getProperties());
			props.addAll (BusinessObjectQueryHelper.getAllInheritedProperties ((BusinessObject) b.getType()));

			Iterable<Property> keys = Iterables.filter (props, new Predicate<Property> () {
	
				public boolean apply(final Property input) {
					return input.isIsBusinessKey();
				}
				
			});
			if (Lists.newArrayList(keys).isEmpty())
				error ("The target businessObject of the weak-ref defines no business-key. " +
						"The business-key is required to represent and resolve the reference. " +
						"Remove the weak-ref qualifier or define a single business-key in the target businessObject", ServiceDslPackage.Literals.VERSIONED_TYPE_REF__TYPE );
		}
	}
	
	@Check
	public void checkWeakRefTargetDefinesOnlyOneBusinessKey (final BusinessObjectRef b) {
		if (b.eContainer() instanceof Reference) {
			Iterable<Property> keys = Iterables.filter(b.getType().getProperties(), new Predicate<Property> () {
	
				public boolean apply(final Property input) {
					// TODO Auto-generated method stub
					return input.isIsBusinessKey();
				}
				
			});
			if (Lists.newArrayList(keys).size() > 1)
				error ("The target businessObject of the weak-ref defines more than one business-key. " +
						"The business-key is required to represent and resolve the reference. " +
						"Remove the weak-ref qualifier or define a single business-key in the target businessObject", ServiceDslPackage.Literals.BUSINESS_OBJECT_REF__TYPE );

		}
	}
	
	@Check
	public void checkWeakRefTargetDefinesOnlyOneBusinessKey (final VersionedTypeRef b) {
		if (b.eContainer() instanceof Reference && b.getType() instanceof BusinessObject) {
			Iterable<Property> keys = Iterables.filter(((BusinessObject)b.getType()).getProperties(), new Predicate<Property> () {
	
				public boolean apply(final Property input) {
					// TODO Auto-generated method stub
					return input.isIsBusinessKey();
				}
				
			});
			if (Lists.newArrayList(keys).size() > 1)
				error ("The target businessObject of the weak-ref defines more than one business-key. " +
						"The business-key is required to represent and resolve the reference. " +
						"Remove the weak-ref qualifier or define a single business-key in the target businessObject", ServiceDslPackage.Literals.VERSIONED_TYPE_REF__TYPE );

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

	private ReferencedStateChecker createStateChecker (EObject owner) {
		LifecycleStateResolver stateResolver = new ServiceDslLifecycleStateResolver (owner.eResource().getResourceSet());
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
