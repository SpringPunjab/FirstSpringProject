package com.baljit.hellocontroller;

import java.beans.PropertyEditorSupport;

public class StudentNameEditor  extends PropertyEditorSupport{
	
//when will submit admission form
//Spring MVC will run setAsText function of the class
// before performing data binding task for studentname property of student object
	
	public void setAsText(String studentName) throws IllegalArgumentException
	{
		if(studentName.contains("Mr.")|| studentName.contains("Ms."))
		{
			setValue(studentName);
		}else
		    {
			studentName= "Ms." +studentName;
			setValue(studentName);					//what ever value provide to setvaue...spring MVC use
													//same value to perform data binding task for studentName property
		    }
	}
	
}