package com.dnipro.beldii.lesson10.model;

import java.io.Serializable;

public class Fruit implements Serializable {
     private String name;
     private int id;
     private String family;
     private String order;
     private String genus;
     private final Nutrition nutritions = new Nutrition();

    public Nutrition getNutritions() {
        return nutritions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getFamily() {
        return family;
    }

    public String getOrder() {
        return order;
    }

    public String getGenus() {
        return genus;
    }

    public static class Nutrition implements Serializable {
        int calories;
        double fat;
        double sugar;
        double carbohydrates;
        double protein;

        public int getCalories() {
            return calories;
        }

        public double getFat() {
            return fat;
        }

        public double getSugar() {
            return sugar;
        }

        public double getCarbohydrates() {
            return carbohydrates;
        }

        public double getProtein() {
            return protein;
        }
    }
}
