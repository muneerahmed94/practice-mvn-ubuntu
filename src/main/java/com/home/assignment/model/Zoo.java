package com.home.assignment.model;

import java.util.*;

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

    public int findAFriend(int animalId) {
        Animal animal = animals.get(animalId);
        Set<Integer> friends = animal.getFriends();

        List<Integer> possibleFriends = new ArrayList<Integer>();
        for(int aId: animals.keySet()) {
            if(aId != animalId && !friends.contains(aId)) {
                possibleFriends.add(aId);
            }
        }

        int noOfPossibleFriends = possibleFriends.size();
        if(noOfPossibleFriends == 0) {
            return -1;
        }

        Random random = new Random();
        int randomNo = random.nextInt(noOfPossibleFriends);
        return possibleFriends.get(randomNo);
    }

    public void listAllAnimals() {
        for(int animalId: animals.keySet()) {
            Animal animal = animals.get(animalId);
            System.out.println(animal);
            System.out.print("Friends: ");
            animal.printFriends();
            System.out.println("\n");
        }
    }

    public void addFriends() {
        boolean[] animalsProcessed = new boolean[animals.size()];
        for (int animalId: animals.keySet()) {
            if(!animalsProcessed[animalId]) {
                Animal animal = animals.get(animalId);
                int newFriendId = findAFriend(animalId);
                if(newFriendId != -1) {
                    animal.addFriend(newFriendId);
                    Animal friendAnimal = animals.get(newFriendId);
                    friendAnimal.addFriend(animalId);
                    System.out.println(animal.getName() + " has established friendship with " + friendAnimal.getName());
                    animalsProcessed[newFriendId] = true;
                }
                animalsProcessed[animalId] = true;
            }
        }
    }

    public void removeFriends() {
        boolean[] animalsProcessed = new boolean[animals.size()];
        for (int animalId: animals.keySet()) {
            if(!animalsProcessed[animalId]) {
                Animal animal = animals.get(animalId);
                int noOfFriends = animal.getNoOfFriends();
                if(noOfFriends > 0) {
                    Random random = new Random();
                    int randomNo = random.nextInt(noOfFriends);
                    Set<Integer> friends = animal.getFriends();
                    int count = 0;
                    for(int friendId: friends) {
                        if(count == randomNo) {
                            friends.remove(friendId);
                            Animal friendAnimal = animals.get(friendId);
                            friendAnimal.removeFriend(animalId);
                            System.out.println(animal.getName() + " has lost friendship with " + friendAnimal.getName());
                            animalsProcessed[friendId] = true;
                            break;
                        }
                        count++;
                    }
                }
                animalsProcessed[animalId] = true;
            }

        }
    }

    public void liveOneDay() {
        System.out.println("-----Remove friends------");
        removeFriends();
        System.out.println("\n");
        System.out.println("-----Add friends-----");
        addFriends();
        System.out.println("\n");
    }

    public Map<Integer, Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Map<Integer, Animal> animals) {
        this.animals = animals;
    }
}
