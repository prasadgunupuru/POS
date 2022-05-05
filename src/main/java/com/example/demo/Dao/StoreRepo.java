package com.example.demo.Dao;



import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.FoodBean;
import com.example.demo.bean.StoreBean;


public interface StoreRepo extends JpaRepository<StoreBean,String> {
	
	ArrayList<StoreBean> findByStoreID(String storeID);

}