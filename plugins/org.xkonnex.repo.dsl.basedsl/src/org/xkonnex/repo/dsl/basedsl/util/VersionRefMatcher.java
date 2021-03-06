package org.xkonnex.repo.dsl.basedsl.util;

import org.xkonnex.repo.dsl.basedsl.baseDsl.FixedVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.LowerBoundRangeVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MajorVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MaxVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MinVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.VersionRef;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.LatestMajorVersionFilter;
import org.xkonnex.repo.dsl.basedsl.version.VersionComparator;

import com.google.inject.Singleton;

@Singleton
public class VersionRefMatcher {
	
	
	/**
	 * tests, whether the version constraint ref1 matches that of ref2, i.e. ref1 is fully 
	 * covered by the version constraint ref2
	 * 
	 * @param ref1 a version constraint
	 * @param ref2 another version constraint to check against
	 * @return true, if version constraint ref1 matches that of ref2
	 */
	public boolean matches (VersionRef ref1, VersionRef ref2) {
		if (ref1 instanceof MajorVersionRef) {
			MajorVersionRef verRef1 = (MajorVersionRef) ref1;
			if (ref2 instanceof MajorVersionRef) {
				MajorVersionRef verRef2 = (MajorVersionRef) ref2;
				return VersionComparator.compare (verRef1.getMajorVersion(), verRef2.getMajorVersion()) == 0;
				
			} else if (ref2 instanceof LowerBoundRangeVersionRef) {
				LowerBoundRangeVersionRef verRef2 = (LowerBoundRangeVersionRef) ref2;
				int minCmp = VersionComparator.compare (LatestMajorVersionFilter.toMajorVersion (verRef2.getMinVersion()), verRef1.getMajorVersion());
				int maxCmp = VersionComparator.compare (verRef2.getMaxVersion(), verRef1.getMajorVersion() + 1);
				return minCmp == 0 && maxCmp >= 0;
				
			} else if (ref2 instanceof MinVersionRef) {
				MinVersionRef verRef2 = (MinVersionRef) ref2;
				int minCmp = VersionComparator.compare (verRef2.getMinVersion (), verRef1.getMajorVersion ());
				return minCmp <= 0;
				
			} else if (ref2 instanceof MaxVersionRef) {
				MaxVersionRef verRef2 = (MaxVersionRef) ref2;
				int maxCmp = VersionComparator.compare (verRef2.getMaxVersion (), verRef1.getMajorVersion () + 1);
				return maxCmp >= 0;
				
			}
		
		} else if (ref1 instanceof MinVersionRef) {
			MinVersionRef verRef1 = (MinVersionRef) ref1;
			if (ref2 instanceof MinVersionRef) {
				MinVersionRef verRef2 = (MinVersionRef) ref2;
				return VersionComparator.compare (verRef1.getMinVersion(), verRef2.getMinVersion()) >= 0;
				
			}
		
		} else if (ref1 instanceof LowerBoundRangeVersionRef) {
			LowerBoundRangeVersionRef verRef1 = (LowerBoundRangeVersionRef) ref1;
			if (ref2 instanceof MajorVersionRef) {
				MajorVersionRef verRef2 = (MajorVersionRef) ref2;
				int minCmp = VersionComparator.compare (verRef1.getMinVersion(), verRef2.getMajorVersion());
				int maxCmp = VersionComparator.compare (verRef1.getMaxVersion(), verRef2.getMajorVersion() + 1);
				return minCmp >= 0 && maxCmp <= 0;
				
			} else if (ref2 instanceof MinVersionRef) {
				MinVersionRef verRef2 = (MinVersionRef) ref2;
				return VersionComparator.compare (verRef1.getMinVersion(), verRef2.getMinVersion()) >= 0;
				
			} else if (ref2 instanceof LowerBoundRangeVersionRef) {
				LowerBoundRangeVersionRef verRef2 = (LowerBoundRangeVersionRef) ref2;
				int minCmp = VersionComparator.compare (verRef1.getMinVersion(), verRef2.getMinVersion());
				int maxCmp = VersionComparator.compare (verRef1.getMaxVersion(), verRef2.getMaxVersion());
				return minCmp >= 0 && maxCmp <= 0;
				
			} else if (ref2 instanceof MaxVersionRef) {
				MaxVersionRef verRef2 = (MaxVersionRef) ref2;
				return VersionComparator.compare (verRef1.getMaxVersion(), verRef2.getMaxVersion()) <= 0;
				
			}
		
		} else if (ref1 instanceof MaxVersionRef) {
			MaxVersionRef verRef1 = (MaxVersionRef) ref1;
			if (ref2 instanceof MaxVersionRef) {
				MaxVersionRef verRef2 = (MaxVersionRef) ref2;
				return VersionComparator.compare (verRef1.getMaxVersion(), verRef2.getMaxVersion()) <= 0;
				
			}
		
		} else if (ref1 instanceof FixedVersionRef) {
			FixedVersionRef verRef1 = (FixedVersionRef) ref1;
			if (ref2 instanceof MajorVersionRef) {
				MajorVersionRef verRef2 = (MajorVersionRef) ref2;
				return VersionComparator.compare (LatestMajorVersionFilter.toMajorVersion (verRef1.getFixedVersion()), verRef2.getMajorVersion()) == 0;
				
			} else if (ref2 instanceof MinVersionRef) {
				MinVersionRef verRef2 = (MinVersionRef) ref2;
				return VersionComparator.compare (verRef1.getFixedVersion(), verRef2.getMinVersion()) >= 0;
				
			} else if (ref2 instanceof LowerBoundRangeVersionRef) {
				LowerBoundRangeVersionRef verRef2 = (LowerBoundRangeVersionRef) ref2;
				return VersionComparator.compare (verRef1.getFixedVersion(), verRef2.getMinVersion()) >= 0 &&
						VersionComparator.compare (verRef1.getFixedVersion(), verRef2.getMaxVersion()) < 0;
				
			} else if (ref2 instanceof MaxVersionRef) {
				MaxVersionRef verRef2 = (MaxVersionRef) ref2;
				return VersionComparator.compare (verRef1.getFixedVersion(), verRef2.getMaxVersion()) <= 0;
				
			} else if (ref2 instanceof FixedVersionRef) {
				FixedVersionRef verRef2 = (FixedVersionRef) ref2;
				return VersionComparator.compare (verRef1.getFixedVersion(), verRef2.getFixedVersion()) == 0;
				
			}
		}
		return false;
	}
	
	/**
	 * tests, whether the version constraint ref1 matches exactly the version constraint ref2
	 * 
	 * @param ref1 a version constraint
	 * @param ref2 another version constraint to check against
	 * @return true, if version constraint ref1 matches exactly that of ref2
	 */
	public boolean matchesExactly (VersionRef ref1, VersionRef ref2) {
		if (ref1 instanceof MajorVersionRef) {
			MajorVersionRef verRef1 = (MajorVersionRef) ref1;
			if (ref2 instanceof MajorVersionRef) {
				MajorVersionRef verRef2 = (MajorVersionRef) ref2;
				return VersionComparator.compare (verRef1.getMajorVersion(), verRef2.getMajorVersion()) == 0;
				
			}
		} else if (ref1 instanceof MinVersionRef) {
			MinVersionRef verRef1 = (MinVersionRef) ref1;
			if (ref2 instanceof MinVersionRef) {
				MinVersionRef verRef2 = (MinVersionRef) ref2;
				return VersionComparator.compare(verRef1.getMinVersion(), verRef2.getMinVersion()) == 0;
				
			}
		} else if (ref1 instanceof LowerBoundRangeVersionRef) {
			LowerBoundRangeVersionRef verRef1 = (LowerBoundRangeVersionRef) ref1;
			if (ref2 instanceof LowerBoundRangeVersionRef) {
				LowerBoundRangeVersionRef verRef2 = (LowerBoundRangeVersionRef) ref2;
				return VersionComparator.compare(verRef1.getMinVersion(), verRef2.getMinVersion()) == 0 &&
						VersionComparator.compare(verRef1.getMaxVersion(), verRef2.getMaxVersion()) == 0;
				
			}
		} else if (ref1 instanceof MaxVersionRef) {
			MaxVersionRef verRef1 = (MaxVersionRef) ref1;
			if (ref2 instanceof MaxVersionRef) {
				MaxVersionRef verRef2 = (MaxVersionRef) ref2;
				return VersionComparator.compare(verRef1.getMaxVersion(), verRef2.getMaxVersion()) == 0;
				
			}
		} else if (ref1 instanceof FixedVersionRef) {
			FixedVersionRef verRef1 = (FixedVersionRef) ref1;
			if (ref2 instanceof FixedVersionRef) {
				FixedVersionRef verRef2 = (FixedVersionRef) ref2;
				return VersionComparator.compare(verRef1.getFixedVersion(), verRef2.getFixedVersion()) == 0;
				
			}
		}
		return false;
	}

}
