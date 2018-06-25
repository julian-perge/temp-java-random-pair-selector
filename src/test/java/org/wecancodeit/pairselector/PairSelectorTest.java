package org.wecancodeit.pairselector;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Random;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PairSelectorTest {
	
	private Person jeff = new Person("Jeff");
	private Person stephen = new Person("Stephen");
	private Person deci = new Person("Deci");
	private Person alex = new Person("Alex");

	@Mock
	private Random rng;
	
	@Test
	public void shouldSelectOnePair() {
		MockitoAnnotations.initMocks(this);
		PairSelector underTest = new PairSelector(rng, jeff, stephen);
			
		Collection<Pair> generated = underTest.generate();
		
		Pair expected = new Pair(jeff, stephen);
		assertThat(generated, contains(expected));
	}

	@Test
	public void shouldSelectADifferentPair() {
		MockitoAnnotations.initMocks(this);
		PairSelector underTest = new PairSelector(rng, jeff, stephen, deci, alex);
		when(rng.nextInt(4)).thenReturn(0);
		when(rng.nextInt(3)).thenReturn(1);
		
		Collection<Pair> generated = underTest.generate();
		
		Pair expected = new Pair(jeff, deci);
		assertThat(generated, contains(expected));
	}
}
