package org.xkonnex.repo.dsl.profiledsl.scoping.versions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType;
import org.xkonnex.repo.dsl.environmentdsl.util.EnvironmentTypeComparator;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.Inject;


public class EnvironmentBasedLifecycleStateComparator implements Comparator<LifecycleState> {

	@Inject
	private IQualifiedNameProvider nameProvider;
	@Inject
	private EnvironmentTypeComparator envTypeComparator;
	
	
	public int compare (LifecycleState s1, LifecycleState s2) {
		if (s1 == null && s2 == null)
			return 0;
		if (s1 != null && s2 == null)
			return 0;
		if (s1 == null && s2 != null)
			return 0;
		if (s1.equals(s2))
			return 0;
		
		List<EnvironmentType> leftEnvTypes = getStateEnvironmentTypes (s1);
		List<EnvironmentType> rightEnvTypes = getStateEnvironmentTypes (s2);
		
		EObject o = s1.eContainer ();
		if (o instanceof Lifecycle) {
			Lifecycle lifecycle = (Lifecycle) o;
			EList<LifecycleState> states = lifecycle.getStates ();
			if (leftEnvTypes.size () == rightEnvTypes.size()) {
				EnvironmentType greatestLeftEnvType = envTypeComparator.getGreatestEnvType (leftEnvTypes);
				EnvironmentType greatestRightEnvType = envTypeComparator.getGreatestEnvType (rightEnvTypes);
				int cmp = getEnvTypeComparator().compare (greatestLeftEnvType, greatestRightEnvType);
				return cmp;
			} else {
				EnvironmentType greatestLeftEnvType = envTypeComparator.getGreatestEnvType (leftEnvTypes);
				EnvironmentType greatestRightEnvType = envTypeComparator.getGreatestEnvType (rightEnvTypes);
				int cmp = getEnvTypeComparator().compare (greatestLeftEnvType, greatestRightEnvType);
				return cmp;
			}
		}
		return 0;
		
	}

	protected int compareByDefinitionIndex (LifecycleState s1,
			LifecycleState s2, EList<LifecycleState> states) {
		int s1Idx = states.indexOf (s1);
		int s2Idx = states.indexOf (s2);
		if (s1Idx > s2Idx)
			return 1;
		else if (s1Idx < s2Idx)
			return -1;
		else
			return 0;
	}
	
	public List<EnvironmentType> getStateEnvironmentTypes (LifecycleState state) {
		List<EnvironmentType> types = new ArrayList<EnvironmentType> ();
		if (state != null) {
			types.addAll (state.getQualifiesFor ());
			types.addAll (Lists.transform (state.getQualifiesForEnvironment (), new Function<Environment, EnvironmentType> () {
				
				public EnvironmentType apply (Environment env) {
					return env.getType ();
				}
				
			}));
		}
		return types;
	}
	
	protected boolean containsGreaterOrEqual (List<EnvironmentType> envTypes, EnvironmentType expectedEnvType) {
		for (EnvironmentType envType : envTypes) {
			if (getEnvTypeComparator().compare (envType, expectedEnvType) >= 0) 
				return true;
		}
		return false;
	}
	
	protected boolean containsLessOrEqual (List<EnvironmentType> envTypes, EnvironmentType expectedEnvType) {
		for (EnvironmentType envType : envTypes) {
			if (getEnvTypeComparator().compare (envType, expectedEnvType) <= 0) 
				return true;
		}
		return false;
	}
	

	public void setNameProvider(IQualifiedNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}

	public IQualifiedNameProvider getNameProvider() {
		return nameProvider;
	}

	public void setEnvTypeComparator(EnvironmentTypeComparator envTypeComparator) {
		this.envTypeComparator = envTypeComparator;
	}

	public EnvironmentTypeComparator getEnvTypeComparator() {
		return envTypeComparator;
	}

}
