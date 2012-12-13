package org.fornax.soa.service.ui.hierarchy;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEditorImageUtil;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder;

import com.google.inject.Inject;

/**
 * Label provider for the hierarchy viewers. 
 */
public class HierarchyLabelProvider extends DefaultDescriptionLabelProvider  {

	@Inject
	private IStorage2UriMapper storage2UriMapper;

	@Inject
	private DefaultEditorImageUtil imageUtil;
	
	private boolean useQualifiedNames = true;

	public Object image(IEObjectDescription element) {
		return "full/obj16/" + element.getEClass().getName() + ".gif"; 
	}

	
	public Object text(IEObjectDescription element) {
		StyledString name = new StyledString(element.getQualifiedName().getLastSegment());
		String version = element.getUserData (IEObjectDescriptionBuilder.VERSION_KEY);
		if (version != null) {
			StyledString versionAndState  = new StyledString(" " + version, StyledString.DECORATIONS_STYLER);
			name.append (versionAndState);
		}
		if (element.getQualifiedName().getSegmentCount() > 1) {
			StyledString nsName = new StyledString(" - " + element.getQualifiedName().skipLast(1), StyledString.DECORATIONS_STYLER);
			name.append (nsName);
		}
		return name;
	}


	public boolean getUseQualfiedNames() {
		return useQualifiedNames;
	}


	public void setUseQualfiedNames(boolean on) {
		this.useQualifiedNames = useQualifiedNames;
	}

}
