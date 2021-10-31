package phone.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.StringTokenizer;

import phone.Main;
import phone.mysqlconnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CafeViewController {
Main main= new Main();
	
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	int todays,espresso,americano_hot,americano_ice,latte_hot,latte_ice,cafu_hot,cufu_ice,mocha_hot,mocha_ice,apocato;
	int coffe_cake, cream_phi ,cholet_cake,cheese_cake,kropol,makarong;
	int total_coffee=0;
	int total_cake = 0;
	int total =0;

	String currentdate, currentdate1;
	XYChart.Series<String,Integer> s1;
	
    @FXML
    private DatePicker txtDate_start;

    @FXML
    private DatePicker txtDate_end;
    @FXML
    private TextField txt_coffee_total;

    @FXML
    private TextField txt_cake_total;

    @FXML
    private TextField txt_all_total;

	@FXML
	private CategoryAxis xAxis;
	private ObservableList<String> names = FXCollections.observableArrayList();
    @FXML
    private DatePicker txtDate;
    @FXML
    private Label lbl_date;
    @FXML
    private Label lbl_total;
	@FXML
	private BarChart<String, Integer> bar;
	public void initialize() {	
		conn = mysqlconnect.ConnectDb();
		DateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 : kk시 mm분 ss초");
		currentdate1 = format.format(Calendar.getInstance().getTime());
		lbl_date.setText(currentdate1);

		String[] name = {"todays coffee","espresso","americano_hot","americano_ice","latte_hot","latte_ice"
				,"cafu_hot","cufu_ice","mocha_hot","mocha_ice","apocato",
				"coffe_cake", "cream_phi" ,"cholet_cake","cheese_cake","kropol","makarong"};
		String[] name1 = {"오늘의 커피e","에스프레소","아메리카노(HOT)","아메리카노(ICE)","라테(HOT)","라테(ICE)"
				,"카푸치노(HOT)","카푸치노(ICE)","모카(HOT)","모카(ICE)","아포카토",
				"커피케익", "크림파이" ,"초콜랫케익","치즈케익","크로폴","마카롱"};
		
		names.addAll(Arrays.asList(name));
		xAxis.setCategories(names);

	}
	
    @FXML
    void onClickDisplay(ActionEvent event) throws SQLException {
    	int year1 = (txtDate_start.getValue().getYear());
    	int month1 = (txtDate_start.getValue().getMonthValue());
    	int day1 = (txtDate_start.getValue().getDayOfMonth());
    
    	
    	String s_y1,s_m1,s_d1,start_date;  	
    	if(day1<10) 
    		s_d1 = "0"+day1;
    	else
    		s_d1 = String.valueOf(day1);
    	
    	if(month1<10) 
    		s_m1 = "0"+month1;
    	else
    		s_m1 = String.valueOf(month1);   	
    	
    	s_y1 = String.valueOf(year1);
    	
    	start_date = s_y1+s_m1+s_d1;
    	

    	int year2 = (txtDate_end.getValue().getYear());
    	int month2 = (txtDate_end.getValue().getMonthValue());
    	int day2 = (txtDate_end.getValue().getDayOfMonth());
    	
    	String s_y2,s_m2,s_d2,end_date;  	
    	if(day2<10) 
    		s_d2 = "0"+day2;
    	else
    		s_d2 = String.valueOf(day2);
    	
    	if(month2<10) 
    		s_m2 = "0"+month2;
    	else
    		s_m2 = String.valueOf(month2);   	
    	
    	s_y2 = String.valueOf(year2);
    	
    	end_date = s_y2+s_m2+s_d2;
    	
		String sql = "select * from cafe";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while(rs.next()) {	
			String date_s = rs.getString("date");
			int k=0;
			String ss[] = new String[3];
			
			StringTokenizer str = new StringTokenizer(date_s);
			while(str.hasMoreTokens()) {
				String s1 = str.nextToken();
				int i = s1.length();
				String s2 = s1.substring(0, i-1);
				ss[k++]= s2;
				
			}
					
			String current_date = ss[0]+ss[1]+ss[2];
			
			int currentDate = Integer.parseInt(current_date);
			int startDate = Integer.parseInt(start_date);
			int endDate = Integer.parseInt(end_date);
			
			if((currentDate >= startDate) && (currentDate <=endDate)) {
				int r1 = rs.getInt("todays");
				int r2 = rs.getInt("espresso");
				int r3 = rs.getInt("americano_hot");
				int r4 = rs.getInt("americano_ice");
				int r5 = rs.getInt("latte_hot");
				int r6 = rs.getInt("latte_ice");
				int r7 = rs.getInt("cafu_hot");
				int r8 = rs.getInt("cufu_ice");
				int r9 = rs.getInt("mocha_hot");
				int r10 = rs.getInt("mocha_ice");
				int r11 = rs.getInt("apocato");
				int r12 = rs.getInt("coffe_cake");
				int r13 = rs.getInt("cream_phi");
				int r14 = rs.getInt("cholet_cake");
				int r15 = rs.getInt("cheese_cake");
				int r16 = rs.getInt("kropol");
				int r17 = rs.getInt("makarong");
				
				int t_coffee = rs.getInt("total_coffee");
				int t_cake = rs.getInt("total_cake");
				int t_total = rs.getInt("total");			

				todays +=r1;
				espresso +=r2;
				americano_hot +=r3;
				americano_ice +=r4;
				latte_hot +=r5;
				latte_ice +=r6;
				cafu_hot +=r7;
				cufu_ice +=r8;
				mocha_hot +=r9;
				mocha_ice +=r10;
				apocato +=r11;
				coffe_cake +=r12;
				cream_phi +=r13;
				cholet_cake +=r14;
				cheese_cake +=r15;
				kropol +=r16;
				makarong +=r17;			
				
				total_coffee += t_coffee;
				total_cake += t_cake;
				total += t_total;
				
			}			
		}
		String s_d = txtDate_start.getValue().toString();
		String s_e = txtDate_end.getValue().toString();
		display_barchart(s_d+" ~ " + s_e);
		display_total(s_d+" ~ " + s_e);
    }
	
    @FXML
    void onClickDate(ActionEvent event) throws SQLException {
    	int year = (txtDate.getValue().getYear());
    	int month = (txtDate.getValue().getMonthValue());
    	int day = (txtDate.getValue().getDayOfMonth());
    	
    	String s_y,s_m,s_d;
    	
    	if(day<10) 
    		s_d = "0"+day;
    	else
    		s_d = String.valueOf(day);
    	
    	if(month<10) 
    		s_m = "0"+month;
    	else
    		s_m = String.valueOf(month);   	
    	
    	s_y = String.valueOf(year);
    	
    	currentdate = s_y+"년 "+s_m+"월 "+s_d+"일";    	

		String sql = "select * from cafe where date =?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, currentdate);
		rs = pst.executeQuery();

		while(rs.next()) {		
			int r1 = rs.getInt("todays");
			int r2 = rs.getInt("espresso");
			int r3 = rs.getInt("americano_hot");
			int r4 = rs.getInt("americano_ice");
			int r5 = rs.getInt("latte_hot");
			int r6 = rs.getInt("latte_ice");
			int r7 = rs.getInt("cafu_hot");
			int r8 = rs.getInt("cufu_ice");
			int r9 = rs.getInt("mocha_hot");
			int r10 = rs.getInt("mocha_ice");
			int r11 = rs.getInt("apocato");
			int r12 = rs.getInt("coffe_cake");
			int r13 = rs.getInt("cream_phi");
			int r14 = rs.getInt("cholet_cake");
			int r15 = rs.getInt("cheese_cake");
			int r16 = rs.getInt("kropol");
			int r17 = rs.getInt("makarong");
			
			int t_coffee = rs.getInt("total_coffee");
			int t_cake = rs.getInt("total_cake");
			int t_total = rs.getInt("total");			


			todays +=r1;
			espresso +=r2;
			americano_hot +=r3;
			americano_ice +=r4;
			latte_hot +=r5;
			latte_ice +=r6;
			cafu_hot +=r7;
			cufu_ice +=r8;
			mocha_hot +=r9;
			mocha_ice +=r10;
			apocato +=r11;
			coffe_cake +=r12;
			cream_phi +=r13;
			cholet_cake +=r14;
			cheese_cake +=r15;
			kropol +=r16;
			makarong +=r17;
			
			total_coffee += t_coffee;
			total_cake += t_cake;
			total += t_total;
			
		}

		display_barchart(txtDate.getValue().toString());
		
		display_total(txtDate.getValue().toString());
		
		
	}
    
    public void display_total(String dis) {
        NumberFormat numberFormatter = NumberFormat.getNumberInstance();
    
    	txt_coffee_total.setText(numberFormatter.format(total_coffee) +"원");
    	txt_cake_total.setText(numberFormatter.format(total_cake)+"원");
    	txt_all_total.setText(numberFormatter.format(total)+"원");
    	
    	lbl_total.setText(dis);
    }

    public void display_barchart(String title_str) {
    	s1 = new XYChart.Series<String,Integer>();
		s1.setName(title_str);           

		s1.getData().add(new XYChart.Data<String, Integer>("todays coffee", todays));    
		s1.getData().add(new XYChart.Data<String, Integer>("espresso", espresso));
		s1.getData().add(new XYChart.Data<String, Integer>("americano_hot", americano_hot));
		s1.getData().add(new XYChart.Data<String, Integer>("americano_ice", americano_ice));
		s1.getData().add(new XYChart.Data<String, Integer>("latte_hot", latte_hot));
		s1.getData().add(new XYChart.Data<String, Integer>("latte_ice", latte_ice));
		s1.getData().add(new XYChart.Data<String, Integer>("cafu_hot", cafu_hot));    
		s1.getData().add(new XYChart.Data<String, Integer>("cufu_ice", cufu_ice));
		s1.getData().add(new XYChart.Data<String, Integer>("mocha_hot", mocha_hot));
		s1.getData().add(new XYChart.Data<String, Integer>("mocha_ice", mocha_ice));
		s1.getData().add(new XYChart.Data<String, Integer>("apocato", apocato));
		s1.getData().add(new XYChart.Data<String, Integer>("coffe_cake", coffe_cake));
		s1.getData().add(new XYChart.Data<String, Integer>("cream_phi", cream_phi));    
		s1.getData().add(new XYChart.Data<String, Integer>("cholet_cake", cholet_cake));
		s1.getData().add(new XYChart.Data<String, Integer>("cheese_cake", cheese_cake));
		s1.getData().add(new XYChart.Data<String, Integer>("kropol", kropol));
		s1.getData().add(new XYChart.Data<String, Integer>("makarong", makarong));
			
		bar.getData().add(s1); // 차트에 시리즈 추가
    }
	@FXML
	void onClickClear(ActionEvent event) {
      	main.showMainView();
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("/phone/view/CafeMain.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
