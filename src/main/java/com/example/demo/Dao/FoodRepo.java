package com.example.demo.Dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.FoodBean;


public interface FoodRepo extends JpaRepository<FoodBean,String> {
	
	ArrayList<FoodBean> findByFoodID(String foodID);

}

