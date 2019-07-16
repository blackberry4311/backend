package com.platform.papafood.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SetFoodModel {
    private int id;
    private String name;
    private String mainBottle;
    private List<String> subBottle;
    private float price;
    private String currency;
    private boolean active;
}
