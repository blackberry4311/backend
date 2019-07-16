package com.platform.papafood.controller;

import com.platform.papafood.commons.ApiConstant;
import com.platform.papafood.dto.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstant.HEALTH)
@Slf4j
@AllArgsConstructor
public class HealthController extends AbstractController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto<String> searchHistory() throws Exception {
        return new ResponseDto<>("OK!");
    }
}
