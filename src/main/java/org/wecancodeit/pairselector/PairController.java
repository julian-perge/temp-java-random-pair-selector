package org.wecancodeit.pairselector;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PairController {
	@Autowired
	private PairSelector selector;

	@RequestMapping("/generatedPairs")
	public void selectPairs(Model model) {
		Collection<Pair> pairs = selector.generate();
		model.addAttribute("generatedPairs", pairs);
	}

}
