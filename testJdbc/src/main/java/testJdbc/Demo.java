package testJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("remove this line");
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","123456");
	  //Connection con = DriverManager.getConnection("databaseURL", "userName", "password");	
		
		System.out.println("Connection Approved");
				
		Statement st = con.createStatement();
	
		ResultSet rs = st.executeQuery("Select * from employees");
				
		ResultSetMetaData rsmd = rs.getMetaData();
	
		int j = st.executeUpdate ("insert into employees (employee_id, first_name, last_name)values (300, name, last)");
		System.out.println(j);

		
		int numOfCol = rsmd.getColumnCount();
		
		while (rs.next()) {
			for (int i = 1; i <= numOfCol; i++) {
				System.out.println(rsmd.getColumnName(i) + " " + rs.getString(i) + "+ ");
			}
		System.out.println();
		}
		
		
		
		
	
	}

}
