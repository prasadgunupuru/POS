package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="POS_TBL_Store")
@Data

public class StoreBean {

	@Id
	private String storeID;
	private String Name;
	private String Street;
	private String mobileno;
	private String city;
	private String State;
	private String Pincode;
}
