package com.platform.papafood.controller;

import com.platform.papafood.commons.ApiConstant;
import com.platform.papafood.dto.ResponseDto;
import com.platform.papafood.exception.BusinessException;
import com.platform.papafood.models.MenuModel;
import com.platform.papafood.service.MenuService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = ApiConstant.MENU)
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Secured({ "ROLE_ADMIN", "ROLE_CUSTOMER" })
    public ResponseDto<MenuModel> findMenuByDay(
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE) LocalDate menuDate)
            throws BusinessException {
        return new ResponseDto<>(menuService
                .findMenuByDate(Date.from(menuDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())));
    }
}
