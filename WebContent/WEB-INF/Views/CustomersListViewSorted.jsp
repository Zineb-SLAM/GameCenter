<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Customer"%>
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
    <h4>Sorted List</h4>

    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Id</th>
          <th>Firstname</th>
          <th>Lastname</th>
          <th>Username</th>
          <th>Email</th>
       </tr>
      <%
		Object obj = request.getAttribute("CustomersList");
		if(obj!=null)
		{
			List<Customer> lc = (List<Customer>)obj;
			for(Customer u : lc)
			{
	%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getFirstname()%></td>
				<td><%=u.getLastname()%></td>
				<td><%=u.getUsername()%></td>
				<td><%=u.getEmail()%></td>
				<td>
					<a href="customers?action=doDelete&id=<%=u.getId()%>">Delete</a>
					<a href="customers?action=doEdit&id=<%=u.getId()%>">Edit</a>	
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