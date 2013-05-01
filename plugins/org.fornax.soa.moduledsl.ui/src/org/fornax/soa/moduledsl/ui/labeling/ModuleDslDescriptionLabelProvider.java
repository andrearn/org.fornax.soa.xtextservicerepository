/*
* generated by Xtext
*/
package org.fornax.soa.moduledsl.ui.labeling;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

/**
 * Provides labels for a IEObjectDescriptions and IResourceDescriptions.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ModuleDslDescriptionLabelProvider extends DefaultDescriptionLabelProvider {

/*
	//Labels and icons can be computed like this:
	
	String text(IEObjectDescription ele) {
	  return "my "+ele.getName();
	}
	 
    String image(IEObjectDescription ele) {
      return ele.getEClass().getName() + ".gif";
    }	 
*/
	
	public Object text(IEObjectDescription ele) {
		StyledString s = new StyledString (ele.getQualifiedName().toString());
		if (ele.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY) != null) {
			s.append(" v");
			s.append (ele.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY));
		}
		s.append (" - ");
		s.append (ele.getEClass().getName());
		return s;
	}

	public String image (IEObjectDescription ele) {
		if (ele.getEClass ().isSuperTypeOf (ModuleDslPackage.Literals.MODULE)) {
			return "Module.gif";
		} else if (ele.getEClass ().isSuperTypeOf (ModuleDslPackage.Literals.SERVICE_REF)) {
			return "ServiceExportRef.gif";
		} else if (ele.getEClass ().isSuperTypeOf (ModuleDslPackage.Literals.IMPORT_SERVICE_REF)) {
			return "ImportServiceRef.gif";
		} else {
			return null;
		}
	}

}
