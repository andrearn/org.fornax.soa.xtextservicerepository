package org.example;

import java.util.ArrayList;
import java.util.List;

public class Nested {
	
	private String prop;
	
	private List<String> someList = new ArrayList<String>();

	public String getProp() {
		return prop;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}

	public List<String> getSomeList() {
		return someList;
	}

	public void addSomeList(String someListElement) {
		this.someList.add(someListElement);
	}
	

}
