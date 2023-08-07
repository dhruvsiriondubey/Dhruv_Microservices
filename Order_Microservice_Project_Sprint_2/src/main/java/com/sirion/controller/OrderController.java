package com.sirion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirion.bean.Order;
import com.sirion.service.OrderService;

@RestController
@RequestMapping("orders")
public class OrderController {
	@Autowired
	private OrderService os;

	@GetMapping("/{orderId}")
	public Order getOrder(@PathVariable int orderId) {
		return os.viewOrder(orderId);
	}

	@GetMapping("/all/{userId}")
	public List<Order> getOrdersByUserId(@PathVariable String userID) {
		return os.viewAllOrderByUserId(userID);
	}

	@GetMapping("/all")
	public List<Order> viewAllOrders() {
		return os.viewAllOrders();
	}

	@PostMapping
	public Order addOrder(@RequestBody Order order) {
		return os.addOrder(order);
	}

	@PutMapping
	public Order updateOrder(@RequestBody Order order) {
		return os.updateOrder(order);
	}

	@DeleteMapping("/{orderId}")
	public void deleteAddress(@PathVariable int orderId) {
		os.removeOrder(orderId);
	}

}
