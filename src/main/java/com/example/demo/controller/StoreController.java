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

import com.example.demo.Exception.InvalidStoreIdException;
import com.example.demo.bean.StoreBean;
import com.example.demo.services.AdminServiceImpl;

@RestController

public class StoreController {

	@Autowired
	AdminServiceImpl ad;
	
	@PostMapping(value="/store/save",consumes="application/json")
	public String addstore(@RequestBody StoreBean store) {
		 Random rand=new Random();
		 int resRandom = rand.nextInt((999-100)+1)+10;
		 store.setStoreID(store.getState().substring(0,2)+Integer.toString(resRandom));
		 ad.addStore(store);
		 return  "added Successfully";	
	}
	@GetMapping(value="/store/viewall")
	public ArrayList<StoreBean> viewall(){
		 if(ad.viewByAllStore().isEmpty())
		 {
		 System.out.println("No Stores Available");
		 throw new InvalidStoreIdException();
		 
		 }
		 return ad.viewByAllStore();
		}
	
	@GetMapping(value="/store/viewById/{storeID}")
	public ArrayList<StoreBean> viewById(@PathVariable("storeID") String storeID)
	{
	 if(ad.viewByStoreID(storeID)==null) {
	 System.out.println("No food is available");
	 throw new InvalidStoreIdException();
	 }
	 return ad.viewByStoreID(storeID);
	}
	
	@DeleteMapping(value="/store/delete/{storeID}")
	public String deletestore(@PathVariable("storeID") String storeID) {
		 ad.removeStore(storeID);
		 return "Deleted Successfully";
		}
	
	@PutMapping(value="/store/update")
	public StoreBean updateStore(@RequestBody StoreBean StoreID)
	{
	 return ad.modifyStore(StoreID);
	}


}
