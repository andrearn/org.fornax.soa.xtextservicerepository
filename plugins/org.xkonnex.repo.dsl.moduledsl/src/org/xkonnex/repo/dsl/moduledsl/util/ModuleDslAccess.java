package org.xkonnex.repo.dsl.moduledsl.util;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleModel;

public class ModuleDslAccess {
	
	public static ModuleModel getModuleModel (EObject o) {
		if (o instanceof ModuleModel)
			return (ModuleModel) o;
		else if (o.eContainer() != null)
			return getModuleModel(o.eContainer());
		else
			return null;
	}
	
	public static Module getOwningModule (EObject o) {
		if (o instanceof Module) {
			return (Module)o;
		} else if (o.eContainer () != null) {
			return getOwningModule (o.eContainer ());
		} else {
			return null;
		}
	}

}
