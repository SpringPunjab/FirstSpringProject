package com.baljit.hellocontroller;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandlerMethod {
    
   /* @ExceptionHandler(value = NullPointerException.class)							//null pointerexception handlar method
               public String handleNullPointerException(Exception e)
         {       																 //logging null pointer exception
    	         System.out.println("null pointer exception occured: " + e);
		           return "NullPointerException";												// this same handler also be done by @ExceptionHandler annotation in each particular class or classess 
		           																                // this same handler activity can be done by bean property in dispatcher.servlet.xml file				
         }				
         
   @ExceptionHandler(value = IOException.class)									//IO exception handlar method
               public String handleIOException(Exception e)
           {       																 //logging IO exception
                 System.out.println("IO Exception Occured " + e);
                   return "IOException";

           }
   @ResponseStatus(value = HttpStatus.INTERAL_SERVER_ERROR)				//this annotation will send write status code if anyone check in HTTP header
   @ExceptionHandler(value = Exception.class)									//generic exception handlar method
   public String ingeneral(Exception e)
              {       																 //logging in generic exception
                    System.out.println("Exception Occured " + e);
                      return "Exception";

                }
*/
}
