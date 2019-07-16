package com.platform.papafood.models;

import com.tpp.persistence.AbstractExtensibleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel extends AbstractExtensibleEntity<String> {
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private String status;
    private Set<RoleModel> roleModels;
}
