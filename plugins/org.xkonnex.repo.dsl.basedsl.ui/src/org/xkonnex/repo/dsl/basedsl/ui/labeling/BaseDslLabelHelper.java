package org.xkonnex.repo.dsl.basedsl.ui.labeling;

import org.xkonnex.repo.dsl.basedsl.baseDsl.FixedVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.LowerBoundRangeVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MajorVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MaxVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MinVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.VersionRef;

public class BaseDslLabelHelper {
	
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
