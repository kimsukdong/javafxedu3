package phone.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import phone.Main;

public class DashBoardController {

	@FXML
	private Label lbl_username;

	Scene fxmlFile;
	Parent root;
	Stage window;
	Main main = new Main();

	public void userName(String userName) {
		lbl_username.setText(userName);
	}

	@FXML
	void manageProducts(ActionEvent event) {
		main.showMainView();
		try {
			root = FXMLLoader.load(getClass().getResource("/phone/view/Products.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    @FXML
    void onClickBack(ActionEvent event) {
    //  	main.showMainView();
		try {
			root = FXMLLoader.load(getClass().getResource("/phone/view/RestaurantMain.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	@FXML
	void manageTable(ActionEvent event) {
		main.showMainView();
		try {
			root = FXMLLoader.load(getClass().getResource("/phone/view/Tables.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
