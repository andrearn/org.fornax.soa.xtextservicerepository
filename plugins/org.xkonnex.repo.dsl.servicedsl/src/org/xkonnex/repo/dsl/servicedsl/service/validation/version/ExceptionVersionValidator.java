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
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SimpleAttribute;
import org.xkonnex.repo.dsl.servicedsl.validation.VersionedObjectFeatureConflicts;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class ExceptionVersionValidator extends AbstractServiceDslVersionValidator {
	
	@Inject IPredicateSearch lookup;
	@Inject IQualifiedNameProvider nameProvider;
	@Inject VersionComparator versionComp;
	@Inject TypeRefMatcher typeRefMatcher;	
	
	@Check
	public void checkExceptionBackwardCompatibility (final org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception ex) {
		QualifiedName exName = nameProvider.getFullyQualifiedName (ex);
		final Resource res = ex.eResource ();
		IEObjectDescription nextLesserVersion = getNextLesserVersion (exName.toString (), ex.getVersion ().getVersion (), ex.eClass ().getName ());
		if (nextLesserVersion != null) {
			EObject eObject = nextLesserVersion.getEObjectOrProxy ();
			if (eObject.eIsProxy ())
				eObject = EcoreUtil2.resolve (eObject, res);
			if (eObject instanceof org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception) {
				org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception otherEx  = (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception)eObject;
				if (! otherEx.getState().isIsEnd()) {
					if (ex.getSuperException () != null) {
						if (otherEx.getSuperException () == null || ! (ex.getSuperException ().getException ().equals (otherEx.getSuperException ().getException ()))) {
							error ("The Exception " + ex.getName () + " version " + ex.getVersion ().getVersion () + " has an incompatible change to it's type hierarchy.", ServiceDslPackage.Literals.EXCEPTION__NAME);
						}
					} else if (otherEx.getSuperException () != null) {
						error ("The Exception " + ex.getName () + " version " + ex.getVersion ().getVersion () + " has an incompatible change to it's type hierarchy as it does not have a supertype anymore.", ServiceDslPackage.Literals.EXCEPTION__NAME);
					}
					
					for (final SimpleAttribute currOtherExProp :  otherEx.getProperties()) {
						boolean anyAttrWithName = Iterables.any (ex.getProperties(), new Predicate<SimpleAttribute>() {
			
							public boolean apply (SimpleAttribute prop) {
								return prop.getName ().equals (currOtherExProp.getName ());
							}
						});
						if (! anyAttrWithName) {
							// VersionedObjectFeatureConflicts.MISSING
							error ("The Attribute " + currOtherExProp.getName() + " is missing from Exception " + ex.getName () + " version " + ex.getVersion ().getVersion () + ". This is an incompatible change.", ServiceDslPackage.Literals.EXCEPTION__NAME);
						}
					}
				}
			}
		}
	}

	
	@Check
	public void checkExceptionPropertyBackwardCompatibility (final SimpleAttribute prop) {
		org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exc = (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception)prop.eContainer ();
		QualifiedName boName = nameProvider.getFullyQualifiedName (exc);
		final Resource res = exc.eResource ();
		IEObjectDescription nextLesserVersion = getNextLesserVersion (boName.toString (), exc.getVersion ().getVersion (), exc.eClass ().getName ());
		
		if (nextLesserVersion != null) {
			EObject eObject = nextLesserVersion.getEObjectOrProxy ();
			if (eObject.eIsProxy ())
				eObject = EcoreUtil2.resolve (eObject, res.getResourceSet ());
			if (eObject instanceof org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception) {
				org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception otherBo  = (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception)eObject;
				
				if (! otherBo.getState().isIsEnd()) {
					EList<SimpleAttribute> exProps = exc.getProperties ();
					EList<SimpleAttribute> otherExProps = otherBo.getProperties ();
					int exPropIdx = exProps.indexOf (prop);
					
					checkExceptionAttributes (prop, exProps, otherExProps,
							exPropIdx);
				}
			}
		}		
	}


	private void checkExceptionAttributes (final SimpleAttribute prop,
			EList<SimpleAttribute> exProps,
			EList<SimpleAttribute> otherExProps, int exPropIdx) {
		SimpleAttribute otherExProp = null;
		int otherExPropIdx = -1;
		
		for (int i = 0; i < otherExProps.size (); i++) {
			SimpleAttribute attr = otherExProps.get (i);
			if (attr.getName ().equals (prop.getName ())) {
				otherExProp = attr;
				otherExPropIdx = i;
			}
		}
		int highestPrevBOKnownPropertyIdx = -1;
		highestPrevBOKnownPropertyIdx = updateHighestPrevAttrIndex (exProps, otherExProps, highestPrevBOKnownPropertyIdx);
			
		Set<VersionedObjectFeatureConflicts> conflicts = compareAttributes (exPropIdx, prop, exProps, otherExPropIdx, otherExProp, otherExProps, highestPrevBOKnownPropertyIdx);
		notifySimpleAttrVersionConflicts (prop, conflicts);
	}

	
	protected Set<VersionedObjectFeatureConflicts> compareAttributes (int indexOfProp1, final SimpleAttribute prop1, final List<SimpleAttribute> boProps, int otherBoPropIdx, final SimpleAttribute prop2, final List<SimpleAttribute> otherBOProps, int highestPrevBOKnownPropertyIdx) {
		Set<VersionedObjectFeatureConflicts> conflicts = new HashSet<VersionedObjectFeatureConflicts>();
		if (prop2 != null) {
			if (indexOfProp1 != otherBoPropIdx) {
				conflicts.add (VersionedObjectFeatureConflicts.OUT_OF_ORDER_FEATURE);
			} else {
				TypeRefMatchResult typeRefMatchRes = typeRefMatcher.matches (prop2.getType(), prop1.getType());
				if (typeRefMatchRes == TypeRefMatchResult.NO_MATCH) {
					conflicts.add (VersionedObjectFeatureConflicts.WRONG_TYPE);
				} else if (typeRefMatchRes == TypeRefMatchResult.NO_VERSION_MATCH) {
					conflicts.add (VersionedObjectFeatureConflicts.WRONG_TYPE_VERSION_RANGE);
				}
				if (prop2.isOptional() && !prop1.isOptional()) {
					conflicts.add (VersionedObjectFeatureConflicts.CHANGED_TO_MANDATORY);
				}
				
			}
		} else {
			if (indexOfProp1 <= highestPrevBOKnownPropertyIdx)
				conflicts.add (VersionedObjectFeatureConflicts.NEW_FEATURE_IN_WRONG_POSITION);
			if (!prop1.isOptional())
				conflicts.add ( VersionedObjectFeatureConflicts.NEW_FEATURE_MANDATORY);
		}
		return conflicts;
	}
	
	private void notifySimpleAttrVersionConflicts (SimpleAttribute attr, Set<VersionedObjectFeatureConflicts> conflicts) {
		org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exc = (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception) attr.eContainer ();
		for (VersionedObjectFeatureConflicts conflict : conflicts) {
			if (conflict.equals (VersionedObjectFeatureConflicts.NAME_CONFLICT)) {
				error ("The property "
						+ attr.getName ()
						+ " has a different name than the property in the same position of the previous version of the Exception type.  This is an incompatible change.",
						ServiceDslPackage.Literals.SIMPLE_ATTRIBUTE__NAME);
			} else if (conflict
					.equals (VersionedObjectFeatureConflicts.OUT_OF_ORDER_FEATURE)) {
				warning (
						"The property "
								+ attr.getName ()
								+ " appears in a different order than in the previous version of the Exception type. This is an incompatible change and will not work in many cases.",
						ServiceDslPackage.Literals.SIMPLE_ATTRIBUTE__NAME);
			} else if (conflict
					.equals (VersionedObjectFeatureConflicts.WRONG_MULTIPLICITY)) {
				error ("The property "
						+ attr.getName ()
						+ " has a different multiplicity than the property in the previous version of the Exception type. This is an incompatible change.",
						ServiceDslPackage.Literals.SIMPLE_ATTRIBUTE__NAME);
			} else if (conflict
					.equals (VersionedObjectFeatureConflicts.WRONG_TYPE)) {
				error ("The property "
						+ attr.getName ()
						+ " has a different type than the property in the previous version of the Exception type. This is an incompatible change.",
						ServiceDslPackage.Literals.SIMPLE_ATTRIBUTE__NAME);
			} else if (conflict
					.equals (VersionedObjectFeatureConflicts.WRONG_TYPE_VERSION_RANGE)) {
				error ("The property "
						+ attr.getName ()
						+ " has the same type but a version constraint that can not satisfy the version constraint of the property's  type in the previous version of the Exception type. This is an incompatible change.",
						ServiceDslPackage.Literals.SIMPLE_ATTRIBUTE__NAME);
			} else if (conflict
					.equals (VersionedObjectFeatureConflicts.NEW_FEATURE_IN_WRONG_POSITION)) {
				warning (
						"The property "
								+ attr.getName ()
								+ " is a new property, but does not appear after the properties defined in the previous version. This is an incompatible change and will not work in many cases.",
						ServiceDslPackage.Literals.SIMPLE_ATTRIBUTE__NAME);
			} else if (conflict
					.equals (VersionedObjectFeatureConflicts.NEW_FEATURE_FROM_OTHER_NAMESPACE)) {
				warning (
						"The property "
								+ attr.getName ()
								+ " uses a type defined in a different namespace or with a defferent major version. Validating consumers might consider it an incompatible change.",
						ServiceDslPackage.Literals.SIMPLE_ATTRIBUTE__NAME);
			} else if (conflict
					.equals (VersionedObjectFeatureConflicts.NEW_FEATURE_MANDATORY)) {
				error ("The property "
						+ attr.getName ()
						+ " is a new property in this version, but is not optional. This is an incompatible change.",
						ServiceDslPackage.Literals.SIMPLE_ATTRIBUTE__NAME);
			}
		}
	}
	
	private int updateHighestPrevAttrIndex (EList<SimpleAttribute> boProps,
			EList<SimpleAttribute> otherBoProps, int highestPrevBOKnownPropertyIdx) {
		for (int i=0; i< boProps.size (); i++) {
			final SimpleAttribute prop = boProps.get(i);
			boolean prevHasProp = Iterables.any (otherBoProps, new Predicate<SimpleAttribute>() {

				public boolean apply (SimpleAttribute input) {
					return input.getName ().equals (prop.getName ());
				}
			});
			if (prevHasProp && i > highestPrevBOKnownPropertyIdx) {
				highestPrevBOKnownPropertyIdx = i;
			}
		}
		return highestPrevBOKnownPropertyIdx;
	}
}
