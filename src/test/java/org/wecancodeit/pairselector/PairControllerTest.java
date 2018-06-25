package org.wecancodeit.pairselector;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class PairControllerTest {

	@InjectMocks
	private PairController underTest;

	@Mock
	private Model model;

	@Mock
	private PairSelector pairSelector;

	@Mock
	private Collection<Pair> expectedPairs;
	
	@Test
	public void shouldSelectOnePair() {
		MockitoAnnotations.initMocks(this);
		when(pairSelector.generate()).thenReturn(expectedPairs);
		
		underTest.selectPairs(model);
		
		verify(model).addAttribute("generatedPairs", expectedPairs);
	}
}
