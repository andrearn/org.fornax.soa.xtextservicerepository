/*
* generated by Xtext
*/
package org.xkonnex.repo.dsl.profiledsl.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.DataType;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.MessageHeader;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ProfileDslLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public ProfileDslLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	
	String image (DataType ele) {
		return "full/obj16/datatype_obj.gif";
	}
	
	String image (MessageHeader ele) {
		return "full/obj16/message_part.gif";
	}

	Object text (org.xkonnex.repo.dsl.profiledsl.profileDsl.Class ele) {
		StyledString name = new StyledString(ele.getName());
		StyledString versionAndState  = new StyledString(" " + ele.getVersion().getVersion() + " " + ele.getState().getName (), StyledString.DECORATIONS_STYLER);
		name.append(versionAndState);
		return name;
	}
	
	String image (org.xkonnex.repo.dsl.profiledsl.profileDsl.Class ele) {
		return "full/obj16/bo_obj.gif";
	}
	
	Object text (org.xkonnex.repo.dsl.profiledsl.profileDsl.Enumeration ele) {
		StyledString name = new StyledString(ele.getName());
		StyledString versionAndState  = new StyledString(" " + ele.getVersion().getVersion() + " " + ele.getState().getName (), StyledString.DECORATIONS_STYLER);
		name.append(versionAndState);
		return name;
	}
	String image (org.xkonnex.repo.dsl.profiledsl.profileDsl.Enumeration ele) {
		return "full/obj16/enum_obj.gif";
	}
}