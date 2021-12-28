<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javax.swing.event.ListSelectionEvent"%>
<%@page import="Hibernate.Book_detail"%>
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
<form action="./update_book">

<table>
<% ArrayList<Book_detail> std = (ArrayList<Book_detail>)request.getAttribute("updatebook");
for(Book_detail s:std){%>
<tr>
<td>
Name 
</td>
<td>
<input type="text" name="Name" value="<%=s.getBook_name()%>"/><br>
</td>
</tr>
<tr>
<td>
Author
</td>
<td>
<input type="text" name= "Author" value="<%=s.getAuthor_details().getName()%>"/><br>
</td>
</tr>
<tr>
<td>
Price
</td>
<td>
<input type="text" name= "price" value="<%=s.getBook_price()%>"/><br>
</td>
</tr>

<tr>
<td>
ISBN:
</td>
<td>
<input type="text" name= "ISBN" value="<%=s.getISBN()%>"/><br>
</td>
</tr>

<tr>
<td>Book edition</td>
<td><input type="text" name= "Book_edition" value="<%=s.getBook_edition()%>"/></td>
</tr>

<tr>
<td>pages:</td>
<td><input type="text" name= "pages" value="<%=s.getPages()%>"/></td>
</tr>

<tr>
<td>Language</td>
<td><input type="text" name= "language" value="<%=s.getLanguage()%>"/></td>
</tr>

<tr>
<td>Date of publish<br> (yyyy-MM-dd)</td>
<td><input type="text" name= "date_of_publish" value="<%=s.getDate_of_publish()%>"/></td>
</tr>
<tr>
<td>
<input type="hidden" value="<%=s.getBook_ID()%>" name="bookid" />
</td>
</tr>
<tr>
<td>
<%}%>
</td>
<td>
<input type="submit" value="update book">
</td>
</tr>
</table>

</form>
</center>
</div>

</div>

</body>
</html>