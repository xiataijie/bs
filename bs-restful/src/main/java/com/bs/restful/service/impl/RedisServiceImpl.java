package com.bs.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.bs.common.bean.ExceptionUtil;
import com.bs.common.bean.ResponseResultJson;
import com.bs.restful.service.RedisService;

import dao.JedisClient;

public class RedisServiceImpl implements RedisService {

	@Autowired
	private JedisClient jedisClient;
	
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	@Override
	public ResponseResultJson syncContent(long contentCid) {
		try {
			jedisClient.hdel(INDEX_CONTENT_REDIS_KEY, contentCid + "");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResultJson.build(500, ExceptionUtil.getStackTrace(e));
		}
		return ResponseResultJson.ok();
	}


}
