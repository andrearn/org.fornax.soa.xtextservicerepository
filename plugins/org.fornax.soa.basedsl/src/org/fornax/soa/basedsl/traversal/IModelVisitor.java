package org.fornax.soa.basedsl.traversal;

public interface IModelVisitor<T> {

	boolean visit(T modelElement, T predecessorElement);
}
