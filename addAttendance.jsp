<%@page contentType="text/html;charset=UTF-8" %>
<%@page import="java.sql.*,java.util.*" %>
<%
// load students for checkbox list
java.util.List<java.util.Map<String,Object>> students = new java.util.ArrayList<>();
try (java.sql.Connection conn = com.example.util.DBUtil.getConnection();
java.sql.PreparedStatement ps = conn.prepareStatement("SELECT student_id,name,roll_no FROM students");
java.sql.ResultSet rs = ps.executeQuery()) {
while (rs.next()) {
java.util.Map<String,Object> m = new java.util.HashMap<>();
m.put("id", rs.getInt("student_id"));
m.put("name", rs.getString("name"));
m.put("roll", rs.getString("roll_no"));
students.add(m);
}
} catch (Exception e) { e.printStackTrace(); }
%>
<!doctype html>
<html>
<head><title>Mark Attendance</title></head>
<body>
<h2>Mark Attendance for Today</h2>
<form action="attendance" method="post">
<input type="hidden" name="date" value="<%= new java.sql.Date(System.currentTimeMillis()) %>" />
<table border="1">
<tr><th>Select</th><th>Roll No</th><th>Name</th></tr>
<% for (Map<String,Object> s : students) { %>
<tr>
<td><input type="checkbox" name="present" value="<%= s.get("id") %>"></td>
<td><%= s.get("roll") %></td>
<td><%= s.get("name") %></td>
</tr>
<% } %>
</table>
<button type="submit">Save Attend
