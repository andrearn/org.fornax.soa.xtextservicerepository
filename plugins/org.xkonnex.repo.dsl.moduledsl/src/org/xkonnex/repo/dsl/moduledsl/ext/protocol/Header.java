package org.xkonnex.repo.dsl.moduledsl.ext.protocol;

public class Header {
	
	protected String name;
	protected String messageHeader;
	protected String description;
	protected String type;
	protected Boolean optional;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/** 
	 * The message header field represented by this header 
	 * @return the message header
	 */
	public String getMessageHeader() {
		return messageHeader;
	}
	public void setMessageHeader(String messageHeader) {
		this.messageHeader = messageHeader;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	/** 
	 * Data type of the header field, defaults to string 
	 * 
	 * @return the type name of the header field
	 */
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Boolean getOptional() {
		return optional;
	}
	public void setOptional(Boolean optional) {
		this.optional = optional;
	}

}
