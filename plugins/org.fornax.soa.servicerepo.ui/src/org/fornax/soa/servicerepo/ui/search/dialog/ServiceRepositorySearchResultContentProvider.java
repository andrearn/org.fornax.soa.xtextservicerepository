/*
 * based on Xtext findrefs components
 */
package org.fornax.soa.servicerepo.ui.search.dialog;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.StatefulResourceDescription;
import org.fornax.soa.servicerepo.ui.search.EObjectSearchResult;
import org.fornax.soa.servicerepo.ui.search.EObjectSearchResultEvents.Added;
import org.fornax.soa.servicerepo.ui.search.EObjectSearchResultEvents.Reset;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class ServiceRepositorySearchResultContentProvider implements ITreeContentProvider, ISearchResultListener,
		IResourceDescription.Event.Listener {

	private IResourceDescriptions resourceDescriptions;

	private List<ServiceRepositorySearchViewTreeNode> rootNodes;

	private TreeViewer viewer;

	private List<SearchResultEvent> batchedSearchResultEvents;

	private volatile boolean isUIUpdateScheduled;

	@Inject
	public ServiceRepositorySearchResultContentProvider(IResourceDescriptions resourceDescriptions) {
		batchedSearchResultEvents = Lists.newArrayList();
		this.resourceDescriptions = resourceDescriptions;
		if (resourceDescriptions instanceof IResourceDescription.Event.Source) {
			((IResourceDescription.Event.Source) resourceDescriptions).addListener(this);
		}
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof ServiceRepositorySearchViewTreeNode) {
			return Iterables.toArray(((ServiceRepositorySearchViewTreeNode) parentElement).getChildren(),
					ServiceRepositorySearchViewTreeNode.class);
		}
		return null;
	}

	public Object getParent(Object element) {
		if (element instanceof ServiceRepositorySearchViewTreeNode) {
			return ((ServiceRepositorySearchViewTreeNode) element).getParent();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof ServiceRepositorySearchViewTreeNode) {
			return !((ServiceRepositorySearchViewTreeNode) element).getChildren().isEmpty();
		}
		return false;
	}

	public Object[] getElements(Object inputElement) {
		if (rootNodes == null || rootNodes.isEmpty()) {
			return new Object[0];
		}
		return Iterables.toArray(rootNodes, ServiceRepositorySearchViewTreeNode.class);
	}

	public void dispose() {
		rootNodes = null;
	}

	public void inputChanged(final Viewer viewer, Object oldInput, Object newInput) {
		synchronized (viewer) {
			if (rootNodes != null) {
				rootNodes.clear();
			}
			if (oldInput instanceof EObjectSearchResult) {
				((EObjectSearchResult) oldInput).removeListener(this);
			}
			if (newInput instanceof EObjectSearchResult && viewer instanceof TreeViewer) {
				((EObjectSearchResult) newInput).addListener(this);
				this.viewer = (TreeViewer) viewer;
				for (IEObjectDescription referenceDescription : ((EObjectSearchResult) newInput)
						.getMatchingObjects()) {
					addReference(referenceDescription, false);
				}
			}
		}
	}

	
	private void addReference(IEObjectDescription referenceDescription, boolean isUpdateViewer) {
		//TODO FIXME containerEObjectURI
		URI containerEObjectURI = referenceDescription.getEObjectURI();
		final URI eObjectURI = (containerEObjectURI == null) ? referenceDescription.getEObjectURI()
				: containerEObjectURI;
		IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(eObjectURI
				.trimFragment());
		if (resourceDescription != null) {
			ServiceRepositorySearchViewTreeNode resourceNode = resourceNode(resourceDescription, isUpdateViewer);
			ServiceRepositorySearchViewTreeNode referenceNode = null;
			for (IEObjectDescription eObjectDescription : resourceDescription.getExportedObjects()) {
				if (eObjectDescription.getEObjectURI().equals(eObjectURI)) {
					referenceNode = new ServiceRepositorySearchViewTreeNode(resourceNode, referenceDescription,
							eObjectDescription);
					break;
				}
			}
			if (referenceNode == null)
				referenceNode = new ServiceRepositorySearchViewTreeNode(resourceNode, referenceDescription,
						referenceDescription);
		}
	}

	private ServiceRepositorySearchViewTreeNode resourceNode(IResourceDescription resourceDescription, boolean isUpdateViewer) {
		if (rootNodes == null) {
			rootNodes = Lists.newArrayList();
		}
		for (ServiceRepositorySearchViewTreeNode node : rootNodes) {
			Object nodeDescription = node.getDescription();
			if (nodeDescription instanceof IResourceDescription) {
				if (((IResourceDescription) nodeDescription).getURI().equals(resourceDescription.getURI())) {
					return node;
				}
			}
		}
		ServiceRepositorySearchViewTreeNode node = new ServiceRepositorySearchViewTreeNode(null, resourceDescription,
				resourceDescription);
		rootNodes.add(node);
		if (isUpdateViewer) {
			viewer.add(viewer.getInput(), node);
		}
		return node;
	}

	public void searchResultChanged(final SearchResultEvent e) {
		synchronized (batchedSearchResultEvents) {
			batchedSearchResultEvents.add(e);
		}
		if (!isUIUpdateScheduled) {
			isUIUpdateScheduled = true;
			new UIUpdater().schedule();
		}
	}

	private class UIUpdater extends UIJob {

		public UIUpdater() {
			super(ServiceRepositorySearchMessages.ServiceRepositorySearchResultContentProvider_label);
			setSystem(true);
		}

		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {
			isUIUpdateScheduled = false;
			List<SearchResultEvent> events;
			synchronized (batchedSearchResultEvents) {
				events = Lists.newArrayList(batchedSearchResultEvents);
				batchedSearchResultEvents.clear();
			}
			SubMonitor progress = SubMonitor.convert(monitor, events.size());
			for (SearchResultEvent event : events) {
				if (event instanceof Added) {
					addReference(((Added) event).getEObjectDescription(), true);
				} else if (event instanceof Reset) {
					if (rootNodes != null && !rootNodes.isEmpty()) {
						synchronized (viewer) {
							viewer.remove(viewer.getInput(),
									Iterables.toArray(rootNodes, ServiceRepositorySearchViewTreeNode.class));
							rootNodes = null;
						}
					}
				}
				progress.worked(1);
			}
			viewer.refresh();
			viewer.expandToLevel(1);
			return Status.OK_STATUS;
		}
	}

	public void descriptionsChanged(final Event event) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if (rootNodes != null) {
					for (Delta delta : event.getDeltas()) {
						if (!(delta.getNew() instanceof StatefulResourceDescription)) {
							for (Iterator<ServiceRepositorySearchViewTreeNode> i = rootNodes.iterator(); i.hasNext();) {
								ServiceRepositorySearchViewTreeNode rootNode = i.next();
								if (((IResourceDescription) rootNode.getDescription()).getURI().equals(delta.getUri())) {
									if (delta.getNew() == null) {
										i.remove();
										viewer.remove(rootNode);
										break;
									} else {
										Iterable<IEObjectDescription> exportedEObjectDescriptions = delta.getNew()
												.getExportedObjects ();
										List<ServiceRepositorySearchViewTreeNode> removedEObjectNodes = Lists.newArrayList();
										for (ServiceRepositorySearchViewTreeNode eObjectNode : rootNode.getChildren()) {
											final URI eObjectURI = ((IEObjectDescription) eObjectNode
													.getDescription()).getEObjectURI ();
											if (Iterables.isEmpty(Iterables.filter(exportedEObjectDescriptions,
													new Predicate<IEObjectDescription>() {
														public boolean apply(IEObjectDescription input) {
															return input.getEObjectURI ().equals(
																	eObjectURI);
														}
													}))) {
												removedEObjectNodes.add(eObjectNode);
											}
										}
										for (ServiceRepositorySearchViewTreeNode removedReferenceNode : removedEObjectNodes) {
											rootNode.removeChild(removedReferenceNode);
										}
										if (rootNode.getChildren().isEmpty()) {
											i.remove();
											viewer.remove(rootNode);
											break;
										} else {
											viewer.remove(rootNode, Iterables.toArray(removedEObjectNodes,
													ServiceRepositorySearchViewTreeNode.class));
										}
									}
								}
							}
						}
					}
				}
			}
		});
	}
	
	public void clear() {
		viewer.refresh();
	}
}