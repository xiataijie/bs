package com.bs.restful.service;

import java.util.List;

import com.bs.bean.TbContent;

public interface ContentService {

	 List<TbContent> getContentList(long contentCid);
}
