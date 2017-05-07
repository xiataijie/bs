package com.bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.bean.TbContent;
import com.bs.common.bean.ExceptionUtil;
import com.bs.common.bean.PageUtils;
import com.bs.common.bean.ResponseResultJson;
import com.bs.service.ContentService;

@Controller
public class ContentController {
	@Autowired
	private ContentService contentService;
	
	/**
	 * 添加内容信息
	 * @param content
	 * @return
	 */
	@RequestMapping("/content/save")
	@ResponseBody
	public ResponseResultJson insertContent(TbContent content) {
		ResponseResultJson result = contentService.insertContent(content);
		return result;
	}

	/**
	 * 获取内容列表
	 * @param contentCategoryId
	 * @return
	 */
	@RequestMapping("/list/{contentCategoryId}")
	@ResponseBody
	public ResponseResultJson getContentList(@PathVariable Long contentCategoryId) {
		try {
			List<TbContent> list = contentService.getContentList(contentCategoryId);
			return ResponseResultJson.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResultJson.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

	@RequestMapping("/content/query/list")
	@ResponseBody
	public PageUtils getItemList(Integer page ,Integer rows){
		PageUtils result = contentService.getItemList(page, rows);
		return result;
	}
	
}
