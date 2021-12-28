<%@page import="javax.swing.event.ListSelectionEvent"%>
<%@page import="Hibernate.User_detail"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table table-striped" border="1">
  <thead>
    <tr>
      <th scope="col">User Id</th>
      <th scope="col">User Name</th>
      <th scope="col">Email</th>
      <th scope="col">Book Id</th>
      <th scope="col">Issue Date</th>
      <th scope="col">Return date</th>
      <th scope="col">Fine </th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
      
      
    </tr>
  </thead>
  <tbody>
      
      <% ArrayList<User_detail> std = (ArrayList<User_detail>)request.getAttribute("totaluser");
      
        for(User_detail s:std){
        System.out.println("std"+s);%>
        <tr>
        <td><%=s.getId()%></td>
        <td><%=s.getName()%></td>
        <td><%=s.getEmail()%></td>
        <td><%=s.getBook1_ID()%></td>
        <td><%=s.getBook1_issue()%></td>
        <td><%=s.getBook1_return()%></td>
        <% long fine = s.getAuthor_details().getAmount();
        if(fine == 0){%>
        <td><a href="Pay/<%=s.getId()%>">Fine</a></td>
        <%}else{%>
        <td><a href="Pay/<%=s.getId()%>"><%=s.getAuthor_details().getAmount()%>/-</a></td>
        
        <%}%>
        <td><a href="edituser/<%=s.getId()%>">Edit</a></td>
        <td><a href="deleteuser/<%=s.getId()%>">Delete</a></td>
        </tr>
     <%}%>
    
    
     
  </tbody>
</table>


</body>
</html>