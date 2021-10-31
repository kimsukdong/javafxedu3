package phone.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import phone.Main;
import phone.mysqlconnect;
import phone.users;

public class BusUpdateController {
	Connection conn;
	PreparedStatement pst = null;
	ResultSet srs;
	int seatno = 0,index1=0,index;
	String date;
	HashSet<Integer> set;

	Main main = new Main();

	@FXML
	private TableView<users> tableContent;

	@FXML
	private DatePicker txtdate;
	@FXML
	private TableColumn<users, String> col_name;

	@FXML
	private TableColumn<users, Integer> col_seat;

	@FXML
	private TableColumn<users, Integer> col_price;

	@FXML
	private TableColumn<users, String> col_date;	

	@FXML
	private TextField txt_name;

	@FXML
	private TextField txt_seat;

	@FXML
	private TextField txt_price;

	@FXML
	private TextField txt_date;

	@FXML
	private void initialize() {
		Date date = new Date();
		Instant instant = date.toInstant();
		LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
		txtdate.setValue(localDate);
	}

	@FXML
	void onClickBack(ActionEvent event) throws IOException {
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/phone/view/BusMain.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void tablelookup() {
		ObservableList<users> list = FXCollections.observableArrayList();
		conn = mysqlconnect.ConnectDb();
		set = new HashSet<Integer>();
		try {
			pst = conn.prepareStatement("select * from bus where date =?");
			pst.setString(1, date);	
			srs = pst.executeQuery();
			if(!srs.next()) {
				tableContent.setItems(list);
				JOptionPane.showMessageDialog(null, "No Seat Booked!");				
			} else 			
				do {
					int r0 = srs.getInt("id");
					String r1 = srs.getString("name");
					int r2 = srs.getInt("seatno");
					int r3 = srs.getInt("price");
					String r4 = srs.getString("date");

					list.add(new users(r0,r1, r2,r3,r4));

					col_name.setCellValueFactory(new PropertyValueFactory<users,String>("name"));
					col_seat.setCellValueFactory(new PropertyValueFactory<users,Integer>("seatno"));
					col_price.setCellValueFactory(new PropertyValueFactory<users,Integer>("price"));
					col_date.setCellValueFactory(new PropertyValueFactory<users,String>("date"));

					tableContent.setItems(list);
					set.add(r2);

				}	while(srs.next());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void onClickSearch(ActionEvent event) {
		if(txtdate.getValue() == null) {
			JOptionPane.showMessageDialog(null, "Please, select the date !");
			return;
		}
		int year = (txtdate.getValue().getYear());
		int month = (txtdate.getValue().getMonthValue());
		int day = (txtdate.getValue().getDayOfMonth());
		date = ""+year+"-"+month+"-"+day;
		tablelookup();

	}
	@FXML
	void onClickDelete(ActionEvent event) {
		if(index1==0) {
			JOptionPane.showMessageDialog(null, "No Data");
			return ;
		}
		int dialogresult = JOptionPane.showConfirmDialog(null, "Do you want to delete this reservation?");
		if(dialogresult == JOptionPane.YES_NO_OPTION)
		{
			try {
				pst = conn.prepareStatement("delete from bus where id = ?");
				pst.setInt(1, index1);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Reservation Canceled!");
				tablelookup();						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cleartext();
	}
	public void cleartext() {
		txt_seat.setText("");
		txt_name.setText("");
		txt_price.setText("");
		txt_date.setText("");
	}

	@FXML
	void onClickUpdate(ActionEvent event) {
		String r1 = txt_name.getText();
		String r2 = txt_seat.getText();
		String r3 = txt_price.getText();
		String r4 = txt_date.getText();
		if(index1==0) {
			JOptionPane.showMessageDialog(null, "No Record !!!");
			return ;
		}

		try {
			pst = conn.prepareStatement("update bus set name= ?, seatno=?, price=?, date=? where id = ?");
			pst.setString(1, r1);
			if(r2.isEmpty()) return;
			int i1 = Integer.parseInt(r2);
			pst.setInt(2, i1);
			int i2 = Integer.parseInt(r3);
			pst.setInt(3, i2);
			pst.setString(4, r4);
			pst.setInt(5, index1);

			if((i1<1) ||(i1>12))
				JOptionPane.showMessageDialog(null, "Try to another Seat Number");
			else if(index == i1) {
				JOptionPane.showMessageDialog(null, "Success update!");
				pst.executeUpdate();	
			} else if(set.add(i1)) {
				JOptionPane.showMessageDialog(null, "Success update!");
				pst.executeUpdate();
			} else
			{
				JOptionPane.showMessageDialog(null, "Try to another Seat Number");
			}

			cleartext();
			tablelookup();	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void onMouseClicked(MouseEvent event) {
		TableViewSelectionModel<users> model = tableContent.getSelectionModel();
		users s = (users)model.getSelectedItem();
		
		if(s == null) return;
		txt_name.setText(s.getName());
		String bs = Integer.toString(s.getSeatno());
		if(bs.isEmpty()) return;
		txt_seat.setText(bs);
		bs= Integer.toString(s.getPrice());
		txt_price.setText(bs);
		txt_date.setText(s.getDate());

		index1 = s.getId();
		index = s.getSeatno();
	}
}