package com.sirion.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {
	@Id
	private String catId;
	private String categoryName;

	public Category(String catId, String categoryName) {
		this.catId = catId;
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", categoryName=" + categoryName + "]";
	}

}
