package com.example.bands.models;

import java.io.Serializable;

public class Member implements Serializable {

    private int id;

    private String name;

    private int bandId;

    public Member(int id, String name, int bandId){
        this.id = id;
        this.name = name;
        this.bandId = bandId;
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

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }
}
