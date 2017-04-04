package org.xkonnex.repo.dsl.servicedsl.validation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.validation.Check;
import org.xkonnex.repo.dsl.servicedsl.service.query.ServiceQueries;
import org.xkonnex.repo.dsl.servicedsl.service.validation.version.AbstractServiceDslVersionValidator;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage;

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

	@Check
	public void checkResourceIsUsed (Resource service) {
		List<EObject> allConsumers = svcQueries.findAllResourceConsumers(service);
		if (allConsumers.isEmpty()) {
			warning("The resource " + nameProvider.getFullyQualifiedName(service) + " version " +service.getVersion().getVersion() +" is not being used by a service or solution.", ServiceDslPackage.Literals.SERVICE__NAME);
		}
	}
}
