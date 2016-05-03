package org.example;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ExtensibleConnector;
import org.xkonnex.repo.dsl.environmentdsl.ext.connector.IConnector;

public class SomeConnector implements IConnector {
	
	private int port;
	private boolean monitored;
	private String something;
	private SomeEnum someEnum;
	private Nested nested;
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	public boolean isMonitored() {
		return monitored;
	}
	public void setMonitored(boolean monitored) {
		this.monitored = monitored;
	}
	
	public String getSomething() {
		return something;
	}
	public void setSomething(String something) {
		this.something = something;
	}
	
	public SomeEnum getSomeEnum() {
		return someEnum;
	}
	public void setSomeEnum(SomeEnum someEnum) {
		this.someEnum = someEnum;
	}
	
	public Nested getNested() {
		return nested;
	}
	public void setNested(Nested nested) {
		this.nested = nested;
	}
	@Override
	public String getEndpointUrl(ExtensibleConnector connectorDefinition) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getSecuredEndpointUrl(ExtensibleConnector connectorDefinition) {
		// TODO Auto-generated method stub
		return null;
	}

}
