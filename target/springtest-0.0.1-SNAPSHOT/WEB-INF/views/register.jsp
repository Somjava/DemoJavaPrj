<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>Registration Form</title>
<style type="text/css">
h3{font-family: Calibri; font-size: 22pt; font-style: normal; font-weight: bold; color:SlateBlue;
text-align: center; text-decoration: underline }
table{font-family: Calibri; color:white; font-size: 11pt; font-style: normal;width: 50%;
text-align:; background-color: SlateBlue; border-collapse: collapse; border: 2px solid navy}
table.inner{border: 0px}
</style>
</head>
 
<body>
<h3>Customer Registration Form</h3>
<c:url var="registerCustomer" value="/registerCustomer" ></c:url>
<form:form action="${registerCustomer}" commandName="customer" method="POST" modelAttribute="customer">
<%-- <form action="RegisterServlet" method="POST"> --%>
 
<table align="center" cellpadding = "10">
<tr>
<td>Customer login ID</td>
<td><form:input type="text" name="custId" path="custId" maxlength="30"/>
This will be your login ID
</td>
<tr>
<td>Customer Name</td>
<td><form:input type="text" name="name" path="name" maxlength="30"/>
(max 30 characters a-z and A-Z)
</td>
</tr> 
<tr>
<td>Contact</td>
<td><form:input type="text" name="contact" path="contact" maxlength="30"/>
</td>
</tr>
<tr>
<td>City</td>
<td><form:input type="text" name="city" path="city" maxlength="30"/>
</td>
</tr>
<tr>
<td>state</td>
<td><form:input type="text" name="state" path="state" maxlength="30"/>
</td>
</tr>
<tr>
<td>house No</td>
<td><form:input type="text" name="houseno" path="houseno" maxlength="30"/>
</td>
</tr>
 <tr>
<td>Landmark</td>
<td><form:input type="text" name="landmark" path="landmark" maxlength="30"/>
</td>
</tr>
<tr>
<td colspan="2" align="center">
<form:button type="submit" value="Submit" >Submit</form:button>
<form:button type="reset" value="Reset" >Reset</form:button>
</td>
</tr>
</table>
 
</form:form>
 
</body>
</html>