/*
* generated by Xtext
*/
package org.xkonnex.repo.dsl.businessdsl.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.xkonnex.repo.dsl.basedsl.ui.labeling.BaseDslLabelHelper;
import org.xkonnex.repo.dsl.businessdsl.businessDsl.Capability;
import org.xkonnex.repo.dsl.businessdsl.businessDsl.CapabilityGroup;
import org.xkonnex.repo.dsl.businessdsl.businessDsl.CapabilityRef;
import org.xkonnex.repo.dsl.businessdsl.businessDsl.CapabilityVariation;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class BusinessDslLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public BusinessDslLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

/*
	//Labels and icons can be computed like this:
	
	String text(MyModel ele) {
	  return "my "+ele.getName();
	}
	 
    String image(MyModel ele) {
      return "MyModel.gif";
    }
*/
	
	String image (Capability cap) {
		return "Capability.gif";
	}

	String image (CapabilityGroup cap) {
		return "CapabilityGroup.gif";
	}
	
	String text(CapabilityVariation var) {
		return "~ " + var.getVarying().getCapability().getName() + BaseDslLabelHelper.getVersionConstraint (var.getVarying().getVersionRef());
	}
	
	String text (CapabilityRef ref) {
		return "-> " + ref.getCapability().getName() + BaseDslLabelHelper.getVersionConstraint(ref.getVersionRef());
	}
	
}
