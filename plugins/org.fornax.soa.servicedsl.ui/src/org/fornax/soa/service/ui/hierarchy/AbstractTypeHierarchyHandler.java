package org.fornax.soa.service.ui.hierarchy;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Derived from AbstractTypeHierarchyHandler in Xbase
 */
public abstract class AbstractTypeHierarchyHandler extends AbstractHandler {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	@Inject
	protected Injector injector;

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
		if (editor != null) {
			final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
			IUnitOfWork<Void, XtextResource> unitOfWork = new IUnitOfWork<Void, XtextResource>() {
				public java.lang.Void exec(XtextResource resource) throws Exception {
					EObject selectedElement = eObjectAtOffsetHelper.resolveElementAt(resource, selection.getOffset());
					if (selectedElement != null) {
						openPresentation(editor, selectedElement);
					}
					return null;
				}

			};
			editor.getDocument().readOnly(unitOfWork);
		}
		return null;
	}

	protected abstract void openPresentation(final XtextEditor editor, final EObject selectedElement);

}
