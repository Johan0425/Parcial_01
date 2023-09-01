/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import connection.BDConnection;
import enums.Genre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Song;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author joanp
 */
public class Controller {

    private final BDConnection conn;
    private final Connection con;

    public Controller() {

        this.conn = new BDConnection();
        this.con = conn.getConnection();
    }

    public ArrayList<Song> listSongs() {
        ArrayList<Song> songs = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM tabla_canciones";

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("nombre");
                String author = rs.getString("autor");
                Genre genre = Genre.valueOf(rs.getString("genero"));
                String duration = rs.getString("duracion");
                String launch = rs.getString("lanzamiento");
                String platform = rs.getString("plataforma");

                Song song = new Song(0, name, author, genre, duration, launch, platform);
                songs.add(song);
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return songs;
    }

    public Song searchBook(int id) {
        try {
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM tabla_canciones WHERE id = ?";

            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("nombre");
                String author = rs.getString("autor");
                Genre genre = Genre.valueOf(rs.getString("genero"));
                String duration = rs.getString("duracion");
                String launch = rs.getString("lanzamiento");
                String platform = rs.getString("plataforma");

                Song song = new Song(id, name, author, genre, duration, launch, platform);

                return song;
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return null;
    }

    public void addSong(Song song) throws SQLException {
        try {
            PreparedStatement ps;

            String query = "INSERT INTO tabla_canciones (id, nombre, autor, genero, duracion, lanzamiento, plataforma) VALUES (?, ?, ?, ?, ?, ?,?)";

            ps = con.prepareStatement(query);

            ps.setInt(1, song.getId());
            ps.setString(3, song.getName());
            ps.setString(2, song.getAuthor());
            ps.setString(4, song.getGenre().name());
            ps.setString(5, song.getDuration());
            ps.setString(6, song.getLaunch());
            ps.setString(7, song.getPlatform());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.toString());
            throw new SQLException();
        }
    }

    public boolean updateSong(Song song) {
        try {
            PreparedStatement ps;

            String query = "UPDATE books SET nombre = ?, autor = ?, genero = ?, duracion = ?, lanzamiento = ?, plataforma = ? WHERE isbn = ?";

            ps = con.prepareStatement(query);
            ps.setString(1, song.getName());
            ps.setString(2, song.getAuthor());
            ps.setString(3, song.getGenre().name());
            ps.setString(4, song.getDuration());
            ps.setString(5, song.getLaunch());
            ps.setString(6, song.getPlatform());
            ps.setInt(7, song.getId());

            int rowsUpdated = ps.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
        }
    }

    public boolean deleteSong(int id) {
        try {
            PreparedStatement ps;

            String query = "DELETE FROM tabla_canciones WHERE id = ?";

            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rowDeleted = ps.executeUpdate();

            return rowDeleted > 0;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return false;
    }

}
