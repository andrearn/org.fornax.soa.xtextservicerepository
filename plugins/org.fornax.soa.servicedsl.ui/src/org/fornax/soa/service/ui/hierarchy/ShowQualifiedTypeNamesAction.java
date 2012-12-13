package org.fornax.soa.service.ui.hierarchy;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.custom.BusyIndicator;

public class ShowQualifiedTypeNamesAction extends Action {

	private TypeHierarchyViewPart fView;

	public ShowQualifiedTypeNamesAction(
			TypeHierarchyViewPart v, boolean initValue) {
		super(EObjectDescrHierarchyMessages.ShowQualifiedTypeNamesAction_label);
		setDescription(EObjectDescrHierarchyMessages.ShowQualifiedTypeNamesAction_description);
		setToolTipText(EObjectDescrHierarchyMessages.ShowQualifiedTypeNamesAction_tooltip);


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
