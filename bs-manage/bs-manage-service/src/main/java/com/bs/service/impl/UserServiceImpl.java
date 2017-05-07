package com.bs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.bean.TbItem;
import com.bs.bean.TbItemExample;
import com.bs.bean.TbUser;
import com.bs.bean.TbUserExample;
import com.bs.common.bean.PageUtils;
import com.bs.mapper.TbUserMapper;
import com.bs.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private TbUserMapper tbUserMapper;

	@Override
	public PageUtils getUserList(int page, int rows) {
		TbUserExample example = new TbUserExample();
		PageHelper.startPage(page, rows);
		List<TbUser> list = tbUserMapper.selectByExample(example);
		PageUtils result = new PageUtils();
		result.setRows(list);
		PageInfo<TbUser> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public long deleteUser(long userId) {
		long result =tbUserMapper.deleteByPrimaryKey(userId);
		if(result!=1){
			return 0;
		}
		return result;
	}

}
