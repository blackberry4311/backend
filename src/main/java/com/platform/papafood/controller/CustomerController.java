//package com.platform.papafood.controller;
//
//import com.platform.papafood.service.CustomerService;
//import com.platform.papafood.commons.ApiConstant;
//import com.platform.papafood.commons.ERROR;
//import com.platform.papafood.dto.ResponseDto;
//import com.platform.papafood.models.CustomerModel;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@CrossOrigin(origins = "*", allowCredentials = "true")
//@RequestMapping(value = ApiConstant.FOOD)
//public class CustomerController {
//
//    private static final Logger LOGGER = Logger.getLogger(CustomerController.class);
//
//    @Autowired
//    CustomerService customerService;
//
//    @RequestMapping(value = ApiConstant.GET_CUSTOMER, method = RequestMethod.GET)
//    public ResponseDto<CustomerModel> getCustomer(@PathVariable String id) {
//        try {
//            return new ResponseDto<>(ERROR.SUCCESS, customerService.get(id));
//        } catch (Exception e) {
//            LOGGER.error(e);
//            return new ResponseDto<>(ERROR.FAILURE, e.getMessage());
//        }
//    }
//
//    @RequestMapping(value = ApiConstant.CUSTOMER, method = RequestMethod.POST)
//    public ResponseDto<Map<String, Integer>> insertCustomer(@RequestBody Map<String, Object> mapBody) {
//        try {
//            Map<String, Integer> mapResponse = new HashMap<>();
//            mapResponse.put("result", customerService.insert(mapBody));
//            return new ResponseDto<>(ERROR.SUCCESS, mapResponse);
//        } catch (Exception e) {
//            LOGGER.error(e);
//            return new ResponseDto<>(ERROR.FAILURE, e.getMessage());
//        }
//    }
//
//    @RequestMapping(value = ApiConstant.CUSTOMER, method = RequestMethod.PUT)
//    public ResponseDto<Map<String, Integer>> updateCustomer(@RequestBody Map<String, Object> mapBody) {
//        try {
//            Map<String, Integer> mapResponse = new HashMap<>();
//            mapResponse.put("result", customerService.update(mapBody));
//            return new ResponseDto<>(ERROR.SUCCESS, mapResponse);
//        } catch (Exception e) {
//            LOGGER.error(e);
//            return new ResponseDto<>(ERROR.FAILURE, e.getMessage());
//        }
//    }
//
//}
