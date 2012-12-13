

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.information.IInformationProvider;
import org.eclipse.jface.text.information.IInformationProviderExtension;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class EObjectElementProvider implements IInformationProvider, IInformationProviderExtension  {
	
	private XtextEditor _editor;
	
	@Inject
	ILocationInFileProvider _locationProvider;

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private Injector injector;

	public EObjectElementProvider(IEditorPart editor) {
		if (editor instanceof XtextEditor)
			_editor = (XtextEditor)editor;
	}

	public EObjectElementProvider(IEditorPart editor, EObject selectedElement) {
		if (editor instanceof XtextEditor)
			_editor = (XtextEditor)editor;
	}

	public Object getInformation2(ITextViewer textViewer, IRegion subject) {
		if (_editor == null)
			return null;

		final ITextSelection selection = (ITextSelection) _editor.getSelectionProvider().getSelection();
		EObject element = _editor.getDocument().readOnly (new IUnitOfWork<EObject, XtextResource>() {
			public EObject exec (XtextResource resource) throws Exception {
				EObject selectedElement = eObjectAtOffsetHelper.resolveElementAt (resource, selection.getOffset());
				return selectedElement;
			}
		});
		return element;

	}

	public IRegion getSubject(ITextViewer textViewer, int offset) {
		if (textViewer != null && _editor != null) {
			IRegion region = null;
			try {
				region = _editor.getDocument().getLineInformationOfOffset(offset);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (region != null)
				return region;
			else
				return new Region(offset, 0);
		}
		return null;
	}

	public String getInformation (ITextViewer textViewer, IRegion subject) {
		return getInformation2(textViewer, subject).toString();
	}
}
