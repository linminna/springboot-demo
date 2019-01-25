package com.lmn.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lmn.mybatis.dao.UserMapper;
import com.lmn.mybatis.model.User;
import com.lmn.mybatis.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserById(Integer userId) {
		return userMapper.getUserById(userId);
	}
}
