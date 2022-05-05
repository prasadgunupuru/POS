package com.example.demo.Dao;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.bean.ProfileBean;

public interface UserProfileRepo extends CrudRepository<ProfileBean, String> {

}
