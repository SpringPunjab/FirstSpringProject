<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form Submitted</title>
</head>
<body>
<h1>${mainmsg}</h1>										<!-- this here just to show on every page -->
<h2>Form Has been Submitted</h2>



<table> 

<tr> 
<td>Student Name:</td>
<td>${student1.studentName}</td>
</tr>

<tr> 
<td>Student Hobby:</td>
<td>${student1.studentHobby}</td>
</tr>

<tr> 
<td>Student Mobile:</td>
<td>${student1.studentMobile}</td>
</tr>

<tr> 
<td>Student DOB:</td>
<td>${student1.studentDOB}</td>
</tr>

<tr> 
<td>Student Skills:</td>
<td>${student1.studentSkills}</td>
</tr>

<tr> 
<td>Student country:</td>
<td>${student1.studentAddress.country}</td>
</tr>

<tr> 
<td>Student city:</td>
<td>${student1.studentAddress.city}</td>
</tr>

<tr> 
<td>Student street:</td>
<td>${student1.studentAddress.street}</td>

<tr> 
<td>Student pincode:</td>
<td>${student1.studentAddress.pincode}</td>
</tr>
</tr>

</table>

</body>
</html>