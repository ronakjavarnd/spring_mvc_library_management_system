<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter User Details</h3>
        <form:form method="POST" 
          action="add_user" commandName="employee">
             <table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                 <tr>
                    <td><form:label path="email">Email Address</form:label></td>
                    <td><form:input path="email"/></td>
                </tr>
               
                <tr>
                    <td><form:label path="Book1_ID">Book Id</form:label></td>
                    <td><form:input path="Book1_ID"/></td>
                </tr>
               
                <tr>
                    <td><form:label  path="Book1_issue">Book Issue Date</br>(dd/mm/yyyy)</form:label></td>
                    <td><form:input  path="Book1_issue" /></td>
                </tr>
               
                <tr>
                    <td><form:label path="Book1_return">Book Return Date</br>(dd/mm/yyyy)</form:label></td>
                    <td><form:input path="Book1_return" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>