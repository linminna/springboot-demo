package com.lmn.mongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.lmn.mongo.service.UserLuckDrawService;
import com.wana.log.dto.UserLuckDrawRecordDto;

@Service
public class UserLuckDrawServiceImpl implements UserLuckDrawService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<UserLuckDrawRecordDto> getUserLuckDrawRecordDtoByUserId(Integer userId) {
		Criteria c = new Criteria();
		if (userId != null) {
			c.and("userId").is(userId);
		}
		return mongoTemplate.find(Query.query(c).limit(10).with(new Sort(Sort.Direction.DESC, "createTime")), UserLuckDrawRecordDto.class, "userLuckDrawRecordDto");
	}

}
