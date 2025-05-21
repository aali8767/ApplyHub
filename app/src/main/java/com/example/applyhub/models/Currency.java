package com.example.applyhub.models;

public class Currency {
    private int id;
    private String name;
    private String shape;


    public Currency(int id, String name, String shape) {
        this.id = id;
        this.name = name;
        this.shape = shape;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
