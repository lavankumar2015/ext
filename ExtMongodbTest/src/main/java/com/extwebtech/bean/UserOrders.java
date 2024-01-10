package com.extwebtech.bean;

import lombok.Data;

@Data
public class UserOrders {
	private User user;
	private Product product;
	private Order order;
}
