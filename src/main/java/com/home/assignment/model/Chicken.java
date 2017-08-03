package com.home.assignment.model;

public class Chicken extends Bird {
    private boolean isBroiler;

    public Chicken(String name, String favoriteFood, Zoo zoo, float wingSpan, boolean isBroiler) {
        super(name, favoriteFood, zoo, wingSpan);
        this.isBroiler = isBroiler;
    }


    public boolean isBroiler() {
        return isBroiler;
    }

    public void setBroiler(boolean broiler) {
        isBroiler = broiler;
    }
}
