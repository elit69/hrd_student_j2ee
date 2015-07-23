package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DBConnection {
	private static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:";
	private static String PORT_NUMBER = "3306";
	private static String DB_NAME = "hrd_students";
	private static String USER_NAME = "root";
	private static String PASSWORD = "1234";

	/**
	 * Deny object initialization
	 */
	private DBConnection() {}
	
	/**
	 * connect to database
	 * 
	 * @return object connection to a database
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName(DRIVER_NAME);
		Connection con = DriverManager.getConnection(URL + PORT_NUMBER + "/"
				+ DB_NAME, USER_NAME, PASSWORD);
		System.out.println("\n" + new SimpleDateFormat("dd/MM/YYYY HH:mm:ss").format(new Date()));
		System.out.println("Connecting to database...");
		return con;
	}
	public static void main(String[] args) {
		
	}
}
	