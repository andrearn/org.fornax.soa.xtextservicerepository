package org.fornax.soa.binding;

import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.moduledsl.moduleDsl.Module;

import com.google.inject.ImplementedBy;

@ImplementedBy(ModuleContextRootProvider.class)
public interface IContextRootProvider {

	public abstract String getContextRoot(final Module mod,
			final String serverTypeName, final BindingProtocol prot);

	public abstract String getContextRoot(final Module mod,
			final String serverTypeName, final String serverVersion,
			final BindingProtocol prot);

	public abstract String getCtxRootByAssemblyType(final Module mod,
			final String serverType);

	public abstract String getCtxRootByAssemblyType(final Module mod,
			final String serverType, final String serverVersion);

	public abstract String getContextRoot(final ServiceBinding b);

	public abstract String getContextRootByProtocol(final BindingProtocol prot);

}