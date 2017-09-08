package org.xkonnex.repo.dsl.servicedsl.service.query

import org.xkonnex.repo.dsl.profiledsl.profileDsl.MessageHeader
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractOperation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceOperation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service

class MessageHeaderQuery {
	
	def dispatch MessageHeader getRequestMessageHeader(Service service, Profile profile) {
		if (service.getRequestMessageHeader() !== null) {
			return service.getRequestMessageHeader().getHeader()
		} else {
			return profile.getMessaging().getDefaultRequestHeader().getHeader()
		}
	}

	def dispatch MessageHeader getRequestMessageHeader(Resource service, Profile profile) {
		if (service.getRequestMessageHeader() !== null) {
			return service.getRequestMessageHeader().getHeader()
		} else {
			return profile.getMessaging().getDefaultRequestHeader().getHeader()
		}
	}

	def dispatch MessageHeader getRequestMessageHeader(AbstractOperation operation, Profile profile) {
		if (operation.getRequestMessageHeader() !== null) {
			return operation.getRequestMessageHeader().getHeader()
		} else {
			return getRequestMessageHeader((operation.eContainer() as Service), profile)
		}
	}

	def dispatch MessageHeader getRequestMessageHeader(ResourceOperation operation, Profile profile) {
		if (operation.getRequestMessageHeader() !== null) {
			return operation.getRequestMessageHeader().getHeader()
		} else {
			return getRequestMessageHeader((operation.eContainer() as Resource), profile)
		}
	}

	def dispatch MessageHeader getResponseMessageHeader(Service service, Profile profile) {
		if (service.getResponseMessageHeader() !== null) {
			return service.getResponseMessageHeader().getHeader()
		} else {
			return profile.getMessaging().getDefaultRequestHeader().getHeader()
		}
	}

	def dispatch MessageHeader getResponseMessageHeader(Resource service, Profile profile) {
		if (service.getResponseMessageHeader() !== null) {
			return service.getResponseMessageHeader().getHeader()
		} else {
			return profile.getMessaging().getDefaultRequestHeader().getHeader()
		}
	}

	def dispatch MessageHeader getResponseMessageHeader(AbstractOperation operation, Profile profile) {
		if (operation.getResponseMessageHeader() !== null) {
			return operation.getResponseMessageHeader().getHeader()
		} else {
			return getRequestMessageHeader((operation.eContainer() as Service), profile)
		}
	}

	def dispatch MessageHeader getResponseMessageHeader(ResourceOperation operation, Profile profile) {
		if (operation.getResponseMessageHeader() !== null) {
			return operation.getResponseMessageHeader().getHeader()
		} else {
			return getRequestMessageHeader((operation.eContainer() as Resource), profile)
		}
	}

	def dispatch MessageHeader getPublishMessageHeader(Service service, Profile profile) {
		if (service.getPublishMessageHeader() !== null) {
			return service.getPublishMessageHeader().getHeader()
		} else {
			return profile.getMessaging().getDefaultRequestHeader().getHeader()
		}
	}

	def dispatch MessageHeader getPublishMessageHeader(Resource service, Profile profile) {
		if (service.getPublishMessageHeader() !== null) {
			return service.getPublishMessageHeader().getHeader()
		} else {
			return profile.getMessaging().getDefaultRequestHeader().getHeader()
		}
	}

	def dispatch MessageHeader getPublishMessageHeader(AbstractOperation operation, Profile profile) {
		if (operation.getPublishMessageHeader() !== null) {
			return operation.getPublishMessageHeader().getHeader()
		} else {
			return getRequestMessageHeader((operation.eContainer() as Service), profile)
		}
	}

	def dispatch MessageHeader getPublishMessageHeader(ResourceOperation operation, Profile profile) {
		if (operation.getPublishMessageHeader() !== null) {
			return operation.getPublishMessageHeader().getHeader()
		} else {
			return getRequestMessageHeader((operation.eContainer() as Resource), profile)
		}
	}
}
