package phone.controller;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import phone.Main;
public class EmployeeMainController {
	Parent root;
	@FXML Main main;
	
	@FXML 
	private void goElectrical() throws IOException {
		try {
			root = FXMLLoader.load(getClass().getResource("/phone/view/ElectricalDept.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML 
	private void goMechanical() throws IOException {
		try {
			root = FXMLLoader.load(getClass().getResource("/phone/view/MechanicalDept.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    @FXML
    void onClickAddEmployee(ActionEvent event) throws IOException {
    	Main.showEmployeeAddStage();
    }
	
}
