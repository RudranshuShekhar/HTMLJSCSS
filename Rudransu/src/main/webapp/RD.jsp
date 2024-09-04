<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%try 
   {
   Class.forName("oracle.jdbc.driver.OracleDriver");
   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","johny123");
   Statement stmt=con.createStatement();
   ResultSet rs=stmt.executeQuerry("Select * from workspace.student");
   %>
   <table border="3">
   <tr>
   <th>Roll No</tr>th>
   <th>Name</th>
   <th>Address</th>
   <th>Mark</th>
   <%
   while(rs.mext())
   {
   %>
   <tr>
   <td><%=rs.getInt(1) %></td>
   <td><%=rs.getString(2) %></td>
   <td><%=rs.getString(3) %></td>
   <td><%=rs.getInt(4) %></td>
   </tr>
   <%
   }
   }
   catch(Exception e)
   {
   {
   %>
   </table>
</body>
</html>