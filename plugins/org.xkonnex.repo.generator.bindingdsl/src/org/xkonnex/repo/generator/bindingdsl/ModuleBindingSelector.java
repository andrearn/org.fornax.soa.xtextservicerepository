package org.xkonnex.repo.generator.bindingdsl;

import java.util.regex.Pattern;

import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.EndpointQualifierRef;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server;

public class ModuleBindingSelector {
	
	private String name;
	private String targetServerName;
	private String targetEnvironmentName;
	private String endpointQualifier;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTargetServerName() {
		return targetServerName;
	}
	public void setTargetServerName(String targetServerName) {
		this.targetServerName = targetServerName;
	}
	public String getTargetEnvironmentName() {
		return targetEnvironmentName;
	}
	public void setTargetEnvironmentName(String targetEnvironmentName) {
		this.targetEnvironmentName = targetEnvironmentName;
	}
	public String getEndpointQualifier() {
		return endpointQualifier;
	}
	public void setEndpointQualifier(String endpointQualifier) {
		this.endpointQualifier = endpointQualifier;
	}
	
	public boolean matches (ModuleBinding binding, IQualifiedNameProvider qualifiedNameProvider) {
		Server server = binding.getProvServer();
		Environment env = binding.getEnvironment();
		EndpointQualifierRef endpointQualifierRef = binding.getEndpointQualifierRef();
		if (env == null && server != null) {
			env = (Environment)server.eContainer();
		}
		if (server == null && env != null) {
			server = env.getDefaultESB();
		}
		if (name != null && !Pattern.matches(name, binding.getName())) {
			return false;
		}
		if (targetEnvironmentName != null && !Pattern.matches (targetEnvironmentName, qualifiedNameProvider.getFullyQualifiedName(env).toString())) {
			return false;
		}
		if (targetServerName != null && !Pattern.matches (targetServerName, qualifiedNameProvider.getFullyQualifiedName(server).toString())) {
			return false;
		}
		if (endpointQualifier != null && (endpointQualifierRef == null || !Pattern.matches(endpointQualifier, endpointQualifierRef.getEndpointQualifier().getName()))) {
			return false;
		}
		return true;
	}

}
