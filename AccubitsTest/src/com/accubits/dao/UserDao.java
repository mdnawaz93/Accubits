package com.accubits.dao;

import com.accubits.model.UserForm;

public interface UserDao {
	public UserForm getUser(UserForm user);
	public String saveUser(UserForm user);

}
