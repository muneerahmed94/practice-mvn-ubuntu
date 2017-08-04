package com.home.assignment.model;

public class Parrot extends Bird {
    boolean canSpeak;

    public Parrot(String name, String favoriteFood, Zoo zoo, float wingSpan, boolean canSpeak) {
        super(name, favoriteFood, zoo, wingSpan);
        this.canSpeak = canSpeak;
    }

    @Override
    public String toString() {
        return super.toString() + "Parrot{" +
                "canSpeak=" + canSpeak +
                '}';
    }
}
