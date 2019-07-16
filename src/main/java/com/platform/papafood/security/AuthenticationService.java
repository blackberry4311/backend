package com.platform.papafood.security;

public interface AuthenticationService {
    UserDetails retrieve(String token);

    UserDetails getCurrentUser();
}
