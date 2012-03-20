package org.fornax.soa.moduledsl.util;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.moduledsl.moduleDsl.ModuleModel;

public class ModuleDslAccess {
	
	public static ModuleModel getModuleModel (EObject o) {
		if (o instanceof ModuleModel)
			return (ModuleModel) o;
		else if (o.eContainer() != null)
			return getModuleModel(o.eContainer());
		else
			return null;
	}

}
