package com.rassil.watche.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rassil.watche.entities.StyleDeMontre;
import com.rassil.watche.entities.Watche;
import com.rassil.watche.repos.WatcheRepository;

@Service
public class WatcheServiceImpl implements WatcheService {

	@Autowired
	private WatcheRepository watcheRepository;

	@Override
	public Watche saveWatche(Watche w) {
		return watcheRepository.save(w);
	}

	@Override
	public Watche updateWatche(Watche w) {
		return watcheRepository.save(w);
	}

	@Override
	public void deleteWatche(Watche w) {
		watcheRepository.delete(w);
	}

	@Override
	public void deleteWatcheById(Long id) {
		watcheRepository.deleteById(id);
	}

	@Override
	public Watche getWatche(Long id) {
		return watcheRepository.findById(id).orElse(null);
	}

	@Override
	public List<Watche> getAllWatches() {
		return watcheRepository.findAll();
	}

	@Override
	public List<Watche> findByNomWatche(String nom) {
		return watcheRepository.findByNomWatche(nom);
	}

	@Override
	public List<Watche> findByNomWatcheContains(String nom) {
		return watcheRepository.findByNomWatcheContains(nom);
	}

	@Override
	public List<Watche> findByNomPrix(String nom, Double prix) {
		return watcheRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Watche> findByStyleDeMontre(StyleDeMontre styleDeMontre) {
		return watcheRepository.findByStyleDeMontre(styleDeMontre);
	}

	@Override
	public List<Watche> findByStyleDeMontreIdStyle(Long id) {
		return watcheRepository.findByStyleDeMontreIdStyle(id);
	}

	@Override
	public List<Watche> findByOrderByNomWatcheAsc() {
		return watcheRepository.findByOrderByNomWatcheAsc();
	}

	@Override
	public List<Watche> trierWatchesNomsPrix() {
		return watcheRepository.trierWatchesNomsPrix();
	}
}
