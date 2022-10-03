package com.zen.services;

import com.zen.entities.MyOrders;

public interface MyOrderService {

	public MyOrders placeOrder(MyOrders myOrders);

	public MyOrders getOrderId(int orderId);

	public MyOrders getByUserId(int userId);

}
