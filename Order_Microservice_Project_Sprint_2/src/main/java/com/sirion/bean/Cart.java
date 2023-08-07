package com.sirion.bean;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyJoinColumn;

@Entity
public class Cart {

	@Id
	private String cartId;
	private String userId;
	@MapKeyJoinColumn
	@ElementCollection
	Map<Product, Integer> products; // product and quantity

	public Cart(String cartId, String userId) {
		this.cartId = cartId;
		this.userId = userId;
		this.products = new HashMap<Product, Integer>();
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public void setProducts(Map<Product, Integer> products) {
		this.products = products;
	}

}
