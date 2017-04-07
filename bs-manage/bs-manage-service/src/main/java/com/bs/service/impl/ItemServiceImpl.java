package com.bs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.bean.TbItem;
import com.bs.bean.TbItemDesc;
import com.bs.bean.TbItemExample;
import com.bs.bean.TbItemParamItem;
import com.bs.common.bean.GenUtils;
import com.bs.common.bean.PageUtils;
import com.bs.common.bean.ResponseResultJson;
import com.bs.mapper.TbItemDescMapper;
import com.bs.mapper.TbItemMapper;
import com.bs.mapper.TbItemParamItemMapper;
import com.bs.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemServiceImpl implements ItemService {
    
	@Autowired
	private TbItemMapper tbItemMapper ;
	
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper tbItemParamItemMapper;

	@Override
	public PageUtils getItemList(int page, int rows) {
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(page, rows);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		PageUtils result = new PageUtils();
		result.setRows(list);
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public ResponseResultJson createItem(TbItem tbItem , String desc ,String itemParams) throws Exception {
		Long itemId =GenUtils.genItemId();
		tbItem.setId(itemId);
		//1-正常  2-下架  3-删除
		tbItem.setStatus((byte)1);
		tbItem.setCreated(new Date());
		tbItem.setUpdated(new Date());
		tbItemMapper.insert(tbItem);
		//添加商品描述信息
		ResponseResultJson result = insertItemDesc(itemId, desc);
				if (result.getStatus() != 200) {
					throw new Exception();
				}
				
		//添加商品规格参数
			result = insertItemParamItem(itemId , itemParams);
			if(result.getStatus() !=200){
				throw new Exception();
			}
				
		return ResponseResultJson.ok();
	}

	private ResponseResultJson insertItemDesc(Long itemId, String desc) {
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		tbItemDescMapper.insert(itemDesc);
		return ResponseResultJson.ok();
	}
	
	private  ResponseResultJson insertItemParamItem(Long itemId, String itemParam) {
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParam);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		// 向表中插入数据
		tbItemParamItemMapper.insert(itemParamItem);
		return ResponseResultJson.ok();

	}

}
