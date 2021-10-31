package phone.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;

import phone.Main;
import phone.mysqlconnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
public class CafeMenuController {
Main main= new Main();
	
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

	int total_coffee=0;
	int total_cake = 0;
	int total =0;
	int subtotal =0;
	int tax =0;
	int service =0;
	int l;
	
	 String s_total_coffee;
	 String s_total_cake;
	 String s_total;
	 String s_subtotal;
	 String s_tax;
	 String s_service;
	 
	 String currentdate;
	 String currentdate1;
	 int ir;
	 
	Vector<String> sel;
	
	@FXML	private CheckBox c1;
	@FXML	private CheckBox c2;
	@FXML	private CheckBox c3;
	@FXML	private CheckBox c4;
	@FXML	private CheckBox c5;
	@FXML	private CheckBox c6;
	@FXML	private CheckBox c7;
	@FXML	private TextField txt_c1;
	@FXML	private TextField txt_c2;
	@FXML	private TextField txt_c31;
	@FXML	private TextField txt_c32;
	@FXML	private TextField txt_c41;
	@FXML	private TextField txt_c42;
	@FXML	private TextField txt_c7;
	@FXML	private TextField txt_c62;
	@FXML	private TextField txt_c61;
	@FXML	private TextField txt_c52;
	@FXML	private TextField txt_c51;
	@FXML	private CheckBox k1;
	@FXML	private CheckBox k2;
	@FXML	private CheckBox k3;
	@FXML	private CheckBox k4;
	@FXML	private CheckBox k5;
	@FXML	private CheckBox k6;
	@FXML	private TextField txt_k1;
	@FXML	private TextField txt_k2;
	@FXML	private TextField txt_k3;
	@FXML	private TextField txt_k4;
	@FXML	private TextField txt_k6;
	@FXML	private TextField txt_k5;
	@FXML	private TextArea ta;
	@FXML	private TextField txt_t1;
	@FXML	private TextField txt_t2;
	@FXML	private TextField txt_t3;
	@FXML	private TextField txt_t4;
	@FXML	private TextField txt_t5;
	@FXML	private TextField txt_t6;

	public void initialize() {	
		conn = mysqlconnect.ConnectDb();
	}
	public void reset() {	
		txt_c1.setText("");
		txt_c2.setText("");
		txt_c31.setText("");
		txt_c41.setText("");
		txt_c51.setText("");
		txt_c61.setText("");
		txt_c32.setText("");
		txt_c42.setText("");
		txt_c52.setText("");
		txt_c62.setText("");
		txt_c7.setText("");
		txt_k1.setText("");
		txt_k2.setText("");
		txt_k3.setText("");
		txt_k4.setText("");
		txt_k5.setText("");
		txt_k6.setText("");

		txt_t1.setText("");
		txt_t2.setText("");
		txt_t3.setText("");
		txt_t4.setText("");
		txt_t5.setText("");
		txt_t6.setText("");
		
		ta.setText("");
		
		 total_coffee=0;
		 total_cake = 0;
		 total =0;
		 subtotal =0;
		 tax =0;
		 service = 1500;
		 l=0;
	}


	@FXML
	void onClickB1(ActionEvent event) {    	
		if(!(txt_c1.getText().equals("")))
			l++;
		else
			l=1;

		total_coffee += 3000;
		txt_c1.setText(String.valueOf(l));  
		txt_t1.setText(String.valueOf(total_coffee));    

	}

	@FXML
	void onClickB2(ActionEvent event) {
		if(!(txt_c2.getText().equals("")))
			l++;
		else
			l=1;

		total_coffee += 3000;
		txt_c2.setText(String.valueOf(l));  
		txt_t1.setText(String.valueOf(total_coffee));   
	}

	@FXML
	void onClickB31(ActionEvent event) {
		if(!(txt_c31.getText().equals("")))
			l++;
		else
			l=1;

		total_coffee += 3500;
		txt_c31.setText(String.valueOf(l));  
		txt_t1.setText(String.valueOf(total_coffee));   
	}

	@FXML
	void onClickB32(ActionEvent event) {
		if(!(txt_c32.getText().equals("")))
			l++;
		else
			l=1;

		total_coffee += 4000;
		txt_c32.setText(String.valueOf(l));  
		txt_t1.setText(String.valueOf(total_coffee));   
	}

	@FXML
	void onClickB41(ActionEvent event) {
		if(!(txt_c41.getText().equals("")))
			l++;
		else
			l=1;

		total_coffee += 4000;
		txt_c41.setText(String.valueOf(l));  
		txt_t1.setText(String.valueOf(total_coffee));   
	}

	@FXML
	void onClickB42(ActionEvent event) {
		if(!(txt_c42.getText().equals("")))
			l++;
		else
			l=1;

		total_coffee += 4500;
		txt_c42.setText(String.valueOf(l));  
		txt_t1.setText(String.valueOf(total_coffee));   
	}

	@FXML
	void onClickB51(ActionEvent event) {
		if(!(txt_c51.getText().equals("")))
			l++;
		else
			l=1;

		total_coffee += 4000;
		txt_c51.setText(String.valueOf(l));  
		txt_t1.setText(String.valueOf(total_coffee));   
	}

	@FXML
	void onClickB52(ActionEvent event) {
		if(!(txt_c52.getText().equals("")))
			l++;
		else
			l=1;

		total_coffee += 4500;
		txt_c52.setText(String.valueOf(l));  
		txt_t1.setText(String.valueOf(total_coffee));   
	}

	@FXML
	void onClickB61(ActionEvent event) {
		if(!(txt_c61.getText().equals("")))
			l++;
		else
			l=1;

		total_coffee += 4000;
		txt_c61.setText(String.valueOf(l));  
		txt_t1.setText(String.valueOf(total_coffee));   
	}

	@FXML
	void onClickB62(ActionEvent event) {
		if(!(txt_c62.getText().equals("")))
			l++;
		else
			l=1;

		total_coffee += 4500;
		txt_c62.setText(String.valueOf(l));  
		txt_t1.setText(String.valueOf(total_coffee));   
	}

	@FXML
	void onClickB7(ActionEvent event) {
		if(!(txt_c7.getText().equals("")))
			l++;
		else
			l=1;

		total_coffee += 5000;
		txt_c7.setText(String.valueOf(l));  
		txt_t1.setText(String.valueOf(total_coffee));   
	}

	@FXML
	void onClickK1(ActionEvent event) {
		if(!(txt_k1.getText().equals("")))
			l++;
		else
			l=1;

		total_cake += 4500;
		txt_k1.setText(String.valueOf(l));  
		txt_t2.setText(String.valueOf(total_cake));   
	}

	@FXML
	void onClickK2(ActionEvent event) {
		if(!(txt_k2.getText().equals("")))
			l++;
		else
			l=1;

		total_cake += 5500;
		txt_k2.setText(String.valueOf(l));  
		txt_t2.setText(String.valueOf(total_cake));  
	}

	@FXML
	void onClickK3(ActionEvent event) {
		if(!(txt_k3.getText().equals("")))
			l++;
		else
			l=1;

		total_cake += 5000;
		txt_k3.setText(String.valueOf(l));  
		txt_t2.setText(String.valueOf(total_cake));  
	}

	@FXML
	void onClickK4(ActionEvent event) {
		if(!(txt_k4.getText().equals("")))
			l++;
		else
			l=1;

		total_cake += 5000;
		txt_k4.setText(String.valueOf(l));  
		txt_t2.setText(String.valueOf(total_cake));  
	}

	@FXML
	void onClickK5(ActionEvent event) {
		if(!(txt_k5.getText().equals("")))
			l++;
		else
			l=1;

		total_cake += 7000;
		txt_k5.setText(String.valueOf(l));  
		txt_t2.setText(String.valueOf(total_cake));  
	}

	@FXML
	void onClickK6(ActionEvent event) {
		if(!(txt_k6.getText().equals("")))
			l++;
		else
			l=1;

		total_cake += 1000;
		txt_k6.setText(String.valueOf(l));  
		txt_t2.setText(String.valueOf(total_cake));  
	}
	
	@FXML
	void onClickReceipt(ActionEvent event) {

	  	ta.setText(ta.getText()+"\t\t\t\t\t\t 영수증 \n\n");
	  	Random r = new Random();
	  	ir = r.nextInt(10000);
	  	ta.setText(ta.getText()+"Reference #   " + "\t\t\t\t\t\t\t\t\t\t\t\t"+ ir + "\n");
		ta.setText(ta.getText()+"==========================================================\n");
	  	
		if(!(txt_c1.getText().equals("")))
	    	ta.setText(ta.getText()+"Today's coffee  : " + "\t\t\t"+ txt_c1.getText() + "\n");
		if(!(txt_c2.getText().equals("")))
	    	ta.setText(ta.getText()+"에스프레소  :        " + "\t\t\t"+ txt_c2.getText() + "\n");
		if(!(txt_c31.getText().equals("")))
	    	ta.setText(ta.getText()+"아메리카노 Hot  : " + "\t\t\t"+ txt_c31.getText() + "\n");
		if(!(txt_c32.getText().equals("")))
	    	ta.setText(ta.getText()+"아메리카노 Ice  :  " + "\t\t\t"+ txt_c32.getText() + "\n");
		if(!(txt_c41.getText().equals("")))
	    	ta.setText(ta.getText()+"카페라테 Hot  :   " + "\t\t\t"+ txt_c41.getText() + "\n");
		if(!(txt_c42.getText().equals("")))
	    	ta.setText(ta.getText()+"카페라테 Ice  :      " + "\t\t\t"+ txt_c42.getText() + "\n");
		if(!(txt_c51.getText().equals("")))
	    	ta.setText(ta.getText()+"카푸치노 Hot  :    " + "\t\t\t"+ txt_c51.getText() + "\n");
		if(!(txt_c52.getText().equals("")))
	    	ta.setText(ta.getText()+"카푸치노 Ice  :    " + "\t\t\t"+ txt_c52.getText() + "\n");
		if(!(txt_c61.getText().equals("")))
	    	ta.setText(ta.getText()+"카페모카 Hot  :    " + "\t\t\t"+ txt_c61.getText() + "\n");
		if(!(txt_c62.getText().equals("")))
	    	ta.setText(ta.getText()+"카페모카 Ice  :      " + "\t\t\t"+ txt_c62.getText() + "\n");
		if(!(txt_c7.getText().equals("")))
	    	ta.setText(ta.getText()+"아포카토  :          " + "\t\t\t"+ txt_c7.getText() + "\n");
		
		ta.setText(ta.getText()+"==========================================================\n");
		       
    	ta.setText(ta.getText()+" 커피음료 합계 = " + "\t\t\t"+ s_total_coffee + "\n\n");

		if(!(txt_k1.getText().equals("")))
	    	ta.setText(ta.getText()+"커피케익  :          " + "\t\t\t"+ txt_k1.getText() + "\n");
		if(!(txt_k2.getText().equals("")))
	    	ta.setText(ta.getText()+"크림 파이  :          " + "\t\t\t"+ txt_k2.getText() + "\n");
		if(!(txt_k3.getText().equals("")))
	    	ta.setText(ta.getText()+"초코렛케익  :       " + "\t\t\t"+ txt_k3.getText() + "\n");
		if(!(txt_k4.getText().equals("")))
	    	ta.setText(ta.getText()+"치즈케익  :          " + "\t\t\t"+ txt_k4.getText() + "\n");
		if(!(txt_k5.getText().equals("")))
	    	ta.setText(ta.getText()+"크로폴  :          " + "\t\t\t"+ txt_k5.getText() + "\n");
		if(!(txt_k6.getText().equals("")))
	    	ta.setText(ta.getText()+"마카롱  :          " + "\t\t\t"+ txt_k6.getText() + "\n");
		
		ta.setText(ta.getText()+"==========================================================\n");
    	ta.setText(ta.getText()+" 케익 합계 = " + "\t\t\t"+ s_total_cake + "\n\n");
		
    	ta.setText(ta.getText()+"==========================================================\n\n");
    	
    	ta.setText(ta.getText()+"봉사료 = " + "\t\t"+ s_service + "\n");
    	ta.setText(ta.getText()+"세금 = " + "\t\t\t"+ s_tax + "\n");
    	ta.setText(ta.getText()+"중간합계 = " + "\t\t"+ s_subtotal + "\n");
    	ta.setText(ta.getText()+"Total = " + "\t\t\t"+ s_total + "\n\n");
    	
		ta.setText(ta.getText()+"==========================================================\n");
    	
    	DateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
    	currentdate = format.format(Calendar.getInstance().getTime());
    	DateFormat format1 = new SimpleDateFormat("hh시 mm분 ss초");
    	currentdate1 = format1.format(Calendar.getInstance().getTime());
    	
    	ta.setText(ta.getText()+"Date : " + "\t"+ currentdate + "\t\t Time : " + currentdate1+ "\n\n");
   
    	ta.setText(ta.getText()+"**************** Thank you Come Again******************\n");
    	
		push_db();

	}

	@FXML
	void onClickReset(ActionEvent event) {
		reset();
	}

	@FXML
	void onClickTotal(ActionEvent event) {
		int sum = total_coffee + total_cake;
		if(sum >50000)
			service = 2000;
		else
			service = 1000;
		subtotal = sum+service;
		tax = (int)(0.1*sum);
		total = subtotal+tax;

	
        NumberFormat numberFormatter = NumberFormat.getNumberInstance();
        s_total_coffee = numberFormatter.format(total_coffee);
        s_total_cake = numberFormatter.format(total_cake);
        s_subtotal = numberFormatter.format(subtotal);
        s_service = numberFormatter.format(service);
        s_tax = numberFormatter.format(tax);
        s_total = numberFormatter.format(total);

		txt_t1.setText(String.valueOf(s_total_coffee));
		txt_t2.setText(String.valueOf(s_total_cake));
		txt_t3.setText(String.valueOf(s_service));
		txt_t4.setText(String.valueOf(s_tax));
		txt_t5.setText(String.valueOf(s_subtotal));
		txt_t6.setText(String.valueOf(s_total));
		

	}
	
	public void push_db() {
		String date;
		int reference, todays,espresso,americano_hot,americano_ice,latte_hot,latte_ice,cafu_hot,cufu_ice,mocha_hot,mocha_ice,apocato;
		int coffe_cake,cream_phi,cholet_cake,cheese_cake,kropol,makarong;
		int total_coffee_d,total_cake_d,service_d,tax_d,subtotal_d,total_d;
		
		date = currentdate;
		reference=ir;
		
		if(!(txt_c1.getText().equals(""))) 
			todays=Integer.parseInt(txt_c1.getText());
		else
			todays = 0;
		
		if(!(txt_c2.getText().equals("")))
			espresso = Integer.parseInt(txt_c2.getText());
		else 
			espresso=0;

		if(!(txt_c31.getText().equals("")))
			americano_hot = Integer.parseInt(txt_c31.getText());
		else 
			americano_hot=0;
		
		if(!(txt_c32.getText().equals("")))
			americano_ice = Integer.parseInt(txt_c32.getText());
		else 
			americano_ice=0;
		
		if(!(txt_c41.getText().equals("")))
			latte_hot = Integer.parseInt(txt_c41.getText());
		else 
			latte_hot=0;
		
		if(!(txt_c42.getText().equals("")))
			latte_ice = Integer.parseInt(txt_c42.getText());
		else 
			latte_ice=0;
		
		if(!(txt_c51.getText().equals("")))
			cafu_hot = Integer.parseInt(txt_c51.getText());
		else 
			cafu_hot=0;
		
		if(!(txt_c52.getText().equals("")))
			cufu_ice = Integer.parseInt(txt_c52.getText());
		else 
			cufu_ice=0;
		
		if(!(txt_c61.getText().equals("")))
			mocha_hot = Integer.parseInt(txt_c61.getText());
		else 
			mocha_hot=0;
		
		if(!(txt_c62.getText().equals("")))
			mocha_ice = Integer.parseInt(txt_c62.getText());
		else 
			mocha_ice=0;
		
		if(!(txt_c7.getText().equals("")))
			apocato = Integer.parseInt(txt_c7.getText());
		else 
			apocato=0;
		
		if(!(txt_k1.getText().equals("")))
			coffe_cake = Integer.parseInt(txt_k1.getText());
		else 
			coffe_cake=0;
		if(!(txt_k2.getText().equals("")))
			cream_phi = Integer.parseInt(txt_k2.getText());
		else 
			cream_phi=0;
		if(!(txt_k3.getText().equals("")))
			cholet_cake = Integer.parseInt(txt_k3.getText());
		else 
			cholet_cake=0;
		if(!(txt_k4.getText().equals("")))
			cheese_cake = Integer.parseInt(txt_k4.getText());
		else 
			cheese_cake=0;
		if(!(txt_k5.getText().equals("")))
			kropol = Integer.parseInt(txt_k5.getText());
		else 
			kropol=0;
		if(!(txt_k6.getText().equals("")))
			makarong = Integer.parseInt(txt_k6.getText());
		else 
			makarong=0;
		
		total_coffee_d = total_coffee;
		total_cake_d = total_cake;
		service_d = service;
		tax_d = tax;
		subtotal_d = subtotal;
		total_d = total;
		
    	String sql = "insert into cafe (date,reference,todays,espresso,americano_hot,americano_ice,latte_hot,latte_ice,"
    			+ "cafu_hot,cufu_ice,mocha_hot,mocha_ice,apocato,coffe_cake,cream_phi,cholet_cake,cheese_cake,"
    			+ "kropol,makarong,total_coffee,total_cake,service,tax,subtotal,total)"
    			+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try {
			pst = conn.prepareStatement(sql);
			
	//		pst.setString(1, "2020년 12월 06일");
			pst.setString(1, currentdate);
			pst.setInt(2, ir);
			pst.setInt(3, todays);
			pst.setInt(4, espresso);
			pst.setInt(5, americano_hot);
			pst.setInt(6, americano_ice);
			pst.setInt(7, latte_hot);
			pst.setInt(8, latte_ice);
			pst.setInt(9, cafu_hot);
			pst.setInt(10, cufu_ice);
			pst.setInt(11, mocha_hot);
			pst.setInt(12, mocha_ice);
			pst.setInt(13, apocato);
			pst.setInt(14, coffe_cake);
			pst.setInt(15, cream_phi);
			pst.setInt(16, cholet_cake);
			pst.setInt(17, cheese_cake);
			pst.setInt(18, kropol);
			pst.setInt(19, makarong);
			pst.setInt(20, total_coffee_d);
			pst.setInt(21, total_cake_d);
			pst.setInt(22, service_d);
			pst.setInt(23, tax_d);
			pst.setInt(24, subtotal_d);
			pst.setInt(25, total_d);

			
			pst.execute();
			
			JOptionPane.showMessageDialog(null,"Saved");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	void onClickExit(ActionEvent event) {
   //   	Main.stopstageView();
      	main.showMainView();
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/phone/view/CafeMain.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
