package org.wecancodeit.pairselector;

import javax.annotation.Resource;

@Resource
public class Pair {

	private Person p1;
	private Person p2;

	public Pair(Person p1, Person p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public boolean equals(Object obj) {
		Pair other = (Pair) obj;
		return p1.equals(other.p1) && p2.equals(other.p2);
	}

	@Override
	public String toString() {
		return String.format("a pair consisting of %s and %s", p1, p2);
	}

	
}
