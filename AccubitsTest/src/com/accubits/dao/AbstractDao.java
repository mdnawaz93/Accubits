package com.accubits.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {
	
	
	    @Autowired
	    private SessionFactory sessionFactory;
	 
	    protected Session getSession(){
	        return sessionFactory.getCurrentSession();
	    }
	 
	    /*@SuppressWarnings("unchecked")
	    public T getByKey(PK key) {
	        return (T) getSession().get(persistentClass, key);
	    }*/
	 
	    public void persist(Object entity) {
	        getSession().persist(entity);
	    }
	 
	    public void delete(Object entity) {
	        getSession().delete(entity);
	    }
	     
	    

}
