package org.fornax.soa.service.ui.hierarchy;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;

public class ToggleViewAction extends Action {

	public static final String ORG_FORNAX_SOA_SERVICEDSL_HIERARCHY_TOGGLEVIEW = "org.fornax.soa.servicedsl.hierarchy.toggleview";
	private TypeHierarchyViewPart fViewPart;
	private int fViewerIndex;
	
	public ToggleViewAction(TypeHierarchyViewPart v, int viewerIndex) {
		super("", AS_RADIO_BUTTON); //$NON-NLS-1$
		if (viewerIndex == TypeHierarchyViewPart.HIERARCHY_MODE_SUPERTYPES) {
			setText (EObjectDescrHierarchyMessages.ToggleViewAction_supertypes_label);
			setDescription (EObjectDescrHierarchyMessages.ToggleViewAction_supertypes_description);
			setToolTipText (EObjectDescrHierarchyMessages.ToggleViewAction_supertypes_tooltip);
		} else if (viewerIndex == TypeHierarchyViewPart.HIERARCHY_MODE_SUBTYPES) {
			setText (EObjectDescrHierarchyMessages.ToggleViewAction_subtypes_label);
			setDescription (EObjectDescrHierarchyMessages.ToggleViewAction_subtypes_description);
			setToolTipText (EObjectDescrHierarchyMessages.ToggleViewAction_subtypes_tooltip);
		} else if (viewerIndex == TypeHierarchyViewPart.HIERARCHY_MODE_CLASSIC) {
			setText (EObjectDescrHierarchyMessages.ToggleViewAction_vajhierarchy_label);
			setDescription (EObjectDescrHierarchyMessages.ToggleViewAction_vajhierarchy_description);
			setToolTipText (EObjectDescrHierarchyMessages.ToggleViewAction_vajhierarchy_tooltip);
		} else {
			Assert.isTrue(false);
		}

		fViewPart= v;
		fViewerIndex= viewerIndex;
		setActionDefinitionId(ORG_FORNAX_SOA_SERVICEDSL_HIERARCHY_TOGGLEVIEW);
	}

	public int getViewerIndex() {
		return fViewerIndex;
	}

	/*
	 * @see Action#actionPerformed
	 */
	@Override
	public void run() {
		fViewPart.setHierarchyMode(fViewerIndex);
	}
}
