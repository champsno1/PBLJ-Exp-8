<%@page contentType="text/html;charset=UTF-8" %>
<%
String fullname = (String) session.getAttribute("fullname");
if (fullname == null) { response.sendRedirect("login.html"); return; }
%>
<!doctype html>
<html>
<head><title>Welcome</title></head>
<body>
<h2>Welcome, <%= fullname %></h2>
<p><a href="employees">View Employees (Part B)</a></p>
<p><a href="attendance">Attendance Portal (Part C)</a></p>
<form action="logout" method="post"><button>Logout</button></form>
</body>
</html>
