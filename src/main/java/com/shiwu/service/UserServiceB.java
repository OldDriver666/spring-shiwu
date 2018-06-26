package com.shiwu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shiwu.dao.UserMapper;
import com.shiwu.model.User;

@Service
public class UserServiceB {
    
    @Autowired
    UserMapper userDao;
	
    @Transactional(propagation=Propagation.NEVER)
	public int addUser(User user)  {
		return userDao.insertSelective(user);
	}
	@Transactional(propagation=Propagation.NEVER)
	public int updateUser(User user) {
		return userDao.updateByPrimaryKeySelective(user);
	}
    
}