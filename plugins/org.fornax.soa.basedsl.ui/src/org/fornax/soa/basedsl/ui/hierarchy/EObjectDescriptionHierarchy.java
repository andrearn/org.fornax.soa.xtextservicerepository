package org.fornax.soa.basedsl.ui.hierarchy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.util.TreeNode;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * Representation of a TreeNode for use by {@link IContentProvider}s
 * based on JDTs TypeHierarchy
 * @author aarnold
 *
 */
public class EObjectDescriptionHierarchy {
	
	private IEObjectDescription root;
	private Map<IEObjectDescription, IEObjectDescription> elementToParent = new HashMap<IEObjectDescription, IEObjectDescription>();
	private Map<IEObjectDescription, List<IEObjectDescription>> elementToChildren = new HashMap<IEObjectDescription, List<IEObjectDescription>>();
	
	public EObjectDescriptionHierarchy (TreeNode<IEObjectDescription> tree, IProgressMonitor pm) {
		refreshFromTree(tree, pm);
	}

	private void refreshFromTree(TreeNode<IEObjectDescription> tree, IProgressMonitor pm) {
		TreeNode<IEObjectDescription> treeRoot = tree.getRoot();
		root = treeRoot.getElement();
		Iterator<TreeNode<IEObjectDescription>> treeRootIt = treeRoot.iterator();
		while (treeRootIt.hasNext() && !pm.isCanceled()) {
			TreeNode<IEObjectDescription> node = treeRootIt.next();
			TreeNode<IEObjectDescription> parent = node.getParent();
			if (parent != null)
				elementToParent.put(node.getElement(), parent.getElement());
			List<TreeNode<IEObjectDescription>> childNodes = node.getChildren();
			if (childNodes != null && !childNodes.isEmpty() && !pm.isCanceled()) {
				List<IEObjectDescription> children = Lists.transform(childNodes, new Function<TreeNode<IEObjectDescription>, IEObjectDescription>() {
					public IEObjectDescription apply (TreeNode<IEObjectDescription> input) {
						return input.getElement();
					}
				});
				elementToChildren.put(node.getElement(), children);
			}
		}
	}

	public IEObjectDescription getRoot() {
		return root;
	}
	public void setElement(TreeNode<IEObjectDescription> root, IProgressMonitor pm) {
		refreshFromTree(root, pm);
	}

	public IEObjectDescription getParent(IEObjectDescription element) {
		return elementToParent.get(element);
	}
	
	public List<IEObjectDescription> getChildren(IEObjectDescription element) {
		return elementToChildren.get(element);
	}
	
	public void removeHierarchyChangedListener(
			IEObjectDescrHierarchyChangedListener eObjectDescriptionHierarchyLifeCycle) {
		// TODO Auto-generated method stub
		
	}
	public void addHierarchyChangedListener(
			IEObjectDescrHierarchyChangedListener eObjectDescriptionHierarchyLifeCycle) {
		// TODO Auto-generated method stub
		
	}
	public void refresh(IProgressMonitor pm) {
		// TODO Auto-generated method stub
		
	}

}
