package com.extwebtech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extwebtech.bean.UserOrders;
import com.extwebtech.repository.UserOrdersRepository;
import com.mongodb.client.result.UpdateResult;

@Service
public class UserOrdersService {
  @Autowired
  private UserOrdersRepository userOrdersRepository;
  
  public UserOrders createOrder(UserOrders userOrders) {
		return userOrdersRepository.createOrder(userOrders);
	}
	
	public UpdateResult updateOrder(String id,UserOrders userOrders) {
		return userOrdersRepository.updateOrder(id,userOrders);
	}
}
