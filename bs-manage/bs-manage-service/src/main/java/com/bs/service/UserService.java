package com.bs.service;

import com.bs.common.bean.PageUtils;

public interface UserService {

	public PageUtils getUserList(int page ,int rows);
	
	public long deleteUser(long userId);
}
