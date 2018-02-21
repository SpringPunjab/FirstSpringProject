package com.baljit.hellocontroller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String>{					// class has validation logic of IsValidHobby annotation
	
	private String listofvalidHobbies;
	@Override																//before calling isValid method it call initialize method first
	public void initialize(IsValidHobby isValidHobby) {
	this.listofvalidHobbies=isValidHobby.listofvalidHobbies();}
	

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
	
		if(studentHobby == null)
		{
			return false;
		}	
		if(studentHobby.matches(listofvalidHobbies)) 
		//if(studentHobby.matches("Music|Cricket|Football|Hockey")) 						// this hardcode values provided
		  {
			return true;
		  }	else
		    {
			   return false;
		    }
     }
}