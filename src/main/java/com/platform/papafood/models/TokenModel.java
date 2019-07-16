package com.platform.papafood.models;

import com.tpp.persistence.AbstractExtensibleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenModel extends AbstractExtensibleEntity<String> {
    private String token;
    private Date expiredAt;
    private UserModel user;
}
