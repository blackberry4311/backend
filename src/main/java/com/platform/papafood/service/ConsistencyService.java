//package com.platform.papafood.service;
//
//import com.platform.papafood.adapters.ConsistencyAdapter;
//import com.platform.papafood.commons.DEFAULT;
//import com.platform.papafood.commons.Utils;
//import com.platform.papafood.jdbc.pojos.Consistency;
//import com.platform.papafood.models.ConsistencyModel;
//import com.platform.papafood.models.CustomerModel;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class ConsistencyService {
//
//    private static final Logger LOGGER = Logger.getLogger(ConsistencyService.class);
//
//    @Autowired
//    DAOImplementRepository<Consistency> daoImplementRepository;
//
//    @Autowired
//    CustomerService customerService;
//
//    public List<ConsistencyModel> list(String token) {
//        try {
//            CustomerModel customerModel = customerService.get(token);
//            if (Utils.isEmpty(customerModel) || customerModel.getId() <= 0) {
//                return DEFAULT.emptyList;
//            }
//            List<Consistency> consistencies = daoImplementRepository.select(new Consistency(0, "", "", true), Consistency.class);
//            List<ConsistencyModel> consistencyModels = new ArrayList<>();
//            for (Consistency consistency : consistencies) {
//                consistencyModels.add(ConsistencyAdapter.adaptConsistencyModel(consistency));
//            }
//            return consistencyModels;
//        } catch (Exception e) {
//            LOGGER.error(e);
//            return DEFAULT.emptyList;
//        }
//    }
//}
