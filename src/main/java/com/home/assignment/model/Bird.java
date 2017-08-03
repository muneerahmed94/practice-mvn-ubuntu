package com.home.assignment.model;

public class Bird extends Animal {
    private float wingSpan;

    public Bird(String name, String favoriteFood, Zoo zoo, float wingSpan) {
        super(name, favoriteFood, zoo);
        this.wingSpan = wingSpan;
    }

    public float getWingSpan() {
        return wingSpan;
    }

    public void setWingSpan(float wingSpan) {
        this.wingSpan = wingSpan;
    }
}
