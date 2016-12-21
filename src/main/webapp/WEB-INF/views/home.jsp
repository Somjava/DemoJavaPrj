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
<script type="text/javascript">
/* function onSelectPizza(){
	var tbl = document.getElementById("tbl-1");

    var numRows = tbl.rows.length;
	//alert("No if row in the table"+numRows);
    for (var i = 2; i = numRows; i++) {
    	var trs = tbl.getElementsByTagName("tr");
        alert(cellVal);
      }

} */

function submitForm(){
	var shipmentCharge = calSum();
	
	document.getElementById("shipmentCharge").value=shipmentCharge;
	document.forms["f1"].submit();
	
}
function submitFormOrder(){
	document.forms["orderForm"].submit();
	
}

function resetAll(){
	var tbl = document.getElementById("tbl-1");
    var numRows = tbl.rows.length;
    for (var i = 1; i < numRows; i++) {
    	var id1 = i+"r3i";
    	document.getElementById(id1).value="";
    	var id2 = i+"r5i"
    	var td2 = document.getElementById(id2).value="";
    	var id3 = i+"r7i"
    	var td3 = document.getElementById(id3).value="";	
    	document.getElementById(i+"r8l").value="";
    	document.getElementById("totalSum").value="";
      }
	
}


function calTopsBill(rowID,price){
	var id1 = rowID+"t3i"
	var td1 = document.getElementById(id1).value;	
	var total = td1*price;
	
	document.getElementById(rowID+"t8l").value =total; 
}


function calSum(){
	var tbl = document.getElementById("tbl-1");
    var numRows = tbl.rows.length;
    var sum = 0;
    for (var i = 1; i < numRows; i++) {
    	var val  = document.getElementById(i+"r8l").value;
    	sum = (Number(sum)+Number(val));
      }
    
    var tbl2 = document.getElementById("tbl-2");
    var numRows2 = tbl2.rows.length;
    for (var i = 1; i < numRows2; i++) {
    	var val2  = document.getElementById(i+"t8l").value;
    	sum = (Number(sum)+Number(val2));
      }
    
    document.getElementById("totalSum").value= sum;
    return sum;
}


function calculateRowBill(rowID,price){
	var id1 = rowID+"r3i"
	var td1 = document.getElementById(id1).value;	
	var total = td1*price;
	
	var id2 = rowID+"r5i"
	var td2 = document.getElementById(id2).value;	
	total  = total + td2*price*2;
	
	var id3 = rowID+"r7i"
	var td3 = document.getElementById(id3).value;	
	total  = total + td3*price*2;
	
	document.getElementById(rowID+"r8l").value =total; 
}
</script>
</head>

<body>
Home Welcome <h1>${customer.name}</h1>

<form action="viewOrder" method="post" id="orderForm">
View Order By orderID: <input id="orderId" name="orderId"/> <input type="button" value="Enter" onclick="submitFormOrder();"/>
</form>
<center>
		 <table id="tbl-1">
			 <thead>
				 <tr>
					 <th>Pizza</th>
					 <th>Small</th>
					 <th>Enter Qty</th>
					 <th>Medium</th>
					 <th>Enter Qty</th>
					 <th>Large</th>	
					 <th>Enter Qty</th>	
					 <th>Action</th>							
				 </tr>
			 </thead>
			 <tbody>
			 
			 <c:forEach items="${pizzas}" var="pizza"> 
			  <tr id="${pizza.pizzaId}r">
			    <td id="${pizza.pizzaId}r1">${pizza.name}</td>
			    <td id="${pizza.pizzaId}r2">${pizza.price}</td>
			    <td id="${pizza.pizzaId}r3"><input id="${pizza.pizzaId}r3i" type="text" onchange="calculateRowBill('${pizza.pizzaId}','${pizza.price}')"/></td>
			    <td id="${pizza.pizzaId}r4">${pizza.price * 2}</td>
			    <td id="${pizza.pizzaId}r5"><input id="${pizza.pizzaId}r5i" type="text" onchange="calculateRowBill('${pizza.pizzaId}','${pizza.price}')"/></td>
			    <td id="${pizza.pizzaId}r6">${pizza.price * 3}</td>
			    <td id="${pizza.pizzaId}r7"><input id="${pizza.pizzaId}r7i" type="text" onchange="calculateRowBill('${pizza.pizzaId}','${pizza.price}')"/></td>
			    <td id="${pizza.pizzaId}r8"><input id="${pizza.pizzaId}r8l" type="text" /></td>
			  </tr>
			</c:forEach>
			 </tbody>
		 </table>
		 
		 
		 
		 		
		 <br/>
		 
		 
		 
		 
		 <table id="tbl-2">
			 <thead>
				 <tr>
					 <th>Toppings</th>
					 <th>Rate</th>
					 <th>Enter Qty</th>
					 <th>Action</th>							
				 </tr>
			 </thead>
			 <tbody>
			 
			 <c:forEach items="${toppings}" var="topping"> 
			  <tr id="${topping.toppingId}t">
			    <td id="${topping.toppingId}t1">${topping.toppingType}</td>
			    <td id="${topping.toppingId}t2">${topping.toppingPrice}</td>
			    <td id="${topping.toppingId}t3"><input id="${topping.toppingId}t3i" type="text" onchange="calTopsBill('${topping.toppingId}','${topping.toppingPrice}')"/></td>
			    <td id="${topping.toppingId}t8"><input id="${topping.toppingId}t8l" type="text" /></td>
			  </tr>
			</c:forEach>
			 </tbody>
		 </table>
	 </div>
	</center>	

<center><div>Total Amount : <input type="text" id="totalSum"/><br />
							<input type="button" value="Reset" onclick="resetAll();"/> 
							<input type="button" value="Submit Order" onclick="submitForm();"/></div></center>

<c:url var="makeOrder" value="/makeOrder"></c:url>
<form:form action="${makeOrder}" commandName="order" method="POST" id="f1">
	<form:hidden path="shipmentCharge" id="shipmentCharge"/>
	<form:hidden path="orderStatus" id="orderStatus" value="PENDING" />
	<form:hidden path="custId" id="custId" value="${customer.id}" />
</form:form>
</body>
</html>
