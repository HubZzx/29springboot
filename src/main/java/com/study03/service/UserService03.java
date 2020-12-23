package com.study03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;
import com.study01.mapper.UserMapper01;
import com.study02.mapper.UserMapper02;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService03 {
	@Autowired
	private UserMapper01 userMapper01;
	
	@Autowired
	private UserMapper02 userMapper02;
		
	//多数据源不生效
	@Transactional(transactionManager="test2TransactionManager")
	public int insertUser3(String name, Integer age) {
		log.info("新增user对象");
		int result = userMapper01.insert(name, age);
		result = userMapper02.insert(name, age);
		int a = 1 / age;
		return result;
	}
	
	//多数据源事务解决方案：jpa+automikos
	@Transactional
	public int insertUser4(String name, Integer age) {
		log.info("新增user对象");
		int result = userMapper01.insert(name, age);
		result = userMapper02.insert(name, age);
		int a = 1 / age;
		return result;
	}
}
