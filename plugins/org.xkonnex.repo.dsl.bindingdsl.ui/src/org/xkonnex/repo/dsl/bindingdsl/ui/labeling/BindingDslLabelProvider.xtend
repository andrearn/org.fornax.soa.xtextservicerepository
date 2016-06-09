/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.bindingdsl.ui.labeling

import com.google.inject.Inject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import org.xkonnex.repo.dsl.basedsl.baseDsl.Assignment
import org.xkonnex.repo.dsl.basedsl.ui.labeling.BaseDslLabelHelper
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AccuracyAssertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AuthenticationPolicy
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AvailabilityAssertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.CapacityAssertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ChannelBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.CostAssertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.EncryptionPolicy
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.LatencyAssertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.LogPolicy
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.OperationBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.PredefinedAssertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ReliabilityAssertion
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SigningPolicy
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.AMQP
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.EJB
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.FILE
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.FTP
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.HTTP
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.IIOP
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.JMS
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.REST
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.SCA
import org.xkonnex.repo.dsl.bindingdsl.util.BindingDslHelper
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SAP
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace

/** 
 * Provides labels for a EObjects.
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
class BindingDslLabelProvider extends DefaultEObjectLabelProvider {
	@Inject package EnvironmentBindingResolver envBindResolver

	@Inject new(AdapterFactoryLabelProvider delegate) {
		super(delegate)
	}

	def String image(Binding ele) {
		return "full/obj16/messageexchange.gif"
	}

	def String text(ModuleBinding m) {
		return '''«m.getModule().getModule().getName()» -> «envBindResolver.resolveEnvironment(m).getName()»'''
	}

	def String text(ServiceBinding ele) {
		return '''«ele.getService().getService().getName()» «BaseDslLabelHelper.getVersionConstraint(ele.getService().getVersionRef())»'''
	}
	
	def String text(ChannelBinding ele) {
		return '''«ele.channel.name»'''
	}
	
	def String text(OperationBinding ele) {
		return '''«ele.operation.name»'''
	}
	
	def String text(SOAP ele) {
		var Server server = envBindResolver.resolveServer(ele)
		if(server !== null) return '''SOAP -> «server.getName()»''' else return "SOAP"
	}
	def String text(REST ele, ExtensibleProtocol prot) {
		var Server server = envBindResolver.resolveServer(prot)
		if(server !== null) return '''REST -> «server.getName()»''' else return "REST"
	}
	def String text(HTTP ele, ExtensibleProtocol prot) {
		var Server server = envBindResolver.resolveServer(prot)
		if(server !== null) return '''HTTP -> «server.getName()»''' else return "HTTP"
	}
	def String text(FTP ele, ExtensibleProtocol prot) {
		var Server server = envBindResolver.resolveServer(prot)
		if(server !== null) return '''FTP -> «server.getName()»''' else return "FTP"
	}
	def String text(FILE ele, ExtensibleProtocol prot) {
		var Server server = envBindResolver.resolveServer(prot)
		if(server !== null) return '''File -> «server.getName()»''' else return "File"
	}
	def String text(JMS ele, ExtensibleProtocol prot) {
		var Server server = envBindResolver.resolveServer(prot)
		if(server !== null) return '''JMS -> «server.getName()»''' else return "JMS"
	}
	def String text(IIOP ele, ExtensibleProtocol prot) {
		var Server server = envBindResolver.resolveServer(prot)
		if(server !== null) return '''IIOP -> «server.getName()»''' else return "IIOP"
	}
	def String text(AMQP ele, ExtensibleProtocol prot) {
		var Server server = envBindResolver.resolveServer(prot)
		if(server !== null) return '''AMQP -> «server.getName()»''' else return "AMQP"
	}
	def String text(SCA ele, ExtensibleProtocol prot) {
		var Server server = envBindResolver.resolveServer(prot)
		if(server !== null) return '''SCA -> «server.getName()»''' else return "SCA"
	}

	def String text(org.xkonnex.repo.dsl.bindingdsl.ext.protocol.SAP ele) {
		var String clientText = null
		if (ele.getClient() !== null) {
			var SAP sapServer = (ele.getClient().
				eContainer() as SAP)
			clientText = sapServer.getName() + ele.getClient().getClient()
		}
		if(clientText !== null) return '''SAP -> «clientText»''' else return "SAP"
	}

	def String text(EJB ele, ExtensibleProtocol prot) {
		var Server server = envBindResolver.resolveServer(prot)
		var StringBuffer label = new StringBuffer("EJB")
		var SubNamespace ns = BindingDslHelper.getSubNamespace(prot)
		if (server === null) {
			var Environment env = envBindResolver.resolveEnvironment(prot)
			if(ns instanceof DomainNamespace) server = env.getDefaultESB() else server = env.getDefaultAppServer()
		}
		if(server !== null) label.append(''' -> «server.getName()»''')
		if (ele.getJndiName() !== null) {
			var String[] jndiNameParts = ele.getJndiName().split("/")
			if(jndiNameParts.length > 0) label.
				append('''/«{val _rdIndx_jndiNameParts=jndiNameParts.length - 1 jndiNameParts.get(_rdIndx_jndiNameParts)}»''')
		}
		return label.toString()
	}

	def String text(ExtensibleProtocol ele) {
		var Server server = envBindResolver.resolveServer(ele)
		var JvmType protocolType = ele.getType()
		if(server !== null) return '''«protocolType.getSimpleName()» -> «server.getName()»''' else return protocolType.
			getSimpleName()
	}

	def String text(Assignment ele) {
		var JvmIdentifiableElement feature = ele.getFeature()
		if (feature !== null) {
			var String featureName = feature.getSimpleName()
			if (featureName.startsWith("set") || featureName.startsWith("add")) {
				return featureName.substring(3).toFirstLower
			} else {
				return featureName
			}
		} else {
			return "Unnamed"
		}
	}
	
	def Object text(LogPolicy ele) {
		return '''Log policy «ele.logPolicy.literal»'''
	}
	
	def Object text(AuthenticationPolicy ele) {
		if (ele.name != null) {
			return ele.name			
		} else {
			return "Authentication policy"
		}
	}
	
	def Object text(SigningPolicy ele) {
		return '''Signing policy «ele.requiredSigningAlgorithm?.name»'''
	}
	
	def Object text(EncryptionPolicy ele) {
		return '''Encryption policy «ele.requiredCipherAlgorithm?.name»'''
	}

	def Object text(AvailabilityAssertion ele) {
		return "Availability assertion"
	}
	def Object text(LatencyAssertion ele) {
		return "Latency assertion"
	}
	def Object text(CapacityAssertion ele) {
		return "Encryption assertion"
	}
	def Object text(ReliabilityAssertion ele) {
		return "Capacity assertion"
	}
	def Object text(CostAssertion ele) {
		return "Costs assertion"
	}
	def Object text(AccuracyAssertion ele) {
		return "Accuracy assertion"
	}
	def Object text(PredefinedAssertion ele) {
		return ele.assertion?.name
	}
	
	def package String image(ServiceBinding ele) {
		return "full/obj16/invoke.gif"
	}

	def package String image(BindingProtocol ele) {
		return "full/obj16/message_part.gif"
	}

	def package String image(SOAP ele) {
		return "full/obj16/message_part.gif"
	}

	def package String image(org.xkonnex.repo.dsl.bindingdsl.ext.protocol.SAP ele) {
		return "full/obj16/message_part.gif"
	}
}
