<%@ page language="java" %>
<html>
<head><title>Attendance Form</title></head>
<body>
  <h2>Student Attendance Form</h2>
  <form action="AttendanceServlet" method="post">
    Roll No: <input type="text" name="rollno" required><br>
    Subject: <input type="text" name="subject" required><br>
    Date: <input type="date" name="date" required><br>
    Status: 
    <select name="status">
      <option value="Present">Present</option>
      <option value="Absent">Absent</option>
    </select><br>
    <input type="submit" value="Submit Attendance">
  </form>
</body>
</html>
