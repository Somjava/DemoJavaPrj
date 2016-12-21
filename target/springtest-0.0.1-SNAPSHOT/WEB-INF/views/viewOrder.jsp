<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Login Page</title>

<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
</head>


<body>

<center>

<h1>Your Order Details</h1>
<table id="tbl-1">
			 <thead>
				 <tr>
					 <th>Order ID</th>
					 <th>Order Status</th>
					 <th>Shipment Charge</th>
					 <th>Customer Name</th>	
					 <th>Customer Address</th>						
				 </tr>
			 </thead>
			 <tbody>
			 	<tr id="r">
			    <td id="r1">${order.orderId}</td>
			    <td id="r2">${order.orderStatus}</td>
			    <td id="r3">${order.shipmentCharge}</td>
			    <td id="r4">${customer.name}</td>
			    <td id="r34">${customer.name}-${customer.city }</td>
			    </tr>
			 </tbody>
		 </table>
		



</center>


</body>
</html>
