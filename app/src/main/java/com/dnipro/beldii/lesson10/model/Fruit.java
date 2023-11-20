package com.dnipro.beldii.lesson10.model;

import com.dnipro.beldii.lesson10.helpers.MyJson;

public class Fruit {
    @MyJson()
     private String name;
    @MyJson()
     private int id;
    @MyJson()
     private String family;
    @MyJson()
     private String order;
    @MyJson()
     private String genus;
    @MyJson()
     private Nutrition nutritions = new Nutrition();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    class Nutrition {
        int calories;
        double fat;
        double sugar;
        double carbohydrates;
        double protein;
    }
}
