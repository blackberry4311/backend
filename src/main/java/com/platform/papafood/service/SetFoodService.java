package com.platform.papafood.service;

import com.platform.papafood.exception.BusinessException;
import com.platform.papafood.models.FoodModel;
import com.tpp.persistence.GenericDao;
import com.tpp.persistence.SearchCriteria;
import com.tpp.persistence.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(value = "transactionManager", propagation = Propagation.SUPPORTS)
public class SetFoodService {
    @Autowired
    private GenericDao genericDao;

    public SearchResult<FoodModel> searchFood(SearchCriteria<FoodModel> criteria) throws BusinessException {
        return genericDao.find(FoodModel.class, criteria);
    }
}
