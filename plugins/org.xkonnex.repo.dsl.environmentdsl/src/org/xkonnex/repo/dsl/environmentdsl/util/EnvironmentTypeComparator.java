package org.xkonnex.repo.dsl.environmentdsl.util;

import java.util.Comparator;
import java.util.List;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType;

public class EnvironmentTypeComparator implements Comparator<EnvironmentType> {

	public int compare (EnvironmentType o1, EnvironmentType o2) {
		if (o1 == null && o2 == null)
			return 0;
		if (o1 == null)
			return -1;
		if (o2 == null)
			return 1;
		if (o1.equals (o2))
			return 0;
		if (EnvironmentType.OTHER.equals (o1) && EnvironmentType.LOCAL.equals (o2))
			return 1;
		if (EnvironmentType.OTHER.equals (o1) && EnvironmentType.DEV.equals (o2))
			return -1;
		if (EnvironmentType.DEV.equals (o1) && EnvironmentType.LOCAL.equals (o2))
			return 1;
		if  (EnvironmentType.DEV.equals (o1) && EnvironmentType.OTHER.equals (o2)) 
			return 1;
		if (EnvironmentType.TEST.equals (o1) && 
				! (EnvironmentType.PROD.equals (o2) || EnvironmentType.STAGING.equals (o2)))
			return 1;
		if (EnvironmentType.STAGING.equals (o1) && 
				! EnvironmentType.PROD.equals (o2))
			return 1;
		if  (EnvironmentType.PROD.equals (o1)) 
			return 1;
		return -1;
	}
	
	public EnvironmentType getGreatestEnvType (List<EnvironmentType> envTypes) {
		EnvironmentType greatestEnvType = null;
		for (EnvironmentType envType : envTypes) {
			if (greatestEnvType == null)
				greatestEnvType = envType;
			else if (compare (envType, greatestEnvType) > 0)
				greatestEnvType = envType;
		}
		return greatestEnvType;
	}

}
