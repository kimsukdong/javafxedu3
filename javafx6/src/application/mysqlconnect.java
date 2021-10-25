package application;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class mysqlconnect {
	static Connection conn;

	public static Connection ConnectDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/sampledb2?serverTimezone=UTC", "sukdongkim","brd901as-kim");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		} 
	}
}