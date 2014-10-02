package org.xkonnex.repo.dsl.servicedsl.service.ui.hierarchy;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.custom.BusyIndicator;

public class ShowQualifiedTypeNamesAction extends Action {

	private static final String ORG_FORNAX_SOA_SERVICEDSL_HIERARCHY_SHOWQUALIFIEDTYPENAMES = "org.xkonnex.repo.dsl.semanticsdsl.servicedsl.hierarchy.showqualifiedtypenames";
	private TypeHierarchyViewPart fView;

	public ShowQualifiedTypeNamesAction(
			TypeHierarchyViewPart v, boolean initValue) {
		
		super(EObjectDescrHierarchyMessages.ShowQualifiedTypeNamesAction_label);
		setDescription(EObjectDescrHierarchyMessages.ShowQualifiedTypeNamesAction_description);
		setToolTipText(EObjectDescrHierarchyMessages.ShowQualifiedTypeNamesAction_tooltip);
		setActionDefinitionId(ORG_FORNAX_SOA_SERVICEDSL_HIERARCHY_SHOWQUALIFIEDTYPENAMES);

		fView= v;
		setChecked(initValue);

	}

	/*
	 * @see Action#actionPerformed
	 */
	@Override
	public void run() {
		BusyIndicator.showWhile(fView.getSite().getShell().getDisplay(), new Runnable() {
			public void run() {
				fView.showQualifiedTypeNames(isChecked());
			}
		});
	}

}
