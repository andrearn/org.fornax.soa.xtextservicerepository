package org.xkonnex.repo.dsl.basedsl.traversal;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.search.IReferenceSearch;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class ReferrerGraphTraversor {
	
	@Inject
	private IReferenceSearch refSearch;
	@Inject
	private IEObjectLookup objLookup;
	
	public void traverse (final IEObjectDescription element, final IEObjectDescription referredElement, final List<IModelVisitor<IEObjectDescription>> visitors, final ResourceSet resourceSet) {
		for (IModelVisitor<IEObjectDescription> visitor : visitors) {
			boolean continueTraversal = visitor.visit(element, referredElement);
			if (!continueTraversal) {
				return;
			}
		}
		final List<IEObjectDescription> refs = Lists.newArrayList();
		Predicate<IReferenceDescription> predicate = Predicates.alwaysTrue();
		IAcceptor<IReferenceDescription> refCollector = new IAcceptor<IReferenceDescription>() {
			
			public void accept(IReferenceDescription refDesc) {
				//FIXME: resolution of IEObjectDescription
				IEObjectDescription sourceObjDesc = objLookup.getIEOBjectDescriptionByURI (refDesc.getSourceEObjectUri(), resourceSet);
				if (sourceObjDesc != null) {
					refs.add(sourceObjDesc);
				}
			}
		};
		refSearch.findAllReferences(element, resourceSet, predicate, refCollector);
		for (IEObjectDescription ref : refs) {
			traverse (ref, element, visitors, resourceSet);
		}
		
	}

}
