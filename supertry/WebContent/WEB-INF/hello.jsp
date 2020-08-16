<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data-entry</title>
</head>
<body bgcolor="yellow">
<br>
<hr>
<h1 align="center">Data-Entry</h1>
<hr>
<br><br><br>
<form action="<%=request.getContextPath()%>/rouge" method="post">
Name= <input type="text" name="a" />
<br><br>
Age = <input type="number" name="b" />
<br><br>
Pos = <select name="c">
<option value="manager">Manager</option>
<option value="clerk">Clerk</option>
<option value="janitor">Janitor</option>
<option value="watchman">Watchman</option>
</select>
<br><br>
<center>
 <input type="submit" value="enter" />
</center>
</form>
</body>
</html>