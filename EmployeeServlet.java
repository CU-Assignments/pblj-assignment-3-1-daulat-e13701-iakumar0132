import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EmployeeServlet extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    String empid = req.getParameter("empid");
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");

      if (empid != null && !empid.trim().isEmpty()) {
        ps = con.prepareStatement("SELECT * FROM employees WHERE id = ?");
        ps.setInt(1, Integer.parseInt(empid));
      } else {
        ps = con.prepareStatement("SELECT * FROM employees");
      }

      rs = ps.executeQuery();
      out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Dept</th></tr>");
      while (rs.next()) {
        out.println("<tr><td>" + rs.getInt("id") + "</td><td>" + rs.getString("name") + "</td><td>" + rs.getString("department") + "</td></tr>");
      }
      out.println("</table>");
    } catch (Exception e) {
      out.println("Error: " + e.getMessage());
    }
  }
}
