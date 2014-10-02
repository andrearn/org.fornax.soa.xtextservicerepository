package org.xkonnex.repo.dsl.servicedsl.service.ui.hierarchy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.AbstractInformationControlManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.information.IInformationProvider;
import org.eclipse.jface.text.information.InformationPresenter;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;
import org.xkonnex.repo.dsl.servicedsl.service.ui.EObjectElementProvider;

import com.google.inject.Inject;
import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class QuickTypeHierarchyHandler extends AbstractTypeHierarchyHandler {

	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	@Inject
	private IQualifiedNameProvider nameProvider;
	
	@Inject
	private Injector injector;

	@Override
	protected void openPresentation (final XtextEditor editor,
			final EObject selectedElement) {
		
		final ISourceViewer sourceViewer = editor.getInternalSourceViewer ();
		InformationPresenter presenter = new HierarchyInformationPresenter (
				getHierarchyPresenterControlCreator (), sourceViewer,
				selectedElement);
		injector.injectMembers(presenter);
		presenter
				.setDocumentPartitioning (IDocumentExtension3.DEFAULT_PARTITIONING);
		presenter.setAnchor (AbstractInformationControlManager.ANCHOR_GLOBAL);
		//FIXME use my search
		IInformationProvider provider = new EObjectElementProvider (editor);
		injector.injectMembers(provider);
		
		presenter.setInformationProvider (provider,
				IDocument.DEFAULT_CONTENT_TYPE);
		presenter.setInformationProvider (provider,
				"__XSR");
		
		presenter.setSizeConstraints (50, 20, true, false);
		presenter.install (sourceViewer);
		presenter.showInformation ();

	}

	private IInformationControlCreator getHierarchyPresenterControlCreator () {
		return new IInformationControlCreator () {
			public IInformationControl createInformationControl (Shell parent) {
				int shellStyle = SWT.RESIZE;
				int treeStyle = SWT.V_SCROLL | SWT.H_SCROLL;
				HierarchyInformationControl hierarchyInformationControl = new HierarchyInformationControl (
						parent, shellStyle, treeStyle, injector);
				return hierarchyInformationControl;
			}
		};
	}

	protected final class HierarchyInformationPresenter extends
			InformationPresenter {
		private final ISourceViewer sourceViewer;
		private final EObject selectedElement;

		protected HierarchyInformationPresenter(
				IInformationControlCreator creator, ISourceViewer sourceViewer,
				EObject selectedElement) {
			super (creator);
			this.sourceViewer = sourceViewer;
			this.selectedElement = selectedElement;
		}

		@Override
		protected void computeInformation () {
			setCustomInformationControlCreator (null);
			ITextRegion significantRegion = locationInFileProvider
					.getSignificantTextRegion (selectedElement);
			setInformation (selectedElement /*nameProvider.getFullyQualifiedName (selectedElement).getLastSegment ()*/,
					computeArea (new Region (significantRegion.getOffset (),
							significantRegion.getLength ())));
			presentInformation ();
		}

		// copied from org.eclipse.jface.text.information.InformationPresenter
		// due to visibility problems
		protected Rectangle computeArea (IRegion region) {

			int start = 0;
			int end = 0;

			IRegion widgetRegion = modelRange2WidgetRange (region);
			if (widgetRegion != null) {
				start = widgetRegion.getOffset ();
				end = widgetRegion.getOffset () + widgetRegion.getLength ();
			}

			StyledText styledText = sourceViewer.getTextWidget ();
			Rectangle bounds;
			if (end > 0 && start < end)
				bounds = styledText.getTextBounds (start, end - 1);
			else {
				Point loc = styledText.getLocationAtOffset (start);
				bounds = new Rectangle (loc.x, loc.y, 0,
						styledText.getLineHeight (start));
			}

			return bounds;
		}

		// copied from org.eclipse.jface.text.information.InformationPresenter
		// due to visibility problems
		protected IRegion modelRange2WidgetRange (IRegion region) {
			if (sourceViewer instanceof ITextViewerExtension5) {
				ITextViewerExtension5 extension = (ITextViewerExtension5) sourceViewer;
				return extension.modelRange2WidgetRange (region);
			}

			IRegion visibleRegion = sourceViewer.getVisibleRegion ();
			int start = region.getOffset () - visibleRegion.getOffset ();
			int end = start + region.getLength ();
			if (end > visibleRegion.getLength ())
				end = visibleRegion.getLength ();

			return new Region (start, end - start);
		}
	}
}
