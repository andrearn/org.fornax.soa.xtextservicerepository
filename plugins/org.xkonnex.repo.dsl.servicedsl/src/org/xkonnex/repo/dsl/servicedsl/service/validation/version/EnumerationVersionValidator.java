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
import org.xkonnex.repo.dsl.servicedsl.service.util.TypeRefMatcher;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EnumLiteral;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage;
import org.xkonnex.repo.dsl.servicedsl.validation.VersionedObjectFeatureConflicts;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class EnumerationVersionValidator extends AbstractServiceDslVersionValidator {
	
	@Inject IPredicateSearch lookup;
	@Inject IQualifiedNameProvider nameProvider;
	@Inject VersionComparator versionComp;
	@Inject TypeRefMatcher typeRefMatcher;


	@Check
	public void checkEnumBackwardCompatibility (final Enumeration enumeration) {
		QualifiedName enumName = nameProvider.getFullyQualifiedName (enumeration);
		final Resource res = enumeration.eResource ();
		IEObjectDescription nextLesserVersion = getNextLesserVersion (enumName.toString (), enumeration.getVersion ().getVersion (), enumeration.eClass ().getName ());
		
		if (nextLesserVersion != null) {
			EObject eObject = nextLesserVersion.getEObjectOrProxy ();
			if (eObject.eIsProxy ())
				eObject = EcoreUtil2.resolve (eObject, res.getResourceSet ());
			if (eObject instanceof Enumeration) {
				Enumeration otherEnum  = (Enumeration)eObject;
				if (otherEnum.getState() == null || !otherEnum.getState().isIsEnd()) {
					for (final EnumLiteral lit : otherEnum.getLiterals ()) {
						boolean curVerHasLiteral = Iterables.any (enumeration.getLiterals (), new Predicate<EnumLiteral>() {
	
							public boolean apply (EnumLiteral input) {
								return input.getName ().equals (lit.getName ());
							}
						});
						if (!curVerHasLiteral) {
							error ("The enum literal " + lit.getName () + " has been removed. This is an incompatible change!", ServiceDslPackage.Literals.VERSIONED_TYPE__NAME);
						}
						
					}
				}
			}
		}
	}
	
	@Check
	public void checkPropertyBackwardCompatibility (final EnumLiteral literal) {
		Enumeration en = (Enumeration)literal.eContainer ();
		QualifiedName enumName = nameProvider.getFullyQualifiedName (en);
		final Resource res = en.eResource ();
		IEObjectDescription nextLesserVersion = getNextLesserVersion (enumName.toString (), en.getVersion ().getVersion (), en.eClass ().getName ());
		
		if (nextLesserVersion != null) {
			EObject eObject = nextLesserVersion.getEObjectOrProxy ();
			if (eObject.eIsProxy ())
				eObject = EcoreUtil2.resolve (eObject, res.getResourceSet ());
			if (eObject instanceof Enumeration) {
				Enumeration otherEnum  = (Enumeration)eObject;
				
				if (otherEnum.getState() == null || !otherEnum.getState().isIsEnd()) {
					EList<EnumLiteral> enumLiterals = en.getLiterals ();
					EList<EnumLiteral> otherEnumLiterals = otherEnum.getLiterals ();
					int enumLiteralIdx = enumLiterals.indexOf (literal);

					checkEnumLiterals (literal, enumLiterals,
							otherEnumLiterals, enumLiteralIdx);
				}
			}
		}		
	}
	
	private void checkEnumLiterals (final EnumLiteral literal,
			EList<EnumLiteral> enumLiterals,
			EList<EnumLiteral> otherEnumLiterals, int enumLiteralIdx) {

		EnumLiteral otherEnumLiteral = null;
		int otherEnumLiteralIdx = -1;

		for (int i=0; i<otherEnumLiterals.size (); i++) {
			EnumLiteral enumLit = otherEnumLiterals.get (i);
			if (enumLit.getName ().equals (literal.getName ())) {
				otherEnumLiteral = enumLit;
				otherEnumLiteralIdx = i;
			}
		}
		int highestPrevEnumKnownLiteralIdx = -1;
		highestPrevEnumKnownLiteralIdx = updateHighestPrevPropIndex (enumLiterals, otherEnumLiterals, highestPrevEnumKnownLiteralIdx);
			
		Set<VersionedObjectFeatureConflicts> conflicts = compareLiterals (enumLiteralIdx, literal, enumLiterals, otherEnumLiteralIdx, otherEnumLiteral, otherEnumLiterals, highestPrevEnumKnownLiteralIdx);
		notifyLiteralVersionConflicts (literal, conflicts);
	}
	
	private Set<VersionedObjectFeatureConflicts> compareLiterals (int curEnumLitIdx, final EnumLiteral curLiteral, final List<EnumLiteral> curEnumLitarals, int otherEnumLitIdx, final EnumLiteral lesserEnumLiteral, final List<EnumLiteral> lesserEnumLiterals, int highestPrevBOKnownPropertyIdx) {
		Set<VersionedObjectFeatureConflicts> conflicts = new HashSet<VersionedObjectFeatureConflicts>();
		if (lesserEnumLiteral != null) {
			if (curEnumLitIdx != otherEnumLitIdx) {
				conflicts.add (VersionedObjectFeatureConflicts.OUT_OF_ORDER_FEATURE);
			}
		} else {
			if (curEnumLitIdx <= highestPrevBOKnownPropertyIdx)
				conflicts.add (VersionedObjectFeatureConflicts.NEW_FEATURE_IN_WRONG_POSITION);
		}
		return conflicts;
	}
	
	private void notifyLiteralVersionConflicts (EnumLiteral attr, Set<VersionedObjectFeatureConflicts> conflicts) {
		Enumeration en = (Enumeration) attr.eContainer ();
		for (VersionedObjectFeatureConflicts conflict : conflicts) {
			if (conflict.equals (VersionedObjectFeatureConflicts.NAME_CONFLICT)) {
				error ("The enum literal " + attr.getName () + " has a different name than the enum literal in the same position of the previous version of the BusinessObject.  This is an incompatible change.", ServiceDslPackage.Literals.ENUM_LITERAL__NAME );
			} else if (conflict.equals (VersionedObjectFeatureConflicts.OUT_OF_ORDER_FEATURE)) {
				warning ("The enum literal " + attr.getName () + " appears in a different order than in the previous version of the BusinessObject. This is an incompatible change and will not work in many cases.", ServiceDslPackage.Literals.ENUM_LITERAL__NAME );
			} else if (conflict.equals (VersionedObjectFeatureConflicts.NEW_FEATURE_IN_WRONG_POSITION)) {
				warning ("The enum literal " + attr.getName () + " is a new enum literal, but does not appear after the properties defined in the previous version. This is an incompatible change and will not work in many cases.", ServiceDslPackage.Literals.ENUM_LITERAL__NAME );
			}
			
		}
	}

	private int updateHighestPrevPropIndex (EList<EnumLiteral> curEnumLiterals,
			EList<EnumLiteral> lesserEnumLiterals, int highestPrevBOKnownPropertyIdx) {
		for (int i=0; i< curEnumLiterals.size (); i++) {
			final EnumLiteral curLit = curEnumLiterals.get(i);
			boolean prevHasProp = Iterables.any (lesserEnumLiterals, new Predicate<EnumLiteral>() {

				public boolean apply (EnumLiteral input) {
					return input.getName ().equals (curLit.getName ());
				}
			});
			if (prevHasProp && i > highestPrevBOKnownPropertyIdx) {
				highestPrevBOKnownPropertyIdx = i;
			}
		}
		return highestPrevBOKnownPropertyIdx;
	}
}
