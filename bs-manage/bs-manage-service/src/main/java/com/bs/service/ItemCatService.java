package com.bs.service;

import java.util.List;

import com.bs.common.bean.EUTreeNode;

public interface ItemCatService {
	
	List<EUTreeNode> getItemCatList(Long parentId) throws Exception;

}
