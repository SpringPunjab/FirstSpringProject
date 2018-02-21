package com.baljit.hellocontroller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {								

   // @RequestMapping(value="/welcome/countryName/{username}")										//any name username will put in URL it will work
	//public ModelAndView helloworld() {
    //public ModelAndView helloworld(@PathVariable("username")String name) {
    	
    	  @RequestMapping(value="/welcome/{countryName}/{username}")
    	    //public ModelAndView helloworld(@PathVariable("username")String name, @PathVariable("countryName")String country) { 				// with pathvariable annotation string will be printout on screen
    		  
    		  public ModelAndView helloworld(@PathVariable Map<String,String> pathVars) {
    		  String name= pathVars.get("username");
    		  String country= pathVars.get("countryName");
    		  
       ModelAndView model = new ModelAndView("HelloPage");                                              //jsp
       
	//  model.addObject("msg", "hello ");
       model.addObject("msg", "hello " +name + " from country " +country);																					
     
      return model;
    }
}