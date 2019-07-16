//package com.platform.papafood.service;
//
//import com.platform.papafood.commons.DateUtils;
//import com.platform.papafood.commons.Utils;
//import com.platform.papafood.jdbc.pojos.Order;
//import com.platform.papafood.models.CustomerModel;
//import com.platform.papafood.models.PackageModel;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static com.platform.papafood.commons.Constants.*;
//
//
//@Service
//public class OrderService {
//
//    private static final Logger LOG = Logger.getLogger(OrderService.class);
//
//    @Autowired
//    DAOImplementRepository<Order> daoImplementRepository;
//
//    @Autowired
//    PackageService packageService;
//
//    @Autowired
//    CustomerService customerService;
//
//    public boolean validateDates(String token, Integer packageId, List<String> dates) {
//        try {
//
//
//            CustomerModel currentCustomer = customerService.get(token);
//            if (Utils.isEmpty(currentCustomer) || currentCustomer.getId() <= 0) {
//                return false;
//            }
//
//            if (packageId <= 0) {
//                return false;
//            }
//            PackageModel packageModel = packageService.get(packageId);
//            List<String> listDate = DateUtils.listDate(dates);
//            if (listDate.size() != packageModel.getDates()) {
//                return false;
//            }
//            String[] splitCondition = packageModel.getCondition().split(":");
//            int exits = 0;
//            LocalDate dateOfTerm = LocalDate.parse(listDate.get(0)).plusDays(packageModel.getTerm() - 1);
//            LocalDate lastDate = LocalDate.parse(listDate.get(listDate.size() - 1));
//            for (int i = 0; i < listDate.size(); i++) {
//                LocalDate currentDate = LocalDate.parse(listDate.get(i));
//                Integer compareWithCurrentDate = dateOfTerm.compareTo(currentDate);
//                Integer compareWithLastDate = dateOfTerm.compareTo(lastDate);
//                if (compareWithLastDate <= 0) {
//                    if (compareWithCurrentDate >= 0) {
//                        exits++;
//                        continue;
//                    }
//                    if (!checkCondition(exits, splitCondition[0], Integer.valueOf(splitCondition[1]))) {
//                        return false;
//                    }
//                    dateOfTerm = dateOfTerm.plusDays(packageModel.getTerm());
//                    exits = 1;
//                    continue;
//                }
//                if (compareWithCurrentDate >= 0) {
//                    exits++;
//                    continue;
//                }
//                if (exits < (listDate.size() - i)) {
//                    return false;
//                }
//            }
//            return true;
//        } catch (Exception e) {
//            LOG.error(e);
//            return false;
//        }
//    }
//
//    public static boolean checkCondition(int value, String op, int comparation) {
//        switch (op) {
//            case OPERATOR_LT:
//                return value > 0 && value < comparation;
//            case OPERATOR_LE:
//                return value > 0 && value <= comparation;
//            case OPERATOR_GT:
//                return value > comparation;
//            case OPERATOR_GE:
//                return value >= comparation;
//            default:
//                return false;
//        }
//    }
//
//}
//
//
