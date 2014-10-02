package org.xkonnex.repo.dsl.basedsl.traversal;

public interface IModelVisitor<T> {

	boolean visit(T modelElement, T predecessorElement);
}
