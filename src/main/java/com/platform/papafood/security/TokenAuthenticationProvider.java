package com.platform.papafood.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private AuthenticationService authenticationService;

    public TokenAuthenticationProvider(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        // Nothing to do
    }

    @Override
    protected UserDetails retrieveUser(String token,
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        return this.authenticationService.retrieve(token);
    }
}
