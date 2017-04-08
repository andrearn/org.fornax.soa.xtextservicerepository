package org.xkonnex.repo.dsl.servicedsl.service.validation.version;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.validation.Check;
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch;
import org.xkonnex.repo.dsl.basedsl.version.VersionComparator;
import org.xkonnex.repo.dsl.servicedsl.service.util.TypeRefMatchResult;
import org.xkonnex.repo.dsl.servicedsl.service.util.TypeRefMatcher;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ErrorResponse;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceOperation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage;
import org.xkonnex.repo.dsl.servicedsl.validation.VersionedObjectFeatureConflicts;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class ResourceVersionValidator extends AbstractServiceDslVersionValidator {

	@Inject
	IPredicateSearch lookup;
	@Inject
	IQualifiedNameProvider nameProvider;
	@Inject
	VersionComparator versionComp;
	@Inject
	TypeRefMatcher typeRefMatcher;

	@Check
	public void checkResourceCompatibility(final org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource svc) {
		QualifiedName svcName = nameProvider.getFullyQualifiedName(svc);
		final Resource res = svc.eResource();
		IEObjectDescription nextLesserVersion = getNextLesserVersion(svcName.toString(), svc.getVersion().getVersion(),
				svc.eClass().getName());

		if (nextLesserVersion != null) {
			EObject eObject = nextLesserVersion.getEObjectOrProxy();
			if (eObject.eIsProxy())
				eObject = EcoreUtil2.resolve(eObject, res.getResourceSet());
			if (eObject instanceof Service) {
				org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource otherSvc = (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource) eObject;
				if (otherSvc.getState() == null || !otherSvc.getState().isIsEnd()) {
					for (final ResourceOperation op : otherSvc.getOperations()) {
						boolean lesserVerHasOp = Iterables.any(svc.getOperations(), new Predicate<ResourceOperation>() {

							public boolean apply(ResourceOperation input) {
								return input.getName().equals(op.getName());
							}
						});
						if (!lesserVerHasOp) {
							error("The operation " + op.getName()
									+ " has been removed. This is an incompatible change!",
									ServiceDslPackage.Literals.RESOURCE__NAME);
						}
					}
				}
			}
		}
	}

	@Check
	public void checkOperationCompatibility(final ResourceOperation op) {
		org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource svc = (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource) op.eContainer();
		QualifiedName svcName = nameProvider.getFullyQualifiedName(svc);
		final Resource res = svc.eResource();
		IEObjectDescription nextLesserVersion = getNextLesserVersion(svcName.toString(), svc.getVersion().getVersion(),
				svc.eClass().getName());

		if (nextLesserVersion != null) {
			EObject eObject = nextLesserVersion.getEObjectOrProxy();
			if (eObject.eIsProxy())
				eObject = EcoreUtil2.resolve(eObject, res.getResourceSet());
			if (eObject instanceof org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource) {
				org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource otherSvc = (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource) eObject;
				if (otherSvc.getState() == null || !otherSvc.getState().isIsEnd()) {
					boolean lesserVerHasOp = Iterables.any(otherSvc.getOperations(), new Predicate<ResourceOperation>() {
						public boolean apply(ResourceOperation input) {
							return input.getName().equals(op.getName());
						}
					});
					if (lesserVerHasOp) {
						ResourceOperation lesserVerOp = Iterables.find(otherSvc.getOperations(), new Predicate<ResourceOperation>() {

							public boolean apply(ResourceOperation input) {
								return input.getName().equals(op.getName());
							}
						});
						for (final Parameter param : lesserVerOp.getParameters()) {
							boolean hasParam = Iterables.any(op.getParameters(), new Predicate<Parameter>() {

								public boolean apply(Parameter input) {
									return input.getName().equals(param.getName());
								}
							});
							if (!hasParam) {
								error("The parameter " + param.getName() + " of operation " + op.getName()
										+ " has been removed. This is an incompatible change!",
										ServiceDslPackage.Literals.ABSTRACT_OPERATION__NAME);
							}

						}
						for (final Parameter returnParam : lesserVerOp.getResponse().get(0).getReturn()) {
							boolean hasReturnParam = Iterables.any(op.getResponse().get(0).getReturn(), new Predicate<Parameter>() {

								public boolean apply(Parameter input) {
									return input.getName().equals(returnParam.getName());
								}
							});
							if (!hasReturnParam) {
								error("The return parameter " + returnParam.getName() + " of operation " + op.getName()
										+ " has been removed. This is an incompatible change!",
										ServiceDslPackage.Literals.ABSTRACT_OPERATION__NAME);
							}

						}
						for (final ErrorResponse errorResp : op.getThrows()) {
							ExceptionRef exRef = errorResp.getException();
							boolean hasReturnParam = Iterables.any(lesserVerOp.getThrows(),
									new Predicate<ErrorResponse>() {

										public boolean apply(ErrorResponse input) {
											return input.getException().getException().getName()
													.equals(exRef.getException().getName());
										}
									});
							if (!hasReturnParam) {
								warning("The operation " + op.getName() + " declares a new exception "
										+ exRef.getException().getName()
										+ ". Depending on the consumer this is an incompatible change in most cases!",
										ServiceDslPackage.Literals.ABSTRACT_OPERATION__NAME);
							}
						}
					}
				}
			}
		}
	}

	@Check
	public void checkOperationParameters(final Parameter param) {
		if (param.eContainer() instanceof org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource) {
			final ResourceOperation op = (ResourceOperation) param.eContainer();
			final org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource svc = (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource) op.eContainer();

			QualifiedName opName = nameProvider.getFullyQualifiedName(op.eContainer());
			final Resource res = op.eResource();
			IEObjectDescription nextLesserVersion = getNextLesserVersion(opName.toString(),
					svc.getVersion().getVersion(), svc.eClass().getName());

			if (nextLesserVersion != null) {
				EObject eObject = nextLesserVersion.getEObjectOrProxy();
				if (eObject.eIsProxy())
					eObject = EcoreUtil2.resolve(eObject, res.getResourceSet());
				if (eObject instanceof org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource) {
					org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource otherSvc = (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource) eObject;
					if (otherSvc.getState() == null || !otherSvc.getState().isIsEnd()) {
						boolean lesserHasOp = Iterables.any(otherSvc.getOperations(), new Predicate<ResourceOperation>() {

							public boolean apply(ResourceOperation input) {
								return input.getName().equals(op.getName());
							}
						});

						if (lesserHasOp) {
							ResourceOperation lesserVerOp = Iterables.find(otherSvc.getOperations(),
									new Predicate<ResourceOperation>() {

										public boolean apply(ResourceOperation input) {
											return input.getName().equals(op.getName());
										}
									});
							if (param.eContainingFeature()
									.equals(ServiceDslPackage.Literals.ABSTRACT_OPERATION__PARAMETERS)) {
								EList<Parameter> lesserVerParams = lesserVerOp.getParameters();
								EList<Parameter> currVerParams = op.getParameters();
								checkOpParameters(param, lesserVerParams, currVerParams, false);

							} else if (param.eContainingFeature()
									.equals(ServiceDslPackage.Literals.RESPONSE__RETURN)) {
								EList<Parameter> lesserVerParams = lesserVerOp.getResponse().get(0).getReturn();
								EList<Parameter> currVerParams = op.getResponse().get(0).getReturn();
								checkOpParameters(param, lesserVerParams, currVerParams, true);
							}
						}
					}
				}
			}
		}
	}
	@Check
	public void checkResourceOperationParameters(final Parameter param) {
		if (param.eContainer() instanceof ResourceOperation) {
			final ResourceOperation op = (ResourceOperation) param.eContainer();
			final org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource svc = (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource) op.eContainer();

			QualifiedName opName = nameProvider.getFullyQualifiedName(op.eContainer());
			final Resource res = op.eResource();
			IEObjectDescription nextLesserVersion = getNextLesserVersion(opName.toString(),
					svc.getVersion().getVersion(), svc.eClass().getName());

			if (nextLesserVersion != null) {
				EObject eObject = nextLesserVersion.getEObjectOrProxy();
				if (eObject.eIsProxy())
					eObject = EcoreUtil2.resolve(eObject, res.getResourceSet());
				if (eObject instanceof org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource) {
					org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource otherSvc = (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource) eObject;
					if (otherSvc.getState() == null || !otherSvc.getState().isIsEnd()) {
						boolean lesserHasOp = Iterables.any(otherSvc.getOperations(), new Predicate<ResourceOperation>() {

							public boolean apply(ResourceOperation input) {
								return input.getName().equals(op.getName());
							}
						});

						if (lesserHasOp) {
							ResourceOperation lesserVerOp = Iterables.find(otherSvc.getOperations(),
									new Predicate<ResourceOperation>() {

										public boolean apply(ResourceOperation input) {
											return input.getName().equals(op.getName());
										}
									});
							if (param.eContainingFeature()
									.equals(ServiceDslPackage.Literals.ABSTRACT_OPERATION__PARAMETERS)) {
								EList<Parameter> lesserVerParams = lesserVerOp.getParameters();
								EList<Parameter> currVerParams = op.getParameters();
								checkOpParameters(param, lesserVerParams, currVerParams, false);

							} else if (param.eContainingFeature()
									.equals(ServiceDslPackage.Literals.RESOURCE_OPERATION__RESPONSE)) {
							}
						}
					}
				}
			}
		}
	}

	private void notifyParamVersionConflicts(Parameter param, boolean isReturnParam,
			Set<VersionedObjectFeatureConflicts> conflicts) {
		String opFeatureName = "parameter";
		if (isReturnParam)
			opFeatureName = "return parameter";
		for (VersionedObjectFeatureConflicts conflict : conflicts) {
			if (conflict.equals(VersionedObjectFeatureConflicts.NAME_CONFLICT)) {
				error("The " + opFeatureName + param.getName() + " has a different name than the " + opFeatureName
						+ " in the same position of the previous version of the Service.  This is an incompatible change.",
						ServiceDslPackage.Literals.PARAMETER__NAME);
			} else if (conflict.equals(VersionedObjectFeatureConflicts.OUT_OF_ORDER_FEATURE)) {
				error("The " + opFeatureName + param.getName()
						+ " appears in a different order than in the previous version of the Service. This is an incompatible change.",
						ServiceDslPackage.Literals.PARAMETER__NAME);
			} else if (conflict.equals(VersionedObjectFeatureConflicts.WRONG_MULTIPLICITY)) {
				error("The " + opFeatureName + param.getName() + " has a different multiplicity than the "
						+ opFeatureName + " in the previous version of the Service. This is an incompatible change.",
						ServiceDslPackage.Literals.PARAMETER__NAME);
			} else if (conflict.equals(VersionedObjectFeatureConflicts.WRONG_TYPE)) {
				error("The " + opFeatureName + param.getName() + " has a different type than the " + opFeatureName
						+ " in the previous version of the Service. This is an incompatible change.",
						ServiceDslPackage.Literals.PARAMETER__NAME);
			} else if (conflict.equals(VersionedObjectFeatureConflicts.WRONG_TYPE_VERSION_RANGE)) {
				error("The " + opFeatureName + param.getName()
						+ " has the same type but a version constraint that can not satisfy the version constraint of the "
						+ opFeatureName
						+ "'s  type in the previous version of the Service. This is an incompatible change.",
						ServiceDslPackage.Literals.PARAMETER__NAME);
			} else if (conflict.equals(VersionedObjectFeatureConflicts.NEW_FEATURE)) {
				error("The " + opFeatureName + param.getName() + " is a new " + opFeatureName
						+ ", but does not appear after the properties defined in the previous version. This is an incompatible change.",
						ServiceDslPackage.Literals.PARAMETER__NAME);
			}
		}
	}

	private void checkOpParameters(final Parameter param, EList<Parameter> lesserVerParams,
			EList<Parameter> currVerParams, boolean isReturnParam) {
		int paramIdx = currVerParams.indexOf(param);
		int highestLesserParamIdx = -1;

		Parameter lesserVerParam = null;
		int lesserVerParamIdx = -1;
		for (int i = 0; i < lesserVerParams.size(); i++) {
			Parameter p = lesserVerParams.get(i);
			if (p.getName().equals(param.getName())) {
				lesserVerParam = p;
				lesserVerParamIdx = i;
			}
		}
		highestLesserParamIdx = determineHighestLesserParamIndex(currVerParams, lesserVerParams, highestLesserParamIdx);

		Set<VersionedObjectFeatureConflicts> conflicts = compareParameters(paramIdx, param, currVerParams,
				lesserVerParamIdx, lesserVerParam, lesserVerParams, highestLesserParamIdx);
		notifyParamVersionConflicts(param, isReturnParam, conflicts);
	}

	private Set<VersionedObjectFeatureConflicts> compareParameters(int indexOfCurrParam, final Parameter curParam,
			final List<Parameter> curParams, int lesserVerParamIdx, final Parameter lesserVerParam,
			final List<Parameter> lesserVerParams, int highestLesserParamIdx) {
		Set<VersionedObjectFeatureConflicts> conflicts = new HashSet<VersionedObjectFeatureConflicts>();
		if (lesserVerParam != null) {
			if (indexOfCurrParam != lesserVerParamIdx) {
				conflicts.add(VersionedObjectFeatureConflicts.OUT_OF_ORDER_FEATURE);
			} else {
				TypeRefMatchResult typeRefMatchRes = typeRefMatcher.matches(lesserVerParam.getType(),
						curParam.getType());
				if (typeRefMatchRes == TypeRefMatchResult.NO_MATCH) {
					conflicts.add(VersionedObjectFeatureConflicts.WRONG_TYPE);
				} else if (typeRefMatchRes == TypeRefMatchResult.NO_VERSION_MATCH) {
					conflicts.add(VersionedObjectFeatureConflicts.WRONG_TYPE_VERSION_RANGE);
				}
			}
		} else {
			conflicts.add(VersionedObjectFeatureConflicts.NEW_FEATURE);
		}
		return conflicts;
	}

	private int determineHighestLesserParamIndex(EList<Parameter> opParams, EList<Parameter> lesserOpParams,
			int highestLesserOpKnownParamIdx) {
		for (int i = 0; i < opParams.size(); i++) {
			final Parameter param = opParams.get(i);
			boolean lesserHasParam = Iterables.any(lesserOpParams, new Predicate<Parameter>() {

				public boolean apply(Parameter input) {
					return input.getName().equals(param.getName());
				}
			});
			if (lesserHasParam && i > highestLesserOpKnownParamIdx) {
				highestLesserOpKnownParamIdx = i;
			}
		}
		return highestLesserOpKnownParamIdx;
	}

}
