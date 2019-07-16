//package com.platform.papafood.controller;
//
//import com.platform.papafood.commons.ApiConstant;
//import com.platform.papafood.commons.Utils;
//import com.platform.papafood.dto.ResponseDto;
//import com.platform.papafood.models.PackageModel;
//import com.platform.papafood.service.PackageService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//@RestController
//@RequestMapping(value = ApiConstant.FOOD)
//@Slf4j
//public class PackageController {
//
//    //    private static final Logger LOG = Logger.getLogger(PackageController.class);
//
//    @Autowired
//    PackageService packageService;
//
//    @GetMapping(value = ApiConstant.LIST_PACKAGE)
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseDto<List<PackageModel>> packages(HttpServletRequest request) {
//        try {
//            List<String> list = Utils.convertStringToListString(request.getHeader("Authorization"), " ");
//            String token = Utils.isEmpty(list) || list.size() < 2 ? "" : list.get(1);
//            return new ResponseDto<>(packageService.list(token));
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//
//}
