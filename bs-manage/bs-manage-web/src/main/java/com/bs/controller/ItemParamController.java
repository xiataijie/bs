package com.bs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.bean.TbItemParam;
import com.bs.common.bean.PageUtils;
import com.bs.common.bean.ResponseResultJson;
import com.bs.service.ItemParamService;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping("/list")
	@ResponseBody
	public PageUtils getItemParam(Integer page ,Integer rows) {
		PageUtils result = itemParamService.getItemParam(page,rows);
		System.out.println(result.getRows());
		return result;
	}
		
	/**
	 * 根据ID获取商品规格参数
	 * @param itemCatId
	 * @return
	 */
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public ResponseResultJson getItemParamByCid(@PathVariable Long itemCatId) {
		ResponseResultJson result = itemParamService.getItemParamByCid(itemCatId);
		return result;
	}

	/**
	 * 添加商品规格参数
	 * @param cid
	 * @param paramData
	 * @return
	 */
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public ResponseResultJson insertItemParam(@PathVariable Long cid, String paramData) {
		//创建pojo对象
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		ResponseResultJson result = itemParamService.insertItemParam(itemParam);
		return result;
	}

	
	
}
