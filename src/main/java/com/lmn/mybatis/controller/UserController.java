package com.lmn.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.lmn.mybatis.model.User;
import com.lmn.mybatis.service.UserService;
import com.wana.dto.ResultDto;
import com.wana.user.interfaces.UserInterface;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserInterface userInterface;

	@RequestMapping("/hello")
	public String index() {
		return "hello world";
	}

	@RequestMapping("/getUserById")
	public String getUserById(Integer userId) {
		User user = userService.getUserById(userId);
		return JSONObject.toJSONString(user);
	}

	@RequestMapping("/getUserCredit")
	public Integer getUserCredit(Integer userId) {
		ResultDto<Integer> dto = userInterface.getCredit(userId);
		return dto.getData();
	}
}
