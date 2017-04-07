package com.bs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.bean.TbItemCat;
import com.bs.bean.TbItemCatExample;
import com.bs.bean.TbItemCatExample.Criteria;
import com.bs.common.bean.EUTreeNode;
import com.bs.mapper.TbItemCatMapper;
import com.bs.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	private TbItemCatMapper tbItemCatMapper;

	@Override
	public List<EUTreeNode> getItemCatList(Long parentId) throws Exception {
		TbItemCatExample example = new TbItemCatExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		//根据parentid查询子节点
		criteria.andParentIdEqualTo(parentId);
		//返回子节点列表
		List<TbItemCat> list = tbItemCatMapper.selectByExample(example);
		//把list转换成EUTreeNode 的list
		List<EUTreeNode> resultList = new ArrayList<>();
		
		for(TbItemCat tbItemCat : list){
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		return resultList;

	}

}
