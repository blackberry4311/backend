//package com.platform.papafood.service;
//
//import com.platform.papafood.adapters.SEOAdapter;
//import com.platform.papafood.jdbc.pojos.Seo;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class SeoService {
//
//  private static final Logger LOG = Logger.getLogger(SeoService.class);
//
//  @Autowired
//  private DAOImplementRepository<Seo> daoImplementRepository;
//
//  public Map<String, Object> getPage(String page) {
//    try {
//      Seo filter = new Seo(page);
//      List<Seo> data = daoImplementRepository.select(filter, Seo.class);
//      if(data == null || data.isEmpty()) {
//        LOG.error("Data Seo is empty");
//        return new HashMap<>();
//      }
//      if(data.size() > 1) {
//        LOG.error("Cannot have over 2 page get the sample Seo-content");
//        return new HashMap<>();
//      }
//      return SEOAdapter.adaptSEO(data.get(0));
//    } catch(Exception e) {
//      LOG.error(e);
//      return new HashMap<>();
//    }
//  }
//
//}
