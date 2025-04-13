import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    String username = req.getParameter("username");
    String password = req.getParameter("password");

    if ("admin".equals(username) && "1234".equals(password)) {
      out.println("<h2>Welcome, " + username + "!</h2>");
    } else {
      out.println("<h2>Invalid credentials. Try again.</h2>");
    }
  }
}
