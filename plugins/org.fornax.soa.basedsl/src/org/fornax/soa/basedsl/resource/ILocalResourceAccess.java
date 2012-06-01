package org.fornax.soa.basedsl.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * Executes <code>work</code> on the element referred to by the
 * <code>targetURI</code>. That involves reloading the element if it is
 * proxified or the editor it belonged to has been closed.
 */
public interface ILocalResourceAccess {
	<R> R readOnly (URI resourceURI, IUnitOfWork<R, ResourceSet> work);
}
