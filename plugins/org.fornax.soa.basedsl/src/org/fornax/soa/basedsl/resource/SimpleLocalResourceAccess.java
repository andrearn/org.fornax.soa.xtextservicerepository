/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.fornax.soa.basedsl.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author André Arnold  - ported to runtime SOABaseDsl
 */
public class SimpleLocalResourceAccess implements ILocalResourceAccess {

	private ResourceSet resourceSet;

	public SimpleLocalResourceAccess(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	public <R> R readOnly(URI targetURI, IUnitOfWork<R, ResourceSet> work) {
		try {
			return work.exec(resourceSet);
		} catch(Exception exc) {
			throw new WrappedException(exc);
		}
	}

}