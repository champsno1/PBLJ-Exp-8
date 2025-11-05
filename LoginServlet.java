package com.example.partA;


import com.example.util.DBUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String username = req.getParameter("username");
String password = req.getParameter("password");


String sql = "SELECT id, fullname FROM users WHERE username=? AND password=?";
try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
ps.setString(1, username);
ps.setString(2, password);
try (ResultSet rs = ps.executeQuery()) {
if (rs.next()) {
HttpSession session = req.getSession(true);
session.setAttribute("userId", rs.getInt("id"));
session.setAttribute("fullname", rs.getString("fullname"));
resp.sendRedirect(req.getContextPath() + "/welcome.jsp");
} else {
resp.setContentType("text/html;charset=UTF-8");
resp.getWriter().println("<p>Invalid credentials. <a href=\"login.html\">Try again</a></p>");
}
}
} catch (SQLException e) {
throw new ServletException(e);
}
}
}
