package com.platform.papafood.service;

import com.platform.papafood.exception.BusinessException;
import com.platform.papafood.models.MenuModel;

import java.util.Date;

public interface MenuService {
    MenuModel findMenuByDate(Date date) throws BusinessException;

    MenuModel createMenu(MenuModel menuModel) throws BusinessException;
}

