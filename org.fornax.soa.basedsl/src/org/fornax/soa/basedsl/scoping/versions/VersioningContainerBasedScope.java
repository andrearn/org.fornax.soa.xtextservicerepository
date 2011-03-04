package org.fornax.soa.basedsl.scoping.versions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ContainerBasedScope;

import com.google.common.collect.Lists;

public class VersioningContainerBasedScope extends ContainerBasedScope {
	
	private final IScope outer;
	private final EReference reference;
	private final IContainer container;
	private final VersionFilter filter;

	public VersioningContainerBasedScope(IScope outer, EReference reference, IContainer container, VersionFilter filter) {
		super(outer, reference, container);
		this.outer = outer;
		this.reference = reference;
		this.container = container;
		this.filter = filter;
	}

	@Override
	public Iterable<IEObjectDescription> internalGetContents() {
		return container.findAllEObjects(reference.getEReferenceType());
	}

	@Override
	public IEObjectDescription getContentByName(String name) {
		Iterable<IEObjectDescription> allDescriptions = findAllEObjectsByName(name);
		Iterator<IEObjectDescription> iter = allDescriptions.iterator();
		List <IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		while (iter.hasNext()) {
			if (getOuterScope() != NULLSCOPE) {
				IEObjectDescription ieDesc = getOuterScope().getContentByName(name);
				if (ieDesc != null)
					result.add(ieDesc);
			}
			IEObjectDescription firstDesc = iter.next();
			if (firstDesc != null)
				result.add(firstDesc);
		}
		if (!result.isEmpty())
			return filter.getBestMatchByNames(result).get(name);
		return filter.getBestMatchByNames (Arrays.asList(getOuterScope().getContentByName(name))).get (name);
	}

	protected Iterable<IEObjectDescription> findAllEObjectsByName(String name) {
		List<IEObjectDescription> allDesc = Lists.newArrayList(container.findAllEObjects(reference.getEReferenceType(), name));
		return allDesc;
	}

	@Override
	public IEObjectDescription getContentByEObject(EObject object) {
		URI resourceURI = EcoreUtil.getURI(object).trimFragment();
		IResourceDescription description = container.getResourceDescription(resourceURI);
		if (description != null) {
			Iterable<IEObjectDescription> allDescriptions = description.getExportedObjectsForEObject(object);
			Iterator<IEObjectDescription> iter = allDescriptions.iterator();
			boolean hadNext = false;
			while (iter.hasNext()) {
				hadNext = true;
				IEObjectDescription result = iter.next();
				if (isValidForEObject(result))
					return result;
			}
			if (hadNext)
				return null;
		}
		return getOuterScope().getContentByEObject(object);
	}

	private boolean isValidForEObject(IEObjectDescription result) {
		Iterable<IEObjectDescription> allDescriptionsByName = findAllEObjectsByName(result.getName());
		Iterator<IEObjectDescription> iter = allDescriptionsByName.iterator();
		IEObjectDescription inverted = null;
		while (iter.hasNext()) {
			if (inverted != null)
				return false;
			inverted = iter.next();
		}
		return inverted != null && inverted.getEObjectURI().equals(result.getEObjectURI());
	}
	
	public VersioningContainerBasedScope getFiltered (VersionFilter verFilter) {
		return new VersioningContainerBasedScope(getOuterScope(), getReference(), container, verFilter);
	}

	public IScope getOuterScope() {
		return outer;
	}
	
	protected IContainer getContainer() {
		return container;
	}
	
	protected EReference getReference() {
		return reference;
	}

}
