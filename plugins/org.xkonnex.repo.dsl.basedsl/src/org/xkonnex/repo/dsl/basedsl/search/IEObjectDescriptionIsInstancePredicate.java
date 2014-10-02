package org.xkonnex.repo.dsl.basedsl.search;

import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;

/**
 * Predicate, that filters {@link IEObjectDescription}s by the type of {@link IEObjectDescription#getEObjectOrProxy()}
 * @author aarnold
 *
 */
public class IEObjectDescriptionIsInstancePredicate implements
		Predicate<IEObjectDescription> {
	
	private Class clazz;
	
	public IEObjectDescriptionIsInstancePredicate(Class<?> clazz) {
		this.clazz = clazz;
	}

	public boolean apply(IEObjectDescription input) {
		return clazz.isInstance (input.getEObjectOrProxy());
	}

}
