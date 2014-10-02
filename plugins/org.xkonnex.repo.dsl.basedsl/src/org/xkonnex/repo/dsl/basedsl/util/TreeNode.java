package org.xkonnex.repo.dsl.basedsl.util;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.ref.DependencyDescription;

public class TreeNode<T>  implements Iterable<TreeNode<T>> {

	private TreeNode<T> parent;
	
	private T element;
	
	private T elementMembers;
	
	private List<TreeNode<T>> children = new ArrayList<TreeNode<T>>();

	
	public TreeNode() {
		
	}
	
	public TreeNode(T element) {
		this.element = element;
	}

	public List<TreeNode<T>> getChildren () {
		return children;
	}

	public void setChildren (List<TreeNode<T>> children) {
		this.children = children;
	}
	
	public void addChild (T child) {
		TreeNode<T> childNode = new TreeNode<T> (child);
		childNode.setParent(this);
		children.add (childNode);
	}

	public TreeNode<T> getParent () {
		return parent;
	}

	public void setParent (TreeNode<T> parent) {
		this.parent = parent;
	}

	public T getElement () {
		return element;
	}

	public void setElement (T element) {
		this.element = element;
	}

	public T getElementMembers() {
		return elementMembers;
	}

	public void setElementMembers(T elementMembers) {
		this.elementMembers = elementMembers;
	}

	public TreeNode<T> getRoot() {
		if (parent != null)
			return parent.getRoot();
		else
			return this;
	}
	
	public TreeNode<T> findNode(T element) {
		if (this.element.equals(element)) {
			return this;
		} else {
			for (TreeNode<T> child : children) {
				return child.findNode(element);
			}
		}
		return null;
	}

	public Iterator<TreeNode<T>> iterator() {
		// TODO Auto-generated method stub
		return new TreeNodeIterator(getRoot());
	}
	private class TreeNodeIterator implements Iterator<TreeNode<T>> {
		
		private TreeNode<T> first;
		boolean isFirst = true;

		private Iterator<TreeNode<T>> currentKeyIt;
		private Iterator<TreeNode<T>> currentDepIt;
		
		public TreeNodeIterator(TreeNode<T> dep) {
			if (children != null) {
				currentKeyIt = children.iterator();
			}
			first = dep;
		}

		public boolean hasNext() {
			if (!isFirst) {
				return currentDepIt != null && currentDepIt.hasNext() || 
					currentKeyIt != null && currentKeyIt.hasNext();
			}
			return first != null;
		}

		public TreeNode<T> next() {
			TreeNode<T> next = successor();
			return next;
		}

		public void remove() {
			throw new RuntimeException ("Not implemented");
		}
		
		private TreeNode<T> successor() {
			if (isFirst) {
				isFirst = false;
				return first;
			}
			if (currentDepIt != null && currentDepIt.hasNext()) {
				return currentDepIt.next();
			}
			if (currentKeyIt != null && currentKeyIt.hasNext()) {
				TreeNode<T> nextDep = currentKeyIt.next();
				currentDepIt = nextDep.iterator();
				return nextDep;
			}
			throw new NoSuchElementException();
		}
		
	}

}
