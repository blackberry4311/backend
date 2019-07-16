package com.platform.papafood.service;

import com.platform.papafood.config.properties.SecurityProperties;
import com.platform.papafood.exception.BusinessException;
import com.platform.papafood.models.TokenModel;
import com.platform.papafood.models.UserModel;
import com.platform.papafood.util.DateTimeUtils;
import com.tpp.persistence.GenericDao;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vn.com.bmbsteel.warehouse.dto.LoginResponse;

import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
@Transactional(value = "transactionManager", propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {
    private final GenericDao genericDao;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final SecurityProperties securityConfig;

    @Override
    @Transactional(transactionManager = "transactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public LoginResponse doLogin(String userName, String password) throws BusinessException {
        UserModel existed = genericDao
                .findUnique(UserModel.class, new String[] { "userName" }, new Object[] { userName });

        if (existed != null && passwordEncoder.matches(password, existed.getPassword())) {
            final String token = tokenService.generateBase64Token();
            TokenModel tokenModel = TokenModel.builder().token(token).user(existed)
                    .expiredAt(DateUtils.addHours(DateTimeUtils.nowInUTC(), securityConfig.getExpiredInHours()))
                    .build();
            genericDao.create(tokenModel);

            LoginResponse result = LoginResponse.builder().token(token).username(userName).roleNames(
                    existed.getRoleModels().stream().map(role -> role.getName()).collect(Collectors.toList())).build();
            return result;
        } else throw new BusinessException(String.format("wrong user name or password"));
    }

    public static void main(String[] args) {
        PasswordEncoder p = new BCryptPasswordEncoder();
        System.out.println(p.encode("password"));
    }
}
