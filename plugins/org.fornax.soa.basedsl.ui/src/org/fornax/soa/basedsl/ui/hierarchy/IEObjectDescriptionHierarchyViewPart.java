package org.fornax.soa.basedsl.ui.hierarchy;

import org.eclipse.xtext.resource.IEObjectDescription;

public interface IEObjectDescriptionHierarchyViewPart {
	
	public IEObjectDescription getInputElement ();
	public void showQualifiedTypeNames(boolean enabled);
	public boolean isQualifiedTypeNamesEnabled();
	public boolean isLinkingEnabled();
	public void setLinkingEnabled(boolean enabled);


}
