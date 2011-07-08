package org.fornax.soa.basedsl.ui.labeling;

import org.fornax.soa.basedsl.sOABaseDsl.FixedVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.LowerBoundRangeVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MajorVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MaxVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MinVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;

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
