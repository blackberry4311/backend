//package com.platform.papafood.service;
//
//import com.platform.papafood.adapters.FoodAdapter;
//import com.platform.papafood.commons.DEFAULT;
//import com.platform.papafood.commons.Utils;
//import com.platform.papafood.models.FoodCategoryModel;
//import com.platform.papafood.models.FoodModel;
//import com.platform.papafood.models.IngredientModel;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class FoodService {
//
//    private static final Logger LOG = Logger.getLogger(FoodService.class);
//
//    @Autowired
//    DAOImplementRepository<com.platform.papafood.jdbc.pojos.FoodModel> daoImplementRepository;
//
//    @Autowired
//    FoodCategoryBusiness foodCategoryBusiness;
//
//    @Autowired
//    IngredientService ingredientService;
//
//    public List<FoodModel> getByIds(List<Integer> ids) {
//        try {
//            List<com.platform.papafood.jdbc.pojos.FoodModel> foods = daoImplementRepository.selectByListIds(ids, com.platform.papafood.jdbc.pojos.FoodModel.class);
//            List<FoodModel> foodModels = new ArrayList<>();
//            for (com.platform.papafood.jdbc.pojos.FoodModel food : foods) {
//                FoodCategoryModel foodCategoryModel = foodCategoryBusiness.get(food.getCategory());
//                List<IngredientModel> ingredientModels = ingredientService.listByIds(Utils.convertStringToListInt(food.getIngredient_id()));
//                foodModels.add(FoodAdapter.adaptFoodModel(food, foodCategoryModel, ingredientModels));
//            }
//            return foodModels;
//        } catch (Exception e) {
//            LOG.error(e);
//            return DEFAULT.emptyList;
//        }
//
//    }
//
//}
