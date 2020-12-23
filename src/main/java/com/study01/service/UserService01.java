package com.study01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;
import com.study01.mapper.UserMapper01;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService01 {
	@Autowired
	private UserMapper01 userMapper01;

	public User findByName(String name) {
		return userMapper01.findByName(name);
	}
	
	@Transactional(transactionManager="test1TransactionManager")
	public int insertUser(String name, Integer age) {
		log.info("新增user对象");
		int result = userMapper01.insert(name, age);
		int a = 1 / age;
		return result;
	}
}
