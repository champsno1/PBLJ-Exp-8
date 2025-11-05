<%@page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*" %>
<%
List<Map<String,Object>> employees = (List<Map<String,Object>>) request.getAttribute("employees");
%>
<!doctype html>
<html>
<head><title>Employees</title></head>
<body>
<h2>Employee Records</h2>
<table border="1" cellpadding="6">
<tr><th>ID</th><th>Name</th><th>Department</th><th>Email</th><th>Salary</th></tr>
<c:forEach var="e" items="${employees}">
<tr>
<td>${e.emp_id}</td>
<td>${e.name}</td>
<td>${e.department}</td>
<td>${e.email}</td>
<td>${e.salary}</td>
</tr>
</c:forEach>
</table>
<p><a href="welcome.jsp">Back</a></p>
</body>
</html>
