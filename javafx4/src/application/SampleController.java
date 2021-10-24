package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SampleController {

	Connection conn = null;
	ResultSet srs = null;
	PreparedStatement pst = null;
	
    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

	@FXML
	private void initialize() {
		conn = mysqlconnect.ConnectDb();
		try {
			pst = conn.prepareStatement("select * from users where name =? and password=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
    @FXML
    void onClickCancel(ActionEvent event) {
    	System.exit(0);
    }  
    
    @FXML
    void onClickLogin(ActionEvent event) {  	
       	String uname = tf1.getText();
    	String pass = tf2.getText();
    	

    	if(uname.equals("") && pass.equals(""))
    	{
    		JOptionPane.showMessageDialog(null, "UserName or Password Blank");    		    		
    	} else 
    	{
			try {
				pst.setString(1, uname);
				pst.setString(2, pass);
				
				srs = pst.executeQuery();
				if(srs.next()) {
					JOptionPane.showMessageDialog(null, "Login Success");  
				} else
				{
					JOptionPane.showMessageDialog(null, "Login Failed");  
					tf1.setText("");
					tf2.setText("");
					tf1.requestFocus();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

}
