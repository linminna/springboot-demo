package com.lmn.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lmn.mybatis.model.User;

@Mapper
public interface UserMapper {
	public User getUserById(Integer userId);
}
