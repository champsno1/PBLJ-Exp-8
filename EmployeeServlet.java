package com.example.partB;


import com.example.util.DBUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;


@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
List<Map<String,Object>> list = new ArrayList<>();
String sql = "SELECT emp_id, name, department, email, salary FROM employees";
try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
while (rs.next()) {
Map<String,Object> m = new HashMap<>();
m.put("emp_id", rs.getInt("emp_id"));
m.put("name", rs.getString("name"));
m.put("department", rs.getString("department"));
m.put("email", rs.getString("email"));
m.put("salary", rs.getBigDecimal("salary"));
list.add(m);
}
} catch (SQLException e) {
throw new ServletException(e);
}
req.setAttribute("employees", list);
req.getRequestDispatcher("/employees.jsp").forward(req, resp);
}
}
