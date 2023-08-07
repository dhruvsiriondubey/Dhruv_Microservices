package com.sirion.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirion.bean.Order;
import java.util.List;
import java.time.LocalDate;
import com.sirion.bean.Address;

public interface IOrderRepo extends JpaRepository<Order, Integer> {
	public List<Order> findByOrderDate(LocalDate orderDate);

	public List<Order> findByUserId(String userId);

	public List<Order> findByAddressId(Address addressId);
}
