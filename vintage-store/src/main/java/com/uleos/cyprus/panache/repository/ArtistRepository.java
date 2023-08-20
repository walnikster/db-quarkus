package com.uleos.cyprus.panache.repository;

import com.uleos.cyprus.jdbc.Artist;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist> {
}
