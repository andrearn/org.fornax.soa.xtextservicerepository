package org.xkonnex.repo.dsl.basedsl.test.util;

import java.util.List;

public class NestedBean {
	
	private int port;
	private int ignoredPort;
	private Integer wrapperPort;
	private boolean flag;
	private boolean ignoredFlag;
	private Boolean wrapperFlag;
	private List<String> stringList;
	private SampleEnum sampleEnum;
	private SampleEnum defaultSampleEnum;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getIgnoredPort() {
		return ignoredPort;
	}

	public void setIgnoredPort(int ignoredPort) {
		this.ignoredPort = ignoredPort;
	}

	public boolean isIgnoredFlag() {
		return ignoredFlag;
	}

	public void setIgnoredFlag(boolean ignoredFlag) {
		this.ignoredFlag = ignoredFlag;
	}

	public List<String> getStringList() {
		return stringList;
	}

	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}

	public SampleEnum getSampleEnum() {
		return sampleEnum;
	}

	public void setSampleEnum(SampleEnum sampleEnum) {
		this.sampleEnum = sampleEnum;
	}

	public SampleEnum getDefaultSampleEnum() {
		return defaultSampleEnum;
	}

	public void setDefaultSampleEnum(SampleEnum defaultSampleEnum) {
		this.defaultSampleEnum = defaultSampleEnum;
	}

	public Integer getWrapperPort() {
		return wrapperPort;
	}

	public void setWrapperPort(Integer wrapperPort) {
		this.wrapperPort = wrapperPort;
	}

	public Boolean getWrapperFlag() {
		return wrapperFlag;
	}

	public void setWrapperFlag(Boolean wrapperFlag) {
		this.wrapperFlag = wrapperFlag;
	}

}
