package com.rassil.watche;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rassil.watche.entities.StyleDeMontre;
import com.rassil.watche.entities.Watche;
import com.rassil.watche.repos.WatcheRepository;

@SpringBootTest
class WatcheApplicationTests {

	@Autowired
	private WatcheRepository watcheRepository;

	@Test
	public void testCreateWatche() {
		Watche watch = new Watche("Rolex Submariner", 8500.0, new Date());
		watcheRepository.save(watch);
	}

	@Test
	public void testFindWatche() {
		Watche w = watcheRepository.findById(1L).orElse(null);
		System.out.println(w);
	}

	@Test
	public void testUpdateWatche() {
		Watche w = watcheRepository.findById(1L).orElseGet(() -> {
			Watche newWatch = new Watche("Fossil Grant", 300.5, new Date());
			return watcheRepository.save(newWatch);
		});
		w.setPrixWatches(250.0);
		watcheRepository.save(w);
		System.out.println(w);
	}

	@Test
	public void testDeleteWatche() {
		watcheRepository.deleteById(1L);
	}

	@Test
	public void testListerTousWatches() {
		List<Watche> watches = watcheRepository.findAll();
		for (Watche w : watches) {
			System.out.println(w);
		}
	}

	@Test
	public void testFindByNomWatche() {
		List<Watche> watches = watcheRepository.findByNomWatche("Rolex Submariner");
		for (Watche w : watches) {
			System.out.println(w);
		}
	}

	@Test
	public void testFindByNomWatcheContains() {
		List<Watche> watches = watcheRepository.findByNomWatcheContains("Rolex");
		for (Watche w : watches) {
			System.out.println(w);
		}
	}

	@Test
	public void testFindByNomPrix() {
		List<Watche> watches = watcheRepository.findByNomPrix("Rolex", 1000.0);
		for (Watche w : watches) {
			System.out.println(w);
		}
	}

	@Test
	public void testFindByStyleDeMontre() {
		StyleDeMontre style = new StyleDeMontre();
		style.setIdStyle(1L);
		List<Watche> watches = watcheRepository.findByStyleDeMontre(style);
		for (Watche w : watches) {
			System.out.println(w);
		}
	}

	@Test
	public void testFindByStyleDeMontreIdStyle() {
		List<Watche> watches = watcheRepository.findByStyleDeMontreIdStyle(1L);
		for (Watche w : watches) {
			System.out.println(w);
		}
	}

	@Test
	public void testFindByOrderByNomWatcheAsc() {
		List<Watche> watches = watcheRepository.findByOrderByNomWatcheAsc();
		for (Watche w : watches) {
			System.out.println(w);
		}
	}

	@Test
	public void testTrierWatchesNomsPrix() {
		List<Watche> watches = watcheRepository.trierWatchesNomsPrix();
		for (Watche w : watches) {
			System.out.println(w);
		}
	}
}
