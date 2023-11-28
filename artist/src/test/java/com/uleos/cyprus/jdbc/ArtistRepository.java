package com.uleos.cyprus.jdbc;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Random;

@ApplicationScoped
public class ArtistRepository {


    private Random randomGenerator = new Random();
    
    @Inject
    private DataSource dataSource;

    public void persist(Artist artist) throws SQLException {

        Connection conn = dataSource.getConnection();
        String sql = "INSERT INTO t_artists (id, name, bio, created_date) VALUES (?, ?, ?, ?)";
        artist.setId(randomGenerator.nextInt(Integer.MAX_VALUE - 1));

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, artist.getId());
            ps.setString(2, artist.getName());
            ps.setString(3, artist.getBio());
            ps.setTimestamp(4, Timestamp.from(artist.getCreated()));
            ps.executeUpdate();
        }
        conn.close();


    }

    public Artist findById(Long id) throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = "SELECT id, name, bio, created_date FROM t_artists WHERE id = ?";
        Artist artist = new Artist();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                artist.setId(rs.getLong(1));
                artist.setName(rs.getString(2));
                artist.setBio(rs.getString(3));
                artist.setCreated(rs.getTimestamp(4).toInstant());
            }
        }
        conn.close();
        return artist;
    }

}
