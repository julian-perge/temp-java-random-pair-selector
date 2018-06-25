package org.wecancodeit.pairselector;

import javax.annotation.Resource;

@Resource
public class Person {

	private String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
