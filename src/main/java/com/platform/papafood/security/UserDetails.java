package com.platform.papafood.security;

import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Value
public class UserDetails extends User {
    private String email;//maybe, so FIXME
    private String userId;

    public UserDetails(String userId, String userName, String email,
            Collection<? extends GrantedAuthority> authorities) {
        super(userName, userName, authorities);
        this.userId = userId;
        this.email = email;
    }
}
