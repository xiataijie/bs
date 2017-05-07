package com.bs.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.bean.TbUser;
import com.bs.common.bean.ResponseResultJson;

public interface UserService {

	ResponseResultJson checkData(String content, Integer type);
	ResponseResultJson createUser(TbUser user);
	ResponseResultJson userLogin(String username, String password,HttpServletRequest request,HttpServletResponse response);
	ResponseResultJson getUserByToken(String token);
}
