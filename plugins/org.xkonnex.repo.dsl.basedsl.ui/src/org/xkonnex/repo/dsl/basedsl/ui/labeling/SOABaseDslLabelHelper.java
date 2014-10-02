package org.xkonnex.repo.dsl.basedsl.ui.labeling;

import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.FixedVersionRef;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.LowerBoundRangeVersionRef;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.MajorVersionRef;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.MaxVersionRef;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.MinVersionRef;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.VersionRef;

public class SOABaseDslLabelHelper {
	
	public static String getVersionConstraint (VersionRef v) {
		if (v instanceof FixedVersionRef) {
			FixedVersionRef ref = (FixedVersionRef)v;
			return ref.getFixedVersion();
		}
		if (v instanceof MajorVersionRef) {
			MajorVersionRef ref = (MajorVersionRef)v;
			return ref.getMajorVersion() + ".x";
		}
		if (v instanceof MaxVersionRef) {
			MaxVersionRef ref = (MaxVersionRef)v;
			return "<=" + ref.getMaxVersion();
		}
		if (v instanceof MinVersionRef) {
			MinVersionRef ref = (MinVersionRef)v;
			return ">=" + ref.getMinVersion();
		}
		if (v instanceof LowerBoundRangeVersionRef) {
			LowerBoundRangeVersionRef ref = (LowerBoundRangeVersionRef)v;
			return "[" + ref.getMinVersion() + ", " + ref.getMaxVersion() + ")";
		}
		return "";
	}

}
