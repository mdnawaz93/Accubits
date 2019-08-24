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

 
  
        <h1>Blog List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Title</th><th>Description</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="blog" items="${blogList}">   
   <tr>  
   <td>${blog.id}</td>  
   <td>${blog.title}</td>  
   <td>${blog.description}</td>  
   <td><a href="editemp/${blog.id}">Edit</a></td>  
   <td><a href="deleteemp/${blog.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="add-blog">Add Blog</a>   

</body>
</html>