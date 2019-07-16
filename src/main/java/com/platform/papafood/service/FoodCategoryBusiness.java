//package com.platform.papafood.service;
//
//
//import com.platform.papafood.adapters.FoodCategoryAdapter;
//import com.platform.papafood.jdbc.pojos.FoodCategory;
//import com.platform.papafood.models.FoodCategoryModel;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class FoodCategoryBusiness {
//
//    private static final Logger LOG = Logger.getLogger(FoodCategoryBusiness.class);
//
//    @Autowired
//    DAOImplementRepository<FoodCategory> daoImplementRepository;
//
//    public FoodCategoryModel get(int id) {
//        try {
//            List<FoodCategory> foodCategories = daoImplementRepository.select(new FoodCategory(id, "", "", 0, ""), FoodCategory.class);
//            FoodCategoryModel foodCategoryModel = FoodCategoryAdapter.adaptFoodCategoryModel(foodCategories.get(0));
//            return foodCategoryModel;
//        } catch (Exception e) {
//            LOG.error(e);
//            return new FoodCategoryModel();
//        }
//
//    }
//}
