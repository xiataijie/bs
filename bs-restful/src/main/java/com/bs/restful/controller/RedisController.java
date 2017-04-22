package com.bs.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bs.common.bean.ResponseResultJson;
import com.bs.restful.service.RedisService;

public class RedisController {

	@Autowired
	private RedisService redisService;
	
	@RequestMapping("/content/{contentCid}")
	public ResponseResultJson contentCacheSync(@PathVariable Long contentCid) {
		ResponseResultJson result = redisService.syncContent(contentCid);
		return result;
	}

}
