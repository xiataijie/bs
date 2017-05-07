package com.bs.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.common.bean.ResponseResultJson;
import com.bs.portal.bean.CartItem;

public interface CartService {

	ResponseResultJson addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response);
	List<CartItem> getCartItemList(HttpServletRequest request,HttpServletResponse response);
	ResponseResultJson deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}
