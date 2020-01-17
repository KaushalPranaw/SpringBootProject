/*package com.yash.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.pojos.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	

	User findByUserNameAndPassword(String userName,String password);
	User findByUserIdAndPassword(int id,String oldPass);
	User findByUserNameAndEmailIdAndPhoneNumber(String userName, String emailId, String phoneNum);
	
	
}
*/