package org.fornax.soa.basedsl.util;

import java.util.List;

public class TreeNode<T> {

	private TreeNode<T> parent;
	
	private T element;
	
	private List<TreeNode<T>> children;

	
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

}
