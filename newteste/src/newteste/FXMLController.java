/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newteste;

import java.math.RoundingMode;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author steyl
 */
public class FXMLController implements Initializable {
    
     private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    Double n6;
    Double total;
     int n1;
        int     n2;
        int     n3;
          int   n4;
          int   n5;
      @FXML
      private Button bcal;
    @FXML
    private TextField txtotal;
    @FXML
    private TextField txnar;
     @FXML
    private TextField txnfe;
      @FXML
    private TextField txnol;
     @FXML
    private TextField txnac;
      @FXML
    private TextField txnle;
       @FXML
    private TextField txcarg;
        @FXML
    private Label l1;
        @FXML
    private Label l2;
        @FXML
    private Label l3;
        @FXML
    private Label l4;
        @FXML
    private Label l5;
        @FXML
    private Label l6;
        @FXML
    private Label l7;
        @FXML
    private Label l8;
        @FXML
    private Label l9;
        @FXML
    private Label l10;
        @FXML
    private Label l11;
        @FXML
    private Label l12;
        @FXML
    private Label l13;
        @FXML
    private Label l14;
    
       
    public void calcular(ActionEvent event){
        
           try 
      {
         n1=Integer.parseInt(txnar.getText());
         
          n2=Integer.parseInt(txnfe.getText());
         
          n3=Integer.parseInt(txnol.getText());
        
          n4=Integer.parseInt(txnac.getText());
         
          n5=Integer.parseInt(txnle.getText());
        
          n6=Double.parseDouble(txcarg.getText());
          
          n6=27*n6/1000;
         
        total =(22*n1+15*n2+7*n3+16*n4+33*n5+n6);

         
         txtotal.setText(Double.toString(total));
      }
      catch (NumberFormatException ex)
      {
         txtotal.setText("erro"+ total);
         txtotal.selectAll();
         txtotal.requestFocus();
      }
            
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        currency.setRoundingMode(RoundingMode.HALF_UP); 
    }    
    
}
