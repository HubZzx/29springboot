package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.study01.service.UserService01;
import com.study02.service.UserService02;
import com.study03.service.UserService03;

@RestController
// 多数据源测试
public class MultiUserController {

	@Autowired
	private UserService01 userService1;
	
	@Autowired
	private UserService02 userService2;
	
	@Autowired
	private UserService03 userService3;
	//单个事务1
	@RequestMapping("/insertUser1")
	public Integer insertUser1(String name, Integer age) {
		return userService1.insertUser(name, age);
	}
	//单个事务2
	@RequestMapping("/findByName1")
	public User findByName1(String name) {
		return userService1.findByName(name);

	}
	//单个事务3
	@RequestMapping("/insertUser2")
	public Integer insertUser2(String name, Integer age) {
		return userService2.insertUser(name, age);
	}

	//单个事务4
	@RequestMapping("/findByName2")
	public User findByName2(String name) {
		return userService2.findByName(name);
	}
	
	//多数据源的事务不生效
	@RequestMapping("/insertUser3")
	public Integer insertUser3(String name, Integer age) {
		return userService3.insertUser3(name, age);
	}
	
	//不生效解决方案：automikos+jpa
	@RequestMapping("/insertUser4")
	public Integer insertUser4(String name, Integer age) {
		return userService3.insertUser4(name, age);
	}



}
