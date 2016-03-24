package org.xkonnex.repo.dsl.moduledsl.query;

import java.util.List;

import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.OperationRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultModuleOperationResolver.class)
public interface IModuleOperationResolver {
	
	public List<OperationRef> getAllProvidedOperationRefs(Module module);
	public List<Operation> getAllProvidedOperations(Module module);

}
