//package com.platform.papafood.service;
//
//import com.platform.papafood.adapters.CustomerAdapter;
//import com.platform.papafood.commons.Utils;
//import com.platform.papafood.jdbc.pojos.Customer;
//import com.platform.papafood.models.CustomerModel;
//import com.platform.papafood.models.IngredientModel;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class CustomerService {
//
//    private static final Logger LOGGER = Logger.getLogger(CustomerService.class);
//
//    @Autowired
//    DAOImplementRepository<Customer> daoImplementRepository;
//
//    @Autowired
//    IngredientService ingredientService;
//
//    public CustomerModel get(String id) {
//        try {
//            List<Customer> customers = daoImplementRepository.select(new Customer(Long.parseLong(id), "", "", "", "", "", ""), Customer.class);
//            if (Utils.isEmpty(customers)) {
//                LOGGER.warn("Customer is not exist !");
//                return new CustomerModel();
//            }
//            CustomerModel customerModel = CustomerAdapter.adaptCustomerModel(customers.get(0));
//            List<IngredientModel> ingredientModelList = ingredientService
//                    .listByIds(Utils.convertStringToListInt(customers.get(0).getAllergy()));
//            customerModel.setAllgergy(ingredientModelList);
//            return customerModel;
//
//        } catch (Exception e) {
//            LOGGER.error(e);
//            return new CustomerModel();
//        }
//    }
//
//    public Integer insert(Map<String, Object> mapBody) {
//        try {
//            Long id = (!mapBody.containsKey("facebookId") || mapBody.get("facebookId") == null) ? 0 : (Long) mapBody.get("facebookId");
//            List<Customer> currentCustomer = daoImplementRepository.select(new Customer(id, "", "", "", "", "", ""), Customer.class);
//            if (Utils.isEmpty(currentCustomer)) {
//                LOGGER.warn("Customer is exits");
//                return 0;
//            }
//            Customer customer = new Customer();
//            customer.setId(id);
//            customer.setName((!mapBody.containsKey("name") || mapBody.get("name") == null) ? "" : (String) mapBody.get("name"));
//            customer.setAvatar((!mapBody.containsKey("avatar") || mapBody.get("avatar") == null) ? "" : (String) mapBody.get("avatar"));
//            customer.setPhone((!mapBody.containsKey("phone") || mapBody.get("phone") == null) ? "" : (String) mapBody.get("phone"));
//            customer.setEmail((!mapBody.containsKey("email") || mapBody.get("email") == null) ? "" : (String) mapBody.get("email"));
//            customer.setAddress((!mapBody.containsKey("address") || mapBody.get("address") == null) ? "" : (String) mapBody.get("address"));
//            customer.setAllergy((!mapBody.containsKey("allergy") || mapBody.get("allergy") == null) ? "" : (String) mapBody.get("allergy"));
//            return daoImplementRepository.insert(customer, Customer.class);
//        } catch (Exception e) {
//            LOGGER.error(e);
//            return 0;
//        }
//    }
//
//    public Integer update(Map<String, Object> mapBody) {
//        try {
//            Long id = (!mapBody.containsKey("facebookId") || mapBody.get("facebookId") == null) ? 0 : (Long) mapBody.get("facebookId");
//            List<Customer> currentCustomer = daoImplementRepository.select(new Customer(id, "", "", "", "", "", ""), Customer.class);
//            if (Utils.isEmpty(currentCustomer)) {
//                LOGGER.warn("Customer is not exits");
//                return 0;
//            }
//            Customer customer = new Customer();
//            customer.setId(id);
//            customer.setName((!mapBody.containsKey("name") || mapBody.get("name") == null) ? "" : (String) mapBody.get("name"));
//            customer.setAvatar((!mapBody.containsKey("avatar") || mapBody.get("avatar") == null) ? "" : (String) mapBody.get("avatar"));
//            customer.setPhone((!mapBody.containsKey("phone") || mapBody.get("phone") == null) ? "" : (String) mapBody.get("phone"));
//            customer.setEmail((!mapBody.containsKey("email") || mapBody.get("email") == null) ? "" : (String) mapBody.get("email"));
//            customer.setAddress((!mapBody.containsKey("address") || mapBody.get("address") == null) ? "" : (String) mapBody.get("address"));
//            customer.setAllergy((!mapBody.containsKey("allergy") || mapBody.get("allergy") == null) ? "" : (String) mapBody.get("allergy"));
//            return daoImplementRepository.update(customer, Customer.class);
//        } catch (Exception e) {
//            LOGGER.error(e);
//            return 0;
//        }
//    }
//}
