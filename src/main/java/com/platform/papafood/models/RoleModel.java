package com.platform.papafood.models;

import com.tpp.persistence.AbstractExtensibleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel extends AbstractExtensibleEntity<String> {
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_OPERATOR = "OPERATOR";
    public static final String ROLE_CUSTOMER = "CUSTOMER";

    private String name;
}
