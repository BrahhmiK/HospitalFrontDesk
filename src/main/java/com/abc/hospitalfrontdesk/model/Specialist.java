package com.abc.hospitalfrontdesk.model;

import java.util.List;

public class Specialist {
    private String type;
    private String name;
    private List<String> availableDays;
    private String availableTime;
    Boolean isAvailable;
    int hospitalId;

    public Specialist(String type, String name, List<String> availableDays, String availableTime, Boolean isAvailable, int hospitalId) {
        this.type = type;
        this.name = name;
        this.availableDays = availableDays;
        this.availableTime = availableTime;
        this.isAvailable = isAvailable;
        this.hospitalId = hospitalId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(List<String> availableDays) {
        this.availableDays = availableDays;
    }

    public String getAvailableTime() {
        return availableTime;
    }

    public void setAvailableTime(String availableTime) {
        this.availableTime = availableTime;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }
}
