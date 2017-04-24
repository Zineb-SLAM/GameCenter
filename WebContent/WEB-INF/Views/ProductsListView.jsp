<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="beans.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Products List</title>
 </head>
 <body>
 
    <h3>Games List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Genre</th>
          <th>Publisher</th>
          <th>Agemin</th>
           <th>Console Type</th>
          <th>Released</th>
           <th>Price</th>
            <th>Quantity</th>
             <th>Description</th>
       </tr>
      <%
		Object obj = request.getAttribute("ProductsList");
		if(obj!=null)
		{
			List<Product> lp = (List<Product>)obj;
			for(Product p : lp)
			{
	%>
			<tr>
				<td><%=p.getId()%></td>
				<td><%=p.getName()%></td>
				<td><%=p.getMaingenre()%></td>
				<td><%=p.getPublisher()%></td>
				<td><%=p.getAgemin()%></td>
				<td><%=p.getConsole()%></td>
				<td><%=p.getReleasedate()%></td>
				<td><%=p.getPrice()%></td>
				<td><%=p.getQuantity()%></td>
				<td><%=p.getDescription()%></td>
				<td>
					<a href="GestionUsers?action=Delete&id=<%=p.getId()%>">Delete</a>
					<a href="GestionUsers?action=Edit&id=<%=p.getId()%>">Edit</a>	
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
<a href="GestionCustomers">Add</a>
/Edit</h3>

<form method="post" action="GestionUsers">
		<label for="name">Name :</label>
		<input type="text" name="name" id="name" value="${uModif.name}"/>
		<br />
		<label for="name">Main Genre :</label>
		<input type="text" name="genre" id="genre" value="${uModif.genre}"/>
		<br />
		<label for="Tel">Publisher :</label>
		<input type="text" name="pub" id="pub" value="${uModif.pub}"/>
		<br />
		<label for="Tel">Age Restriction :</label>
		<input type="text" name="age" id="age" value="${uModif.age}"/>
		<br />
		<label for="Pwd">Console Type :</label>
		<input type="text" name="console" id="console" value="${uModif.console}"/>
		<br />
		<label for="Pwd">Released Date :</label>
		<input type="text" name="date" id="date" value="${uModif.date}"/>
		<br />
		<label for="Pwd">Price :</label>
		<input type="text" name="price" id="price" value="${uModif.price}"/>
		<br />
		<label for="Pwd">Quantity :</label>
		<input type="text" name="qtty" id="pwqttyd" value="${uModif.qtty}"/>
		<br />
		<label for="Pwd">Description :</label>
		<input type="text" name="desc" id="desc" value="${uModif.desc}"/>
		<br />
		<input type="hidden" name=id value="${uModif.id}"/>
		<input type="submit" value="Valider" />
	</form>

</body>
</html>