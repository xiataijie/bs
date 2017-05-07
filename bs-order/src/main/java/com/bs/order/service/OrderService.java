package com.bs.order.service;

import java.util.List;

import com.bs.bean.TbOrder;
import com.bs.bean.TbOrderItem;
import com.bs.bean.TbOrderShipping;
import com.bs.common.bean.ResponseResultJson;

public interface OrderService {

	ResponseResultJson createOrder(TbOrder order, List<TbOrderItem> itemList, TbOrderShipping orderShipping);
}
