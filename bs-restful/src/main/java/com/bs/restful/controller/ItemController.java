package com.bs.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.common.bean.ResponseResultJson;
import com.bs.restful.service.ItemService;

@Controller
@RequestMapping("/item")

public class ItemController {

	
	@Autowired
	private ItemService itemService;

	@RequestMapping("/info/{itemId}")
	@ResponseBody
	public ResponseResultJson getItemBaseInfo(@PathVariable Long itemId) {
		ResponseResultJson result = itemService.getItemBaseInfo(itemId);
		return result;
	}
	
	
	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public ResponseResultJson getItemDesc(@PathVariable Long itemId) {
		ResponseResultJson result = itemService.getItemDesc(itemId);
		return result;
	}

	@RequestMapping("/param/{itemId}")
	@ResponseBody
	public ResponseResultJson getItemParam(@PathVariable Long itemId) {
		ResponseResultJson result = itemService.getItemParam(itemId);
		return result;
	}


}
