//package com.platform.papafood.controller;
//
//import com.platform.papafood.service.OrderService;
//import com.platform.papafood.commons.ApiConstant;
//import com.platform.papafood.commons.ERROR;
//import com.platform.papafood.dto.ResponseDto;
//import com.platform.papafood.commons.Utils;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@CrossOrigin(origins = "*", allowCredentials = "true")
//@RequestMapping(value = ApiConstant.FOOD)
//public class OrderController {
//
//    private static final Logger LOG = Logger.getLogger(OrderController.class);
//
//    @Autowired
//    OrderService orderService;
//
//    @RequestMapping(value = ApiConstant.LIST_DATE, method = RequestMethod.POST)
//    public ResponseDto<Map<String, Boolean>> validateDates(HttpServletRequest request, @RequestBody Map<String, Object> mapBody) {
//        try {
//            List<String> list = Utils.convertStringToListString(request.getHeader("Authorization"), " ");
//            String token = Utils.isEmpty(list) || list.size() < 2 ? "" : list.get(1);
//            Integer packageId = (!mapBody.containsKey("packageId") || mapBody.get("packageId") == null) ? 0 : (Integer) mapBody.get("packageId");
//            List<String> dates = (!mapBody.containsKey("dates") || mapBody.get("dates") == null)
//                    ? new ArrayList<>() : (List<String>) mapBody.get("dates");
//            Long id = (!mapBody.containsKey("facebookId") || mapBody.get("facebookId") == null) ? 0 : (Long) mapBody.get("facebookId");
//            Map<String, Boolean> mapResponse = new HashMap<>();
//            mapResponse.put("result", orderService.validateDates(token, packageId, dates));
//            return new ResponseDto(ERROR.SUCCESS, mapResponse);
//
//        } catch (Exception e) {
//            LOG.error(e);
//            return new ResponseDto<>(ERROR.FAILURE, e.getMessage());
//        }
//
//    }
//}
