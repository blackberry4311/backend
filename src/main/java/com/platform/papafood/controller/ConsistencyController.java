//package com.platform.papafood.controller;
//
//import com.platform.papafood.service.ConsistencyService;
//import com.platform.papafood.commons.ApiConstant;
//import com.platform.papafood.commons.ERROR;
//import com.platform.papafood.dto.ResponseDto;
//import com.platform.papafood.commons.Utils;
//import com.platform.papafood.models.ConsistencyModel;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "*", allowCredentials = "true")
//@RequestMapping(value = ApiConstant.FOOD)
//public class ConsistencyController {
//
//    private static final Logger LOGGER = Logger.getLogger(ConsistencyController.class);
//
//    @Autowired
//    ConsistencyService consistencyService;
//
//    @RequestMapping(value = ApiConstant.CONSISTENCY, method = RequestMethod.GET)
//    public ResponseDto<List<ConsistencyModel>> list(HttpServletRequest request) {
//        try {
//            List<String> list = Utils.convertStringToListString(request.getHeader("Authorization"), " ");
//            String token = Utils.isEmpty(list) || list.size() < 2 ? "" : list.get(1);
//            return new ResponseDto<>(ERROR.SUCCESS, consistencyService.list(token));
//
//        } catch (Exception e) {
//            LOGGER.error(e);
//            return new ResponseDto<>(ERROR.FAILURE, e.getMessage());
//        }
//    }
//}
