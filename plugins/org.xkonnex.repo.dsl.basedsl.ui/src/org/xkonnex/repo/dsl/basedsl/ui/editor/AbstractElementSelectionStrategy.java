/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xkonnex.repo.dsl.basedsl.ui.editor;

import org.eclipse.ui.IEditorPart;

public abstract class AbstractElementSelectionStrategy implements IElementSelectionStrategy {

	private IEditorPart editor;


	protected ClassLoader getClassLoader() {
		return getClass().getClassLoader();
	}

	public void register(IEditorPart editor) {
		this.editor = editor;
	}

	public void deregister(IEditorPart editor) {
		this.editor = null;
	}

	protected IEditorPart getEditor() {
		return editor;
	}

	protected Object refreshView() {
		return editorSelectionChanged(editor.getSite().getSelectionProvider().getSelection(), true);
	}
}