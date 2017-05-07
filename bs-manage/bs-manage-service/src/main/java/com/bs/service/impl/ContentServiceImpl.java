package com.bs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bs.bean.TbContent;
import com.bs.bean.TbContentExample;
import com.bs.bean.TbItemParam;
import com.bs.bean.TbItemParamExample;
import com.bs.bean.TbContentExample.Criteria;
import com.bs.common.bean.HttpClientUtils;
import com.bs.common.bean.PageUtils;
import com.bs.common.bean.ResponseResultJson;
import com.bs.mapper.TbContentMapper;
import com.bs.service.ContentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private TbContentMapper  tbContentMapper;
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_CONTENT_SYNC_URL}")
	private String REST_CONTENT_SYNC_URL;
	@Override
	public ResponseResultJson insertContent(TbContent content) {
		//补全pojo内容
				content.setCreated(new Date());
				content.setUpdated(new Date());
				tbContentMapper.insert(content);
				//添加缓存同步逻辑
				try {
					HttpClientUtils.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL +content.getCategoryId());
					System.out.println("缓存添加成功！");
				} catch (Exception e) {
					e.printStackTrace();
				}
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
	@Override
	public PageUtils getItemList(Integer page, Integer rows) {
		TbContentExample example = new TbContentExample();
		PageHelper.startPage(page, rows);
		List<TbContent> list = tbContentMapper.selectByExample(example);
		PageUtils result = new PageUtils();
		result.setRows(list);
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	
}
