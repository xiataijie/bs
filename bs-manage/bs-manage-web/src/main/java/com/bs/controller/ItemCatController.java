package com.bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.common.bean.EUTreeNode;
import com.bs.service.ItemCatService;


@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping("/getCatList")
	@ResponseBody
	//如果id为null是使用默认值，也就是parentid为0的分类列表
	public List<EUTreeNode> getCatList(@RequestParam(value="id", defaultValue="0") Long parentId) throws Exception {
		//查询数据库
		List<EUTreeNode> list = itemCatService.getItemCatList(parentId);
		
		return list;
	}

}
