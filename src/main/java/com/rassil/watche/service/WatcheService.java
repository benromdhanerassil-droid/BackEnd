package com.rassil.watche.service;

import java.util.List;

import com.rassil.watche.entities.StyleDeMontre;
import com.rassil.watche.entities.Watche;

public interface WatcheService {

	Watche saveWatche(Watche w);

	Watche updateWatche(Watche w);

	void deleteWatche(Watche w);

	void deleteWatcheById(Long id);

	Watche getWatche(Long id);

	List<Watche> getAllWatches();

	List<Watche> findByNomWatche(String nom);

	List<Watche> findByNomWatcheContains(String nom);

	List<Watche> findByNomPrix(String nom, Double prix);

	List<Watche> findByStyleDeMontre(StyleDeMontre styleDeMontre);

	List<Watche> findByStyleDeMontreIdStyle(Long id);

	List<Watche> findByOrderByNomWatcheAsc();

	List<Watche> trierWatchesNomsPrix();
}
