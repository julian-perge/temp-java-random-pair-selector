package org.wecancodeit.pairselector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
@Service
public class PairSelector {
	
	private Random rng; // needs to be constructed 
										// - CONSTRUCTED

	private List<Person> people;
	
	public PairSelector() {
		people = new ArrayList<Person>();
		Person jim = new Person("Jim");
		Person tim = new Person("Tim");
		Person kim = new Person("Kim");
		Person waldo = new Person("Waldo");
		Person bob = new Person("Bobbo");
		Person patrick = new Person("Patrick");
		people.add(jim);
		people.add(tim);
		people.add(kim);
		people.add(waldo);
		people.add(bob);
		people.add(patrick);
		this.rng = new Random();
	}
	
	public PairSelector(Random rng, Person... people) {	
		this.rng = rng;
		this.people = new ArrayList<>(Arrays.asList(people));
	}

	Collection<Pair> generate() {
		
		Collection<Pair> pairs = new ArrayList<>();
		
		Person first = selectPerson();
		
		Person second = selectPerson();
		// add the selected people as a new pair
		pairs.add(new Pair(first, second));
		// return that new pair of people as a collection
		return pairs;
	}

	private Person selectPerson() {
		// Grabs a random person from our list of people
		System.out.println(people.size());
		Person selected = people.get(rng.nextInt(people.size()));
		// removes person from our list
//		people.remove(selected);
		// returns the removed person to us
		return selected;
	}

}

//	public int getRng()
//	{
//		return rng.nextInt();
//	}
//
//	public List<Person> getPeople()
//	{
//		return people;
//	}