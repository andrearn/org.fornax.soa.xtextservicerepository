package org.fornax.soa.service.validation.version;

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
import org.fornax.soa.basedsl.scoping.versions.VersionComparator;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.service.util.TypeRefMatchResult;
import org.fornax.soa.service.util.TypeRefMatcher;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.validation.VersionedObjectFeatureConflicts;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class BusinessObjectVersionValidator extends AbstractServiceDslVersionValidator {
	
	@Inject IPredicateSearch lookup;
	@Inject IQualifiedNameProvider nameProvider;
	@Inject VersionComparator versionComp;
	@Inject TypeRefMatcher typeRefMatcher;
	
	@Check
	public void checkBOBackwardCompatibility (final BusinessObject bo) {
		QualifiedName boName = nameProvider.getFullyQualifiedName (bo);
		final Resource res = bo.eResource ();
		IEObjectDescription nextLesserVersion = getNextLesserVersion (boName.toString (), bo.getVersion ().getVersion (), bo.eClass ().getName ());
		if (nextLesserVersion != null) {
			EObject eObject = nextLesserVersion.getEObjectOrProxy ();
			if (eObject.eIsProxy ())
				eObject = EcoreUtil2.resolve (eObject, res);
			if (eObject instanceof BusinessObject) {
				BusinessObject otherBo  = (BusinessObject)eObject;
				if (! otherBo.getState().isIsEnd()) {
					if (bo.getSuperBusinessObject () != null) {
						if (otherBo.getSuperBusinessObject () == null || ! (bo.getSuperBusinessObject ().getType ().equals (otherBo.getSuperBusinessObject ().getType ()))) {
							error ("The BusinessObject " + bo.getName () + " version " + bo.getVersion ().getVersion () + " has an incompatible change to it's type hierarchy.", ServiceDslPackage.Literals.VERSIONED_TYPE__NAME);
						}
					} else if (otherBo.getSuperBusinessObject () != null) {
						error ("The BusinessObject " + bo.getName () + " version " + bo.getVersion ().getVersion () + " has an incompatible change to it's type hierarchy as it does not have a supertype anymore.", ServiceDslPackage.Literals.VERSIONED_TYPE__NAME);
					}
					
					for (final Property currOtherBoProp :  otherBo.getProperties()) {
						boolean anyAttrWithName = Iterables.any (bo.getProperties(), new Predicate<Property>() {
			
							public boolean apply (Property prop) {
								return prop.getName ().equals (currOtherBoProp.getName ());
							}
						});
						if (! anyAttrWithName) {
							// VersionedObjectFeatureConflicts.MISSING
							error ("The Property " + currOtherBoProp.getName() + " is missing from BusinessObject " + bo.getName () + " version " + bo.getVersion ().getVersion () + ". This is an incompatible change.", ServiceDslPackage.Literals.VERSIONED_TYPE__NAME);
						}
					}
				}
			}
		}
		
	}


	/**
	 * Is the property backward compatible with the previous version of the BO? Backward compatibility is maintaines
	 * when the property: <br/>
	 * <ul>
	 * 		<li>has the same name as the property in the same position of the previous version</li>
	 * 		<li>has the same type or compatible type as the property in the same position of the previous version</li>
	 * </u> <br/><br/>
	 * 
	 * Types are compatible if is the current type is the same or a super type of the previous one or the new type can 
	 * generally represent the old one, i.e. is convertible
	 */
	@Check
	public void checkPropertyBackwardCompatibility (final Property prop) {
		BusinessObject bo = (BusinessObject)prop.eContainer ();
		QualifiedName boName = nameProvider.getFullyQualifiedName (bo);
		final Resource res = bo.eResource ();
		IEObjectDescription nextLesserVersion = getNextLesserVersion (boName.toString (), bo.getVersion ().getVersion (), bo.eClass ().getName ());
		
		if (nextLesserVersion != null) {
			EObject eObject = nextLesserVersion.getEObjectOrProxy ();
			if (eObject.eIsProxy ())
				eObject = EcoreUtil2.resolve (eObject, res.getResourceSet ());
			if (eObject instanceof BusinessObject) {
				BusinessObject otherBo  = (BusinessObject)eObject;
				
				if (! otherBo.getState().isIsEnd()) {
					EList<Property> boProps = bo.getProperties ();
					EList<Property> otherBoProps = otherBo.getProperties ();
					int boPropIdx = boProps.indexOf (prop);
					checkBOProperties (prop, boProps, otherBoProps, boPropIdx);
				}
			}
		}		
	}


	private void checkBOProperties (final Property prop,
			EList<Property> boProps, EList<Property> otherBoProps, int boPropIdx) {
		int highestPrevBOKnownPropertyIdx = -1;
		int otherBoPropIdx = -1;
		highestPrevBOKnownPropertyIdx = updateHighestPrevPropIndex (boProps, otherBoProps, highestPrevBOKnownPropertyIdx);
		Property otherBOProp = null;
		
		for (int i=0; i<otherBoProps.size (); i++) {
			Property p = otherBoProps.get (i);
			if (p.getName ().equals (prop.getName ())) {
				otherBOProp = p;
				otherBoPropIdx = i;
			}
		}
			
		Set<VersionedObjectFeatureConflicts> conflicts = compareProperties (boPropIdx, prop, boProps, otherBoPropIdx, otherBOProp, otherBoProps, highestPrevBOKnownPropertyIdx);
		notifyPropertyVersionConflicts (prop, conflicts);
	}

	
	private Set<VersionedObjectFeatureConflicts> compareProperties (int indexOfProp1, final Property prop1, final List<Property> boProps, int otherBoPropIdx, final Property prop2, final List<Property> otherBOProps, int highestPrevBOKnownPropertyIdx) {
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
	
	private void notifyPropertyVersionConflicts (Property attr, Set<VersionedObjectFeatureConflicts> conflicts) {
		BusinessObject bo = (BusinessObject) attr.eContainer ();
		for (VersionedObjectFeatureConflicts conflict : conflicts) {
			if (conflict.equals (VersionedObjectFeatureConflicts.NAME_CONFLICT)) {
				error ("The property " + attr.getName () + " has a different name than the property in the same position of the previous version of the BusinessObject.  This is an incompatible change.", ServiceDslPackage.Literals.PROPERTY__NAME );
			} else if (conflict.equals (VersionedObjectFeatureConflicts.OUT_OF_ORDER_FEATURE)) {
				warning ("The property " + attr.getName () + " appears in a different order than in the previous version of the BusinessObject. This is an incompatible change and will not work in many cases.", ServiceDslPackage.Literals.PROPERTY__NAME );
			} else if (conflict.equals (VersionedObjectFeatureConflicts.WRONG_MULTIPLICITY)) {
				error ("The property " + attr.getName () + " has a different multiplicity than the property in the previous version of the BusinessObject. This is an incompatible change.", ServiceDslPackage.Literals.PROPERTY__NAME );
			} else if (conflict.equals (VersionedObjectFeatureConflicts.WRONG_TYPE)) {
				error ("The property " + attr.getName () + " has a different type than the property in the previous version of the BusinessObject. This is an incompatible change.", ServiceDslPackage.Literals.PROPERTY__NAME );
			} else if (conflict.equals (VersionedObjectFeatureConflicts.WRONG_TYPE_VERSION_RANGE)) {
				error ("The property " + attr.getName () + " has the same type but a version constraint that can not satisfy the version constraint of the property's  type in the previous version of the BusinessObject. This is an incompatible change.", ServiceDslPackage.Literals.PROPERTY__NAME );
			} else if (conflict.equals (VersionedObjectFeatureConflicts.NEW_FEATURE_IN_WRONG_POSITION)) {
				warning ("The property " + attr.getName () + " is a new property, but does not appear after the properties defined in the previous version. This is an incompatible change and will not work in many cases.", ServiceDslPackage.Literals.PROPERTY__NAME );
			} else if (conflict.equals (VersionedObjectFeatureConflicts.NEW_FEATURE_FROM_OTHER_NAMESPACE)) {
				warning ("The property " + attr.getName () + " uses a type defined in a different namespace or with a defferent major version. Validating consumers might consider it an incompatible change.", ServiceDslPackage.Literals.PROPERTY__NAME );
			} else if (conflict.equals (VersionedObjectFeatureConflicts.NEW_FEATURE_MANDATORY)) {
				error ("The property " + attr.getName () + " is a new property in this version, but is not optional. This is an incompatible change.", ServiceDslPackage.Literals.PROPERTY__NAME );
			}
			
		}
	}

	private int updateHighestPrevPropIndex (EList<Property> boProps,
			EList<Property> otherBoProps, int highestPrevBOKnownPropertyIdx) {
		for (int i=0; i< boProps.size (); i++) {
			final Property prop = boProps.get(i);
			boolean prevHasProp = Iterables.any (otherBoProps, new Predicate<Property>() {

				public boolean apply (Property input) {
					return input.getName ().equals (prop.getName ());
				}
			});
			if (prevHasProp && i > highestPrevBOKnownPropertyIdx) {
				highestPrevBOKnownPropertyIdx = i;
			}
		}
		return highestPrevBOKnownPropertyIdx;
	}
	
	class PropertyLocation {
		
		private int propertyIndex = -1;
		private Property property;
		
		public PropertyLocation (Property prop, int propertyIndex) {
			property = prop;
			this.propertyIndex = propertyIndex;
		}
	}

}
