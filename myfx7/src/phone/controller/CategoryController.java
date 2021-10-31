package phone.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import phone.Category;
import phone.mysqlconnect;

public class CategoryController {
	
	Connection conn = null;
	Category category;

    @FXML
    private TextField tfCategoryName;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private TableView<Category> tableCategory;
    ObservableList<Category> categoryList;

    @FXML
    private TableColumn<Category, Integer> colId;

    @FXML
    private TableColumn<Category, String> colName;

	@FXML
	private void initialize() {
		addListenerForTable();
		showCategories();
	}
	
    public void showCategories() {
    	ObservableList<Category> list = getCategoryList();
    	colId.setCellValueFactory(new PropertyValueFactory<Category,Integer>("id"));
    	colName.setCellValueFactory(new PropertyValueFactory<Category,String>("name"));

    	tableCategory.setItems(list);
    }
    
	private ObservableList<Category> getCategoryList() {
		categoryList = FXCollections.observableArrayList();
		conn = mysqlconnect.ConnectDb();
		String query = "SELECT * FROM categories";
		Statement st;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				category = new Category(rs.getInt("id"), rs.getString("name"));
				categoryList.add(category);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return categoryList;
	}
	
    private void addListenerForTable() {
    	tableCategory.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) -> {
    		if(newSelection != null) {
    			btnUpdate.setDisable(false);
    			btnDelete.setDisable(false);
    			tfCategoryName.setText(newSelection.getName());
    		}else {
    			tfCategoryName.setText("");
    			btnUpdate.setDisable(true);
    			btnDelete.setDisable(true);
    		}
    	});
    }
    
    private void insertRecord() {
    	String name = tfCategoryName.getText();
    	if(!name.isEmpty()) {
    		String query = "INSERT INTO categories (name) VALUES ('" + name +"')";
    		execteQuery(query);
    		
    		showCategories();
    		tfCategoryName.setText("");
    		
    	}
    }
    
	private void execteQuery(String query) {
		conn = mysqlconnect.ConnectDb();
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
    
    @FXML
    void deleteEntry(ActionEvent event) {
    	conn = mysqlconnect.ConnectDb();
    	Category category = tableCategory.getSelectionModel().getSelectedItem();
    	String query = "DELETE FROM categories WHERE id = '"+category.getId()+"'";
    	execteQuery(query);
    	showCategories();
    }

    @FXML
    void saveCategory(ActionEvent event) {
    	insertRecord();
    }

    @FXML
    void updateEntry(ActionEvent event) {
    	conn = mysqlconnect.ConnectDb();
    	Category category = tableCategory.getSelectionModel().getSelectedItem();
    	String query = "UPDATE categories SET name = '"+tfCategoryName.getText()+"' WHERE id = '"+category.getId()+"'";
    	execteQuery(query);
    	showCategories();
    }

}
