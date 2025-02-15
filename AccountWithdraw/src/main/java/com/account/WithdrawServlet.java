package com.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		int num = Integer.parseInt(request.getParameter("num"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");

            String driver = "oracle.jdbc.driver.OracleDriver";
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "SYSTEM";
            String password = "qwerty";

            try {
                // Load the JDBC driver
                Class.forName(driver);

                // Establish a connection
                Connection con = DriverManager.getConnection(url, "SYSTEM", "qwerty");

                // Prepare SQL statement to update account balance
                String updateQuery = "update account set bal = bal-? WHERE num=?";
                PreparedStatement ps = con.prepareStatement(updateQuery);
                ps.setInt(1, amount);
                ps.setInt(2, num);

                // Execute the update statement
                int rowsUpdated = ps.executeUpdate();

                if (rowsUpdated > 0) {
                    out.println("<h2>Funds withdrawn successfully</h2>");
                } else {
                    out.println("<h2>Failed to withdraw funds. Account not found or insufficient balance.</h2>");
                }

                // Close resources
                ps.close();
                con.close();
            } catch (Exception e) {
                out.println("<h2>Exception: " + e.getMessage() + "</h2>");
            }
	}

}