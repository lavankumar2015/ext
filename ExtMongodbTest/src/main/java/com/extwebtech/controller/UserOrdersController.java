package com.extwebtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.extwebtech.bean.UserOrders;
import com.extwebtech.service.UserOrdersService;
import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping("/orders")
public class UserOrdersController {
	@Autowired
	private UserOrdersService userOrdersService;
	
	@PostMapping
	public UserOrders createOrder(@RequestBody UserOrders userOrders) {
		return userOrdersService.createOrder(userOrders);
	}
	
	@PutMapping
	public UpdateResult updateOrder(@RequestParam String id,@RequestBody UserOrders userOrders) {
		return userOrdersService.updateOrder(id,userOrders);
	}
}
