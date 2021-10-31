package phone.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import phone.Main;
import phone.Tables;
import phone.mysqlconnect;

public class TablesController {
	Connection conn = null;
	Parent root;
	Main main= new Main();

//	String newSelection,oldSelection,obs;
	Tables tables;
    @FXML
    private TextField tfTableName;
    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private TableView<Tables> tableView;
    ObservableList<Tables> tableList;

    @FXML
    private TableColumn<Tables, Integer> colId;

    @FXML
    private TableColumn<Tables, String> colName;

	@FXML
	private void initialize() {
		addListenerForTable();
		showTable();
	}
	
    @FXML
    void deleteTable(ActionEvent event) {
    	conn = mysqlconnect.ConnectDb();
    	Tables table = tableView.getSelectionModel().getSelectedItem();
    	String query = "DELETE FROM tblTable WHERE id = '"+table.getId()+"'";
    	execteQuery(query);
    	showTable();
    }
    @FXML
    void onClickBack(ActionEvent event) {
      	main.showMainView();
		try {
			root = FXMLLoader.load(getClass().getResource("/phone/view/ResDashBoard.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    @FXML
    void updateTable(ActionEvent event) {
    	conn = mysqlconnect.ConnectDb();
    	Tables table = tableView.getSelectionModel().getSelectedItem();
    	String query = "UPDATE tblTable SET name = '"+tfTableName.getText()+"' WHERE id = '"+table.getId()+"'";
    	execteQuery(query);
    	showTable();
    }
    
    private void addListenerForTable() {
    	tableView.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) -> {
    		if(newSelection != null) {
    			btnUpdate.setDisable(false);
    			btnDelete.setDisable(false);
    			tfTableName.setText(newSelection.getName());
    		}else {
    			tfTableName.setText("");
    			btnUpdate.setDisable(true);
    			btnDelete.setDisable(true);
    		}
    	});
    }
	
    @FXML
    void saveTable(ActionEvent event) {
    	insertRecord();
    }
    

    public void showTable() {
    	ObservableList<Tables> list = getTableList();
    	colId.setCellValueFactory(new PropertyValueFactory<Tables,Integer>("id"));
    	colName.setCellValueFactory(new PropertyValueFactory<Tables,String>("name"));

    	tableView.setItems(list);
    }
    
    private void insertRecord() {
    	String name = tfTableName.getText();
    	if(!name.isEmpty()) {
    		String query = "INSERT INTO tblTable (name) VALUES ('" + name +"')";
    		execteQuery(query);
    		
    		showTable();
    		tfTableName.setText("");
    		
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
	private ObservableList<Tables> getTableList() {
		tableList = FXCollections.observableArrayList();
		conn = mysqlconnect.ConnectDb();
		String query = "SELECT * FROM tblTable";
		Statement st;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				tables = new Tables(rs.getInt("id"), rs.getString("name"));
				tableList.add(tables);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tableList;
	}
}
