package com.home.assignment.test;

import com.home.assignment.model.*;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("Nehru Zoological garden");

        Dog dog1 = new Dog("Dog wild", "Meat", zoo, "Hunting");
        Parrot parrot1 = new Parrot("Parrot one", "Grain", zoo, 0.25f, false);
        Chicken chicken1 = new Chicken("Chicken one", "Corn", zoo, 0.75f, true);
        Dog dog2 = new Dog("Dog tame", "Fresh meat", zoo, "Assistance dog");
        Parrot parrot2 = new Parrot("Parrot two", "Grain", zoo, 0.5f, true);
        Dog dog3 = new Dog("Dog three", "pedigree", zoo, "Racing dog");
        Chicken chicken2 = new Chicken("Chicken two", "Corn", zoo, 0.75f, false);

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("-----Menu-----");
            System.out.println("1) List Animals");
            System.out.println("2) Live one day");
            System.out.println("3) Quit");

            System.out.println("Enter any option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    zoo.listAllAnimals();
                    break;
                case 2:
                    zoo.liveOneDay();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice, please try again");

            }
        }
    }
}
