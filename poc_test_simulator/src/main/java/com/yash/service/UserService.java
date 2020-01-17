package com.yash.service;

import java.util.List;

import com.yash.pojos.User;

public interface UserService {

	User login(String userName, String password);
	String updatePassword(int id,String oldPass, String newPass);
	String forgotPassword(String userName, String emailId, String phoneNum);
	void save(User user);
	List<User> findAll();
	
}
