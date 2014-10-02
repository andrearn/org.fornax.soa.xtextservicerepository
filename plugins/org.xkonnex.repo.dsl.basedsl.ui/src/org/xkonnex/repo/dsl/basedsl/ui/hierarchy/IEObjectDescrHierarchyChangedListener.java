package org.xkonnex.repo.dsl.basedsl.ui.hierarchy;





/**
 * A listener which gets notified when a particular type hierarchy object
 * changes.
 * <p>
 * This interface may be implemented by clients.
 * </p>
 */
public interface IEObjectDescrHierarchyChangedListener {
	/**
	 * Notifies that the given type hierarchy has changed in some way and should
	 * be refreshed at some point to make it consistent with the current state of
	 * the Java model.
	 *
	 * @param typeHierarchy the given type hierarchy
	 */
	void hierarchyChanged(EObjectDescriptionHierarchy typeHierarchy);
}
