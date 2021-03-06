/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.basedsl.ui.outline

import javax.inject.Inject
import org.eclipse.jface.viewers.StyledString
import org.eclipse.swt.graphics.RGB
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.ui.IImageHelper
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode
import org.eclipse.xtext.ui.editor.utils.TextStyle
import org.eclipse.xtext.ui.label.StylerFactory
import org.xkonnex.repo.dsl.basedsl.baseDsl.Assignment
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslPackage
import org.xkonnex.repo.dsl.basedsl.baseDsl.Component

/** 
 * Customization of the default outline structure.
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
 */
class BaseDslOutlineTreeProvider extends org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider {
	static final String COMPONENT_TYPE_SEPARATOR = " : "
	@Inject StylerFactory stylerFactory
	@Inject IImageHelper imageHelper

	def protected boolean _isLeaf(Assignment assignment) {
		return !(assignment.getValue() instanceof Component)
	}

	def protected Object _text(Assignment assignment) {
		var StyledString styledText = (super._text(assignment) as StyledString)
		if (assignment.getFeature() instanceof JvmOperation) {
			return appendSimpleName(styledText, ((assignment.getFeature() as JvmOperation)).getParameters().get(0))
		}
		return styledText
	}

	def protected Object _text(Component component) {
		var StyledString styledText = (super._text(component) as StyledString)
		if (component.getType() !== null) {
			return appendSimpleName(styledText, component.getType())
		}
		return styledText
	}

	def protected StyledString appendSimpleName(StyledString styledText, JvmIdentifiableElement element) {
		var String typeName = element.getSimpleName()
		return styledText.append(
			new StyledString(COMPONENT_TYPE_SEPARATOR + typeName,
				stylerFactory.createXtextStyleAdapterStyler(getTypeTextStyle())))
	}

	def protected TextStyle getTypeTextStyle() {
		var TextStyle textStyle = new TextStyle()
		textStyle.setColor(new RGB(149, 125, 71))
		return textStyle
	}
}
