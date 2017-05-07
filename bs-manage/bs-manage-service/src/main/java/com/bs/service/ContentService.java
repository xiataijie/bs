package com.bs.service;

import java.util.List;

import com.bs.bean.TbContent;
import com.bs.common.bean.PageUtils;
import com.bs.common.bean.ResponseResultJson;

public interface ContentService {
	public ResponseResultJson insertContent(TbContent content);
	
	public List<TbContent> getContentList(long contentCid);

	public PageUtils getItemList(Integer page, Integer rows);
	

}
