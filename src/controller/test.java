package controller;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class test {
 
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/hrd_students";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
 
	public static void main(String[] argv) throws ClassNotFoundException {
 
		try {
 
			selectRecordsFromTable();
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		}
 
	}
 
	private static void selectRecordsFromTable() throws SQLException, ClassNotFoundException {
 
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
 
		String selectSQL = "SELECT * FROM hrd_students WHERE stu_name = ?";
 
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "asdfasd");
 
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
 
			while (rs.next()) {
					
System.out.println("found");
 
			}
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			if (preparedStatement != null) {
				preparedStatement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
 
	}
 
	private static Connection getDBConnection() throws ClassNotFoundException, SQLException {
 
		Connection dbConnection = null;
 

 
			Class.forName(DB_DRIVER);
 

			dbConnection = DriverManager.getConnection(
                             DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
 
	}
 
}