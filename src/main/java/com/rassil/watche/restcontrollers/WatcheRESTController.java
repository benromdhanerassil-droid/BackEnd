package com.rassil.watche.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rassil.watche.entities.Watche;
import com.rassil.watche.service.WatcheService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class WatcheRESTController {

	@Autowired
	private WatcheService watcheService;

	@GetMapping
	public List<Watche> getAllWatches() {
		return watcheService.getAllWatches();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Watche> getWatcheById(@PathVariable("id") Long id) {
		Watche w = watcheService.getWatche(id);
		if (w == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(w);
	}

	@PostMapping
	public Watche createWatche(@RequestBody Watche watche) {
		return watcheService.saveWatche(watche);
	}

	@PutMapping
	public Watche updateWatche(@RequestBody Watche watche) {
		return watcheService.updateWatche(watche);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteWatche(@PathVariable("id") Long id) {
		watcheService.deleteWatcheById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/watchesStyle/{idStyle}")
	public List<Watche> getWatchesByStyleId(@PathVariable("idStyle") Long idStyle) {
		return watcheService.findByStyleDeMontreIdStyle(idStyle);
	}

	@GetMapping("/watchescat/{idStyle}")
	public List<Watche> getWatchesByCatId(@PathVariable("idStyle") Long idStyle) {
		return watcheService.findByStyleDeMontreIdStyle(idStyle);
	}

	@GetMapping("/watchesByName/{nom}")
	public List<Watche> findByNomWatcheContains(@PathVariable("nom") String nom) {
		return watcheService.findByNomWatcheContains(nom);
	}
}

