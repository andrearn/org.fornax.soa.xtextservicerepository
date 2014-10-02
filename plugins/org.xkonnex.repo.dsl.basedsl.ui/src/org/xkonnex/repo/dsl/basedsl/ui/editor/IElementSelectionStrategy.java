/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xkonnex.repo.dsl.basedsl.ui.editor;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;

public interface IElementSelectionStrategy {

	boolean isStrategyFor(IEditorPart editor);

	Object editorSelectionChanged(ISelection selection, boolean force);

	ISelection viewSelectionChanged(Object selectedElement);

	void register(IEditorPart editor);

	void deregister(IEditorPart editor);
}
