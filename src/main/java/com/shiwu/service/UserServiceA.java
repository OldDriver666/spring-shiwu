package com.shiwu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shiwu.dao.UserMapper;
import com.shiwu.model.User;

@Service
public class UserServiceA {
    
    @Autowired
    UserMapper userDao;
    
    @Autowired
    UserServiceB userServiceB;
	
    @Transactional(propagation=Propagation.REQUIRED)
	public int addUser(User user) {
		return userDao.insertSelective(user);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public int updateUser(User user) {
		return userDao.updateByPrimaryKeySelective(user);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public void testUser() {
		
		User user1 = new User();
		user1.setId(2);
		user1.setUserName("Jack");
		user1.setAge(201);
		user1.setPassword("123");
		userServiceB.updateUser(user1);

//		userDao.updateByPrimaryKeySelective(user1);
		
		User user2 = new User();
		user2.setId(1);
		user2.setUserName("Tom");
		user2.setAge(18);
		user2.setPassword("123456");
		userDao.insertSelective(user2);
//		userServiceB.addUser(user2);
	}
	@Transactional
	public void test() {
		testUser();
	}
    
}