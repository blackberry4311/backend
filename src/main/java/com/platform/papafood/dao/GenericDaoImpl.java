package com.platform.papafood.dao;

import com.tpp.persistence.GenericDao;
import com.tpp.persistence.PropertyEntityDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("genericDao")
public class GenericDaoImpl extends com.tpp.persistence.GenericDaoImpl implements GenericDao {

    public enum JoinName {
        //	private String joinName;
        //
        //	JoinName(String joinName) {
        //		this.joinName = joinName;
        //	}
        //
        //	public String joinName() {
        //		return joinName;
        //	}
    }

    @Autowired
    public GenericDaoImpl(SessionFactory sessionFactory, PropertyEntityDAO propertyEntityDAO) {
        super(sessionFactory, propertyEntityDAO);

        //add more method related to relationship here
    }
}
