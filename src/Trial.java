import java.sql.*;
import java.math.*;

public class Trial {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/phonedirectory";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "leafe1";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT name,phoneNumber,email,address FROM Contact";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			System.out.println("Name:\t Id:");
			while (rs.next()) {
				// Retrieve by column name
				String name = rs.getString("name");
				String phoneNumber = rs.getString("phoneNumber");
				String email = rs.getString("email");
				String address = rs.getString("address");

				// Display values
				System.out.println(name + "\t" + phoneNumber + "\t" + email + "\t" + address );

			}
			//System.out.println();
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}// end main

}
