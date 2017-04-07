package com.bs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.bean.TbItemParam;
import com.bs.bean.TbItemParamExample;
import com.bs.bean.TbItemParamExample.Criteria;
import com.bs.common.bean.ResponseResultJson;
import com.bs.mapper.TbItemParamMapper;
import com.bs.service.ItemParamService;

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper tbItemParamMapper;
	
	@Override
	public ResponseResultJson getItemParamByCid(long cid) {
		
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
		//判断是否查询到结果
		if (list != null && list.size() > 0) {
			return ResponseResultJson.ok(list.get(0));
		}
		
		return ResponseResultJson.ok();
	}

	@Override
	public ResponseResultJson insertItemParam(TbItemParam itemParam) {
		//补全Bean 
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		//插入到规格参数模板表
		tbItemParamMapper.insert(itemParam);
		return ResponseResultJson.ok();
	}

}
