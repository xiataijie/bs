package com.bs.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bs.common.bean.HttpClientUtils;
import com.bs.common.bean.JsonUtils;
import com.bs.common.bean.ResponseResultJson;
import com.bs.portal.bean.Order;
import com.bs.portal.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	


	@Override
	public String createOrder(Order order) {
		//调用taotao-order的服务提交订单。
		String json = HttpClientUtils.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, JsonUtils.objectToJson(order));
		//把json转换成taotaoResult
		ResponseResultJson taotaoResult = ResponseResultJson.format(json);
		if (taotaoResult.getStatus() == 200) {
			Object orderId = taotaoResult.getData();
			return orderId.toString();
		}
		return "";
	}


}

