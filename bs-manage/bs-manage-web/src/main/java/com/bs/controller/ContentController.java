package com.bs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.bean.TbContent;
import com.bs.common.bean.ExceptionUtil;
import com.bs.common.bean.ResponseResultJson;
import com.bs.service.ContentService;

public class ContentController {
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody
	public ResponseResultJson insertContent(TbContent content) {
		ResponseResultJson result = contentService.insertContent(content);
		return result;
	}

	
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

}
