//package com.platform.papafood.controller;
//
//import com.platform.papafood.service.StatusService;
//import com.platform.papafood.commons.ApiConstant;
//import com.platform.papafood.commons.ERROR;
//import com.platform.papafood.dto.ResponseDto;
//import com.platform.papafood.jdbc.pojos.Status;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "*", allowCredentials = "true")
//@RequestMapping(value = ApiConstant.FOOD)
//public class ServiceController {
//
//    @Autowired
//    StatusService statusService;
//
//    @RequestMapping(value = ApiConstant.LIST_STATUS, method = RequestMethod.GET)
//    public ResponseDto<List<Status>> getListStatus() {
//        List<Status> status = statusService.list();
//        return new ResponseDto<List<Status>>(ERROR.SUCCESS, status);
//    }
//
//    @RequestMapping(value = ApiConstant.STATUS_BY_ID, method = RequestMethod.GET)
//    public ResponseDto<Status> getStatusById(@PathVariable("id") int id) {
//        Status status = statusService.get(id);
//        return new ResponseDto<Status>(ERROR.SUCCESS, status);
//    }
//
//}
