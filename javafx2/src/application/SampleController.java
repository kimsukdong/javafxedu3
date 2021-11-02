package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SampleController {

    @FXML
    private TextField txt_result;
    String op ="";
    long number1;
    long number2;
    // First Method
    public void Number (ActionEvent ae){
        String no = ((Button)ae.getSource()).getText();
        txt_result.setText(txt_result.getText()+no);
    }
    
    // Second Method
    public void Operation (ActionEvent ae){
    
        String operation = ((Button)ae.getSource()).getText();
        if (!operation.equals("=")){      
            if(!op.equals("")){
                return;
            }
            op = operation;
            number1 = Long.parseLong(txt_result.getText());
            txt_result.setText("");
        }else {       
            if(op.equals("")){
                return;
            }
            number2 = Long.parseLong(txt_result.getText());
            calculate(number1, number2, op);
           
        }
    }  

    public void calculate (long n1, long n2, String op){
    	long n3;
    	String str;
        switch (op){
        
            case "+" : 
            	n3 = n1+n2;
            	str = String.format("%,d", n3);
            	txt_result.setText(str);
            	break;
            case "-" :
            	n3 = n1-n2;
            	str = String.format("%,d", n3);
            	txt_result.setText(str);
            	break;
            case "*" : 
            	n3 = n1*n2;
            	str = String.format("%,d", n3);
            	txt_result.setText(str);
            	break;
            case "/" : 
                if (n2 == 0){
                txt_result.setText("ERROR!!!");
                break;
                }
            	double n4 = (double)n1/n2;
            	str = String.format("%,f", n4);
            	txt_result.setText(str);
                break;    
        }
    }
    
    public void clear(ActionEvent ae) {
    	 txt_result.setText("");
    	 op="";
    	 number1=0;
    	 number2=0;
    }
    
}
