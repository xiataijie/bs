package com.bs.portal.service;

import com.bs.bean.TbUser;

public interface UserService {

	TbUser getUserByToken(String token);
}
