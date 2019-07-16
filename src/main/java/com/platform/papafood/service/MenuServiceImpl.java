package com.platform.papafood.service;

import com.platform.papafood.exception.BusinessException;
import com.platform.papafood.models.MenuModel;
import com.tpp.persistence.GenericDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
@Transactional(value = "transactionManager", propagation = Propagation.SUPPORTS)
public class MenuServiceImpl implements MenuService {
    @Autowired
    private GenericDao genericDao;

    @Override
    public MenuModel findMenuByDate(Date date) throws BusinessException {
        MenuModel result = genericDao.findUnique(MenuModel.class, new String[] { "date" }, new Object[] { date });
        if (result == null) throw new BusinessException(String.format("Not found menu within date: %s", date));
        return result;
    }

    @Override
    public MenuModel createMenu(MenuModel menuModel) throws BusinessException {
        return null;
    }
}

