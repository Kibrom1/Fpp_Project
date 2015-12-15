package phonebook;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

class DbProperty {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/phonedirectory";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "leafe1";

	public String getDriver() {
		return JDBC_DRIVER;
	}

	public String getDbUrl() {
		return DB_URL;
	}

	public String getUser() {
		return USER;
	}

	public String getPassword() {
		return PASS;
	}

}

public class DBConnection {

	private static Connection connection = null;

	public static Connection getConnection() throws FileNotFoundException {

		if (connection != null)

			return connection;

		else {

			try {
				DbProperty prop = new DbProperty();
				String driver = prop.getDriver();

				String url = prop.getDbUrl();

				String user = prop.getUser();

				String password = prop.getPassword();

				Class.forName(driver);

				connection = (Connection) DriverManager.getConnection(url, user, password);

			} catch (ClassNotFoundException e) {

				e.printStackTrace();

			} catch (SQLException e) {

				e.printStackTrace();

			}

			return connection;

		}

	}

}
