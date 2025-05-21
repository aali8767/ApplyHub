package com.example.applyhub.models;

public class Certification {
    private int id;
    private String abbreviation;
    private String name;

    public Certification(int id, String abbreviation, String name) {
        this.id = id;
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
