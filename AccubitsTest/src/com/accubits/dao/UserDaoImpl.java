package com.accubits.dao;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accubits.constant.MessageConstant;
import com.accubits.model.UserForm;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao implements UserDao {

	
	@Override
	public String saveUser(UserForm user) {
		try {
			getSession().saveOrUpdate(user);
			return MessageConstant.success;
		} catch (Exception e) {
			// TODO: handle exception
 			e.printStackTrace();
			return MessageConstant.fail;
		}
		
	}

	@Override
	public UserForm getUser(UserForm user) {
		UserForm userForm = null;
try {
	userForm = (UserForm) getSession().createCriteria(UserForm.class).add(Restrictions.eq("email", user.getEmail())).add(Restrictions.eq("password", user.getPassword())).uniqueResult();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userForm;
	}

}
