package com.example.demo.bean;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="POS_TBL_User_Credentials")

@NoArgsConstructor
public class CredentialsBean {
	@Id
	
	private String Userid;
	private String Password;
	private String Usertype;
	private int Loginstatus;
	
}
