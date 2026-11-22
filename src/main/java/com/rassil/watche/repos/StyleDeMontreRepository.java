package com.rassil.watche.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.rassil.watche.entities.StyleDeMontre;

@RepositoryRestResource(path = "styles", collectionResourceRel = "styles")
@CrossOrigin(origins = "http://localhost:4200")
public interface StyleDeMontreRepository extends JpaRepository<StyleDeMontre, Long> {
}
