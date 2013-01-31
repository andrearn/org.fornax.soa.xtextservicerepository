package org.fornax.soa.service.ui.hierarchy;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;

public class FocusOnSelectionAction extends Action {

	private static final String ORG_FORNAX_SOA_SERVICEDSL_HIERARCHY_FOCUSONSELECTION = "org.fornax.soa.servicedsl.hierarchy.focusonselection";
	private TypeHierarchyViewPart fViewPart;

	public FocusOnSelectionAction(TypeHierarchyViewPart part) {
		super(EObjectDescrHierarchyMessages.FocusOnSelectionAction_label);
		setDescription(EObjectDescrHierarchyMessages.FocusOnSelectionAction_description);
		setToolTipText(EObjectDescrHierarchyMessages.FocusOnSelectionAction_tooltip);
		setActionDefinitionId(ORG_FORNAX_SOA_SERVICEDSL_HIERARCHY_FOCUSONSELECTION);
		fViewPart= part;

	}

	
	private ISelection getSelection() {
		ISelectionProvider provider= fViewPart.getSite().getSelectionProvider();
		if (provider != null) {
			return provider.getSelection();
		}
		return null;
	}
}
