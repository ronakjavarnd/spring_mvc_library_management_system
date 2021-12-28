<%@page import="javax.swing.event.ListSelectionEvent"%>
<%@page import="Hibernate.Book_detail"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="ISO-8859-1">

</head>
<body>
<table class="table table-striped" border="1">
  <thead>
    <tr>
      <th scope="col">Book Id</th>
      <th scope="col">Book Author</th>
      <th scope="col">Book Edition</th>
      <th scope="col">Book Name</th>
      <th scope="col">Book Price</th>
      <th scope="col">ISBN</th>
      <th scope="col">Language</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
      
      
    </tr>
  </thead>
  <tbody>
      
      <% ArrayList<Book_detail> std = (ArrayList<Book_detail>)request.getAttribute("totalbook");
        for(Book_detail s:std){%>
        <tr>
        <td><%=s.getBook_ID()%></td>
       <td><%=s.getAuthor_details().getName()%></td>
       <td><%=s.getBook_edition()%></td>
       <td><%=s.getBook_name() %></td>
       <td><%=s.getBook_price()%></td>
        <td><%=s.getISBN()%></td>
        <td><%=s.getLanguage() %></td>
        <td><a href="editbook/<%=s.getBook_ID()%>">Edit</a></td>
        <td><a href="deletebook/<%=s.getBook_ID()%>">Delete</a></td>
        </tr>
     <%}%>
    
    
    
  </tbody>
</table>


</body>
</html>