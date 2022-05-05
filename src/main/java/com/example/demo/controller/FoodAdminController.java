package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.IdNotFoundException;
import com.example.demo.bean.FoodBean;
import com.example.demo.services.*;

@RestController

public class FoodAdminController {

	@Autowired
	AdminServiceImpl ad;
	
	@PostMapping(value="/food/save",consumes="application/json")
	public String addfood(@RequestBody FoodBean food) {
		 Random rand=new Random();
		 int resRandom = rand.nextInt((999-100)+1)+10;
		 food.setFoodID(food.getName().substring(0,2)+Integer.toString(resRandom));
		 ad.addFood(food);
		 return  "added Successfully";	
	}
	@GetMapping(value="/food/viewall")
	public ArrayList<FoodBean> viewall(){
		 if(ad.viewByAllFoods().isEmpty())
		 {
		 System.out.println("No Foods Available");
		 throw new IdNotFoundException();
		 
		 }
		 return ad.viewByAllFoods();
		}
	
	@GetMapping(value="/food/viewById/{foodID}")
	public ArrayList<FoodBean> viewFoodId(@PathVariable("foodID") String foodID)
	{
	 if(ad.viewByFoodID(foodID)==null) {
	 System.out.println("No food is available");
	 throw new IdNotFoundException();
	 }
	 return ad.viewByFoodID(foodID);
	}
	
	@DeleteMapping(value="/food/delete/{foodID}")
	public String deletefood(@PathVariable("foodID") String foodID) {
		 ad.removeFood(foodID);
		 return "Deleted Successfully";
		}
	
	@PutMapping(value="/food/update")
	public FoodBean updateFood(@RequestBody FoodBean foodID)
	{
	 return ad.modifyFood(foodID);
	}


}
