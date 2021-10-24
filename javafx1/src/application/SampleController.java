package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SampleController {

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    void onClickB1(ActionEvent event) {
		int t=Integer.parseInt(tf1.getText());
		double k=t*1.609344;
		int j = (int)(k*100.0);
		k=j/100.0;
		tf2.setText(t+" 마일은 "+k+" 킬로미터입니다.");
    }

    @FXML
    void onClickB2(ActionEvent event) {
		int t=Integer.parseInt(tf1.getText());
		double k=t/1.609344;
		int j = (int)(k*100.0);
		k=j/100.0;
		tf2.setText(t+" 킬로미터는 "+k+" 마일입니다.");
    }

    @FXML
    void onClickStop(ActionEvent event) {
    	System.exit(0);
    }

}
