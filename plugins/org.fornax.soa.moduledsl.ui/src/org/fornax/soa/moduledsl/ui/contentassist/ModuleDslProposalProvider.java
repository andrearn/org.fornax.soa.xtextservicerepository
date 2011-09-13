/*
* generated by Xtext
*/
package org.fornax.soa.moduledsl.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.search.IXtextEObjectSearch;
import org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage;
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef;
import org.fornax.soa.serviceDsl.Service;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class ModuleDslProposalProvider extends AbstractModuleDslProposalProvider {

	@Inject
	private IScopeProvider scopeProvider;
	@Inject
	private IQualifiedNameProvider nameProvider;
	@Inject
	private IXtextEObjectSearch searchEngine;

	public void complete_VersionId(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.complete_VersionId(model, ruleCall, context, acceptor);
//		if (model.eContainer() instanceof ServiceRef) {
//			ServiceRef svcRef = (ServiceRef) model.eContainer();
//			Iterable<Service> serviceCanditates = getServiceCanditates(svcRef);
//			for (Service svc : serviceCanditates) {
//				acceptor.accept(createCompletionProposal (svc.getVersion().getVersion(), context));
//			}
//		}
	}
	
	private Iterable<Service> getServiceCanditates (ServiceRef ref) {
		Iterable<Service> canditates = new ArrayList<Service>();
		EcoreUtil2.resolveAll(ref);
		Service service = ref.getService();
		EcoreUtil2.resolveAll(service);
		if (service != null) {
			QualifiedName svcFqn = nameProvider.getFullyQualifiedName(ref.getService());
			String svcName = service.getName();
			if (svcFqn != null)
				svcName = svcFqn.toString();
			Iterable<IEObjectDescription> matches = searchEngine.findMatches(svcFqn.toString(), service.eClass().getName());
			canditates = Iterables.transform(matches, new Function<IEObjectDescription, Service> () {

				@Override
				public Service apply(IEObjectDescription iEObjDesc) {
					if (iEObjDesc.getEObjectOrProxy() instanceof Service)
						return (Service)iEObjDesc.getEObjectOrProxy();
					return null;
				}
				
			});
		}
		return Iterables.filter(canditates, Predicates.notNull());
	}
}
