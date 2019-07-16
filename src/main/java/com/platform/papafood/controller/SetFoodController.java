//package com.platform.papafood.controller;
//
//import com.platform.papafood.service.SetFoodService;
//import com.platform.papafood.commons.ApiConstant;
//import com.platform.papafood.commons.ERROR;
//import com.platform.papafood.dto.ResponseDto;
//import com.platform.papafood.commons.Utils;
//import com.platform.papafood.models.SetFoodModel;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "*", allowCredentials = "true")
//@RequestMapping(value = ApiConstant.FOOD)
//public class SetFoodController {
//
//    private static final Logger LOG = Logger.getLogger(SetFoodController.class);
//
//    @Autowired
//    SetFoodService setFoodService;
//
//    @RequestMapping(value = ApiConstant.LIST_SET, method = RequestMethod.GET)
//    public ResponseDto<List<SetFoodModel>> sets(HttpServletRequest request) {
//        try {
//            List<String> list = Utils.convertStringToListString(request.getHeader("Authorization")," ");
//            String token = Utils.isEmpty(list) || list.size() < 2 ? "" : list.get(1);
//            return new ResponseDto<>(ERROR.SUCCESS, setFoodService.list(token));
//        } catch (Exception e) {
//            LOG.error(e);
//            return new ResponseDto<>(ERROR.FAILURE, e.getMessage());
//        }
//    }
//}