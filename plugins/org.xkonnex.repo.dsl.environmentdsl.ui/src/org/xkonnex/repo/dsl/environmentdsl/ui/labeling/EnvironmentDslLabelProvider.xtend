/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.environmentdsl.ui.labeling

import com.google.inject.Inject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import org.xkonnex.repo.dsl.basedsl.baseDsl.Assignment
import org.xkonnex.repo.dsl.basedsl.baseDsl.Import
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.AppServer
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Database
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EJB
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ESB
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ExtensibleConnector
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ExtensibleServer
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Host
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.JMS
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.REST
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.RFC
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SAP
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SOAPHTTP
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SOAPJMS
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.TCP

/** 
 * Provides labels for a EObjects.
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
class EnvironmentDslLabelProvider extends DefaultEObjectLabelProvider {
	@Inject new(AdapterFactoryLabelProvider delegate) {
		super(delegate)
	}

	def String text(SOAPHTTP con) {
		return "=> SOAP / HTTP"
	}

	def String text(SOAPJMS con) {
		return "=> SOAP / JMS"
	}

	def String text(REST con) {
		return "=> REST"
	}

	def String text(EJB con) {
		return "=> EJB"
	}

	def String text(JMS con) {
		return "=> JMS"
	}

	def String text(RFC con) {
		return "=> SAP RFC"
	}

	def String text(TCP con) {
		return "=> TCP"
	}
	
	def String text(ExtensibleConnector con) {
		return '''=> «con.type.simpleName»'''
	}

	def String image(Import ele) {
		return "full/obj16/imp_obj.gif"
	}

	def String image(Environment ele) {
		return "full/obj16/env.gif"
	}

	def String image(Host ele) {
		return "full/obj16/server.gif"
	}

	def String image(AppServer ele) {
		return "full/obj16/servnode.gif"
	}

	def String image(ESB ele) {
		return "full/obj16/servnode.gif"
	}

	def String image(SAP ele) {
		return "full/obj16/servnode.gif"
	}

	def String image(ExtensibleServer ele) {
		return "full/obj16/servnode.gif"
	}

	def String image(Database ele) {
		return "full/obj16/db.gif"
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
}
