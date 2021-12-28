<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
h1 {
  background-color: aqua;
}
</style>
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
<h3 style="color:green;">Book added to the Inventory successfully</h3>
<br>

<table border="1">
<tr>
<td>
Name 
</td>
<td>
<%=request.getAttribute("book_name") %><br>
</td>
</tr>
<tr>
<td>
Author
</td>
<td>
<%=request.getAttribute("book_author") %><br>
</td>
</tr>
<tr>
<td>
Price:
</td>
<td>
 <%=request.getAttribute("book_price") %><br>
</td>
</tr>

<tr>
<td>
Book_edition:
</td>
<td>
<%=request.getAttribute("Book_edition") %><br>
</td>
</tr>

<tr>
<td>
pages:
</td>
<td>
<%=request.getAttribute("pages") %><br>
</td>
</tr>

<tr>
<td>
language:
</td>
<td>
<%=request.getAttribute("language") %><br>
</td>
</tr>

<tr>
<td>
Date of publish:
</td>
<td>
<%=request.getAttribute("Date_of_publish") %><br>
</td>
</tr>
</table>
<br>
<br>
</center>
</div>
</div>
</body>
</html>