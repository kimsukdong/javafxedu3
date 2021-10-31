package phone.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import phone.Main;

public class EmployeeMechanicalController {
	Parent root;
	@FXML Main main;
    @FXML
    void onClickBack(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("/phone/view/EmployeeMain.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}
