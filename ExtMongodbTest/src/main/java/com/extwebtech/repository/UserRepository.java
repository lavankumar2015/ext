package com.extwebtech.repository;

import java.sql.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Repository;

import com.extwebtech.bean.User;
import com.mongodb.client.result.UpdateResult;

@Repository
public class UserRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public Object createUser(User user ) {
		return mongoTemplate.save(user,"user");
		
	}
	
	public User getUser(String id) {
		Query query = Query.query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(query, User.class);
	}
	
	public List<User> getAllUsers() {
		return mongoTemplate.findAll(User.class, "user");
	}
	
	public UpdateResult updateUser(String id,User user) {
		Query query = Query.query(Criteria.where("_id").is(id));
		UpdateDefinition updateDef = Update.update("mobileNumber",user.getMobileNumber());
		return mongoTemplate.updateFirst(query, updateDef, User.class);
	}
	
	public User deleteUser(String id) {
		Query query = Query.query(Criteria.where("_id").is(id));
		return mongoTemplate.findAndRemove(query, User.class);
	}
	
	
	
}