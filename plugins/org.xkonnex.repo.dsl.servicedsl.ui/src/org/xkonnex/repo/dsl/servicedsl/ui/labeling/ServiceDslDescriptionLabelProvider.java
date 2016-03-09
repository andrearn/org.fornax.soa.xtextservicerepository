/*
* generated by Xtext
*/
package org.xkonnex.repo.dsl.servicedsl.ui.labeling;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;
import org.xkonnex.repo.dsl.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver;

import com.google.inject.Inject;

/**
 * Provides labels for a IEObjectDescriptions and IResourceDescriptions.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ServiceDslDescriptionLabelProvider extends DefaultDescriptionLabelProvider {

	@Inject
	private IResourceDescriptions resourceDescriptions;

	@Inject
	private ILifecycleStateResolver stateResolver;

	public Object text(IEObjectDescription ele) {
		StyledString s = new StyledString (ele.getQualifiedName().toString());
		if (ele.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY) != null) {
			s.append(" v");
			s.append (ele.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY));
		}
		s.append (" - ");
		if (resourceDescriptions instanceof ResourceSetBasedResourceDescriptions && stateResolver.definesState(ele)) {
			ResourceSet resourceSet = ((ResourceSetBasedResourceDescriptions) resourceDescriptions).getResourceSet();
			LifecycleState state = stateResolver.getLifecycleState(ele, resourceSet);
			if (state != null) {
				s.append (" - ");
				s.append(state.getName());
			}
		}
		s.append (ele.getEClass().getName());
		return s;
	}
	
	public String image(IEObjectDescription description) {
		return "full/obj16/" + description.getEClass().getName() + ".gif"; 
	}

}
