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

 
  
        <h1>Add Blog</h1>  
       <form:form method="post" commandName="blog" action="save-blog">    
        <table >    
         <tr>    
          <td>Title : </td>   
          <td><form:input path="title"  /></td><form:errors path="title"></form:errors>  
         </tr>    
         <tr>    
          <td>Description :</td>    
          <td><form:textarea path="description" /></td>  
         </tr>   
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    

</body>
</html>