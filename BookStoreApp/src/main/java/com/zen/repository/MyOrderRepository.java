package com.zen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zen.entities.MyOrders;

public interface MyOrderRepository extends JpaRepository<MyOrders, Integer> {

	MyOrders getByUserId(int userId);

	MyOrders findByTotalQuantity(int totalQuantity);

}
