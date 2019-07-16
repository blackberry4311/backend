package com.platform.papafood.models;

import com.tpp.persistence.AbstractExtensibleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuModel extends AbstractExtensibleEntity<String> {
    private Date date;
    private String name;
    private Set<FoodModel> foodModels;
}
