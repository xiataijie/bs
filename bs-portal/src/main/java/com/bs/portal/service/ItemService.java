package com.bs.portal.service;

import com.bs.portal.bean.ItemInfo;

public interface ItemService {

	ItemInfo getItemById(Long itemId);
	
	String getItemDescById(Long itemId);
	
	String getItemParam(Long itemId);
	
}
