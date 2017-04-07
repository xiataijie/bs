package com.bs.service;

import com.bs.bean.TbItem;
import com.bs.common.bean.PageUtils;
import com.bs.common.bean.ResponseResultJson;


public interface ItemService {
	
	PageUtils getItemList(int page ,int rows);
	
	ResponseResultJson createItem(TbItem tbItem , String desc ,String itemParams)throws Exception;

}
