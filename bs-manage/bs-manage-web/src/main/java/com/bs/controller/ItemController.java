package com.bs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.bean.TbItem;
import com.bs.common.bean.PageUtils;
import com.bs.common.bean.ResponseResultJson;
import com.bs.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	
	@RequestMapping("/item/getItemList")
	@ResponseBody
	public PageUtils getItemList(Integer page ,Integer rows){
		PageUtils result = itemService.getItemList(page, rows);
		return result;
	}
	
	
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseResultJson createItem(TbItem tbItem, String desc ,String itemParams) throws Exception{
		ResponseResultJson resultJson = itemService.createItem(tbItem, desc ,itemParams);
		return resultJson;
		
	}
	
}
