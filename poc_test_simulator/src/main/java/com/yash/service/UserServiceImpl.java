/*package com.yash.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.dao.UserDao;
import com.yash.pojos.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	

	@Override
	public void save(User user) {
		userDao.save(user);
	}
	
	

	@Override
	public List<User> findAll() {
		List<User> users=userDao.findAll();
		return users;
	}



	@Override
	public User login(String userName, String password) {
		User user=userDao.findByUserNameAndPassword(userName, password);
		
		return user;
	}

	@Override
	public String updatePassword(int id, String oldPass, String newPass) {
		User user=userDao.findByUserIdAndPassword(id, oldPass);
		if(user!=null)
		{
			user.setPassword(newPass);
			userDao.save(user);
			return "password changed";
		}
		return "something went wrong";
	}

	@Override
	public String forgotPassword(String userName, String emailId, String phoneNum) {
		User user=userDao.findByUserNameAndEmailIdAndPhoneNumber(userName, emailId, phoneNum);
		if(user!=null)
			return user.getPassword();
		return "wrong input";
		
	}

	
}
*/