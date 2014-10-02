/*
 * based on Xtext findrefs components
 */
package org.xkonnex.repo.workbench.ui.search.dialog;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ServiceRepositorySearchViewTreeNode {

	private ServiceRepositorySearchViewTreeNode parent;

	private List<ServiceRepositorySearchViewTreeNode> children;

	private Object labelDescription;

	private Object description;
	
	public ServiceRepositorySearchViewTreeNode(ServiceRepositorySearchViewTreeNode parent, Object description, Object labelDescription) {
		super();
		this.parent = parent;
		this.description = description;
		this.labelDescription = labelDescription;
		if (parent != null) {
			parent.addChild(this);
		}
	}

	public ServiceRepositorySearchViewTreeNode getParent() {
		return parent;
	}

	public List<ServiceRepositorySearchViewTreeNode> getChildren() {
		if (children == null) {
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(children);
	}

	public void addChild(ServiceRepositorySearchViewTreeNode child) {
		if (children == null) {
			children = Lists.newArrayList();
		}
		children.add(child);
	}
	
	public void removeChild(ServiceRepositorySearchViewTreeNode child) {
		if(children != null) {
			children.remove(child);
		}
	}

	public Object getDescription() {
		return description;
	}
	
	public Object getLabelDescription() {
		return labelDescription;
	}

}
