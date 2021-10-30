package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SampleController {

	Connection conn = null;
	ResultSet srs = null;
	PreparedStatement pst = null;
	
	AnchorPane root;
	Scene scene;

	
    @FXML
    private Button btn_Manager;
    
    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

	@FXML
	private void initialize() {
		conn = mysqlconnect.ConnectDb();
		try {
			pst = conn.prepareStatement("select * from user where name =? and password=?");
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
    void onClickSignUp(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
		scene = new Scene(root,400,400);
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
		Main.primaryStage.setTitle("SignUp");
    }
    
    @FXML
    void onClickManage(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Manage.fxml"));
		scene = new Scene(root,800,600);
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
		Main.primaryStage.setTitle("Manage");
    }
    
    @FXML
    void onClickLogin(ActionEvent event) throws IOException, InterruptedException {  	
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
					if(uname.equals("admin")) {
						btn_Manager.setDisable(false);
					} else {
					root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
					scene = new Scene(root,600,400);
					Main.primaryStage.setScene(scene);
					Main.primaryStage.show();
					Main.primaryStage.setTitle("Data Processing . . .");  
					}
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