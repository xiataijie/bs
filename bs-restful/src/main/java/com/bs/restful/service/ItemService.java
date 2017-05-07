package com.bs.restful.service;

import com.bs.common.bean.ResponseResultJson;

public interface ItemService {

	ResponseResultJson getItemBaseInfo(long itemId);
	ResponseResultJson getItemDesc(long itemId);
	ResponseResultJson getItemParam(long itemId);
}
