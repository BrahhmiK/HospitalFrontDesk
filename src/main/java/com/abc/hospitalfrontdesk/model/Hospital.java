package com.abc.hospitalfrontdesk.model;

public class Hospital {
    private int id;
    private String name;
    private int bedsAvailable;

    public Hospital(int id, String name, int bedsAvailable) {
        this.id = id;
        this.name = name;
        this.bedsAvailable = bedsAvailable;
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

    public int getBedsAvailable() {
        return bedsAvailable;
    }

    public void setBedsAvailable(int bedsAvailable) {
        this.bedsAvailable = bedsAvailable;
    }
}
