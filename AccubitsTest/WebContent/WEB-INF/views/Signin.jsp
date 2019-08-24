<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Accubits</title>
</head>
<body>


 
  
        <h1>Sign In</h1>  
        <c:if test="${not empty failMsg}"><h2>${failMsg}</h2></c:if>
       <form:form method="post" commandName="user" action="login">    
        <table >    
         <tr>    
          <td>Email :</td>    
          <td><form:input path="email" /></td>  
         </tr>   
         <tr>    
          <td>Password :</td>    
          <td><form:input path="password" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Login" /></td>    
         </tr>    
        </table>    
       </form:form>    

</body>
</html>