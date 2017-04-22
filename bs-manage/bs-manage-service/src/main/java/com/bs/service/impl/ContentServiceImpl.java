package com.bs.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bs.bean.TbContent;
import com.bs.bean.TbContentExample;
import com.bs.bean.TbContentExample.Criteria;
import com.bs.common.bean.HttpClientUtils;
import com.bs.common.bean.JsonUtils;
import com.bs.common.bean.ResponseResultJson;
import com.bs.mapper.TbContentMapper;
import com.bs.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private TbContentMapper  tbContentMapper;


	@Override
	public ResponseResultJson insertContent(TbContent content) {
		//补全pojo内容
				content.setCreated(new Date());
				content.setUpdated(new Date());
				tbContentMapper.insert(content);
				
				return ResponseResultJson.ok();

	}


	@Override
	public List<TbContent> getContentList(long contentCid) {
		//根据内容分类id查询内容列表
				TbContentExample example = new TbContentExample();
				Criteria criteria = example.createCriteria();
				criteria.andCategoryIdEqualTo(contentCid);
				//执行查询
				List<TbContent> list = tbContentMapper.selectByExample(example);
				
				return list;
	}

}
