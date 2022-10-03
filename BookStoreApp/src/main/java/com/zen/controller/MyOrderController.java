package com.zen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zen.dto.Status;
import com.zen.entities.MyOrders;
import com.zen.entities.Response;
import com.zen.services.MyOrderService;

@RestController
public class MyOrderController {

	@Autowired
	private MyOrderService myOrderService;

	Response response = new Response();
	Status status = new Status();

	@PostMapping("/placeOrder")
	public Response placeOrder(@RequestBody MyOrders myOrders) {
		MyOrders orders = myOrderService.placeOrder(myOrders);
		status.setStatusCode(200);
		status.setStatusMessage("Orderd Place Successfully...");
		response.setStatus(status);
		response.setMyOrders(orders);
		return response;
	}

	@GetMapping("/getByOrderId/{orderId}")
	public Response getOrderId(@PathVariable("orderId") int orderId) {
		MyOrders orders = myOrderService.getOrderId(orderId);
		status.setStatusCode(200);
		status.setStatusMessage("Details get By Order Id");
		response.setStatus(status);
		response.setMyOrders(orders);
		return response;

	}

	@GetMapping("/getByUserId/{userId}")
	public Response getByUserId(@PathVariable("userId") int userId) {
		MyOrders orders = myOrderService.getByUserId(userId);
		status.setStatusCode(200);
		status.setStatusMessage("Details with the UserId");
		response.setStatus(status);
		response.setMyOrders(orders);
		return response;
	}

}
