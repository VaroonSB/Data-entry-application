<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result and Retrival</title>
</head>
<body bgcolor="yellow">
<br><hr>
<h2 align="center">ENTRY STATUS</h2><hr><br>
<ul>
<li>If the last entered data is there in the list, then the entry is a success</li>

<li>If the last entered data is not there in the list, then the entry is a failure</li>

<li>If the list is not displayed, then there may be errors in the db or db connections</li>
</ul> <br><br>
<center>
<table border=1 width=50% >
<tr>
<th>Name</th>
<th>Age</th>
<th>Position</th>
</tr>
<%@ page import="java.sql.*" %>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mummy?useSSL=false","root","123456");
Statement st=conn.createStatement();
ResultSet rs=st.executeQuery("select * from data_entry");
while(rs.next()){
	%>
	<tr>
	<td><%=rs.getString(1) %></td>
	<td><%=rs.getInt(2) %></td>
	<td><%=rs.getString(3) %></td>
	</tr>	
<%
}
%>
</table><br><br>
<a href="<%=request.getContextPath()%>/rouge">Continue</a>
</center>
</body>
</html>