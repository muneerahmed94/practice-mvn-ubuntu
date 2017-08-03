package com.home.assignment.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zoo {
    private String zooName;
    private Map<Integer, Animal> animals;

    public Zoo(String zooName) {
        this.zooName = zooName;
        animals = new HashMap<Integer, Animal>();
    }

    public int getNoOfAnimals() {
        return animals.size();
    }

    public void addAnimal(Animal animal) {
        animals.put(animal.getAnimalId(), animal);
    }

    public void listAllAnimals() {

    }
}
