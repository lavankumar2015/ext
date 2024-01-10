package com.extwebtech.bean;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
	private int productId;
	private int quantity;
	private Date createdDate;
}
