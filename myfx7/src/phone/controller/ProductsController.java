package phone.controller;

import java.io.IOException;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import phone.Main;
import phone.Products;
import phone.mysqlconnect;

public class ProductsController {
	Connection conn = null;
	Products products;
	
	Scene fxmlFile;
	Parent root;
	Stage window;
	Main main= new Main();

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private TableView<Products> tableProducts;
    
    ObservableList<Products> productList;

    @FXML
    private TableColumn<Products, Integer> colId;


    @FXML
    private TableColumn<Products, String> colDescription;

    @FXML
    private TableColumn<Products, String> colPrice;

    @FXML
    private TableColumn<Products, String> colCategory;

    @FXML
    private TableColumn<Products, String> colStatus;

    @FXML
    private ImageView ivProducts;

    @FXML
    private TextField evId;

    @FXML
    private TextField evDescription;

    @FXML
    private TextField evPrice;

    @FXML
    private ComboBox<?> cbCategory;

    @FXML
    private ComboBox<?> cbWeight;

    @FXML
    private ComboBox<?> cbStatus;
	@FXML
	private void initialize() {
		addListenerForTable();
		showProducts();
	}

    @FXML
    void deleteTable(ActionEvent event) {

    }

    @FXML
    void addCategory(ActionEvent event) {
    	try {
			openModalWindow("/phone/view/Category.fxml", "Manage Category");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void saveTable(ActionEvent event) {

    }
    @FXML
    void onClickBack(ActionEvent event) {
      	main.showMainView();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/phone/view/ResDashBoard.fxml"));
			Main.mainLayout.setCenter(root);
			Main.setPrimaryStage("주문 화면");			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void updateTable(ActionEvent event) {

    }
    
    private void addListenerForTable() {
    	tableProducts.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) -> {
    		if(newSelection != null) {
    			btnUpdate.setDisable(false);
    			btnDelete.setDisable(false);
 //   			tfTableName.setText(newSelection.getName());
    		}else {
 //   			tfTableName.setText("");
    			btnUpdate.setDisable(true);
    			btnDelete.setDisable(true);
    		}
    	});
    }
    
    public void showProducts() {
    	ObservableList<Products> list = getProductsList();
    	colId.setCellValueFactory(new PropertyValueFactory<Products,Integer>("id"));
    	colDescription.setCellValueFactory(new PropertyValueFactory<Products,String>("description"));
    	colPrice.setCellValueFactory(new PropertyValueFactory<Products,String>("price"));
    	colStatus.setCellValueFactory(new PropertyValueFactory<Products,String>("status"));
    	colCategory.setCellValueFactory(new PropertyValueFactory<Products,String>("category"));
    	
    	tableProducts.setItems(list);
    }
    
    private void insertRecord() {

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
	private ObservableList<Products> getProductsList() {
		productList = FXCollections.observableArrayList();
		conn = mysqlconnect.ConnectDb();
		String query = "SELECT * FROM products";
		Statement st;
		ResultSet rs;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				products = new Products(rs.getInt("id"), rs.getString("description"), rs.getString("price"), rs.getString("status"), rs.getString("category"), rs.getBlob("image"));
				productList.add(products);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return productList;
	}
	
    @FXML
    void saveProducts(ActionEvent event) {

    }
    
	private void openModalWindow(String resource, String title) throws IOException {
		root = FXMLLoader.load(getClass().getResource(resource));
		fxmlFile = new Scene(root);
		window = new Stage();
		window.setScene(fxmlFile);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setAlwaysOnTop(true);
		window.setIconified(false);
		window.setTitle(title);
		window.showAndWait();
	}

}
