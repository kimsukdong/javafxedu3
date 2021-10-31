package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class mysqlconnect {
	static Connection conn;
	private static final String SELECT_QUERY = "SELECT * FROM users WHERE username = ? AND password=?";

	public static Connection ConnectDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?serverTimezone=UTC", "root","brd901as-kim");
	//		JOptionPane.showMessageDialog(null, "Connection Established !!!");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		} 
	}
	
	public static boolean validate(String username, String password) throws SQLException {
		PreparedStatement preparedStatement = conn.prepareStatement(SELECT_QUERY);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		
		ResultSet res = preparedStatement.executeQuery();
		if(res.next())
			return true;
		return false;	
	}
}