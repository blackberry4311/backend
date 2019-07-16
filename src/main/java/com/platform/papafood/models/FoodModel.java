package com.platform.papafood.models;

import com.tpp.persistence.AbstractExtensibleEntity;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodModel extends AbstractExtensibleEntity<String> {
    private String name;
    private String image;
    private Boolean status;
    private FoodCategoryModel foodCategoryModel;
    private String ingredient;
    private List<Integer> ingredientIds;
    private List<Map<String, String>> nutrition;
    private String capacity;
    private boolean allergy;
}
