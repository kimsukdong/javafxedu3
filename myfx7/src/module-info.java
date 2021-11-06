module myfx7 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
	requires javafx.graphics;
	
	opens phone to javafx.graphics, javafx.fxml,javafx.base;
	opens phone.controller to javafx.graphics, javafx.fxml,javafx.base;
}
