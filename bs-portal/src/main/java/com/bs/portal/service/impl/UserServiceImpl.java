package com.bs.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bs.bean.TbUser;
import com.bs.common.bean.HttpClientUtils;
import com.bs.common.bean.ResponseResultJson;
import com.bs.portal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Value("${SSO_BASE_URL}")
	public String SSO_BASE_URL;
	
	@Value("${SSO_USER_URL}")
	private String SSO_USER_URL;
	
	@Value("${SSO_PAGE_LOGIN}")
	public String SSO_PAGE_LOGIN;
	
	@Override
	public TbUser getUserByToken(String token) {
		try {
			//调用sso系统的服务，根据token取用户信息
			String json = HttpClientUtils.doGet(SSO_BASE_URL + SSO_USER_URL + token);
			//把json转换成TaotaoREsult
			ResponseResultJson result = ResponseResultJson.formatToPojo(json, TbUser.class);
			if (result.getStatus() == 200) {
				TbUser user = (TbUser) result.getData();
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
