package com.lmn.mybatis.service;

import com.lmn.mybatis.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

//泛型的参数分别是实体类型和主键类型
@Component
public interface UserSearchRepository extends ElasticsearchRepository<User, Integer> {

    List<User> findUserByRealName(String realName);
}
