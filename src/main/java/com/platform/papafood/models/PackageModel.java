package com.platform.papafood.models;

import java.util.List;

public class PackageModel {
    private int id;
    private String name;
    private boolean test;
    private String description;
    private String descriptionDiscount;
    private int dates;
    private int setsDelivery;
    private int term;
    private String condition;
    private boolean active;


    public PackageModel() {

    }

    public PackageModel(int id, String name, boolean test, String description, String descriptionDiscount, int dates, int setsDelivery, int term, String condition, boolean active) {
        this.id = id;
        this.name = name;
        this.test = test;
        this.description = description;
        this.descriptionDiscount = descriptionDiscount;
        this.dates = dates;
        this.setsDelivery = setsDelivery;
        this.term = term;
        this.condition = condition;
        this.active = active;
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

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionDiscount() {
        return descriptionDiscount;
    }

    public void setDescriptionDiscount(String descriptionDiscount) {
        this.descriptionDiscount = descriptionDiscount;
    }

    public int getDates() {
        return dates;
    }

    public void setDates(int dates) {
        this.dates = dates;
    }

    public int getSetsDelivery() {
        return setsDelivery;
    }

    public void setSetsDelivery(int setsDelivery) {
        this.setsDelivery = setsDelivery;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
