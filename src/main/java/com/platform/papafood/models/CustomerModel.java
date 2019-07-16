package com.platform.papafood.models;

import java.util.List;

public class CustomerModel {
    private long id;
    private String name;
    private String avatar;
    private String phone;
    private String email;
    private String address;
    private List<IngredientModel> allgergy;

    public CustomerModel() {

    }

    public CustomerModel(long id, String name, String avatar, String phone, String email, String address, List<IngredientModel> allgergy) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.allgergy = allgergy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<IngredientModel> getAllgergy() {
        return allgergy;
    }

    public void setAllgergy(List<IngredientModel> allgergy) {
        this.allgergy = allgergy;
    }
}
