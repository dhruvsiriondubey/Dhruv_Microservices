package com.sirion.service;

import java.util.List;

import com.sirion.bean.Order;

public interface IOrderService {
	public Order addOrder(Order order);

	public Order updateOrder(Order order);

	public void removeOrder(int orderId);

	public Order viewOrder(int orderId);

	public List<Order> viewAllOrderByUserId(String userid);

	public List<Order> viewAllOrders();

}
