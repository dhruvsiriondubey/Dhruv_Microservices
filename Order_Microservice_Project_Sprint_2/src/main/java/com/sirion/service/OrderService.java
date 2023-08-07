package com.sirion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirion.bean.Order;
import com.sirion.repo.IOrderRepo;

@Service
public class OrderService implements IOrderService {
	@Autowired
	private IOrderRepo repo;

	@Override
	public Order addOrder(Order order) {
		repo.saveAndFlush(order);
		return order;
	}

	@Override
	public Order updateOrder(Order order) {
		Optional<Order> op = repo.findById(order.getOrderId());
		if (op.isPresent()) {
			repo.saveAndFlush(order);
			return order;
		}
		return null;
	}

	@Override
	public void removeOrder(int orderId) {
		repo.deleteById(orderId);
	}

	@Override
	public Order viewOrder(int orderId) {
		Optional<Order> op = repo.findById(orderId);
		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}

	@Override
	public List<Order> viewAllOrderByUserId(String userid) {
		return repo.findByUserId(userid);
	}

	@Override
	public List<Order> viewAllOrders() {
		return repo.findAll();
	}
}
