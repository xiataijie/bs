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

	/**
	 * 获取商品列表
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/item/getItemList")
	@ResponseBody
	public PageUtils getItemList(Integer page ,Integer rows){
		PageUtils result = itemService.getItemList(page, rows);
		return result;
	}
	
	/**
	 * 添加商品信息、详情描述、规格参数
	 * @param tbItem
	 * @param desc
	 * @param itemParams
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	public ResponseResultJson createItem(TbItem tbItem, String desc ,String itemParams) throws Exception{
		ResponseResultJson resultJson = itemService.createItem(tbItem, desc ,itemParams);
		return resultJson;
	}
	
/*	@RequestMapping(value="/item/delete/{id}", method=RequestMethod.POST)
	@ResponseBody
	public ResponseResultJson deleteItem() throws Exception{
		ResponseResultJson resultJson = itemService.deleteItem();
		return resultJson;
	}
	*/
}
