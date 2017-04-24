<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Users List</title>
</head>

<body>
<h1>Users List</h1>
<h4>Sort by</h4>
Sort :
<form method="post" action="CustomersManager">
	<input name="sortType" type="radio" value="1"/>firstname
	<input name="sortType" type="radio" value="1"/>lastname
	<input name="sortType" type="radio" value="2"/>username
	<input type="hidden" name="action" valce="sort" />
	<input type="submit" value="Sort" />
</form>

<table border="1">
<tr>
	<th>ID</th>
	<th>
		<a href="GestionUsers?action=sort">name</a>
	</th>
	<th>TEL</th>
	<th>USERNAME</th>
	<th>ACTIONS</th>
</tr>
	<%
		Object obj = request.getAttribute("listeC");
		if(obj!=null){
			List<Customer> lc = (List<Customer>)obj;
			for(Customer u : lc){
	%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getFirstname()%></td>
				<td><%=u.getLastname()%></td>
				<td><%=u.getUsername()%></td>
				<td><%=u.getEmail()%></td>
				<td>
					<a href="CustomersManager?action=Delete&id=<%=u.getId()%>">Delete</a>
					<a href="CustomersManager?action=Edit&id=<%=u.getId()%>">Edit</a>	
				</td>
			</tr>
	<%
			}
			
			
		}
	%>
</table>

<h3>
<a href="GestionUsers">Add</a>
/Edit</h3>

<form method="post" action="GestionUsers">
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