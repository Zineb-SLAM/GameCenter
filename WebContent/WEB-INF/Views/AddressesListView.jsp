<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Customer"%>
<%@page import="beans.Address"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Customers List</title>
 </head>
 <body>

    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Id</th>
          <th>Firstname</th>
          <th>Lastname</th>
          <th>Username</th>
          <th>Email</th>
          <th>Status</th>
          <th>address</th>
          <th>zipcode</th>
          <th>city</th>
          <th>country</th>
          <th>Status</th>
       </tr>
      <%
		Object obj = request.getAttribute("CustomersList");
		if(obj!=null)
		{
			List<Address> lc = (List<Address>)obj;
			for(Address u : lc)
			{
	%>
			<tr>
				<td><%=u.getCustomer().getId()%></td>		
				<td><%=u.getCustomer().getFirstname()%></td>
				<td><%=u.getCustomer().getLastname()%></td>
				<td><%=u.getCustomer().getUsername()%></td>
				<td><%=u.getCustomer().getEmail()%></td>
				<td><%=u.getCustomer().getStatus()%></td>
				<td><%=u.getCustomer().getStatus()%></td>
				<td><%=u.getAddress()%></td>
				<td><%=u.getZipcode()%></td>
				<td><%=u.getCity()%></td>
				<td><%=u.getZipcode()%></td>
				<td>
					<a href="customersdelete?action=get&id=<%=u.getId()%>">Delete</a>
					<a href="customersedit?action=get&id=<%=u.getId()%>">Edit</a>	
				</td>
			</tr>
	<%
			}
			
			
		}
		else
		{
			%><h1>NULL</h1>
			<%
			
		}
	%>
    </table>

<h3>
<a href="CustomersManager">Add</a>
/Edit</h3>

<form method="post" action="CustomersManager">
		<label for="name">First name :</label>
		<input type="text" name="name" id="name" value="${uModif.firstname}"/>
		<br />
		<label for="name">Last name :</label>
		<input type="text" name="name" id="name" value="${uModif.lastname}"/>
		<br />
		<label for="Tel">Email :</label>
		<input type="text" name="tel" id="tel" value="${uModif.email}"/>
		<br />
		<label for="Tel">Username :</label>
		<input type="text" name="tel" id="tel" value="${uModif.username}"/>
		<br />
		<label for="Pwd">Password :</label>
		<input type="text" name="pwd" id="pwd" value="${uModif.password}"/>
		<br />
		<input type="hidden" name=id value="${uModif.id}"/>
		<input type="submit" value="Valider" />
	</form>

</body>
</html>