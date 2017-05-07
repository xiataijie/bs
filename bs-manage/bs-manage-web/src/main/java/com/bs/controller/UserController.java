package com.bs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.common.bean.PageUtils;
import com.bs.common.bean.ResponseResultJson;
import com.bs.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/getUserList")
	@ResponseBody
	public PageUtils getUserList(int page,int rows) {
		PageUtils result = userService.getUserList(page, rows);
		System.out.println(result.getRows());
		return result;
	}
	
	@RequestMapping("/user/deleteUser")
	@ResponseBody
	public ResponseResultJson deleteUser(long ids) {
		System.out.println(ids);
		long result = userService.deleteUser(ids);
		if(result==0){
		}
		return ResponseResultJson.ok("成功删除！");
	}
	
}
