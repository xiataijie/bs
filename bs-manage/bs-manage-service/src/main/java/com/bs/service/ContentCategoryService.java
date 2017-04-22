package com.bs.service;

import java.util.List;

import com.bs.common.bean.EUTreeNode;
import com.bs.common.bean.ResponseResultJson;


public interface ContentCategoryService {
	public List<EUTreeNode> getCategoryList(long parentId);
	public ResponseResultJson insertContentCategory(long parentId, String name);
}
