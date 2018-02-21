package com.baljit.hellocontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)										                                     //annotation to block null key values
@JsonIgnoreProperties({"studentSkills"})											                                     // annotation to block specific kay value from data
@JsonPropertyOrder({"studentHobby", "studentDOB", "studentName", "studentAddress", "studentMobile", "studentSkilss"})		// ordering the key values to appear on client side

public class Student {															                                          // callled user defined object

	@Pattern(regexp="[^0-9]*")											                                        //@Pattern annotation will restrict any number from 0-9 to enter
	@JsonProperty("Student_Name")
	private String studentName;
	
	@Size(min= 5, max= 20) @IsValidHobby()											//no listofvalidHobbies parameter because defulat values provided otherwise should be bottom one
	//@Size(min= 5, max= 20) @IsValidHobby(listofvalidHobbies= "Music|Cricket|Football|Hockey")											// IsValidHobby called custom form validation			//validation done by bean studentmessages.property in dispatcher-servlet
	//@Size(min= 5, max= 20, message= "Please enter between {min} and {max} character in Student Hobby field")			//spring MVC flexible give developer dynamically											// validation form fixed number between 5 and 20
	//@Size(min= 5, max= 20, message= "Please enter between 5 and 20 character in Student Hobby field")													// hardcode value 5 and 20												
	private String studentHobby;
	
	@Max(499999999)															//means value <= 499999999 similar way there is annotation @Min
	private Long studentMobile;
	
	@Past																			//it will stop future dates and same there is another annotation @Future
	private Date studentDOB;
	
	private ArrayList<String> studentSkills;
	
	private Address studentAddress;									     	// user defined data type 
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentHobby() {
		return studentHobby;
	}
	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}
	public Long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}
	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
}
