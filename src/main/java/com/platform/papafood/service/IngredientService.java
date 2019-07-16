//package com.platform.papafood.service;
//
//import com.platform.papafood.adapters.IngredientAdapter;
//import com.platform.papafood.commons.DEFAULT;
//import com.platform.papafood.jdbc.pojos.Ingredient;
//import com.platform.papafood.models.IngredientModel;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class IngredientService {
//
//    private static final Logger LOG = Logger.getLogger(IngredientService.class);
//
//    @Autowired
//    DAOImplementRepository<Ingredient> daoImplementRepository;
//
//    public List<IngredientModel> listByIds(List<Integer> ids) {
//        try {
//            List<Ingredient> ingredients = daoImplementRepository.selectByListIds(ids, Ingredient.class);
//            List<IngredientModel> ingredientModels = new ArrayList<>();
//            for (Ingredient ingredient : ingredients) {
//                ingredientModels.add(IngredientAdapter.adaptIngredientModel(ingredient));
//            }
//            return ingredientModels;
//        } catch (Exception e) {
//            LOG.error(e);
//            return DEFAULT.emptyList;
//        }
//    }
//}
