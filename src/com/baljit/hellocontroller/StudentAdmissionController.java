package com.baljit.hellocontroller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {
	
	
//mapping admission from
        @RequestMapping(value="/admform", method = {RequestMethod.POST, RequestMethod.GET})
           public ModelAndView load() throws Exception 
        {
        	String exceptionOccured= "NULL_POINTER";
        	//String exceptionOccured= "IO_EXCEPTION";
        	//String exceptionOccured= "ARTHMETIC_EXCEPTION";
        	
        	if(exceptionOccured.equalsIgnoreCase("NULL_POINTER")) 
        	    {
        		   throw new NullPointerException("Null Pointer Exception");
                }
        		   else if(exceptionOccured.equalsIgnoreCase("IO_EXCEPTION")) 
                   {
                	throw new IOException("IO_EXCEPTION");
                   }
        		      else if(exceptionOccured.equalsIgnoreCase("ARTHMETIC_EXCEPTION")) 
                       {
                	      throw new ArithmeticException("Arthmetic Exception");
                       }
        			
        	
          ModelAndView model = new ModelAndView("admissionForm");    //jsp
           //model.addObject("mainmsg", "Engeering College of Sysdney");						// comment out because @modelatrribute is used at class(method) level
          
          return model;
        }
        
//mapping submit request    
    @RequestMapping(value="/formsubmit", method = {RequestMethod.POST, RequestMethod.GET})
    
        //public ModelAndView submitAdmissionForm(@RequestParam("studentName")String name, @RequestParam("studentHobby")String hobby) {
    	
        //public ModelAndView submitAdmissionForm(@RequestParam(value = "studentName", defaultValue= "Mr abc")String name, 					//default value of studentname set  if want
    	//									      @RequestParam("studentHobby")String hobby) {
    	//Student student1 = new Student();						// how come student class object created in class studentadmissioncontroller??
    	//student1.setStudenName(name);								// called user defined object
    	//student1.setStudentHobby(hobby);
    
        // public ModelAndView submitAdmissionForm(@RequestParam Map<String,String> reqPar) {            	//map is used in submitAdmissionForm arugment
    	//String name = reqPar.get("studentName");
    	//String hobby= reqPar.get("studentHobby");
    	
    	//below modelandview annotation has been used to replace @reqestParam by this 
    	//less coding to for binding data of student object to jsp then other
    public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student dd, BindingResult result)   		//@Valid is added for data binding related to size annotation in student class on studentmobile
    {				
    	if (result.hasErrors()) 																						//data binding error has been set with reference result
    	  {
    		  ModelAndView model = new ModelAndView("admissionForm");				// find binding related error same admissionForm empty will send back
    		  return model;
    	  }
       ModelAndView model = new ModelAndView("admissionSuccess");    //jsp	
       
      // model.addObject("mainmsg", "Engeering College of Sysdney");									// comment out because @modelatrribute is used at class(method) level
	  // model.addObject("mainmsg", "Details has been submit by " + name +  " , " + hobby);				//this method called request handler method	
	  //model.addObject("student1" ,student1);															//why this need and use when creating student object and using @requestParam annotation
      return model;
    }

    
//general @modelattribute method to spread message on all pages mapping in this controller class   
    @ModelAttribute
    public void addingCommentObject(Model model)					// using @ModelAttribute at method to show "mainmsg" object to all pages whose mapping in this class
    {
    	 model.addAttribute("mainmsg", "Engeering College of Sydney");		//Spring MVC will cl
    }
//@InitBinder
    
    @InitBinder
    public void bal(WebDataBinder binder) 
    {																					// this binder will act for whole class
    	binder.setDisallowedFields(new String[] {"studentMobile"});							// by  @InitBinder  studentMobile(can any field) is out of data binding if wanted
    	
    	SimpleDateFormat dtfomat= new SimpleDateFormat("dd/mm/yy");									//this the way to register own way to display data format
    	binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dtfomat, false));// inter sprin MVC use 'Property Editor classes' to perform data binding task example file editor, class editor, custonumber editor
       binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());				// have to MR or MS other wise will add  MS infront of studentname
    }
    
   /* @ExceptionHandler(value = NullPointerException.class)							//null pointerexception handlar method
               public String handleNullPointerException(Exception e)
         {       																 //logging null pointer exception
    	         System.out.println("null pointer exception occured: " + e);
		           return "NullPointerException";
         }
   @ExceptionHandler(value = IOException.class)									//IO exception handlar method
               public String handleIOException(Exception e)																//all these handler method now in one class called globalexceptionhandlermethod
           {       																 //logging IO exception								//under @ControllerAdvice
                 System.out.println("IO Exception Occured " + e);
                   return "IOException";																				// this same handler activity also  be done by bean property in dispatcher.servlet.xml file				
           }
   @ExceptionHandler(value = Exception.class)									//generic exception handlar method
                      public String ingeneral(Exception e)
              {       																 //logging in generic exception
                  System.out.println("Exception Occured " + e);
                    return "Exception";
              }
    */

    
    
    
    
    
    
    
    
}







