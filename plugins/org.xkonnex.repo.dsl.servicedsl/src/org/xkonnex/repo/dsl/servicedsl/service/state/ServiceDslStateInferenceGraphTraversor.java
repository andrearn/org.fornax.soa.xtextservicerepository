package org.xkonnex.repo.dsl.servicedsl.service.state;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.xkonnex.repo.dsl.basedsl.resource.IEObjectDescriptionBuilder;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.search.IReferenceSearch;
import org.xkonnex.repo.dsl.basedsl.traversal.IModelVisitor;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class ServiceDslStateInferenceGraphTraversor {
	
	private static final String MODULEDSL_PACKAGE_NS_URI = "http://www.xkonnex.org/repo/dsl/moduledsl/ModuleDsl";

	@Inject
	private IReferenceSearch refSearch;
	@Inject
	private IEObjectLookup objLookup;
	@Inject
	private IEObjectDescriptionBuilder descriptionBuilder;
	
	public void traverse (final IEObjectDescription element, final IEObjectDescription referrer, final List<IModelVisitor<IEObjectDescription>> visitors, final ResourceSet resourceSet) {
		for (IModelVisitor<IEObjectDescription> visitor : visitors) {
			boolean continueTraversal = visitor.visit(element, referrer);
			if (!continueTraversal) {
				return;
			}
		}
		final List<IEObjectDescription> refs = Lists.newArrayList();
		Predicate<IReferenceDescription> predicate = Predicates.alwaysTrue();
		IAcceptor<IReferenceDescription> refCollector = new IAcceptor<IReferenceDescription>() {
			
			public void accept(IReferenceDescription refDesc) {
				if (refDesc.getContainerEObjectURI() != null) {
					IEObjectDescription sourceObjDesc = objLookup.getIEOBjectDescriptionByURI (refDesc.getContainerEObjectURI(), resourceSet);
					if (sourceObjDesc != null)
						refs.add(sourceObjDesc);
				}
			}
		};
		//FIXME use reference candidates ignoring state instead of linking based references here
		refSearch.findAllReferences(element, resourceSet, predicate, refCollector);
		for (IEObjectDescription ref : refs) {
			EObject obj = ref.getEObjectOrProxy();
			if (obj instanceof Property) {
				if (obj.eIsProxy()) {
					obj = EcoreUtil2.resolve(obj, resourceSet);
				}
				EObject owner = objLookup.getStatefulOwner(obj);
				if (owner instanceof Service || owner instanceof VersionedType) {
					IEObjectDescription ownerDesc = descriptionBuilder.buildDescription(owner);
					traverse (ownerDesc, element, visitors, resourceSet);
				}
			} else if ("Module".equals(obj.eClass().getName()) && 
				MODULEDSL_PACKAGE_NS_URI.equals (obj.eClass().getEPackage().getNsURI())) {
				if (obj.eIsProxy()) {
					obj = EcoreUtil2.resolve(obj, resourceSet);
				}
				IEObjectDescription objDesc = descriptionBuilder.buildDescription(obj);
				traverse (objDesc, element, visitors, resourceSet);
			} else if (obj instanceof Parameter) {
				if (obj.eIsProxy()) {
					obj = EcoreUtil2.resolve(obj, resourceSet);
				}
				EObject owner = objLookup.getStatefulOwner(obj);
				if (owner != null) {
					IEObjectDescription ownerDesc = descriptionBuilder.buildDescription(owner);
					traverse (ownerDesc, element, visitors, resourceSet);
				}
			} else if (obj instanceof ExceptionRef) {
				if (obj.eIsProxy()) {
					obj = EcoreUtil2.resolve(obj, resourceSet);
				}
				EObject owner = objLookup.getStatefulOwner(obj);
				if (owner != null) {
					IEObjectDescription ownerDesc = descriptionBuilder.buildDescription(owner);
					traverse (ownerDesc, element, visitors, resourceSet);
				}
			} else if (obj instanceof Operation) {
				if (obj.eIsProxy()) {
					obj = EcoreUtil2.resolve(obj, resourceSet);
				}
				EObject owner = objLookup.getStatefulOwner(obj);
				if (owner != null) {
					IEObjectDescription ownerDesc = descriptionBuilder.buildDescription(owner);
					traverse (ownerDesc, element, visitors, resourceSet);
				}
			}
		}
		
	}

}
