<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<html>
<head>
<style type="text/css">
.error{
color:red;
}</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Accubits</title>
</head>
<body>

 
  
        <h1>Add New User</h1>  
        <c:if test="${not empty failMsg}"><h2>${failMsg}</h2></c:if>
       <form:form method="post" commandName="user" action="save-user">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /><form:errors cssCalss="error" path="name"></form:errors></td>
         </tr>      
         <tr>    
          <td>Email :</td>    
          <td><form:input path="email" /><form:errors cssCalss="error" path="email"></form:errors></td>  
         </tr>   
         <tr>    
          <td>Password : </td>    
          <td><form:input path="password" /><form:errors cssCalss="error" path="password"></form:errors></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
 <a href="login">Already Register?</a>   
</body>
</html>