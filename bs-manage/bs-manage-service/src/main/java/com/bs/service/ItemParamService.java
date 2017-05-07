package com.bs.service;

import com.bs.bean.TbItemParam;
import com.bs.common.bean.PageUtils;
import com.bs.common.bean.ResponseResultJson;

public interface ItemParamService {

	
	public  ResponseResultJson getItemParamByCid(long cid);
	
	public ResponseResultJson insertItemParam(TbItemParam itemParam) ;

	public PageUtils getItemParam(int page, int rows);
	
	
}
