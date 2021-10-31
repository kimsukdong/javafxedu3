package phone.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import phone.Main;

public class AddressMainController {
	AnchorPane root;
	   @FXML
	    void onAddressOne(MouseEvent event) {
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/MainView2.fxml"));
				Main.mainLayout.setCenter(root);
			} catch(Exception e) {
				e.printStackTrace();
			}
	    }

	    @FXML
	    void onAddressTwo(MouseEvent event) {
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/MainView3.fxml"));
				Main.mainLayout.setCenter(root);
			} catch(Exception e) {
				e.printStackTrace();
			}
	    }
}