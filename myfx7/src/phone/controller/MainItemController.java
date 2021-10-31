package phone.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import phone.Main;
import phone.mysqlconnect;

public class MainItemController {
	@FXML
	Parent root;
	Main main = new Main();
	Connection conn = null;
	ResultSet srs;
	PreparedStatement pst = null;
	Window owner;

	@FXML	public TextField txt_username;
	@FXML	public PasswordField txt_password;
	@FXML   private TextField txt_username1;
	@FXML   private PasswordField txt_password1;
	@FXML   private TextField txt_fullname1;
	@FXML	private Label lblname;
	@FXML	private AnchorPane loginpane;
	@FXML	private AnchorPane logoutpane;
	@FXML   private AnchorPane signupane;

	@FXML
	private void initialize() {
		if( Main.main_username != null &&!Main.main_username.isEmpty()) {
			txt_username.setText(Main.main_username);
			txt_password.setText(Main.main_password);
		}
		if(Main.login.equals("ON")) {
			String s1 = "안녕하세요? " +Main.main_username+ " 님 !!!";
			loginpane.setVisible(false);
			lblname.setText(s1);
			logoutpane.setVisible(true);
			signupane.setVisible(false);
		}
	}

	@FXML
	void onClickLogin(ActionEvent event) throws SQLException {
		owner = txt_username.getScene().getWindow();
		if(txt_username.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR,owner,"Please enter a valid username", "Form error!");
			return;
		}
		if(txt_password.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR,owner,"Please enter a valid Password", "Form error!");
			return;
		}
		conn = mysqlconnect.ConnectDb();
		String username = txt_username.getText();
		String password = txt_password.getText();

		boolean flag =true;
		flag = mysqlconnect.validate(username, password);
		if(!flag)
			infoBox("Please enter correct username and password",null,"Failed");
		else {
			// infoBox("Login Successful , " + username,null,"Success");	
			Main.main_username = username;
			Main.main_password = password;
			Main.login = "ON";
		}
		if(Main.login.equals("ON")) {
			String s1 = "안녕하세요? " +Main.main_username+ " 님 !!!";
			loginpane.setVisible(false);
			lblname.setText(s1);
			logoutpane.setVisible(true);
			signupane.setVisible(false);
		}
	}

	@FXML
	void onClickLogout(ActionEvent event) throws SQLException {
		conn = null;
		Main.main_username = "";
		Main.main_password = "";

		Main.login = "OFF";

		txt_username.setText("");
		txt_password.setText("");

		loginpane.setVisible(true);
		logoutpane.setVisible(false);	
		signupane.setVisible(false);
		Main.login = "OFF";

	}
	@FXML
	void onClickSignUp(ActionEvent event) {
		loginpane.setVisible(false);
		logoutpane.setVisible(false);
		signupane.setVisible(true);
	}
    @FXML
    void onClickCancel(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("../view/MainItem.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	@FXML
	void onClickSignup(ActionEvent event) {
		conn = mysqlconnect.ConnectDb();

		String fullname;
		if(txt_fullname1.getText().isEmpty())
			fullname = "";
		else fullname = txt_fullname1.getText();
		String username = txt_username1.getText();
		String password = txt_password1.getText();

		if(username.length()==0) {
			JOptionPane.showMessageDialog(null, "Please, enter the Username");
			return ;
		}
		if(password.length()==0) {
			JOptionPane.showMessageDialog(null, "Please, enter the Password");
			return ;
		}
		int k=0;
		try {
			pst = conn.prepareStatement("select * from users where username =?");
			pst.setString(1, username);	
			srs = pst.executeQuery();
			if(!srs.next()) {
				pst = conn.prepareStatement("insert into users (fullname, username, password) values (?,?,?)");
				pst.setString(1, fullname);
				pst.setString(2, username);
				pst.setString(3, password);
				k =pst.executeUpdate();
			}
			else {
				JOptionPane.showMessageDialog(null, "사용자 중복!");
				txt_fullname1.setText("");
				txt_username1.setText("");
				txt_password1.setText("");
				return;
			}
			if(k==1) {
				JOptionPane.showMessageDialog(null, "New User !!!");
			} else {
				JOptionPane.showMessageDialog(null, "Error!");
			}
		} catch(SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Duplicate!");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Main.main_username = "";
		Main.main_password = "";

		Main.login = "OFF";

		txt_username.setText("");
		txt_password.setText("");
		if(txt_fullname1 != null)
			txt_fullname1.setText("");
		else 
			txt_fullname1.setText("");
		txt_username1.setText("");
		txt_password1.setText("");

		loginpane.setVisible(true);
		logoutpane.setVisible(false);	
		signupane.setVisible(false);
		Main.login = "OFF";
	}

	public static void infoBox(String infoMessage, String headerText, String title) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(infoMessage);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();    	
	}

	public static void showAlert(Alert.AlertType alertType, Window owner, String message, String title) {
		Alert alert = new Alert(alertType);
		alert.setContentText(message);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.initOwner(owner);
		alert.show();    	
	}

	@FXML
	void onClickCafe(MouseEvent event) {
		if(Main.login.equals("ON"))
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/CafeMain.fxml"));
				Main.mainLayout.setCenter(root);
				Main.setPrimaryStage("카페 관리");
			} catch(Exception e) {
				e.printStackTrace();
			}
		else
		{
			owner = txt_username.getScene().getWindow();
			showAlert(Alert.AlertType.ERROR,owner,"First, You must do login", "Form error!");
			return;
		}
	}
	@FXML
	void onClickAdress(MouseEvent event) {
		if(Main.login.equals("ON"))
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/AddressMain.fxml"));
				Main.mainLayout.setCenter(root);
				Main.setPrimaryStage("주소록 관리");
			} catch(Exception e) {
				e.printStackTrace();
			}
		else
		{
			owner = txt_username.getScene().getWindow();
			showAlert(Alert.AlertType.ERROR,owner,"First, You must do login", "Form error!");
			return;
		}
	}

	@FXML
	void onClickPizza(MouseEvent event) {
		if(Main.login.equals("ON"))
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/PizzaMain.fxml"));
				Main.mainLayout.setCenter(root);
				Main.setPrimaryStage("피자 관리");
			} catch(Exception e) {
				e.printStackTrace();
			}
		else
		{
			owner = txt_username.getScene().getWindow();
			showAlert(Alert.AlertType.ERROR,owner,"First, You must do login", "Form error!");
			return;
		}
	}
	@FXML
	void onClickBus(MouseEvent event) {
		if(Main.login.equals("ON"))
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/BusMain.fxml"));
				Main.mainLayout.setCenter(root);
				Main.setPrimaryStage("버스 예약 관리");
			} catch(Exception e) {
				e.printStackTrace();
			}
		else
		{
			owner = txt_username.getScene().getWindow();
			showAlert(Alert.AlertType.ERROR,owner,"First, You must do login", "Form error!");
			return;
		}
	}

}