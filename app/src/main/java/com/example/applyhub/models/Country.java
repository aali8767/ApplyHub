package com.example.applyhub.models;

public class Country {
    private int id;
    private String code;
    private String prefix_number;
    private String country_image;
    private String name;

    public Country(int id, String code, String prefix_number, String country_image, String name) {
        this.id = id;
        this.code = code;
        this.prefix_number = prefix_number;
        this.country_image = country_image;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrefix_number() {
        return prefix_number;
    }

    public void setPrefix_number(String prefix_number) {
        this.prefix_number = prefix_number;
    }

    public String getCountry_image() {
        return country_image;
    }

    public void setCountry_image(String country_image) {
        this.country_image = country_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
