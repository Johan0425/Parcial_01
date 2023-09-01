/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.Genre;

/**
 *
 * @author joanp
 */
public class Song {

    private final int id;
    private String name;
    private String author;
    private Genre genre;
    private String duration;
    private String launch;
    private String platform;

    public Song(int id, String name, String author, Genre genre, String duration, String launch, String platform) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.duration = duration;
        this.launch = launch;
        this.platform = platform;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getDuration() {
        return duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getLaunch() {
        return launch;
    }

    public String getName() {
        return name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setLaunch(String launch) {
        this.launch = launch;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

}
