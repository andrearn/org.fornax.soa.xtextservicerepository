/*
 * based on Xtext findrefs components
 */
package org.fornax.soa.servicerepo.ui.search.dialog;

import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.label.GlobalDescriptionLabelProvider;

import com.google.inject.Inject;

public class ServiceRepositorySearchResultLabelProvider extends org.eclipse.jface.viewers.LabelProvider {

	@Inject
	private GlobalDescriptionLabelProvider globalDescriptionProvider; 
	
	@Override
	public String getText(Object element) {
		if (element instanceof ServiceRepositorySearchViewTreeNode) {
			return globalDescriptionProvider.getText(((ServiceRepositorySearchViewTreeNode) element).getLabelDescription());
		}
		return ServiceRepositorySearchMessages.ServiceRepositorySearchResultLabelProvider_invalid;
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof ServiceRepositorySearchViewTreeNode) {
			return globalDescriptionProvider.getImage(((ServiceRepositorySearchViewTreeNode) element).getLabelDescription());
		}
		return null;
	}
}