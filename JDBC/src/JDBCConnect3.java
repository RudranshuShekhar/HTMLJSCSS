/*
  Loading the driver:
  	Driver is a translator between Java code and oracle code.
  	Driver is a class.
  	class Class
  	{
  		static void forName(String driver) throws CLassNotFoundException
  	}
  	class DriverManager
	{
		static Connection getConnection(String url, String user, String pwd) throws SQLException
	}
 */

import java.sql.*;
import java.util.Scanner;
public class JDBCConnect3 {

	public static void main(String[] args) {
		try
		{
			String driver = "oracle.jdbc.driver.OracleDriver" ;
			Class.forName(driver);
			System.out.println("Driver Loaded");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe" ;
			String user = "SYSTEM" ;
			String pwd = "qwerty" ;
			
			Connection con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection is ready") ;
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Account num : ");
			int num = sc.nextInt();
			System.out.println("Enter Amount to Withdraw : ");
			int amt = sc.nextInt();
			
			
			String query = "select bal from account where num=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int balance = rs.getInt(1);
				if(amt <= balance)
				{
					String query1 = "update account set bal=bal-? where num=?";
					PreparedStatement ps1 = con.prepareStatement(query1);
					ps1.setInt(1, amt);
					ps1.setInt(2, num);
					ps1.executeUpdate();
					System.out.println("Withdraw Succesfull");
					
				}
			}
			else
				System.out.println("Error : Low balance in Account");
			con.close();
			System.out.println("Connection is closed");
		}
		catch(Exception e)
		{
			System.out.println("Exception : "+e.getMessage());
		}

	}

}