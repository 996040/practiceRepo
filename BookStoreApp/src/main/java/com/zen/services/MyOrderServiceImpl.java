package com.zen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zen.entities.BookInventory;
import com.zen.entities.MyOrders;
import com.zen.repository.InventoryRepository;
import com.zen.repository.MyOrderRepository;

@Service
public class MyOrderServiceImpl implements MyOrderService {

	@Autowired
	private MyOrderRepository myOrderRepository;

	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public MyOrders placeOrder(MyOrders myOrders) {

		BookInventory findByCapacity = inventoryRepository.findByBookId(myOrders.getBookId());

		int capacity = findByCapacity.getCapacity() - myOrders.getTotalQuantity();

		if (capacity <= 0) {
			throw new NullPointerException();
		} else {
			findByCapacity.setCapacity(capacity);
			inventoryRepository.save(findByCapacity);
		}

		findByCapacity.getCapacity();

		System.out.println(capacity);

		return myOrderRepository.save(myOrders);

	}

	@Override
	public MyOrders getOrderId(int orderId) {
		// TODO Auto-generated method stub
		return myOrderRepository.findById(orderId).get();
	}

	@Override
	public MyOrders getByUserId(int userId) {
		// TODO Auto-generated method stub
		return myOrderRepository.getByUserId(userId);
	}

}
