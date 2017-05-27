/*  Author: Benjamin Pipes
    
    The purpose of this program is to implement a simple calculator
    GUI using javafx. It demonstrates some the basic design & operational
    concepts that are brought about by creating a functioning GUI.
 * 
 */
package BasicCalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BasicCalculator extends Application {
    
    //declare all buttons, fields, any nodes that are used in the pane
    Button btn_pls, btn_min, btn_mul, btn_div, btn_clr, btn_mod, btn_pow;
    TextField txt_n1, txt_n2;
    Label lbl_ans;

    @Override
    public void start(Stage primaryStage) {
        //declare all the nodes 
        btn_pls = new Button("+");
        btn_min = new Button("-");
        btn_mul = new Button("*");
        btn_div = new Button("÷");
        btn_mod = new Button("mod");
        btn_pow = new Button("^");
        btn_clr = new Button("Clear");
        lbl_ans = new Label("...");
        txt_n1 = new TextField();
        txt_n2 = new TextField();
       
        setStyle(); //sets widths, heights, etc. for all nodes
        
        GridPane root = new GridPane();
        
        //root.setGridLinesVisible(true);
        root.setAlignment(Pos.CENTER); //align UI in the center of screen
        root.setHgap(10);
        root.setVgap(10);
        
        //add the nodes to the gridpane
        root.add(txt_n1, 0, 0);
        root.add(txt_n2, 1, 0);
        root.add(btn_pls, 0, 1, 1, 1);
        root.add(btn_min, 1, 1, 1, 1);
        root.add(btn_mul, 0, 2, 1, 1);
        root.add(btn_div, 1, 2, 1, 1);
        root.add(btn_mod, 0, 3, 1, 1);
        root.add(btn_pow, 1, 3, 1, 1);
        
        //center the bottom two nodes
        root.setHalignment(lbl_ans,HPos.CENTER);
        root.setHalignment(btn_clr,HPos.CENTER);
        root.add(lbl_ans, 0, 4, 2, 1);
        root.add(btn_clr, 0, 5, 2, 1);
        
        attachCode();   //assign operations for each respective node
        
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Basic Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        scene.getStylesheets().add(BasicCalculator.class.getResource("bccss.css").toExternalForm());
        primaryStage.show();
    }
public void setStyle(){
   /*   input:      none, accesses all nodes that need aethestic changes
        output:     none, makes all style changes to all nodes called.
    */
   
    lbl_ans.setMinWidth(300);
    lbl_ans.setMinHeight(35);
    lbl_ans.setAlignment(Pos.BOTTOM_CENTER);
    btn_clr.setAlignment(Pos.BOTTOM_CENTER);
    btn_pls.setMinWidth(150);
    btn_min.setMinWidth(150);
    btn_mul.setMinWidth(150);
    btn_div.setMinWidth(150);
    btn_mod.setMinWidth(150);
    btn_pow.setMinWidth(150);
    btn_clr.setMinWidth(300);
}
public void attachCode(){
    /*   input:      none, accesses all nodes that perform an operation
        output:     none, adds operations for each node
    */
    btn_pls.setOnAction(e -> btnop(e));
    btn_min.setOnAction(e -> btnop(e));
    btn_mul.setOnAction(e -> btnop(e));
    btn_div.setOnAction(e -> btnop(e));
    btn_mod.setOnAction(e -> btnop(e));
    btn_pow.setOnAction(e -> btnop(e));
    btn_clr.setOnAction(e -> btnop(e));
}
public void btnop(ActionEvent e){
    /*  input:  ActionEvent, used to determine which node has been called
        output: none, performs the required operations for each node 
    */
    int n1, n2, ans = 0;
    float nf1, nf2, ansf;
    if(e.getSource()==btn_clr){
        //clear all fields
        txt_n1.setText("");
        txt_n2.setText("");
        lbl_ans.setText("...");
        txt_n1.requestFocus();
        return;
    }
    else if(e.getSource() == btn_div){
        //check for division and return before using the
        //integer variables a few lines down
        nf1 = Float.parseFloat(txt_n1.getText());
        nf2 = Float.parseFloat(txt_n2.getText());
        ansf = nf1 / nf2;
        
        lbl_ans.setText("" + ansf);
        return;
    }
    
    n1 = Integer.parseInt(txt_n1.getText());
    n2 = Integer.parseInt(txt_n2.getText());
    
    if(e.getSource()==btn_pls){
        ans = n1 + n2;
    }
    else if(e.getSource() == btn_min){
        ans = n1 - n2;
    }
    else if(e.getSource() == btn_mul){
        ans = n1 * n2;
    }
    else if(e.getSource() == btn_mod){
        ans = n1 % n2;
    }
    else if(e.getSource() == btn_pow){
        ans = 1;
        for(int i = 0; i < n2; i++){
            ans *= n1;
        }
    }
    
    //display the answer on the "label" node
    lbl_ans.setText("" + ans);
}
}
