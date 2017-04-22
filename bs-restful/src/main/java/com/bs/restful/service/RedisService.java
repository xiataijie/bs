package com.bs.restful.service;

import com.bs.common.bean.ResponseResultJson;

public interface RedisService {

	ResponseResultJson syncContent(long contentCid);
	
}
