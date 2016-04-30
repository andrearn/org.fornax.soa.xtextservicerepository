package org.xkonnex.repo.dsl.bindingdsl.binding;

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.bindingdsl.binding.ModuleContextRootProvider;
import org.xkonnex.repo.dsl.bindingdsl.model.EffectiveBinding;

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

	public abstract String getContextRoot(final EffectiveBinding b);
	
	public abstract String getContextRoot(final ServiceBinding b);

	public abstract String getContextRootByProtocol(final BindingProtocol prot);

}