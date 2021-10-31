package phone.controller;

import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import phone.Main;

public class AddNewEmployeeController {
	ObservableList<String> maritalStatusList = FXCollections.observableArrayList("Single", "Married", "Divorced");
	ObservableList<String> mainDepartmentList = FXCollections.observableArrayList("Electrical", "Mechanical");
	ObservableList<String> electricalList = FXCollections.observableArrayList("Design", "R&D");
	ObservableList<String> mechanicalList = FXCollections.observableArrayList("Sales", "Management");
	
	Parent root;
	Main main = new Main();
	
	@FXML
	private TextField nameField;
	@FXML
	private TextField addressField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField phoneField;
	@FXML
	private TextField emailField;
	
	@FXML
	private DatePicker dateofBirth;
	@FXML
	private TextField ageField;
	@FXML
	private ChoiceBox<String> maritalStatusBox;
	
	@FXML
	private RadioButton maleBtn;
	@FXML
	private RadioButton femaleBtn;
	
	@FXML
	private TextField idField;
	
	@FXML
	private ComboBox<String> mainDepartmentBox;
	
	@FXML
	private CheckBox yesBox;
	@FXML
	private CheckBox noBox;
	
	@FXML
	private ComboBox<String> departmentBox;
	
	
	@FXML
	private void initialize() {
		maritalStatusBox.setItems(maritalStatusList);
		maritalStatusBox.setValue("Single");
		
		mainDepartmentBox.setValue("Electrical");
		mainDepartmentBox.setItems(mainDepartmentList);
		
		departmentBox.setValue("Design");
		departmentBox.setItems(electricalList);
	}
	
    @FXML
    void showAge() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int birthYear = (dateofBirth.getValue().getYear());
		int age = year-birthYear;
		ageField.setText(Integer.toString(age) + " Years");		
	}
    
    @FXML
    private void mainDepartmentChoice() {
    	if(mainDepartmentBox.getValue().equals("Electrical")) {
    		departmentBox.setValue("Design");
    		departmentBox.setItems(electricalList);
    	}else {
    		departmentBox.setValue("Sales");
    		departmentBox.setItems(mechanicalList);
    	}
    }
    
    @FXML
    private void handleYesBox() {
    	if(yesBox.isSelected()) {
    		noBox.setSelected(false);
    	}
    }
    
    @FXML
    private void handleNoBox() {
    	if(noBox.isSelected()) {
    		yesBox.setSelected(false);
    	}
    }
	
}
