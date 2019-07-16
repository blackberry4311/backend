//package com.platform.papafood.controller;
//
//import com.platform.papafood.service.SeoService;
//import com.platform.papafood.commons.ApiConstant;
//import com.platform.papafood.commons.ERROR;
//import com.platform.papafood.dto.ResponseDto;
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
//public class SEOController {
//
//    private static final Logger LOG = Logger.getLogger(SEOController.class);
//
//    @Autowired
//    private SeoService seoService;
//
//    @RequestMapping(value = ApiConstant.SEO, method = RequestMethod.GET)
//    public ResponseDto<Map<String, Object>> getSEO(@PathVariable(value = "page") String page) {
//        try {
//            Map<String, Object> content = seoService.getPage(page);
//            return new ResponseDto<Map<String, Object>>(ERROR.SUCCESS, content);
//        } catch (Exception e) {
//            LOG.error(e);
//            return new ResponseDto<Map<String, Object>>(ERROR.FAILURE, new HashMap<>());
//        }
//    }
//
//}
