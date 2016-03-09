/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.moduledsl.ui.labeling

import com.google.inject.Inject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import org.xkonnex.repo.dsl.basedsl.baseDsl.Assignment
import org.xkonnex.repo.dsl.basedsl.ui.labeling.BaseDslLabelHelper
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportServiceRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpointProtocol
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.UsingEndpointProtocol
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.NamespaceRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.OperationRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocolConfiguration
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpoint
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef

/** 
 * Provides labels for a EObjects.
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
class ModuleDslLabelProvider extends DefaultEObjectLabelProvider {
	@Inject ILifecycleStateResolver stateResolver

	@Inject new(AdapterFactoryLabelProvider delegate) {
		super(delegate)
	}

	def package Object text(Module mod) {
		var StyledString name = new StyledString(mod.getName())
		var LifecycleState state = stateResolver.getLifecycleState(mod)
		var String stateName = if(state !== null) state.getName() else ""
		var StyledString versionAndState = new StyledString(''' «mod.getVersion().getVersion()» «stateName»''',
			StyledString.DECORATIONS_STYLER)
		name.append(versionAndState)
		return name
	}

	def package String image(Module mod) {
		return "Module.gif"
	}

	def package Object text(ServiceRef s) {
		var StyledString name = new StyledString(s.getService().
			getName())
		var StyledString versionAndState = new StyledString(''' «BaseDslLabelHelper.getVersionConstraint(s.getVersionRef())»''',
			StyledString.DECORATIONS_STYLER)
		name.append(versionAndState)
		return name
	}
	
	def String text (OperationRef ele) {
		ele.operation.name
	}

	def package Object text(ImportServiceRef s) {
		var StyledString name = new StyledString(
			s.getService().
				getName())
				var StyledString versionAndState = new StyledString(''' «BaseDslLabelHelper.getVersionConstraint(s.getVersionRef())»''',
					StyledString.DECORATIONS_STYLER)
				name.append(versionAndState)
				return name
	}

	def package Object text(ModuleRef modRef) {
		var StyledString name = new StyledString(
			modRef.getModuleRef().getModule().
				getName())
				var StyledString versionAndState = new StyledString(''' «BaseDslLabelHelper.getVersionConstraint(modRef.getModuleRef().getVersion())»''',
					StyledString.DECORATIONS_STYLER)
				name.append(versionAndState)
				return name
	}
	
	def String text (NamespaceRef ele) {
		ele.namespace.name
	}
	
	def String image (NamespaceRef ele) {
		return "package_obj.gif"
	}
	
	def String image (Assignment ele) {
		return "assignment.gif"
	}
	
	def Object text (EndpointProtocolConfiguration ele) {
		"Protocol config"
	}
	
	def String image (EndpointProtocolConfiguration ele) {
		"settings_obj.gif"
	}
	
	def String text (UsingEndpointProtocol ele) {
		return ele.type.simpleName
	}
	
	def String image (UsingEndpointProtocol ele) {
		"full/obj16/message_part.gif"
	}
	def String text (ProvidingEndpoint ele) {
		"Providing endpoint"
	}
	
	def String text (EndpointQualifierRef ele) {
		ele.endpointQualifier.name
	}
	
	def String text (ProvidingEndpointProtocol ele) {
		return ele.type.simpleName
	}	
	def String image (ProvidingEndpointProtocol ele) {
		"full/obj16/message_part.gif"
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

	def package String image(ServiceRef svc) {
		return "ServiceExportRef.gif"
	}

	def package String image(ImportServiceRef svc) {
		return "ImportServiceRef.gif"
	}
}
						