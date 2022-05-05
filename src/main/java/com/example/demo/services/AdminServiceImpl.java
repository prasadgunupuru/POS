package com.example.demo.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Dao.FoodRepo;
import com.example.demo.bean.FoodBean;
import com.example.demo.Dao.StoreRepo;
import com.example.demo.bean.StoreBean;
import com.example.demo.Exception.IdNotFoundException;
import com.example.demo.Exception.InvalidStoreIdException;


@Service
public class AdminServiceImpl  {
	
	@Autowired
	private FoodRepo fr;
	@Autowired
	private StoreRepo sr;


	public FoodBean addFood(FoodBean foodbean) {
		
		return fr.save(foodbean);
	}

	
	public FoodBean modifyFood(FoodBean foodbean) {
		
		return fr.save(foodbean);
	}


	public int removeFood(String foodID) {
		if(fr.existsById(foodID)) {
			fr.deleteById(foodID);
			return 1; 
		}
		else {
		throw new IdNotFoundException();
		}
	}


	public ArrayList<FoodBean> viewByAllFoods() {
		
		return (ArrayList<FoodBean>) fr.findAll();
	}
	public ArrayList<FoodBean> viewByFoodID(String foodID) {
		
		return (ArrayList<FoodBean>) fr.findByFoodID(foodID);
	}
	
	
	//Store///
	
	


	public StoreBean addStore(StoreBean storebean) {
		
		return sr.save(storebean);
	}


	public StoreBean modifyStore(StoreBean storebean) {
		
		return sr.save(storebean);
	}


	public int removeStore(String storeID) {
		if(sr.existsById(storeID)) {
			sr.deleteById(storeID);
			return 1; 
		}
		else {
		throw new InvalidStoreIdException();
		}
	}


	public ArrayList<StoreBean> viewByAllStore() {
		
		return (ArrayList<StoreBean>) sr.findAll();
	}


	public ArrayList<StoreBean> viewByStoreID(String storeId) {
		
		return (ArrayList<StoreBean>)sr.findByStoreID(storeId);
	}


	public StoreBean modify(StoreBean storebean) {
		return sr.save(storebean);
	}
}
