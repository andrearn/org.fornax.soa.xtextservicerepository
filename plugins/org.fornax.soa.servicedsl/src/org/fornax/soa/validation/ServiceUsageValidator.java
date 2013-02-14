package org.fornax.soa.validation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.validation.Check;
import org.fornax.soa.service.query.ServiceQueries;
import org.fornax.soa.service.validation.version.AbstractServiceDslVersionValidator;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceDslPackage;

import com.google.inject.Inject;

public class ServiceUsageValidator extends AbstractServiceDslVersionValidator {
	
	@Inject 
	private ServiceQueries svcQueries;
	@Inject
	IQualifiedNameProvider nameProvider;

	@Check
	public void checkServiceIsUsed (Service service) {
		List<EObject> allConsumers = svcQueries.findAllServiceConsumers(service);
		if (allConsumers.isEmpty()) {
			warning("The service " + nameProvider.getFullyQualifiedName(service) + " version " +service.getVersion().getVersion() +" is not being used by a service or solution.", ServiceDslPackage.Literals.SERVICE__NAME);
		}
	}
}
