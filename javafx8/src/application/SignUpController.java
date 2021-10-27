package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SignUpController {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	String sql;
	Main main = new Main();

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf3;

    @FXML
    private TextField tf4;

    @FXML
    private TextField tf2;

    @FXML
    void onClickBack(ActionEvent event) {
    	main.showMainView();
    }

    @FXML
    void onClickSignUp(ActionEvent event) {
		conn = mysqlconnect.ConnectDb();
       	String uname = tf1.getText();
		if(uname.length()==0) {
			JOptionPane.showMessageDialog(null, "No Record");
			return ;
		}
    	
    	String upass = tf2.getText();
       	String uemail = tf3.getText();
    	String uphone = tf4.getText();

		try {
			pst = conn.prepareStatement("insert into user (name,password, email, phone) values (?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, upass);
			pst.setString(3, uemail);
			pst.setString(4, uphone);
			int k =pst.executeUpdate();

			if(k==1) {
				JOptionPane.showMessageDialog(null, "Add User !!!");
			} else {
				JOptionPane.showMessageDialog(null, "Error!");
			}
		} catch(SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Duplicate!");
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }

}