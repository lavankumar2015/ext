package com.extwebtech.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Repository;

import com.extwebtech.bean.UserOrders;
import com.mongodb.client.result.UpdateResult;

@Repository
public class UserOrdersRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public UserOrders createOrder(UserOrders userOrders) {
		return mongoTemplate.save(userOrders,"user_orders");
	}
	
	public UpdateResult updateOrder(String id,UserOrders userOrders) {
		Query query = Query.query(Criteria.where("_id").is(id));
		
		UpdateDefinition updateDef = Update.update("UserOrders.product.productName",userOrders.getProduct().getProductName());
		
		return mongoTemplate.updateFirst(query, updateDef, UserOrders.class);
	}
}
