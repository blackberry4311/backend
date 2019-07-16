package com.platform.papafood.models;

import java.util.List;

public class FoodCategoryModel {
    private int id;
    private String name;
    private List<String> type;
    private float price;
    private String currency;

    public FoodCategoryModel() {

    }


    public FoodCategoryModel(int id, String name, List<String> type, float price, String currency) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
