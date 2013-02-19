/*
* generated by Xtext
*/
package org.fornax.soa.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.fornax.soa.basedsl.ui.labeling.SOABaseDslLabelHelper;
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.EJB;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingDsl.SAP;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.environmentDsl.Server;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.util.BindingDslHelper;

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
			org.fornax.soa.environmentDsl.SAP sapServer = (org.fornax.soa.environmentDsl.SAP) ele.getClient().eContainer();
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
