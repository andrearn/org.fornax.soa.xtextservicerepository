package org.xkonnex.repo.dsl.servicedsl.service

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Aggregate
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Channel
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Command
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Event
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type

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