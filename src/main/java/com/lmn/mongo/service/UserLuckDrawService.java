package com.lmn.mongo.service;

import java.util.List;

import com.wana.log.dto.UserLuckDrawRecordDto;

public interface UserLuckDrawService {
	public List<UserLuckDrawRecordDto> getUserLuckDrawRecordDtoByUserId(Integer userId);
}
