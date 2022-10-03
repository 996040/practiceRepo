package com.zen.entities;

import com.zen.dto.Status;

public class Response {
	
	private Status status;
	
	private MyOrders myOrders;
	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public MyOrders getMyOrders() {
		return myOrders;
	}

	public void setMyOrders(MyOrders myOrders) {
		this.myOrders = myOrders;
	}


}




