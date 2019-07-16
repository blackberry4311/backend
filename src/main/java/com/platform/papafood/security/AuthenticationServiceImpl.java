package com.platform.papafood.security;

import com.platform.papafood.models.TokenModel;
import com.platform.papafood.util.DateTimeUtils;
import com.tpp.persistence.GenericDao;
import com.tpp.persistence.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional(value = "transactionManager", propagation = Propagation.SUPPORTS)
public class AuthenticationServiceImpl implements AuthenticationService {
    private final GenericDao genericDao;

    @Override
    public UserDetails retrieve(String issuedToken) {
        SearchCriteria<TokenModel> criteria = new SearchCriteria<>();
        criteria.getMeta().setValue("expiredAt >", DateTimeUtils.nowInUTC());
        criteria.getMeta().setValue("token", issuedToken);

        return genericDao.find(TokenModel.class, criteria).getList().stream().findFirst().map(token -> token.getUser())
                .map(user -> {
                    final List<SimpleGrantedAuthority> roles = user.getRoleModels().stream()
                            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                            .collect(Collectors.toList());
                    return new UserDetails(user.getId(), user.getUserName(), user.getEmail(), roles);
                }).orElseThrow(() -> new BadCredentialsException("Invalid token"));
    }

    @Override
    public UserDetails getCurrentUser() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
