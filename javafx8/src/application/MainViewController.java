package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class MainViewController {
	@FXML
	AnchorPane root;
	Scene scene;
	Main main = new Main();
    @FXML
    void onClickAdd(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("Add.fxml"));
			scene = new Scene(root,600,400);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
			Main.primaryStage.setTitle("Adding . . ");
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void onClickDelete(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
			scene = new Scene(root,600,400);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
			Main.primaryStage.setTitle("Delete . . ");
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void onClickSearch(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("Search.fxml"));
			scene = new Scene(root,600,400);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
			Main.primaryStage.setTitle("Searching . . ");
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void onClickUpdate(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("Update.fxml"));
			scene = new Scene(root,600,400);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
			Main.primaryStage.setTitle("Update . . ");
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void onClickTotal(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Total.fxml"));
		scene = new Scene(root,800,600);
		Main.primaryStage.setScene(scene);
		Main.primaryStage.show();
		Main.primaryStage.setTitle("Manage");
    }

    @FXML
    void onClickBack(ActionEvent event) {
    	main.showMainView();
    }

}

