package com.bs.service;

import com.bs.bean.TbItem;
import com.bs.common.bean.PageUtils;
import com.bs.common.bean.ResponseResultJson;


public interface ItemService {
	/**
	 * 获取商品列表
	 * @param page
	 * @param rows
	 * @return
	 */
	PageUtils getItemList(int page ,int rows);
	
	/**
	 * 添加商品信息、商品详情、商品参数
	 * @param tbItem
	 * @param desc
	 * @param itemParams
	 * @return
	 * @throws Exception
	 */
	ResponseResultJson createItem(TbItem tbItem , String desc ,String itemParams)throws Exception;
	
	

}
