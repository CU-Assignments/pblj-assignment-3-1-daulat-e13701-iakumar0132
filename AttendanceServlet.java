import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AttendanceServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    String roll = req.getParameter("rollno");
    String subject = req.getParameter("subject");
    String date = req.getParameter("date");
    String status = req.getParameter("status");

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");

      PreparedStatement ps = con.prepareStatement("INSERT INTO attendance (rollno, subject, date, status) VALUES (?, ?, ?, ?)");
      ps.setString(1, roll);
      ps.setString(2, subject);
      ps.setString(3, date);
      ps.setString(4, status);
      ps.executeUpdate();

      out.println("<h2>Attendance recorded for Roll No: " + roll + "</h2>");
    } catch (Exception e) {
      out.println("Error: " + e.getMessage());
    }
  }
}
