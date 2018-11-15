package org.xkonnex.repo.dsl.servicedsl.service

import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Aggregate
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Channel
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Command
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Event
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.QueryObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Entity
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ValueObject
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef

class ModelExtensions {
	
	def types (SubNamespace ns) {
		ns.objects.filter(typeof(Type))
	}
	def dataObjects (SubNamespace ns) {
		ns.objects.filter(typeof(Type))
	}
	def enums (SubNamespace ns) {
		ns.objects.filter(typeof(Enumeration))
	}
	def aggregates (SubNamespace ns) {
		ns.objects.filter(typeof(Aggregate))
	}
	def services (SubNamespace ns) {
		ns.objects.filter(typeof(Service))
	}
	def resources (SubNamespace ns) {
		ns.objects.filter(typeof(Resource))
	}
	def exceptions (SubNamespace ns) {
		ns.objects.filter(typeof(Exception))
	}
	def commands (SubNamespace ns) {
		ns.objects.filter(typeof(Command))
	}
	def events (SubNamespace ns) {
		ns.objects.filter(typeof(Event))
	}
	def channels (SubNamespace ns) {
		ns.objects.filter(typeof(Channel))
	}
	
}