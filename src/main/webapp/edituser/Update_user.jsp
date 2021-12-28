<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javax.swing.event.ListSelectionEvent"%>
<%@page import="Hibernate.User_detail"%>
<%@page import="java.util.ArrayList"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>library management</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<!-- Sidebar -->
<div class="w3-container w3-teal">
  <h1 style="text-align: center;">Library management system</h1>
</div>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
 

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
     
      <li class="nav-item">
        <a class="nav-link" href="Add_new_book.jsp">Add Book</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="./View_all_book">View All Book</a>
      </li>
    </ul>
   
  </div>
</nav>

<!-- Sidebar -->




<div class="w3-container">

<center>
<form action="./update_user">

<table>
<% ArrayList<User_detail> std = (ArrayList<User_detail>)request.getAttribute("updateuser");
for(User_detail s:std){%>
<tr>
<td>
Name 
</td>
<td>
<input type="text" name="Name" value="<%=s.getName()%>"/><br>
</td>
</tr>
<tr>
<td>
Email
</td>
<td>
<input type="text" name= "email" value="<%=s.getEmail()%>"/><br>
</td>
</tr>
<tr>
<td>
Book id
</td>
<td>
<input type="text" name= "bookid" value="<%=s.getId()%>"/><br>
</td>
</tr>

<tr>
<td>
Issue date<br> (MM/dd/yyyy)
</td>
<td>
<input type="text" name= "ISdate" value="<%=s.getBook1_issue()%>"/><br>
</td>
</tr>

<tr>
<td>Return date<br> (MM/dd/yyyy)</td>
<td><input type="text" name= "REdate" value="<%=s.getBook1_return()%>"/></td>
</tr>



<tr>
<td>
<input type="hidden" value="<%=s.getId()%>" name="userid" />
</td>
</tr>
<tr>
<td>
<%}%>
</td>
<td>
<input type="submit" value="update user">
</td>
</tr>
</table>

</form>
</center>
</div>

</div>

</body>
</html>