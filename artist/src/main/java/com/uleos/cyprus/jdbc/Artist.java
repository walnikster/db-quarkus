package com.uleos.cyprus.jdbc;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class Artist {

    private Long id;
    private String name;
    private String bio;
    private Instant created = Instant.now();

    public Artist() {
    }

    public Artist(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }
}
