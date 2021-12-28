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
<div style="margin-left:20%">




<div class="w3-container">

<center>
<form action="add_book" >
<br>
<br>
<table>
<tr>
<td>
Name 
</td>
<td>
<input type="text" name="Name"><br>
</td>
</tr>
<tr>
<td>
Author
</td>
<td>
<input type="text" name= "Author"><br>
</td>
</tr>
<tr>
<td>
Price
</td>
<td>
<input type="text" name= "price"><br>
</td>
</tr>

<tr>
<td>
ISBN:
</td>
<td>
<input type="text" name= "ISBN"><br>
</td>
</tr>

<tr>
<td>Book edition</td>
<td><input type="text" name= "Book_edition"></td>
</tr>

<tr>
<td>pages:</td>
<td><input type="text" name= "pages"></td>
</tr>

<tr>
<td>Language</td>
<td><input type="text" name= "language"></td>
</tr>

<tr>
<td>Date of publish<br> (yyyy-MM-dd)</td>
<td><input type="text" name= "date_of_publish"></td>
</tr>


<tr>
<td>
</td>
<td>
<input type="submit" value="add new book">
</td>
</tr>
</table>
</form>
</center>
</div>

</div>
</body>
</html>