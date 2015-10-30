/*
* generated by Xtext
*/
package org.xkonnex.repo.dsl.bindingdsl.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.xkonnex.repo.dsl.basedsl.ui.labeling.SOABaseDslLabelHelper;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.EJB;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SAP;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding;
import org.xkonnex.repo.dsl.bindingdsl.util.BindingDslHelper;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server;
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class BindingDslLabelProvider extends DefaultEObjectLabelProvider {

	@Inject EnvironmentBindingResolver envBindResolver;

	@Inject
	public BindingDslLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}
	
	String image (ModuleBinding ele) {
		return "full/obj16/messageexchange.gif";
	}
	
	String text (ServiceBinding ele) {
		return ele.getService().getService().getName() + " " + SOABaseDslLabelHelper.getVersionConstraint(ele.getService().getVersionRef());
	}
	
	String text (ModuleBinding m) {
		return m.getModule().getModule().getName() + " -> " + envBindResolver.resolveEnvironment(m).getName();
	}
	
	String text (SOAP ele) {
		Server server = envBindResolver.resolveServer(ele);
		SubNamespace ns = BindingDslHelper.getSubNamespace(ele);
		if (server != null)
			return "SOAP -> "+server.getName();
		else
			return "SOAP";
	}
	
	String text (SAP ele) {
		String clientText = null;
		if (ele.getClient() != null) {
			org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SAP sapServer = (org.xkonnex.repo.dsl.environmentdsl.environmentDsl.SAP) ele.getClient().eContainer();
			clientText = sapServer.getName() + ele.getClient().getClient();
		}
		if (clientText != null)
			return "SAP -> " + clientText;
		else
			return "SAP";
	}
	
	String text (EJB ele) {
		Server server = envBindResolver.resolveServer(ele);
		StringBuffer label = new StringBuffer("EJB");
		SubNamespace ns = BindingDslHelper.getSubNamespace(ele);
		if (server == null) {
			Environment env = envBindResolver.resolveEnvironment(ele);
			if (ns instanceof DomainNamespace)
				server = env.getDefaultESB();
			else 
				server = env.getDefaultAppServer();
		}
		if (server != null)
			label.append(" -> " + server.getName());
		if (ele.getJndiName() != null) {
			String[] jndiNameParts = ele.getJndiName().split("/");
			if (jndiNameParts.length > 0) 
				label.append("/" + jndiNameParts[jndiNameParts.length-1]);
		}
		return label.toString();
	}
	
	
	String image (ServiceBinding ele) {
		return "full/obj16/invoke.gif";
	}

	String image (BindingProtocol ele) {
		return "full/obj16/message_part.gif";
	}
	
	String image (SOAP ele) {
		return "full/obj16/message_part.gif";
	}
	
	String image (SAP ele) {
		return "full/obj16/message_part.gif";
	}

}