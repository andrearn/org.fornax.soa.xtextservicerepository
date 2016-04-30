package org.xkonnex.repo.dsl.bindingdsl.model.protocol;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmType;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Assignment;
import org.xkonnex.repo.dsl.basedsl.model.DelegatingEObject;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ConnectorQualifier;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.EndpointQualifierRef;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol;
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.IProtocol;

public class EffectiveBindingProtocol extends DelegatingEObject implements
		BindingProtocol {

	protected String name;
	private JvmType type;
	private EList<Assignment> assignment = new BasicEList<Assignment>();
	private EndpointQualifierRef endpointQualifierRef;
	private ConnectorQualifier endpointConnector;
	private IProtocol extensibleProtocol;

	public EffectiveBindingProtocol(EObject delegate) {
		super(delegate);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public JvmType getType() {
		return type;
	}

	@Override
	public void setType(JvmType value) {
		this.type = value;
	}

	@Override
	public EList<Assignment> getAssignment() {
		return assignment;
	}

	@Override
	public EndpointQualifierRef getEndpointQualifierRef() {
		return endpointQualifierRef;
	}

	@Override
	public void setEndpointQualifierRef(EndpointQualifierRef value) {
		this.endpointQualifierRef = value;
	}

	@Override
	public ConnectorQualifier getEndpointConnector() {
		return endpointConnector;
	}

	@Override
	public void setEndpointConnector(ConnectorQualifier value) {
		this.endpointConnector = value;
	}
	
	public <T extends IProtocol> T getExtensibleProtocol() {
		return (T)extensibleProtocol;
	}

	public void setExtensibleProtocol(IProtocol extensibleProtocol) {
		this.extensibleProtocol = extensibleProtocol;
	}

}
