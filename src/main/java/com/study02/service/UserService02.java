package com.study02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;
import com.study02.mapper.UserMapper02;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService02 {
	@Autowired
	private UserMapper02 userMapper02;

	public User findByName(String name) {
		return userMapper02.findByName(name);
	}
	
	@Transactional(transactionManager="test2TransactionManager")
	public int insertUser(String name, Integer age) {
		log.info("新增user对象");
		int result = userMapper02.insert(name, age);
		int a = 1 / age;
		return result;
	}
}
