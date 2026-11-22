package com.rassil.watche;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.rassil.watche.entities.StyleDeMontre;
import com.rassil.watche.entities.Watche;
import com.rassil.watche.repos.StyleDeMontreRepository;
import com.rassil.watche.repos.WatcheRepository;

@SpringBootApplication
public class WatcheApplication implements CommandLineRunner {

	@Autowired
	private StyleDeMontreRepository styleDeMontreRepository;

	@Autowired
	private WatcheRepository watcheRepository;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(WatcheApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Watche.class, StyleDeMontre.class);
		// Vérifier si des données existent déjà
		if (styleDeMontreRepository.count() == 0) {
			// Créer des styles de montre
			StyleDeMontre s1 = new StyleDeMontre("Classique", "Montres de style classique et élégant");
			StyleDeMontre s2 = new StyleDeMontre("Sport", "Montres sportives et robustes");
			StyleDeMontre s3 = new StyleDeMontre("Luxe", "Montres de luxe haut de gamme");

			styleDeMontreRepository.save(s1);
			styleDeMontreRepository.save(s2);
			styleDeMontreRepository.save(s3);

			// Créer des montres
			Watche w1 = new Watche("Rolex Submariner", 8500.0, new Date());
			w1.setStyleDeMontre(s3);
			watcheRepository.save(w1);

			Watche w2 = new Watche("Casio G-Shock", 150.0, new Date());
			w2.setStyleDeMontre(s2);
			watcheRepository.save(w2);

			Watche w3 = new Watche("Tissot Heritage", 450.0, new Date());
			w3.setStyleDeMontre(s1);
			watcheRepository.save(w3);

			Watche w4 = new Watche("Omega Seamaster", 4200.0, new Date());
			w4.setStyleDeMontre(s3);
			watcheRepository.save(w4);

			Watche w5 = new Watche("Seiko Prospex", 350.0, new Date());
			w5.setStyleDeMontre(s2);
			watcheRepository.save(w5);

			System.out.println("=== Données initiales créées avec succès ===");
		} else {
			System.out.println("=== Les données existent déjà ===");
		}

		// Repair legacy watches that were saved without a style.
		List<StyleDeMontre> styles = styleDeMontreRepository.findAll();
		StyleDeMontre defaultStyle = styles.stream()
				.filter(style -> "Classique".equalsIgnoreCase(style.getNomStyle()))
				.findFirst()
				.orElse(styles.isEmpty() ? null : styles.get(0));
		if (defaultStyle != null) {
			List<Watche> watchesWithoutStyle = watcheRepository.findByStyleDeMontreIsNull();
			watchesWithoutStyle.forEach(watche -> watche.setStyleDeMontre(defaultStyle));
			watcheRepository.saveAll(watchesWithoutStyle);
			System.out.println("=== Montres sans style associées au style " + defaultStyle.getNomStyle() + " : "
					+ watchesWithoutStyle.size() + " ===");
		}
	}
}

