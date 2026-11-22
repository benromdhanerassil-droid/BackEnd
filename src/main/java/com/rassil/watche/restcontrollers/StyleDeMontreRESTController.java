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

import com.rassil.watche.entities.StyleDeMontre;
import com.rassil.watche.repos.StyleDeMontreRepository;

@RestController
@RequestMapping("/api/style")
@CrossOrigin(origins = "*")
public class StyleDeMontreRESTController {

	@Autowired
	private StyleDeMontreRepository styleDeMontreRepository;

	@GetMapping
	public List<StyleDeMontre> getAllStyles() {
		return styleDeMontreRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<StyleDeMontre> getStyleById(@PathVariable("id") Long id) {
		return styleDeMontreRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public StyleDeMontre createStyle(@RequestBody StyleDeMontre style) {
		return styleDeMontreRepository.save(style);
	}

	@PutMapping("/{id}")
	public ResponseEntity<StyleDeMontre> updateStyle(@PathVariable("id") Long id, @RequestBody StyleDeMontre style) {
		return styleDeMontreRepository.findById(id).map(existing -> {
			existing.setNomStyle(style.getNomStyle());
			existing.setDescriptionStyle(style.getDescriptionStyle());
			return ResponseEntity.ok(styleDeMontreRepository.save(existing));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStyle(@PathVariable("id") Long id) {
		if (!styleDeMontreRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		styleDeMontreRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

