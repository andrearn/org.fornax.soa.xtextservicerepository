/*
* generated by Xtext
*/
package org.fornax.soa.ui.labeling;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;

/**
 * Provides labels for a IEObjectDescriptions and IResourceDescriptions.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ServiceDslDescriptionLabelProvider extends DefaultDescriptionLabelProvider {


	public Object text(IEObjectDescription ele) {
		StyledString s = new StyledString (ele.getQualifiedName().toString());
		if (ele.getUserData(VersionedResourceDescriptionStrategy.VERSION_KEY) != null) {
			s.append(" v");
			s.append (ele.getUserData(VersionedResourceDescriptionStrategy.VERSION_KEY));
		}
		s.append (" - ");
		s.append (ele.getEClass().getName());
		if (ele.getUserData(VersionedResourceDescriptionStrategy.STATE_KEY) != null) {
			s.append(" ");
			s.append (ele.getUserData(VersionedResourceDescriptionStrategy.STATE_KEY), StyledString.DECORATIONS_STYLER);
		}
		return s;
	}
	
	public String image(IEObjectDescription description) {
		return "full/obj16/" + description.getEClass().getName() + ".gif"; 
	}

}
