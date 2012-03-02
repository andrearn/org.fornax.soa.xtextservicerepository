package org.fornax.soa.servicedsl.generator.query.type

import com.google.inject.Inject
import java.util.List
import org.fornax.soa.basedsl.generator.lifecycle.StateMatcher
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.Type
import java.util.HashSet
import java.util.Set
import org.fornax.soa.servicedsl.VersionedDomainNamespace
import org.fornax.soa.serviceDsl.BusinessObject
import org.fornax.soa.serviceDsl.Enumeration

class TypesByLifecycleStateFinder {
	
	@Inject extension StateMatcher
	
	def List<Type> typesWithMinState (SubNamespace ns, LifecycleState state) {
		var Set<Type> types = new HashSet<Type>();
		types.addAll (ns.types.filter (typeof (BusinessObject)).filter (e|e.state.matchesMinStateLevel (state)));
		types.addAll (ns.types.filter (typeof (Enumeration)).filter (e|e.state.matchesMinStateLevel (state)));
		types.toList;
	}
	
	def List<org.fornax.soa.profiledsl.sOAProfileDsl.Type> typesWithMinState (TechnicalNamespace ns, LifecycleState state) {
		ns.types.filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType)).map (t|t as org.fornax.soa.profiledsl.sOAProfileDsl.Type).toList;
	}

	def List<Type> typesWithMinState (Object ns, LifecycleState state) {
		null;
	}

	def List<Type> typesWithMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.subdomain.typesWithMinState (state);
	}
	
}