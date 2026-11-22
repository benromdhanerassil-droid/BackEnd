package com.rassil.watche.entities;

import org.springframework.data.rest.core.config.Projection;

/** A compact watch representation for clients that only need its name. */
@Projection(name = "nomWatche", types = { Watche.class })
public interface WatcheProjection {
	String getNomWatche();
}
