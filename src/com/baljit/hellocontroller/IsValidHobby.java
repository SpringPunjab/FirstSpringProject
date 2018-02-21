package com.baljit.hellocontroller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = HobbyValidator.class)   //hobbyvalidator cllas will be use for validation
@Target( {ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)


public @interface IsValidHobby {														//IsValidHobby annotation
	
	String listofvalidHobbies() default "Music|Cricket|Football|Hockey";
	
	String message() default "Please provide a valid Hobby; " + " accepted hobbies are - Music, Football, Cricket, Hockey(choose anyone)";

	Class<?> [] groups() default {};
	Class<? extends Payload>[] payload() default{};
}
