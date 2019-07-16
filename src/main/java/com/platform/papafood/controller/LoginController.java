package com.platform.papafood.controller;

import com.platform.papafood.commons.ApiConstant;
import com.platform.papafood.dao.LoginRequest;
import com.platform.papafood.exception.BusinessException;
import com.platform.papafood.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.com.bmbsteel.warehouse.dto.LoginResponse;

@RestController
@RequestMapping(ApiConstant.LOGIN)
@Slf4j
@AllArgsConstructor
public class LoginController extends AbstractController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest param) throws BusinessException {
        return userService.doLogin(param.getUserName(), param.getPassword());
    }
}
