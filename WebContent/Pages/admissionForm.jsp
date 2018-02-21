<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admission Form</title>
</head>
<body> 

	<a href="/FirstSpringProject/admform?siteLanguge=en"> English</a>										   <!-- here passing parameter sitelanguage = en or fr -->
	<a href="/FirstSpringProject/admform?siteLanguage=fr"> French</a>											<!--  -->

<form action="/FirstSpringProject/formsubmit" method = "post">   						 <!-- action means when submit button will hit where it will go -->
<form:errors path= "student1.*"/>													<!-- it will display complete binding related error will occur on server -->
                    
							          <h1>${mainmsg}</h1> 
							   <h3><spring:message code = "label.hearderMessage" /> </h3>
							
             <h3> <spring:message code = "label.admissionForm" />  </h3>          <!-- label way called PlaceHolder way -->
<table>             
<tr>
<td><spring:message code ="label.studentName" /></td> <td><input type= "text" name= "studentName"/></td>
<!-- <td>Student Name:</td> <td><input type= "text" name= "studentName"/></td> -->
</tr>

<tr>
<td><spring:message code="label.studentHobby"/></td><td> <input type= "text" name= "studentHobby"/></td>			 <!-- label way called PlaceHolder way -->
<!-- <td>Student Hobby:</td><td> <input type= "text" name= "studentHobby"/></td>-->
</tr>

<tr>
<td><spring:message code="label.studentMobile"/></td><td> <input type="text" name ="studentMobile"/></td>
<!-- <td>Student Mobile:</td><td> <input type="text" name ="studentMobile"/></td>-->
</tr>

<tr>
<td><spring:message code="label.studentDOB"/></td><td> <input type="text" name ="studentDOB"/></td> 
<!-- <td>Student's DOB:</td><td> <input type="text" name ="studentDOB"/></td>-->
</tr>

<tr>
<td><spring:message code="label.studentSkills"/></td><td> <select name ="studentSkills" multiple>					 <!-- label way called PlaceHolder way -->
<!--<td>Student Skills set:</td><td> <select name ="studentSkills" multiple>  --> 
								    <option value = "Java core"> Java Core </option>	
									<option value = "Spring Core"> Spring Core </option>	
									<option value = "Spring MVC"> Spring MVC Core </option>	
									</select> </td>
</tr>
</table>

<table>
		<tr>
		<!--  <td>student' s Address</td>  -->
		<td><spring:message code="label.studentAddress"/></td> 
		</tr>
		
		<tr>
		<!-- <td> country: <input type="text" name="studentAddress.country"/></td> -->
		<td><spring:message code="label.country"/> <input type="text" name="studentAddress.country"/></td>
		
		<!--  <td> city: <input type="text" name="studentAddress.city"/></td>-->
		<td> <spring:message code="label.city"/> <input type="text" name="studentAddress.city"/></td>
		
		<!-- <td> street: <input type="text" name="studentAddress.street"/></td> -->
		<td> <spring:message code="label.street"/><input type="text" name="studentAddress.street"/></td>
		
		<!--<td> pincode: <input type="text" name="studentAddress.pincode"/></td>  -->
		<td> <spring:message code="label.pincode"/><input type="text" name="studentAddress.pincode"/></td>
		</tr>

</table>

<!--<input type="submit" value= "sumit form here"/>  -->
<spring:message code = "label.submit.admform"/><input type="submit" value= "Submit"/>

</form>

</body>
</html>