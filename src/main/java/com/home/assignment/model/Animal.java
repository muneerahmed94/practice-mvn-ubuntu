package com.home.assignment.model;

import java.util.*;

public class Animal {
    private int animalId;
    private String name;
    private String favoriteFood;
    private Zoo zoo;
    private Set<Integer> friends;

    public Animal(String name, String favoriteFood, Zoo zoo) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.zoo = zoo;
        this.animalId = zoo.getNoOfAnimals();
        friends = new HashSet<Integer>();
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

    public int getNoOfFriends() {
        return friends.size();
    }

    public void addFriend(int animalId) {
        friends.add(animalId);
    }

    public void removeFriend(int animalId) {
        friends.remove(animalId);
    }

    public Set<Integer> getFriends() {
        return friends;
    }

    public void setFriends(Set<Integer> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", name='" + name + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                '}';
    }

    public void printFriends() {
        Zoo zoo = this.zoo;

        List<String> friendsList = new ArrayList<String>();
        for(int friendId: friends) {
            Animal friendAnimal = zoo.getAnimals().get(friendId);
            friendsList.add(friendAnimal.getAnimalId() + ": " + friendAnimal.getName());
        }

        System.out.println(friendsList);
    }
}
