package com.example.demo.Dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.CredentialsBean;

public interface CredentialRepo extends JpaRepository<CredentialsBean, String> {

}
