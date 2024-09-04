package xyz.com;
import java.sql.*;
import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dpservlet
 */
@WebServlet(name = "www.dp.com", urlPatterns = { "/www.dp.com" })
public class dpservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dpservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("Text/html");
		PrintWriter pw = response.getWriter();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","johny123");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			pw.print("<tr>");
			pw.print("<th> Roll no </th>");
			pw.print("<th> Name </th>");
			pw.print("<th> Address </th>");
			pw.print("<th> Mark </th>");
			pw.print("</tr>");
			while(rs.next())
			{
				pw.print("<tr>");
				pw.print("<td>"+rs.getInt(1)+"</td>");
				pw.print("<td>"+rs.getString(2)+"</td>");
				pw.print("<td>"+rs.getString(3)+"</td>");
				pw.print("<td>"+rs.getInt(4)+"</td>");
				pw.print("</tr>");
			}
			pw.print("</table></body></html>");
		}
		catch(Exception e)
		{}
	}

}
