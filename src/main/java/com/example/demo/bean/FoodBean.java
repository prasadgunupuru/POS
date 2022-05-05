package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="POS_TBL_Food")
@Data

public class FoodBean {

	@Id
	private String foodID;
	private String Name;
	private String Type;
	private String FoodSize;
	private int    Quantity;
	private double Price;
	
}

