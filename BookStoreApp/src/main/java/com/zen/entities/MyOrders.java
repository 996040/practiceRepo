package com.zen.entities;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class MyOrders {

	@Id
	private int orderId;
	private int userId;
	private String orderDate;
	private int totalQuantity;
	private int totalCost;
	private int bookId;

	public MyOrders() {
		super();
	}

	public MyOrders(int orderId, int userId, String orderDate, int totalQuantity, int totalCost, int bookId) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalQuantity = totalQuantity;
		this.totalCost = totalCost;
		this.bookId = bookId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

}
