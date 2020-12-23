package com.study01.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.entity.User;


//@Mapper
public interface UserMapper01 {
	
	@Select("SELECT * FROM USER WHERE NAME = #{name}")
	User findByName(@Param("name") String name);
	
	@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
	int insert(@Param("name") String name, @Param("age") Integer age);
	
}
