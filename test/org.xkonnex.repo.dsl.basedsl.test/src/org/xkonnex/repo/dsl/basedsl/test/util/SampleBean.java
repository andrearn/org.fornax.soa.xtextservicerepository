package org.xkonnex.repo.dsl.basedsl.test.util;

public class SampleBean {
	
	private String someString;
	
	private String someOtherString;
	
	private NestedBean nestedBean;
	

	public String getSomeString() {
		return someString;
	}

	public void setSomeString(String someString) {
		this.someString = someString;
	}

	public String getSomeOtherString() {
		return someOtherString;
	}

	public void setSomeOtherString(String someOtherString) {
		this.someOtherString = someOtherString;
	}

	public NestedBean getNestedBean() {
		return nestedBean;
	}

	public void setNestedBean(NestedBean nestedBean) {
		this.nestedBean = nestedBean;
	}

}
