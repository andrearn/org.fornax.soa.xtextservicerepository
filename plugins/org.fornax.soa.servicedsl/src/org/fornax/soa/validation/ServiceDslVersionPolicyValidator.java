package org.fornax.soa.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.validation.Check;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.fornax.soa.basedsl.scoping.versions.VersionComparator;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.VersionedTypeRef;
import org.fornax.soa.servicedsl.util.TypeRefMatcher;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.internal.Lists;

public class ServiceDslVersionPolicyValidator extends AbstractPluggableDeclarativeValidator {
	
	@Inject IPredicateSearch lookup;
	@Inject IQualifiedNameProvider nameProvider;
	@Inject VersionComparator versionComp;
	@Inject TypeRefMatcher typeRefMatcher;

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.fornax.soa.serviceDsl.ServiceDslPackage.eINSTANCE);
		return result;
	}
	
	@Check
	public void compatibleBOMinorVersions (final BusinessObject bo) {
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
					}
					for (final Property currOtherBoProp :  otherBo.getProperties()) {
						boolean anyAttrWithName = Iterables.any (bo.getProperties(), new Predicate<Property>() {
			
							public boolean apply (Property prop) {
								return prop.getName ().equals (currOtherBoProp.getName ());
							}
						});
						if (! anyAttrWithName) {
							error ("The Property " + currOtherBoProp.getName() + " is missing from BusinessObject " + bo.getName () + " version " + bo.getVersion ().getVersion () + ". This is an incompatible change.", ServiceDslPackage.Literals.VERSIONED_TYPE__NAME);
						}
					}
				}
			}
		}
		
	}
	
	@Check
	public void checkPropertyCompatibility (final Property prop) {
		BusinessObject bo = (BusinessObject)prop.eContainer ();
		QualifiedName boName = nameProvider.getFullyQualifiedName (bo);
		final Resource res = bo.eResource ();
		IEObjectDescription nextLesserVersion = getNextLesserVersion (boName.toString (), bo.getVersion ().getVersion (), bo.eClass ().getName ());
		if (nextLesserVersion != null) {
			EObject eObject = nextLesserVersion.getEObjectOrProxy ();
			if (eObject.eIsProxy ())
				eObject = EcoreUtil2.resolve (eObject, res);
			if (eObject instanceof BusinessObject && ! ((BusinessObject)eObject).getState ().isIsEnd ()) {
				BusinessObject otherBo  = (BusinessObject)eObject;
				if (! otherBo.getState().isIsEnd()) {
					EList<Property> boProps = bo.getProperties ();
					EList<Property> otherBoProps = otherBo.getProperties ();
					for (int i=0; i< boProps.size (); i++) {
						Property currBoProp = boProps.get (i);
						if (currBoProp.equals (prop)) {
							try {
								Property otherBOProp = null;
								if (i< otherBoProps.size())
										otherBOProp = otherBoProps.get (i);
								Set<PropertyVersionConflicts> conflicts= compareProperties (i, currBoProp, boProps, otherBOProp, otherBoProps);
								notifyPropertyVersionConflicts (currBoProp, conflicts);
							} catch (IndexOutOfBoundsException ex) {
								
							}
						}
					}
				}
			}
		}		
	}
	
	private void notifyPropertyVersionConflicts (Property attr, Set<PropertyVersionConflicts> conflicts) {
		BusinessObject bo = (BusinessObject) attr.eContainer ();
		for (PropertyVersionConflicts conflict : conflicts) {
			if (conflict.equals (PropertyVersionConflicts.NAME_CONFLICT)) {
				error ("The property " + attr.getName () + " has a different name than the property in the same position of the previous version of the BusinessObject.  This is an incompatible change.", ServiceDslPackage.Literals.PROPERTY__NAME );
			} else if (conflict.equals (PropertyVersionConflicts.OUT_OF_ORDER_ATTRIBUTE)) {
				error ("The property " + attr.getName () + " appears in a different order than in the previous version of the BusinessObject. This is an incompatible change.", ServiceDslPackage.Literals.PROPERTY__NAME );
			} else if (conflict.equals (PropertyVersionConflicts.WRONG_MULTIPLICITY)) {
				error ("The property " + attr.getName () + " has a different multiplicity than the property in the previous version of the BusinessObject. This is an incompatible change.", ServiceDslPackage.Literals.PROPERTY__NAME );
			} else if (conflict.equals (PropertyVersionConflicts.WRONG_TYPE)) {
				error ("The property " + attr.getName () + " has a different type than the property in the previous version of the BusinessObject. This is an incompatible change.", ServiceDslPackage.Literals.PROPERTY__NAME );
			} else if (conflict.equals (PropertyVersionConflicts.NEW_PROPERTY_IN_WRONG_POSITION)) {
				error ("The property " + attr.getName () + " is a new property, but does not appear after the properties defined in the previous version. This is an incompatible change.", ServiceDslPackage.Literals.PROPERTY__NAME );
			} else if (conflict.equals (PropertyVersionConflicts.NEW_PROPERTY_FROM_OTHER_NAMESPACE)) {
				warning ("The property " + attr.getName () + " uses a type defined in a different namespace or with a defferent major version. Validating consumers might consider it an incompatible change.", ServiceDslPackage.Literals.PROPERTY__NAME );
			} else if (conflict.equals (PropertyVersionConflicts.MANDATORY_NEW_PROPERTY)) {
				error ("The property " + attr.getName () + " is a new property in this version, but is not optional. This is an incompatible change.", ServiceDslPackage.Literals.PROPERTY__NAME );
			}
			
		}
	}
	
	private Set<PropertyVersionConflicts> compareProperties (int indexOfProp1, final Property prop1, final List<Property> boProps, final Property prop2, final List<Property> otherBOProps) {
		Set<PropertyVersionConflicts> conflicts = new HashSet<PropertyVersionConflicts>();
		if (prop2 != null && !prop1.getName ().equals (prop2.getName ())) {
			boolean anyAttrWithName = Iterables.any (otherBOProps, new Predicate<Property>() {

				public boolean apply (Property otherProp) {
					return otherProp.getName ().equals (prop1.getName ());
				}
			});
			if (anyAttrWithName) {
				conflicts.add (PropertyVersionConflicts.OUT_OF_ORDER_ATTRIBUTE);
			} else {
				if (!prop2.isOptional())
					conflicts.add ( PropertyVersionConflicts.MANDATORY_NEW_PROPERTY);
				if (indexOfProp1 < otherBOProps.size())
					conflicts.add (PropertyVersionConflicts.NEW_PROPERTY_IN_WRONG_POSITION);
				
			}
		} else if (prop2 == null) {
			if (!prop1.isOptional())
				conflicts.add ( PropertyVersionConflicts.MANDATORY_NEW_PROPERTY);
		} else {
			if (!typeRefMatcher.matches (prop2.getType(), prop1.getType())) {
				conflicts.add (PropertyVersionConflicts.WRONG_TYPE);
			}
			if (prop2.isOptional() && !prop1.isOptional()) {
				conflicts.add (PropertyVersionConflicts.CHANGED_TO_MANDATORY);
			}
		}
		return conflicts;
	}
	
	
	private IEObjectDescription getNextLesserVersion (final String name, final String version, final String typeName) {
		final String majorVersion = version.split ("\\.")[0];
		Iterable<IEObjectDescription> candBOs = lookup.search (name.toString () + " ", typeName, new Predicate<IEObjectDescription>() {
			
			public boolean apply (IEObjectDescription iEObjDesc) {
				String objVersion = iEObjDesc.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY);
				final String objMajorVersion = objVersion.split ("\\.")[0];
				int verComp = versionComp.compare (version, objVersion);
				return majorVersion.equals (objMajorVersion) && verComp > 0;
			}
			
		});
		ArrayList<IEObjectDescription> iEObjCandList = Lists.newArrayList (candBOs);
		Collections.sort (iEObjCandList, new Comparator<IEObjectDescription>() {

			public int compare (IEObjectDescription o1, IEObjectDescription o2) {
				String ver1 = o1.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY);
				String ver2 = o2.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY);
				return versionComp.compare (ver1, ver2);
			}
		});
		if (!iEObjCandList.isEmpty ())
			return iEObjCandList.get (iEObjCandList.size () - 1);
		else
			return null;
	}

}
