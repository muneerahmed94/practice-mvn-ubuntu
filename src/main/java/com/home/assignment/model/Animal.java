package com.home.assignment.model;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private int animalId;
    private String name;
    private String favoriteFood;
    private Zoo zoo;
    private List<Integer> friends;

    public Animal(String name, String favoriteFood, Zoo zoo) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.zoo = zoo;
        this.animalId = zoo.getNoOfAnimals();
        friends = new ArrayList<Integer>();
        this.setZoo(zoo);
        zoo.addAnimal(this);
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
}
