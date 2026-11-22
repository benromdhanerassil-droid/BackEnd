package com.rassil.watche.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;

import com.rassil.watche.entities.StyleDeMontre;
import com.rassil.watche.entities.Watche;

@RepositoryRestResource(path = "rest")
public interface WatcheRepository extends JpaRepository<Watche, Long> {

	List<Watche> findByNomWatche(String nom);

	List<Watche> findByNomWatcheContains(String nom);

	@Query("select w from Watche w where w.nomWatche like %:nom and w.prixWatches > :prix")
	List<Watche> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);

	@Query("select w from Watche w where w.styleDeMontre = ?1")
	List<Watche> findByStyleDeMontre(StyleDeMontre styleDeMontre);

	List<Watche> findByStyleDeMontreIdStyle(Long id);

	List<Watche> findByStyleDeMontreIsNull();

	List<Watche> findByOrderByNomWatcheAsc();

	@Query("select w from Watche w order by w.nomWatche ASC, w.prixWatches DESC")
	List<Watche> trierWatchesNomsPrix();
}
