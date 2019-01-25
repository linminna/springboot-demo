package com.lmn.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmn.mongo.service.UserLuckDrawService;
import com.wana.log.dto.UserLuckDrawRecordDto;

@RestController
public class MongoController {

	@Autowired
	private UserLuckDrawService userLuckDrawService;

	@GetMapping("/getUserLuckDrawRecordDtoByUserId")
	public List<UserLuckDrawRecordDto> getUserLuckDrawRecordDtoByUserId(Integer userId) {
		return userLuckDrawService.getUserLuckDrawRecordDtoByUserId(userId);
	}

}
