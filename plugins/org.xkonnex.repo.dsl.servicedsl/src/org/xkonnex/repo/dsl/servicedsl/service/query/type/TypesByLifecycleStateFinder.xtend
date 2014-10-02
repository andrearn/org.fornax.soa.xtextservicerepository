package org.xkonnex.repo.dsl.servicedsl.service.query.type

import com.google.inject.Inject
import java.util.List
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type
import java.util.HashSet
import java.util.Set
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.search.StateMatcher

class TypesByLifecycleStateFinder {
	
	@Inject extension StateMatcher
	
	def List<Type> typesWithMinState (SubNamespace ns, LifecycleState state) {
		var Set<Type> types = new HashSet<Type>();
		types.addAll (ns.types.filter (typeof (BusinessObject)).filter (e|e.state.matchesMinStateLevel (state)));
		types.addAll (ns.types.filter (typeof (Enumeration)).filter (e|e.state.matchesMinStateLevel (state)));
		types.toList;
	}
	
	def List<org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Type> typesWithMinState (TechnicalNamespace ns, LifecycleState state) {
		ns.types.filter (typeof (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedType)).map (t|t as org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Type).toList;
	}

	def List<Type> typesWithMinState (Object ns, LifecycleState state) {
		null;
	}

	def List<Type> typesWithMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.subdomain.typesWithMinState (state);
	}
	
}