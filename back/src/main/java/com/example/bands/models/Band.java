package com.example.bands.models;

import jdk.nashorn.internal.ir.debug.JSONWriter;

import java.io.Serializable;

public class Band implements Serializable {

    private int id;

    private String name;

    private String country;

    private String genre;

    private int year;

    public Band(int id, String name, String country, String genre, int year){
        this.id = id;
        this.name = name;
        this.country = country;
        this.year = year;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("ID: %d,\nName: %s,\nCountry: %s,\nGenre: %s,\nYear: %d", id,name,country,genre,year);
    }
}
