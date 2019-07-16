package com.platform.papafood.service;

import com.platform.papafood.exception.BusinessException;
import vn.com.bmbsteel.warehouse.dto.LoginResponse;

public interface UserService {
    LoginResponse doLogin(String userName, String password) throws BusinessException;
}
