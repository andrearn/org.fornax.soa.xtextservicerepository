package org.xkonnex.repo.dsl.moduledsl.model

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpoint
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.model.IEffectiveFeatureInferrer
import org.xkonnex.repo.dsl.moduledsl.query.endpoint.IProvidingEndpointResolver
import org.xkonnex.repo.dsl.moduledsl.query.endpoint.IModuleEndpointProtocolLookup
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleDslPackage
import org.xkonnex.repo.dsl.basedsl.util.JavaBeanMerger
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol

class BottomUpProvidingEndpointBuilder implements IEffectiveProvidingEndpointBuilder {
	
	@Inject 
	private IEffectiveFeatureInferrer featureInferrer
	@Inject 
	private IProvidingEndpointResolver endpointResolver
	@Inject 
	private IModuleEndpointProtocolLookup endpointProtocolLookup
	@Inject 
	private IComponentInferrer componentInferrer
	@Inject
	private JavaBeanMerger beanMerger
	
	override createEffectiveProvidingEndpoint(Operation operation, ProvidingEndpoint endpoint) {
		val protType = componentInferrer.inferComponent(endpoint.endpointProtocol.type)
		val module = EcoreUtil2.getContainerOfType(endpoint, typeof(Module))
		val specEP = endpointResolver.getMostSpecificProvidingEndpointByType(operation, module, protType)
		val epHierarchy = endpointResolver.collectProvidingEndpointHierarchyByType(operation, module, protType)
		val epProtHierarchy = endpointProtocolLookup.collectEndpointProtocolHierarchyByType(operation, module, protType)
		
		var effEndpoint = new EffectiveProvidingEndpoint(specEP)
		var effProt = new EffectiveProvidingEndpointProtocol(specEP.endpointProtocol)
		val IModuleEndpointProtocol mergedProtocol = beanMerger.merge(epProtHierarchy)
		effProt.endpointProtocol = mergedProtocol
		effEndpoint.endpointProtocol = effProt
		effEndpoint.endpointQualifierRef = featureInferrer.inferFeatureValue(epHierarchy, ModuleDslPackage.Literals.ENDPOINT__ENDPOINT_QUALIFIER_REF)
		effEndpoint
	}
	
	override createEffectiveProvidingEndpoint(Service service, ProvidingEndpoint endpoint) {
		val protType = componentInferrer.inferComponent(endpoint.endpointProtocol.type)
		val module = EcoreUtil2.getContainerOfType(endpoint, typeof(Module))
		val specEP = endpointResolver.getMostSpecificProvidingEndpointByType(service, module, protType)
		val epHierarchy = endpointResolver.collectProvidingEndpointHierarchyByType(service, module, protType)
		val epProtHierarchy = endpointProtocolLookup.collectEndpointProtocolHierarchyByType(service, module, protType)
		
		var effEndpoint = new EffectiveProvidingEndpoint(specEP)
		var effProt = new EffectiveProvidingEndpointProtocol(specEP.endpointProtocol)
		val IModuleEndpointProtocol mergedProtocol = beanMerger.merge(epProtHierarchy)
		effProt.endpointProtocol = mergedProtocol
		effEndpoint.endpointProtocol = effProt
		effEndpoint.endpointQualifierRef = featureInferrer.inferFeatureValue(epHierarchy, ModuleDslPackage.Literals.ENDPOINT__ENDPOINT_QUALIFIER_REF)
		effEndpoint
	}
	
}