package com.example.demo.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="POS_TBL_User_Profile")
@Data
@NoArgsConstructor

public class ProfileBean {
	@Id
	@GeneratedValue
	
	private String userId;
	private String firstName;
	private String lastName;
	private Date   datofBirth;
	private String gender;
	private String street;
	private String location;
	private String city;
	private String state;
	private String pincode;
	private String mobileNumber;
	private String emailId;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private CredentialsBean cred;

}
