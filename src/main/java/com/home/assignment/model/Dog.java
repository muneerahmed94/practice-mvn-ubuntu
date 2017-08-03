package com.home.assignment.model;

public class Dog extends Animal {
    private String dogType;

    public Dog(String name, String favoriteFood, Zoo zoo, String dogType) {
        super(name, favoriteFood, zoo);
        this.dogType = dogType;
    }

    public String getDogType() {
        return dogType;
    }

    public void setDogType(String dogType) {
        this.dogType = dogType;
    }
}
