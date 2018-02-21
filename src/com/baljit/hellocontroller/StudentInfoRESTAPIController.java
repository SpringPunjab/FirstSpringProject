package com.baljit.hellocontroller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController																	//by using this no need to use    @ResponseBody each request handler and @Controller
//@Controller
public class StudentInfoRESTAPIController {

	
       //@ResponseBody																				//because of @responseBody springMVC will not look any view and it comment out because @RestControll used
      // @RequestMapping(value="/students", method = {RequestMethod.POST, RequestMethod.GET})				//record for all students
      @RequestMapping(value="/students", method = {RequestMethod.POST, RequestMethod.GET},  produces= {MediaType.APPLICATION_XML_VALUE})  // produces restict only json or xml to produce
    public List<Student> getStdtlt(@ModelAttribute() Student cc){																	//getStdtlt= getStudentList
    	
    	//Student student1= new Student();
    	//student1.setStudentName("The Great Khali");
    	
    	//Student student2= new Student();
    	//student1.setStudentName("The Undertaker");
    	
    	//Student student3= new Student();
    	//student1.setStudentName("John Cena");
    	List<Student> studentsList = new ArrayList<Student>();
    	
    	studentsList.add(cc);
    	//studentsList.add(student1);
    	//studentsList.add(student2);
    	//studentsList.add(student3);
    	
		return studentsList;
    }
    //**********************retrieving a student record******************* 
    //@ResponseBody																					//because of @responseBody springMVC will not look any view and it comment out because @RestControll used
    @RequestMapping(value="/students/{name}", method = {RequestMethod.POST, RequestMethod.GET})						///record for single student
    public Student getstudent(@PathVariable("name")  String dd){																	//getStdtlt= getStudentList
    	
    	Student student= new Student();
    	//student.setStudentName(studentName);
    	//student.setStudentHobby("wwe");
    	
		return student;
    }
 
  //**********************updating a student record******************* 
    
   @RequestMapping(value="/students/{name}", method = {RequestMethod.PUT}, consumes= {MediaType.APPLICATION_JSON_VALUE})		//by consumes argument means only accept request which is coming in json					
   public boolean updatestud(@PathVariable("name") @ModelAttribute() @RequestBody String vv)
   //public void updatestud(@PathVariable("name") @ModelAttribute() @RequestBody String vv)   // when dont want to show response body in postman body after request processed
  // public boolean updatestud(@PathVariable("name") String studentName, @RequestBody Student student)
   			{	
	   //System.out.println("Student Name: " + studentName);
	   //System.out.println("Student Name: " + student.getStudentName()+"Student Hobby: "+student.getStudentHobby());
	   													//find the matching  student record using "studentName" from the DB
	   													//update the matching student record with the information of student sent bt the client
	   													//return true if update is successfully done and return false if update is not done successfully
	   
	   
    	 //Student  vv = new Student();
	     return true;
    
   			}
   //**********************posting student record******************* 
   
  @RequestMapping(value="/students", method = {RequestMethod.POST}, consumes= {MediaType.APPLICATION_JSON_VALUE})		//by consumes argument means only accept request which is coming in json					
  public ResponseEntity <Boolean> postStudent ( @ModelAttribute() @RequestBody Student vv)
  
  			{	
	   //System.out.println("Student Name: " + studentName);
	  																	//insert the student recird into the DB
	   HttpHeaders httpheaders= new HttpHeaders();
	   httpheaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest().path("name").buildAndExpand(vv.getStudentName()).toUri().toString()  );
	   
   	 //Student  vv = new Student();
	     return new ResponseEntity <Boolean>(true,   httpheaders, HttpStatus.CREATED);
   
  			}
    
  //**********************delete student record******************* 
  
  
  @RequestMapping(value="/students/{name}", method = {RequestMethod.DELETE})		//by consumes argument means only accept request which is coming in json
  
  public ResponseEntity <Boolean> deleteStuden(@PathVariable("name") String studentName)
  
  			{	
	   System.out.println("Student Name: " + studentName);
	  																	//insert the student recird into the DB
	  // HttpHeaders httpheaders= new HttpHeaders();
	   //httpheaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest().path("name").buildAndExpand(student.getStudentName()).toUri().toString()  );
	   
   	 //Student  vv = new Student();
	     return new ResponseEntity <Boolean>(true,  HttpStatus.OK);
   
  			}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
