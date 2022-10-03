package com.zen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.zen.entities.BookInventory;

public interface InventoryRepository extends JpaRepository<BookInventory, Integer> {

	@Query(value = "SELECT * from bookstore.book_inventory where book_id = :bookId", nativeQuery = true)
	BookInventory findByBookId(int bookId);

	BookInventory findByCapacity(int capacity);

}
